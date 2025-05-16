package cn_solution

class CombinationIterator(characters: String, val combinationLength: Int) {

    private var char = characters.toCharArray().apply { sort() }
    private var used = 1.shl(combinationLength) - 1
    private val mask = 1.shl(char.size) - 1

    fun next(): String {
        val sb = StringBuilder()
        var t = used
        while (t != 0) {
            sb.append(char[t.countTrailingZeroBits()])
            t = t and (t - 1)
        }
        used = used or mask.inv()
        used += 1.shl(32 - used.inv().countLeadingZeroBits())
        if (used != 0) {
            used += used.takeHighestOneBit()
            val bits = 1.shl(combinationLength - used.countOneBits()) - 1
            used += bits shl (32 - used.countLeadingZeroBits())
        }
        return String(sb)
    }

    fun hasNext(): Boolean {
        return used != 0
    }
}