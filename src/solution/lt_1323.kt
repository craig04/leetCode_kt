package solution

fun maximum69Number(num: Int): Int {
    var base = 3
    var diff = 0
    var copy = num
    do {
        if (copy and 1 == 0) {
            diff = base
        }
        base *= 10
        copy /= 10
    } while (copy != 0)
    return num + diff
}