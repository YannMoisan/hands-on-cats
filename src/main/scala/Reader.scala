import scalaz._

object Reader {
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
}
