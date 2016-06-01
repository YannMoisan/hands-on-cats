object Sequence {
  def sequence(s: Seq[Option[Int]]) : Option[Seq[Int]] = {
    val z : Option[Seq[Int]] = Some(Seq[Int]())

    val osa = s.foldLeft(z)((osa, oa) => for {
      sa <- osa
      a <- oa
    } yield sa.+:(a)
    )
    osa.map(_.reverse)
  }



}
