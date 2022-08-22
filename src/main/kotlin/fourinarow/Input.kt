package fourinarow

class Input {
     fun askCoordinate(): Int {
        println("Enter a column:")
        val input = readLine()!!
        return input.toInt()
    }
}
