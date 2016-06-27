import scalaz._
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
    def service1: Reader[Dao, String] = sys.error("todo")
    def service2: Reader[Dao, String] = sys.error("todo")
    def service3: Reader[Dao, String] = sys.error("todo")

    def service(dao: Dao): Seq[String] = sys.error("todo")
  }

  object cats {
    def service1: CReader[Dao, String] = sys.error("todo")
    def service2: CReader[Dao, String] = sys.error("todo")
    def service3: CReader[Dao, String] = sys.error("todo")

    def service(dao: Dao): Seq[String] = sys.error("todo")
  }

}
