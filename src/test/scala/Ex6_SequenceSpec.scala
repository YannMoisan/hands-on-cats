class Ex6_SequenceSpec extends org.specs2.mutable.Specification {
  "[vanilla] transform a Seq[Option] in Option[Seq]" >> {
    "should return Some when the seq contains only Some" >> {
      Ex6_Sequence.vanilla.sequence(Seq(Some(1), Some(2))) must_== Some(Seq(1, 2))
    }
    "should return None when the seq contains Some and None" >> {
      Ex6_Sequence.vanilla.sequence(Seq(Some(1), None)) must_== None
    }
    "should return None when the seq contains only None" >> {
      Ex6_Sequence.vanilla.sequence(Seq(None, None)) must_== None
    }
  }
  "[vanilla] transform a Seq[Either] in Either[Seq]" >> {
    "should return Some when the seq contains only Some" >> {
      Ex6_Sequence.vanilla.sequenceEither(Seq(Right(1), Right(2))) must_== Right(Seq(1, 2))
    }
    "should return None when the seq contains Some and None" >> {
      Ex6_Sequence.vanilla.sequenceEither(Seq(Right(1), Left("error"))) must_== Left("error")
    }
    "should return None when the seq contains only None" >> {
      Ex6_Sequence.vanilla.sequenceEither(Seq(Left("error"), Left("error"))) must_== Left("error")
    }
  }
  "[scalaz] transform a Seq[Option] in Option[Seq]" >> {
    "should return Some when the seq contains only Some" >> {
      Ex6_Sequence.scalaz.sequence(Seq(Some(1), Some(2))) must_== Some(List(1, 2))
    }
    "should return None when the seq contains Some and None" >> {
      Ex6_Sequence.scalaz.sequence(Seq(Some(1), None)) must_== None
    }
    "should return None when the seq contains only None" >> {
      Ex6_Sequence.scalaz.sequence(Seq(None, None)) must_== None
    }
  }
  "[scalaz] transform a Seq[Either] in Either[Seq]" >> {
    "should return Some when the seq contains only Some" >> {
      Ex6_Sequence.scalaz.sequenceEither(Seq(Right(1), Right(2))) must_== Right(List(1, 2))
    }
    "should return None when the seq contains Some and None" >> {
      Ex6_Sequence.scalaz.sequenceEither(Seq(Right(1), Left("error"))) must_== Left("error")
    }
    "should return None when the seq contains only None" >> {
      Ex6_Sequence.scalaz.sequenceEither(Seq(Left("error"), Left("error"))) must_== Left("error")
    }
  }
}
