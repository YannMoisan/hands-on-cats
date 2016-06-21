import scalaz.\/

object Ex3_Either {
  object vanilla {
    def flatMap(e1: Either[String, Int], e2: Either[String, Int]): Either[String, Int] =
      for {
        v1 <- e1.right
        v2 <- e2.right
      } yield v1 + v2
  }

  object scalaz {
    def flatMap(e1 : \/[String, Int], e2: \/[String, Int]) : \/[String, Int] =
      for {
        v1 <- e1
        v2 <- e2
      } yield v1 + v2
  }
}