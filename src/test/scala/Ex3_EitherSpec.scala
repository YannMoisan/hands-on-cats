import scalaz.{-\/, \/-}

class Ex3_EitherSpec extends org.specs2.mutable.Specification {
  "[vanilla] flatMap two either" >> {
    "should work with Left/Left" >> {
      Ex3_Either.vanilla.flatMap(Left("error 1"), Left("error 2")) must_== Left("error 1")
    }
    "should work with Left/Right" >> {
      Ex3_Either.vanilla.flatMap(Left("error 1"), Right(2)) must_== Left("error 1")
    }
    "should work with Right/Left" >> {
      Ex3_Either.vanilla.flatMap(Right(1), Left("error 2")) must_== Left("error 2")
    }
    "should work with Right/Right" >> {
      Ex3_Either.vanilla.flatMap(Right(1), Right(2)) must_== Right(3)
    }
  }
  "[scalaz] flatMap two either" >> {
    "should work with Left/Left" >> {
      Ex3_Either.scalaz.flatMap(-\/("error 1"), -\/("error 2")) must_== -\/("error 1")
    }
    "should work with Left/Right" >> {
      Ex3_Either.scalaz.flatMap(-\/("error 1"), \/-(2)) must_== -\/("error 1")
    }
    "should work with Right/Left" >> {
      Ex3_Either.scalaz.flatMap(\/-(1), -\/("error 2")) must_== -\/("error 2")
    }
    "should work with Right/Right" >> {
      Ex3_Either.scalaz.flatMap(\/-(1), \/-(2)) must_== \/-(3)
    }
  }
}
