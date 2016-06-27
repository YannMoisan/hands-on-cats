import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Ex_FutureOption {
  // def findAmountById(id: String) : Future[Option[Int]]

  object vanilla {
    def flatMap(fo1: Future[Option[Int]], fo2: Future[Option[Int]]): Future[Option[Int]] = {
      for {
        o1 <- fo1
        o2 <- fo2
      } yield {
        for {
          i1 <- o1
          i2 <- o2
        } yield i1 + i2
      }
    }
  }

  object _scalaz {
    def flatMap(fo1: Future[Option[Int]], fo2: Future[Option[Int]]): Future[Option[Int]] = sys.error("todo")
  }

  object _cats {
    def flatMap(fo1: Future[Option[Int]], fo2: Future[Option[Int]]): Future[Option[Int]] = sys.error("todo")
  }

}
