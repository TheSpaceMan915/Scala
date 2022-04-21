package Lab4

  object RunTest4
  {

    def func(x: Double): Double = {
      val matcher = x match {
        case x1 if (x1 >= 0) && (x1 < 1) => -2 * x1 + 2
        case x2 if (x2 >= 1) && (x2 < 2) => 0
        case x3 if (x3 >= 2) => x3 - 2
      }

      matcher
    }

    def CalculateCtg(value: Double): Double = Math.cos(value)/Math.sin(value)

    def CalculateTg(value: Double): Double = Math.sin(value)/Math.cos(value)

    def CheckVariable(x: Double): Double = {

      var division = CalculateCtg(x);
      x match {
        case w if (w != 0) && (division < 0.5) => w * -1
        case w if w == 0 => 1
        case _ => -1
      }
    }

    def CheckAngle(angle: Int): Double = {      //0-180 - tg, 180-360 - ctg

      val matcher = angle match {
        case x1 if (x1 >= 0) && (x1 <= 180) => CalculateTg(x1)
        case x2 if (x2 > 180) && (x2 <= 360) => CalculateCtg(x2)
      }

      matcher
    }

    def main(args: Array[String]): Unit = {

      val res =func(1.3)
      println(res)

      val res2 = CheckVariable(0.2)
      println(res2)
    }

  }


