import scalaz._, Scalaz._

object Ex8_Reader {
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
    def service1: Reader[Dao, String] = Reader { _.name }
    def service2: Reader[Dao, String] = Reader { _.name }
    def service3: Reader[Dao, String] = Reader { _.name }

    def service(dao: Dao): Seq[String] =
      (for {
        i1 <- service1
        i2 <- service2
        i3 <- service3
      } yield Seq(i1, i2, i3)).run(new Dao(){})
  }
}
