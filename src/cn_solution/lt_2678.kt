package cn_solution

fun countSeniors(details: Array<String>): Int {
    return details.count { (it[11] - '0') * 10 + (it[12] - '0') > 60 }
}