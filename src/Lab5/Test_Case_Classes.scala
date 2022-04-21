package Lab5

abstract class Position
case object Bus_driver extends Position
case object Judge extends Position
case object EnglishTeacher extends Position


class Employee(val name:String,val age:Int,val pos:Position) {

  val m_name: String = name
  val m_age: Int = age
  val m_pos:Position = pos

  def PrintSalary():Unit = {

    val matcher = m_pos match {
      case Bus_driver => println("A bus driver earns 500$")
      case Judge => println("A judge earns 2000$")
      case EnglishTeacher => println("An english teacher earns 1000$")
      case _ => "Exception"
    }
  }
}

object Test_Case_Classes {

  def main(args: Array[String]): Unit = {

    val person1:Employee = new Employee("Jane",24,EnglishTeacher)
    val person2:Employee = new Employee("Nik",30,Judge)

    person1.PrintSalary()
    person2.PrintSalary()
  }

}
