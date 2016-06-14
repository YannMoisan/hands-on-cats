object Monoid {
  def merge(m1 : Map[String, Int], m2: Map[String, Int]) : Map[String, Int] = {
    val keys = m1.keys ++ m2.keys
    keys.map(k => k -> (m1.getOrElse(k, 0) + m2.getOrElse(k, 0))).toMap
  }

  def mergeEx2(m1 : Map[String, List[String]], m2: Map[String, List[String]]) : Map[String, List[String]] = {
    val keys = m1.keys ++ m2.keys
    keys.map(k => k -> (m1.getOrElse(k, List()) ++ m2.getOrElse(k, List()))).toMap
  }
}
