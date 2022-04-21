package Test6

object Closure {

  def main(args: Array[String]): Unit = {
    var monthCounter = 0
    val ar: Array[String] = Array("Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")

    def FuncClose(): Unit = {
      println(ar(monthCounter % 12))
      monthCounter += 1
    }

    FuncClose()
    FuncClose()
    FuncClose()
    FuncClose()
    FuncClose()
    FuncClose()
    FuncClose()
    FuncClose()
    FuncClose()
  }

}
