package cn_solution

fun countOperations(num1: Int, num2: Int): Int {
    var ans = 0
    var x = num1
    var y = num2
    while (x != 0 && y != 0) {
        if (x > y)
            x -= y
        else
            y -= x
        ans++
    }
    return ans
}