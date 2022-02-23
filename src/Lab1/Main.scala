package Lab1

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._
import scala.util.Random

object Main {

  def FindLast(obj: List[Int]) : Int =    //the 1st using a loop
  {
  var temp: Int = 0

  for (x <- obj)
    {temp = x;}

  temp  //return the last elem
  }

  def FindLastR(obj: List[Int]): Int =      //the 1st using recursion
    {
      if (obj.tail.isEmpty)           //if there's nothing but one element in the list
        {return obj.head}             //return that element

      else
        {return FindLastR(obj.tail)}    //return all a list with all elements except the first
    }

  def CountElements(obj: List[Int]): Int =    //the second using a loop
  {
    var count: Int = 0

    for (x<- obj)
      {
        count += 1
      }

    count
  }

//  def CountElementsR(obj: List[Int]): Int =                 //the second using recursion
//    {                                                       //version #2
//     def TheCounter(obj: List[Int], number: Int): Int =
//       {
//         if (obj.isEmpty)
//           {return number}
//         else
//          { TheCounter(obj.tail,number + 1)}
//       }
//       TheCounter(obj,0)
//    }

  //the second using recursion version #1
    def TheCounter(obj: List[Int], number: Int = 0): Int = {
      if (obj.isEmpty) return number
      TheCounter(obj.tail,number + 1)
    }

  def CheckifPalindrome(obj: List[Int]): Boolean =     //the third using a loop
    {
      var result: Boolean = true
      for (i <- 0 until  obj.length )
        {
          breakable {
          if (obj(i) != obj(obj.length - 1 - i))
            {
              result = false
              break
            }
          }
        }
        return result
    }

  def CheckifPalindromeR(obj: List[Int]): Boolean =     //the third using recursion
  {

    if (obj.length != 1)
      {

        if (obj.head == obj.last)
        {
          CheckifPalindromeR(obj.tail.init)     //get rid of the first and the last
        }                                       //element of the list
        else
          {
            return false
          }
      }
    else
      {return true}

  }

//the 4th task using a loop
  def DeleteNthElement(obj: ListBuffer[Int], elem_number: Int): ListBuffer[Int] =
    {
      var templist: ListBuffer[Int] = ListBuffer()    //create an empty ListBuffer


      for ( i <- 0 until obj.length)    //until - it doesn't include the last value
        {

          if (i != elem_number - 1)
            {
                templist += obj(i)        //use ListBuffer to add elements in a list
            }
        }

      templist
    }

  //the 4th task using recursion
  def DeleteNthElementRec(origlist: List[Int], list2: ListBuffer[Int], elem_number: Int,coun: Int = 0):
  ListBuffer[Int] =
    {
      if ((coun < origlist.length))
        {
          if (elem_number - 1 == coun)
            {
              DeleteNthElementRec(origlist, list2, elem_number,coun + 1)
            }
          else
            {
              DeleteNthElementRec(origlist, list2 += origlist(coun), elem_number,coun + 1)
            }
        }
      else
        {list2}
    }

  //the 5th task using a loop
  def RandomSelect(orig_list: ListBuffer[Int],number_of_elements: Int): ListBuffer[Int] =
  {
    var elem_counter: Int = 0
    var new_list: ListBuffer[Int] = ListBuffer()
    var ind: Int = 0

    while (elem_counter < number_of_elements)
      {

        ind = Random.nextInt(orig_list.length)    //add an element from the old list with
        new_list += orig_list(ind)                //an index less than the length of the
        elem_counter += 1                         //old list - 1

        orig_list -= orig_list(ind)             //remove the element from the old list so there won't
      }                                         //be duplicates

    new_list
  }

