package solution

fun maxLength(arr: List<String>): Int {

    val bitsList = arrayListOf<Int>()
    val lengthList = arrayListOf<Int>()
    init@ for (it in arr) {
        var bits = 0
        for (c in it) {
            val bit = 1 shl c - 'a'
            if (bits and bit != 0) {
                continue@init
            }
            bits = bits or bit
        }
        bitsList.add(bits)
        lengthList.add(it.length)
    }

    var result = 0
    val states = 1 shl bitsList.size
    loop@ for (i in 1 until states) {
        var bits = 0
        var length = 0
        var temp = i
        while (temp != 0) {
            val state = Integer.lowestOneBit(temp)
            val j = Integer.numberOfTrailingZeros(state)
            temp = temp and state.inv()
            if (bits and bitsList[j] != 0) {
                continue@loop
            }
            bits = bits or bitsList[j]
            length += lengthList[j]
        }
        result = maxOf(result, length)
    }
    return result
}