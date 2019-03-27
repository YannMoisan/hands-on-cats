// sum and count elements with only one traversal
object Ex_Fold {
  object vanilla {
    def fold(l: List[Int]): (Int, Int) = {
      var count = 0
      var sum = 0
      l.foreach { e =>
        count = count + 1
        sum = sum + e
      }
      (count, sum)
    }
  }

  object _cats {
    import cats._
    import cats.implicits._
    def fold(l: List[Int]): (Int, Int) =
      l.foldMap(e => (1, e))
  }
}
