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
}
