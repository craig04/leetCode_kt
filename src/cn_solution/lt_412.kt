package cn_solution

fun fizzBuzz(n: Int): List<String> {
    return (1..n).map {
        val a = if (it % 3 == 0) 1 else 0
        val b = if (it % 5 == 0) 2 else 0
        when (a + b) {
            3 -> "FizzBuzz"
            2 -> "Buzz"
            1 -> "Fizz"
            else -> it.toString()
        }
    }
}