  //the 5th task using recursion
  def RandomSelectR(orig_list: ListBuffer[Int],number_of_elements: Int): ListBuffer[Int] =
    {
      var elem_counter: Int = 0
      var new_list: ListBuffer[Int] = ListBuffer()
      var ind: Int = 0

      def HelpSelector(p_list:ListBuffer[Int],orig_list: ListBuffer[Int]): ListBuffer[Int] =
      {
        if (elem_counter < number_of_elements)
        {
          ind =Random.nextInt(orig_list.length)
          elem_counter += 1
          p_list += orig_list(ind)
          HelpSelector(p_list,orig_list -= orig_list(ind))
        }
        else
          {return new_list}
      }

      HelpSelector(new_list,orig_list)
    }

  //the 6th task using a loop
  def CheckifPrime(number: Int): Boolean =
    {
      var i: Int = 2

      while (i < number)
        {
          if (number % i == 0)
            {return false}
          else
            {i += 1}
        }
        true
    }

  //the 6th task using recursion
  def CheckifPrimeR(number: Int, i: Int = 2): Boolean =
    {
      if (i < number)
        {
          if (number % i == 0)
          {return false}
          else
          {CheckifPrimeR(number,i + 1)}
        }
      else
        {return true}
    }

  //the 7th task
  def y(x: Double): Double =
  {
    var res: Double = Math.pow(x,3) + 18 * x - 83
    res
  }

  def y_deriv(x: Double): Double =
    {
      var res:Double = 3 * Math.pow(x,2) + 18
      res
    }

  def CalcNewX(old_x: Double): Double =
    {
      var new_x: Double = old_x - y(old_x)/y_deriv(old_x)
      new_x
    }

  //using a loop
  def TheMethod(guess: Double): Double =
  {
    var temp_x: Double = guess
   // var temp_x: Double = CalcNewX(guess)

        while(y(temp_x) != 0.0)             //get a new x until f(x) = 0
          {
            temp_x = CalcNewX(temp_x)
          }

    return temp_x           //return the x which gives f(x) = 0
  }

  //using recursion
  def TheMethodR(guess:Double): Double =
    {
      var temp_x:Double = guess

      if (y(temp_x) != 0)
        {
          temp_x = CalcNewX(temp_x)
          TheMethodR(temp_x)
        }
      else
        {return temp_x}
    }

  def main(args: Array[String])
  {

    var list1 = List(2,3,2,4,2)
    var listP = List(2,3,2,3,2)    //is a palindrome

    print("The last element in "+ list1 + " using a loop is " + FindLast(list1) + "\n")
    print("The last element in "+ list1 + " using recursion is " + FindLastR(list1)+ "\n")

    println("Counted " + CountElements(list1) + " elements in " + list1 + " using a loop")
    println("Counted " + TheCounter(list1) + " elements in " + list1 + " using recursion")

    println(list1 + " is a palindrome using a loop: " +CheckifPalindrome(list1))
    println(listP + " is a palindrome using a loop: " +CheckifPalindrome(listP))

    println(list1 + " is a palindrome using recursion: " + CheckifPalindromeR(list1))
    println(listP + " is a palindrome using recursion: " + CheckifPalindromeR(listP))

    var list2 = ListBuffer(3,2,6,4)
    println("In " + list2 + " was deleted the 2nd element using a loop: " + DeleteNthElement(list2,2))
    println("In " + list1 + " was deleted the 5th element using recursion: " +DeleteNthElementRec(list1,ListBuffer[Int](),5,0))

    var list3 = ListBuffer(3,5,6,8,2,20)
    println("From " + list3 + " were selected 3 elements using a loop: " + RandomSelect(list3,3))
    println("From " + list3 + " were selected 2 elements using recursion: " + RandomSelectR(list3,2))

    println( "Using a loop:")
    for (j <- 2 to 4)
    {
      println("Number " + j + " is prime: " + CheckifPrime(j))
    }

    println("Using recursion:")
    for (j <- 5 to 7)
    {
      println("Number " + j + " is prime: " + CheckifPrimeR(j))
    }

    println("Using a loop x = "+ TheMethod(2.0))
    println("Using recursion x = "+ TheMethodR(2.0))
  }
}
