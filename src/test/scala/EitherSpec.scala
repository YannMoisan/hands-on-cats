import scalaz.{-\/, \/-}

class EitherSpec extends org.specs2.mutable.Specification {
  "[vanilla] flatMap two either" >> {
    "should work with Left/Left" >> {
      Either.vanilla.flatMap(Left("error 1"), Left("error 2")) must_== Left("error 1")
    }
    "should work with Left/Right" >> {
      Either.vanilla.flatMap(Left("error 1"), Right(2)) must_== Left("error 1")
    }
    "should work with Right/Left" >> {
      Either.vanilla.flatMap(Right(1), Left("error 2")) must_== Left("error 2")
    }
    "should work with Right/Right" >> {
      Either.vanilla.flatMap(Right(1), Right(2)) must_== Right(3)
    }
  }
  "[scalaz] flatMap two either" >> {
    "should work with Left/Left" >> {
      Either.scalaz.flatMap(-\/("error 1"), -\/("error 2")) must_== -\/("error 1")
    }
    "should work with Left/Right" >> {
      Either.scalaz.flatMap(-\/("error 1"), \/-(2)) must_== -\/("error 1")
    }
    "should work with Right/Left" >> {
      Either.scalaz.flatMap(\/-(1), -\/("error 2")) must_== -\/("error 2")
    }
    "should work with Right/Right" >> {
      Either.scalaz.flatMap(\/-(1), \/-(2)) must_== \/-(3)
    }
  }
}
