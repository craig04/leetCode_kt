package solution

fun xorOperation(n: Int, start: Int): Int {
    var xor = 0
    var num = start
    repeat(n) {
        xor = xor.xor(num)
        num += 2
    }
    return xor
}