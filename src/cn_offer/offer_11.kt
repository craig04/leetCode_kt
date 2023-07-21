package cn_offer

fun minArray(numbers: IntArray): Int {
    var left = 0
    var right = numbers.size - 1
    loop@ while (left != right) {
        val mid = (left + right) shr 1
        val num = numbers[mid]
        when {
            num < numbers[right] -> right = mid
            num > numbers[right] -> left = mid + 1
            num > numbers[left] -> break@loop
            num < numbers[left] -> right = mid
            else -> right--
        }
    }
    return numbers[left]
}