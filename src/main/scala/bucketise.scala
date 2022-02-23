object bucketise {
  def truncate_number(x: Double, p:Int): Double = {
    val v = math.pow(10, p)
    (x*v).toInt / v
  }

  def bucket(y: Double): (Double, Double) = {
    val initialValue: Double = (y / 0.05).floor * 0.05
    val finalValue: Double = (y / 0.05).floor * 0.05 + 0.049
    val first : Double = truncate_number(initialValue, 3)
    val second : Double = truncate_number(finalValue, 3)
    (first, second)
  }

  def main(args: Array[String]): Unit = {
    val values : Array[Double] = Array(12.05, 12.03, 10.33, 11.45, 13.5)
    for (num <- values) {
      val ans : (Double, Double) = bucket(num)
      println(s"$num => $ans")
    }
  }
}
