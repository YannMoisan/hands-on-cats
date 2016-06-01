object Reader {
  trait Dao { def name = "Ahoy" }
  def service1(dao: Dao) : String = dao.name
  def service2(dao: Dao) : String = dao.name
  def service3(dao: Dao) : String = dao.name

  def service(dao: Dao) : Seq[String] = {
    Seq(
      service1(dao),
      service2(dao),
      service3(dao)
    )

  }

}
