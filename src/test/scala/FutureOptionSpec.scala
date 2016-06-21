import org.specs2.concurrent.ExecutionEnv

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class FutureOptionSpec(implicit ee: ExecutionEnv) extends org.specs2.mutable.Specification {
  val futureSome = Future(Some(1))
  val futureNone = Future(None)

  "[vanilla] flatMap on Future[Option[Int]]" >> {
    "should sum integers when both option are defined" >> {
      FutureOption.vanilla.flatMap(futureSome, futureSome) must be_==(Some(2)).await
    }
    "should return None when the first option is None" >> {
      FutureOption.vanilla.flatMap(futureNone, futureSome) must be_==(None).await
    }
    "should return None when the second option is None" >> {
      FutureOption.vanilla.flatMap(futureSome, futureNone) must be_==(None).await
    }
    "should return None when both option are None" >> {
      FutureOption.vanilla.flatMap(futureNone, futureNone) must be_==(None).await
    }
  }

  "[scalaz] flatMap on Future[Option[Int]]" >> {
    "should sum integers when both option are defined" >> {
      FutureOption.scalaz.flatMap(futureSome, futureSome) must be_==(Some(2)).await
    }
    "should return None when the first option is None" >> {
      FutureOption.scalaz.flatMap(futureNone, futureSome) must be_==(None).await
    }
    "should return None when the second option is None" >> {
      FutureOption.scalaz.flatMap(futureSome, futureNone) must be_==(None).await
    }
    "should return None when both option are None" >> {
      FutureOption.scalaz.flatMap(futureNone, futureNone) must be_==(None).await
    }
  }

  "[cats] flatMap on Future[Option[Int]]" >> {
    "should sum integers when both option are defined" >> {
      FutureOption.cats.flatMap(futureSome, futureSome) must be_==(Some(2)).await
    }
    "should return None when the first option is None" >> {
      FutureOption.cats.flatMap(futureNone, futureSome) must be_==(None).await
    }
    "should return None when the second option is None" >> {
      FutureOption.cats.flatMap(futureSome, futureNone) must be_==(None).await
    }
    "should return None when both option are None" >> {
      FutureOption.cats.flatMap(futureNone, futureNone) must be_==(None).await
    }
  }

}
