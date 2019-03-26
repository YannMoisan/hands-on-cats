object Ex_Compose {
  object vanilla {
    def double(f: List[Option[Int]]) : List[Option[Int]] =
      f.map(_.map(_*2))
  }

  object _cats {
    def double(f: List[Option[Int]]) : List[Option[Int]] =
      sys.error("todo")
  }
}
