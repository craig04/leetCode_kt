package cn_solution

fun lemonadeChange(bills: IntArray): Boolean {
    var five = 0
    var ten = 0
    return bills.all {
        if (it == 5) {
            ++five
        } else if (it == 10) {
            ++ten
            --five
        } else if (ten != 0) {
            --ten
            --five
        } else {
            five -= 3
        }
        five >= 0
    }
}