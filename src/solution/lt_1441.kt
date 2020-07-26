package solution

fun buildArray(target: IntArray, n: Int): List<String> {
    val result = mutableListOf<String>()
    var index = 0
    for (i in 1..n) {
        if (index == target.size) {
            break
        }
        result.add("Push")
        if (target[index] == i) {
            index++
        } else {
            result.add("Pop")
        }
    }
    return result
}