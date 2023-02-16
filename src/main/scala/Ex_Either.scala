object Ex_Either {
  object vanilla {
    def flatMap(e1: Either[String, Int], e2: Either[String, Int]): Either[String, Int] =
      for {
        v1 <- e1.right
        v2 <- e2.right
      } yield v1 + v2
  }

  object _cats {
    def flatMap(e1: Either[String, Int], e2: Either[String, Int]): Either[String, Int] = sys.error("todo")
  }
}
