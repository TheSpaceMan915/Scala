package Lab3
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

//#1_______________________________________________
trait StrSearch {
  def SearchStrEntry( main_str:String,sub_str:String ): Int
  def SearchStr( main_str:String,sub_str:String ): Int
}

class Str_Entry(val main_str:String, val sub_str:String) extends StrSearch{
  val m_main_str:String = main_str
  val m_sub_str:String = sub_str
  var start_ind: Int = -1
  var ret_ind:Int = 0

  //finds how many times a substring enters a string
  @Override
  override def SearchStrEntry(main_str:String,sub_str:String): Int = {
    var entry_counter = 0
    breakable
    {
      while (ret_ind < main_str.length)
      {
        ret_ind = main_str.indexOf(sub_str, start_ind + 1)
        if (ret_ind == -1)
        {break}
        else
        {
          entry_counter += 1
          start_ind = ret_ind
        }
      }
    }
    entry_counter
  }

  //finds a substring as an individual word
  @Override
  override def SearchStr(main_str: String, sub_str: String):Int = {

    val words_arr:Array[String] = main_str.split(" ")
    var entries_counter = 0

    for (word <- words_arr)
      {
        if (word.equals(sub_str))
        {entries_counter += 1}
      }
      entries_counter
  }
}

//#2_______________________________________________
  trait Stack_methods {

  def Push(elem: AnyVal): Unit
  def Pop(): AnyVal
  def PrintStack(): Unit
}

class Stack(val list: ListBuffer[AnyVal]) extends Stack_methods {
  var m_list: ListBuffer[AnyVal] = list

  @Override
  override def Push(elem: AnyVal): Unit = m_list.append(elem)

  @Override
  override def Pop(): AnyVal =
  {
    val temp = m_list.last
    m_list.remove(m_list.length - 1)
    temp
  }

  @Override
  override def PrintStack(): Unit = {
    val temp_list = new ListBuffer[AnyVal]()    //create a copy of the listbuffer
    temp_list.addAll(m_list)

    println("Here goes your stack: ")
    while (m_list.nonEmpty)                   //while the stack isn't empty
      {                                       //get elements from it and print them
        print(Pop() + "\t")
      }
      println()

    m_list.addAll(temp_list)                  //fill the stack again
    println()
  }
}

//#3_______________________________________________
trait Set_methods {

  def IntersectSets(list: List[AnyVal]): List[AnyVal]
  def UniteSets(list: List[AnyVal]): ListBuffer[AnyVal]
  def DiffSets(list: List[AnyVal]): List[AnyVal]
  def PowOddElems(list: List[Int]): ListBuffer[Int]
}

class Set(list:List[AnyVal]) extends Set_methods {
  val m_list = list

  @Override
  override def IntersectSets(list: List[AnyVal]): List[AnyVal] = m_list.intersect(list)

  @Override
  override def UniteSets(list: List[AnyVal]): ListBuffer[AnyVal] = {

    var temp_list:ListBuffer[AnyVal] = new ListBuffer[AnyVal]
    temp_list.prependAll(list)                                    //it's quicker if I add elements
                                                                  //at the beginning of the list
    for (elem <- m_list)
      {
        if (!temp_list.contains(elem))
          {
            temp_list.prepend(elem)
          }
      }

    temp_list
  }

  @Override
  override def DiffSets(list: List[AnyVal]): List[AnyVal] = m_list.diff(list)

  @Override
  override def PowOddElems(list: List[Int]): ListBuffer[Int] = {
    var buf_list = new ListBuffer[Int]()

    for ( i <- 0 until  list.length)
      {
        if (list(i) % 2 == 0)
          {buf_list.append(list(i) * list(i))}
        else
          {buf_list.append(list(i))}
      }

    buf_list
  }
}

  object RunTest3 {

  def main(args: Array[String]): Unit = {

    //#1_______________________________________________
    val big_str = "findIt if you mustfind it"
    val big_str2 = "find a city find a car find mates  "
    val little_str = "find"
    val test_obj = new Str_Entry(big_str, little_str)

    val n_entries: Int = test_obj.SearchStrEntry(big_str, little_str)
    val n_word_entries = test_obj.SearchStr(big_str2,little_str)
    println(s"There are $n_entries substrings \"$little_str\" in the string: $big_str")
    println(s"There are $n_word_entries substrings \"$little_str\" as individual words  in the string: $big_str2")

    //#2_______________________________________________
    var test_list: ListBuffer[AnyVal] = ListBuffer(3,2,5,7,43)
    var stack_obj = new Stack(test_list)

    stack_obj.Push(100);
    var value = stack_obj.Pop();
    println(s" $value has been popped from the stack")
    stack_obj.PrintStack();

    //#3_______________________________________________
    val list1 = List(11,7,3,8,4)
    val list2:List[AnyVal] = List(5,4,3,8,6)
    val list3 = List(10,5,45,3,7)
    val set_obj = new Set(list1)

    var lists_union:ListBuffer[AnyVal] = set_obj.UniteSets(list2)
    val lists_intersection = set_obj.IntersectSets(list3)
    val lists_difference = set_obj.DiffSets(list3)

    println(s"The union of $list1 and $list2 is $lists_union")
    println(s"The intersection of $list1 and $list3 is $lists_intersection")
    println(s"The difference of $list1 and $list3 is $lists_difference")

    var test_pow = set_obj.PowOddElems(list1)
    println(s"The original list is $list1")
    println(test_pow)
  }
}