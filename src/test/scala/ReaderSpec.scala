import Reader.Dao
import org.specs2.mutable.Specification

class ReaderSpec extends Specification {
  "The service aggregates the result of 3 services" >> {
    "when a dao is injected" >> {
      Reader.service(new Dao(){}) must_== List("Ahoy", "Ahoy", "Ahoy")
    }
  }
}
