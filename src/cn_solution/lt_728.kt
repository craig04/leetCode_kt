package cn_solution

fun selfDividingNumbers(left: Int, right: Int): List<Int> {
    return (left..right).filter {
        var temp = it
        while (temp != 0) {
            val modulo = temp % 10
            if (modulo == 0 || it % modulo != 0)
                return@filter false
            temp /= 10
        }
        true
    }
}