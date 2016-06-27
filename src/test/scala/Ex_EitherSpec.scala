import scalaz.{-\/, \/-}
import cats.data.Xor

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
  "[scalaz] flatMap two either" >> {
    "should work with Left/Left" >> {
      Ex_Either._scalaz.flatMap(-\/("error 1"), -\/("error 2")) must_== -\/("error 1")
    }
    "should work with Left/Right" >> {
      Ex_Either._scalaz.flatMap(-\/("error 1"), \/-(2)) must_== -\/("error 1")
    }
    "should work with Right/Left" >> {
      Ex_Either._scalaz.flatMap(\/-(1), -\/("error 2")) must_== -\/("error 2")
    }
    "should work with Right/Right" >> {
      Ex_Either._scalaz.flatMap(\/-(1), \/-(2)) must_== \/-(3)
    }
  }

  "[cats] flatMap two either" >> {
    "should work with Left/Left" >> {
      Ex_Either._cats.flatMap(cats.data.Xor.Left("error 1"), cats.data.Xor.Left("error 2")) must_== cats.data.Xor.Left("error 1")
    }
    "should work with Left/Right" >> {
      Ex_Either._cats.flatMap(cats.data.Xor.Left("error 1"), cats.data.Xor.Right(2)) must_== cats.data.Xor.Left("error 1")
    }
    "should work with Right/Left" >> {
      Ex_Either._cats.flatMap(cats.data.Xor.Right(1), cats.data.Xor.Left("error 2")) must_== cats.data.Xor.Left("error 2")
    }
    "should work with Right/Right" >> {
      Ex_Either._cats.flatMap(cats.data.Xor.Right(1), cats.data.Xor.Right(2)) must_== cats.data.Xor.Right(3)
    }
  }

}
