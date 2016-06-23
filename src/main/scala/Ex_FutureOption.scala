import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scalaz.OptionT


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
    import _root_.scalaz.OptionT
    // Trick : this import provide a Monad instance for Future
    import _root_.scalaz.std.scalaFuture._

    def flatMap(fo1: Future[Option[Int]], fo2: Future[Option[Int]]): Future[Option[Int]] =
      (for {
        i1 <- OptionT(fo1)
        i2 <- OptionT(fo2)
      } yield i1 + i2).run
  }

  object cats {
    import _root_.cats.data.OptionT
    import _root_.cats.std.future._
    def flatMap(fo1: Future[Option[Int]], fo2: Future[Option[Int]]): Future[Option[Int]] =
      (for {
        i1 <- OptionT(fo1)
        i2 <- OptionT(fo2)
      } yield i1 + i2).value
  }

}
