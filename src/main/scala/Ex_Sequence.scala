object Ex_Sequence {

  object vanilla {
    def sequence(s: Seq[Option[Int]]): Option[Seq[Int]] = {
      val z: Option[Seq[Int]] = Some(Seq[Int]())

      val osa = s.foldLeft(z)((osa, oa) => for {
        sa <- osa
        a <- oa
      } yield sa.+:(a)
      )
      osa.map(_.reverse)
    }

    def sequenceEither(s: Seq[Either[String, Int]]): Either[String, Seq[Int]] = {
      val z: Either[String, Seq[Int]] = Right(Seq[Int]())

      val osa = s.foldLeft(z)((osa, oa) => for {
        sa <- osa.right
        a <- oa.right
      } yield sa.+:(a)
      )
      osa.right.map(_.reverse)
    }
  }

  object _cats {
    import cats.syntax.traverse._
    import cats.instances.list._
    import cats.instances.option._
    import cats.instances.either._

    def sequence(s: Seq[Option[Int]]): Option[List[Int]] = s.toList.sequence

    def sequenceEither(s: Seq[Either[String, Int]]): Either[String, List[Int]] = s.toList.sequence
  }

}
