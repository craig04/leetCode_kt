package cn_solution

fun rand7(): Int = TODO()

fun rand10(): Int {
    val low = rand7() - 1
    val high = rand7() - 1
    val temp = high * 7 + low
    return if (temp >= 40) rand10() else temp.shr(2) + 1
}