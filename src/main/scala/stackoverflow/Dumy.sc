case class NumberPair(number1: Double, number2: Double)
case class OperationIndex(numbers: NumberPair, operator: String)

def parser(number1: Double, number2: Double, operator: String): Double = {
  val result = operator match {
    case "+" => number1 + number2
    case "-" => number1 - number2
    case "/" => number1 / number2
    case "*" => number1 * number2
  }
  result
}

def computeValue(data: List[OperationIndex]): Double = {
  data.foldLeft(0.0) {
    (acc: Double, element: OperationIndex) =>
      acc + parser(element.numbers.number1, element.numbers.number2, element.operator)
  }
}

computeValue(List(OperationIndex(NumberPair(10.0, 20.0), "+")))

List(1,2,3).foldLeft(0)((a,b) => a + b)