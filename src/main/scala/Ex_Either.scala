object Ex_Either {
  object vanilla {
    def flatMap(e1: Either[String, Int], e2: Either[String, Int]): Either[String, Int] =
      for {
        v1 <- e1.right
        v2 <- e2.right
      } yield v1 + v2
  }

  object _scalaz {
    import scalaz.\/
    def flatMap(e1 : \/[String, Int], e2: \/[String, Int]) : \/[String, Int] = sys.error("todo")
  }

  object _cats {
    import cats.data.Xor
    def flatMap(e1: Xor[String, Int], e2: Xor[String, Int]): Xor[String, Int] = sys.error("todo")
  }
}
