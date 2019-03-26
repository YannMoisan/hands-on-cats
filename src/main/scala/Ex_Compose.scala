object Ex_Compose {
  object vanilla {
    def double(f: List[Option[Int]]) : List[Option[Int]] =
      f.map(_.map(_*2))
  }

  object _cats {
    import cats._
    import cats.data.Nested
    import cats.implicits._

    def double(f: List[Option[Int]]) : List[Option[Int]] =
      Nested(f).map(_*2).value
      // or
      // Functor[List].compose(Functor[Option]).map(f)(_*2)
  }
}
