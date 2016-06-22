import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scalaz.OptionT
// Trick : this import provide a Monad instance for Future
import scalaz.std.scalaFuture._


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

  object scalaz {
    def flatMap(fo1: Future[Option[Int]], fo2: Future[Option[Int]]): Future[Option[Int]] =
      (for {
        i1 <- OptionT(fo1)
        i2 <- OptionT(fo2)
      } yield i1 + i2).run
  }

}
