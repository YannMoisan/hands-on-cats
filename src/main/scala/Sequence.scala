import scalaz._
import Scalaz._

object Sequence {

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

  object scalaz {
    def sequence(s: Seq[Option[Int]]): Option[List[Int]] = s.toList.sequence

    // Trick : sequenceU (for Unapply) is needed in replacement of sequence to help the compiler
    // Otherwise, this compilation error is triggered
    //  [error] /Users/yamo/Projects/hands-on-scalaz/src/main/scala/Sequence.scala:33: polymorphic expression cannot be instantiated to expected type;
    //  [error]  found   : [G[_], B]G[List[B]]
    //  [error]  required: Either[String,List[Int]]
    //  [error]     def sequenceEither(s: Seq[Either[String, Int]]): Either[String, List[Int]] = s.toList.sequence
    def sequenceEither(s: Seq[Either[String, Int]]): Either[String, List[Int]] = s.toList.sequenceU
  }
}
