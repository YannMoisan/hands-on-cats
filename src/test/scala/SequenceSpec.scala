class SequenceSpec extends org.specs2.mutable.Specification {
  "transform a Seq[Option] in Option[Seq]" >> {
    "should return Some when the seq contains only Some" >> {
      Sequence.sequence(Seq(Some(1), Some(2))) must_== Some(Seq(1, 2))
    }
    "should return None when the seq contains Some and None" >> {
      Sequence.sequence(Seq(Some(1), None)) must_== None
    }
    "should return None when the seq contains only None" >> {
      Sequence.sequence(Seq(None, None)) must_== None
    }
  }
  "transform a Seq[Either] in Either[Seq]" >> {
    "should return Some when the seq contains only Some" >> {
      Sequence.sequenceEither(Seq(Right(1), Right(2))) must_== Right(Seq(1, 2))
    }
    "should return None when the seq contains Some and None" >> {
      Sequence.sequenceEither(Seq(Right(1), Left("error"))) must_== Left("error")
    }
    "should return None when the seq contains only None" >> {
      Sequence.sequenceEither(Seq(Left("error"), Left("error"))) must_== Left("error")
    }
  }
}
