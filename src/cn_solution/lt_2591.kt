package cn_solution

fun distMoney(money: Int, children: Int): Int {
    if (money < children)
        return -1
    val temp = children * 8 - money
    return when {
        temp == 4 -> children - 2
        temp < 0 -> children - 1
        else -> (money - children) / 7
    }
}