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
    import scalaz.OptionT
    // Trick : this import provide a Monad instance for Future
    import scalaz.std.scalaFuture._

    def flatMap(fo1: Future[Option[Int]], fo2: Future[Option[Int]]): Future[Option[Int]] =
      (for {
        i1 <- OptionT(fo1)
        i2 <- OptionT(fo2)
      } yield i1 + i2).run
  }

  object _cats {
    import cats.data.OptionT
    import cats.instances.future._
    def flatMap(fo1: Future[Option[Int]], fo2: Future[Option[Int]]): Future[Option[Int]] =
      (for {
        i1 <- OptionT(fo1)
        i2 <- OptionT(fo2)
      } yield i1 + i2).value
  }

}
