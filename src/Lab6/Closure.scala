package Lab6

object Closure {

  //define free variables
  var monthCounter = 0
  val ar: Array[String] = Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")

  def GetMonth(): (Int,String) = {

    monthCounter += 1
    var ind:Int = ((monthCounter-1) % 12)

    val temp_tuple = (ind + 1,ar(ind))

    temp_tuple
  }

  //test function
 /* def FuncClose(): Unit = {
    println(ar(monthCounter % 12))
    monthCounter += 1
  }*/

  def main(args: Array[String]): Unit = {

    var iter_counter: Int = 0
    var temp_tumple: (Int,String) = (0,"")

    while (iter_counter < 14)
    {
      temp_tumple = GetMonth()
      println(temp_tumple._1 + " " + temp_tumple._2)
      iter_counter += 1
    }
  }

}
