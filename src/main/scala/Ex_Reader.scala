import scalaz.{Reader => R, _}
import Scalaz._
import cats.data.{Reader=>CReader}

object Ex_Reader {
  trait Dao { def name = "Ahoy" }

  object vanilla {
    def service1(dao: Dao): String = dao.name
    def service2(dao: Dao): String = dao.name
    def service3(dao: Dao): String = dao.name

    def service(dao: Dao): Seq[String] = {
      Seq(
        service1(dao),
        service2(dao),
        service3(dao)
      )

    }
  }

  object scalaz {
    def service1: R[Dao, String] = R { _.name }
    def service2: R[Dao, String] = R { _.name }
    def service3: R[Dao, String] = R { _.name }

    def service(dao: Dao): Seq[String] =
      (for {
        i1 <- service1
        i2 <- service2
        i3 <- service3
      } yield Seq(i1, i2, i3)).run(new Dao(){})
  }

  object cats {
    def service1: CReader[Dao, String] = CReader { _.name }
    def service2: CReader[Dao, String] = CReader { _.name }
    def service3: CReader[Dao, String] = CReader { _.name }

    def service(dao: Dao): Seq[String] =
      (for {
        i1 <- service1
        i2 <- service2
        i3 <- service3
      } yield Seq(i1, i2, i3)).run(new Dao(){})
  }

}
