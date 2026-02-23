package cn_solution

fun largestOddNumber(num: String): String {
    return num.take(num.indexOfLast { (it - '0') % 2 == 1 } + 1)
}