class EitherSpec extends org.specs2.mutable.Specification {
  "flatMap two either" >> {
    "should work with Left/Left" >> {
      Either.flatMap(Left("error 1"), Left("error 2")) must_== Left("error 1")
    }
    "should work with Left/Right" >> {
      Either.flatMap(Left("error 1"), Right(2)) must_== Left("error 1")
    }
    "should work with Right/Left" >> {
      Either.flatMap(Right(1), Left("error 2")) must_== Left("error 2")
    }
    "should work with Right/Right" >> {
      Either.flatMap(Right(1), Right(2)) must_== Right(3)
    }
  }
}
