package Lab2

class Paper(val title: String, val price: Int ) {

  val m_title: String = title
  val m_price: Int = price

  def Print(): Unit = {
    println(s"This is \"$m_title\".It costs $m_price dollars")
  }

  def GetTitle(): String = m_title
  def GetPrice():Int = m_price

}

class Newspaper(override val title: String, override val price: Int, val style: String) extends
  Paper(title,price) {

  val m_style: String = style

  override def Print(): Unit = {
    println(s"This is \"$title\" newspaper. The stile of the newspaper is $m_style. It costs $price dollars")
  }
}

class Book(override val title: String,override val price:Int,val number_of_pages:Int) extends
  Paper(title, price) {

  val m_number_of_pages: Int = number_of_pages

  override def Print(): Unit = {
    println(s"There are $m_number_of_pages in the book \"$title\"")
  }
}

class Magazine(override val title:String,override val price:Int,val publishing_company_name:String)
  extends Paper(title,price) {

  val m_publishing_company_name: String = publishing_company_name

  override def Print(): Unit = {
    println(s"$title is published by $m_publishing_company_name")
  }
}

class Textbook(override val title:String,override val price:Int,val subject_of_studying:String)
  extends Paper(title,price) {

  val m_subject_of_studying:String = subject_of_studying

  override def Print(): Unit = println(s"This is a textbook for $m_subject_of_studying")
}

class Poster(override val title:String,override val price:Int,val what_is_on_the_poster:String)
  extends Paper(title,price) {

  val m_what_is_on_the_poster:String = what_is_on_the_poster

  override def Print(): Unit = println(s"The price of the poster is $price. And there's $m_what_is_on_the_poster on it")
}

class Painting(override val title:String,override val price:Int,val the_painter_of_the_painting:String)
  extends Paper(title,price) {

  val m_the_painter_of_the_painting = the_painter_of_the_painting

  override def Print(): Unit = println(s"$title was painted by $m_the_painter_of_the_painting")
}

class Library(val arr_books:Array[Book],val arr_magazines:Array[Magazine]) {

  val m_arr_books = arr_books
  val m_arr_magazines = arr_magazines

  def PrintThingsInTheLibrary(): Unit = {

    println("Available books:")
    for (item: Book <- m_arr_books)
    {
      print(item.GetTitle() + '\t')
    }
    println()

    println("Available magazines:")
    for (item: Magazine <- m_arr_magazines)
    {
      print(item.GetTitle() + '\t')
    }
    println()
  }
}

class NewspapersShop(val arr_posters:Array[Poster],val arr_newspapers:Array[Newspaper])
{

  val m_arr_posters = arr_posters
  val m_arr_newspapers = arr_newspapers

  def PrintThingsInTheShop(): Unit = {

    println("Available posters:")
    for (item <- m_arr_posters)
    {
      print(item.GetTitle() + '\t')
    }
    println()

    println("Available newspapers:")
    for (item <- m_arr_newspapers)
    {
      print(item.GetTitle() + '\t')
    }
    println()
  }
}

object RunTest2 {

  def main(args: Array[String]): Unit =
  {
    val paper_obj:Paper = new Paper("The Paper",2)
    val newspaper_obj:Paper = new Newspaper("Daily Mirror",3,"press report")
    val textbook_obj:Paper = new Textbook("Art and Culture",324,"Arts")
    paper_obj.Print()
    newspaper_obj.Print()
    textbook_obj.Print()

    val book0:Book = new Book("Book1",402,503)
    val book1:Book = new Book("Book2",204,102)
    val book2:Book = new Book("Book3",506,147)
    val ar_books:Array[Book] = new Array[Book](3)
    ar_books(0) = book0
    ar_books(1) = book1
    ar_books(2) = book2

    val ar_magazines:Array[Magazine] = new Array[Magazine](3)
    val mag0:Magazine = new Magazine("Magazine1",182,"Company1")
    val mag1:Magazine = new Magazine("Magazine2",891,"Company2")
    val mag2:Magazine = new Magazine("Magazine3",265,"Company3")
    ar_magazines(0) = mag0
    ar_magazines(1) = mag1
    ar_magazines(2) = mag2

    val ar_posters:Array[Poster] = new Array[Poster](3)
    val pos0:Poster = new Poster("Title1",223,"Something1")
    val pos1:Poster = new Poster("Title2",286,"Something2")
    val pos2:Poster = new Poster("Title3",194,"Something3")
    ar_posters(0) = pos0
    ar_posters(1) = pos1
    ar_posters(2) = pos2

    val ar_newspapers:Array[Newspaper] = new Array[Newspaper](3)
    val newsp0 = new Newspaper("Title1",394,"Style1")
    val newsp1 = new Newspaper("Title2",489,"Style2")
    val newsp2 = new Newspaper("Title3",585,"Style3")
    ar_newspapers(0) = newsp0
    ar_newspapers(1) = newsp1
    ar_newspapers(2) = newsp2

    val lib_obj:Library = new Library(ar_books,ar_magazines)
    val shop_obj:NewspapersShop = new NewspapersShop(ar_posters,ar_newspapers)

    lib_obj.PrintThingsInTheLibrary()
    shop_obj.PrintThingsInTheShop()
  }
}
