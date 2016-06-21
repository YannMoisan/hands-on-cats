import Reader.Dao
import org.specs2.mutable.Specification

class ReaderSpec extends Specification {
  "[vanilla] The service aggregates the result of 3 services" >> {
    "when a dao is injected" >> {
      Reader.vanilla.service(new Dao(){}) must_== List("Ahoy", "Ahoy", "Ahoy")
    }
  }
  "[scalaz] The service aggregates the result of 3 services" >> {
    "when a dao is injected" >> {
      Reader.scalaz.service(new Dao(){}) must_== List("Ahoy", "Ahoy", "Ahoy")
    }
  }
  "[cats] The service aggregates the result of 3 services" >> {
    "when a dao is injected" >> {
      Reader.cats.service(new Dao(){}) must_== List("Ahoy", "Ahoy", "Ahoy")
    }
  }
}
