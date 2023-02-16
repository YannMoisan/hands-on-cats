class Ex_EitherSpec extends org.specs2.mutable.Specification {
  "[vanilla] flatMap two either" >> {
    "should work with Left/Left" >> {
      Ex_Either.vanilla.flatMap(Left("error 1"), Left("error 2")) must_== Left("error 1")
    }
    "should work with Left/Right" >> {
      Ex_Either.vanilla.flatMap(Left("error 1"), Right(2)) must_== Left("error 1")
    }
    "should work with Right/Left" >> {
      Ex_Either.vanilla.flatMap(Right(1), Left("error 2")) must_== Left("error 2")
    }
    "should work with Right/Right" >> {
      Ex_Either.vanilla.flatMap(Right(1), Right(2)) must_== Right(3)
    }
  }

  "[cats] flatMap two either" >> {
    "should work with Left/Left" >> {
      Ex_Either._cats.flatMap(Left("error 1"), Left("error 2")) must_== Left("error 1")
    }
    "should work with Left/Right" >> {
      Ex_Either._cats.flatMap(Left("error 1"), Right(2)) must_== Left("error 1")
    }
    "should work with Right/Left" >> {
      Ex_Either._cats.flatMap(Right(1), Left("error 2")) must_== Left("error 2")
    }
    "should work with Right/Right" >> {
      Ex_Either._cats.flatMap(Right(1), Right(2)) must_== Right(3)
    }
  }

}
