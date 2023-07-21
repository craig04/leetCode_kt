package cn_offer

class MaxQueue() {

    private val seqs = ArrayDeque<Int>()
    private val mono = ArrayDeque<Int>()

    fun max_value(): Int {
        return mono.firstOrNull() ?: -1
    }

    fun push_back(value: Int) {
        seqs.addLast(value)
        while (mono.isNotEmpty() && mono.last() < value)
            mono.removeLast()
        mono.addLast(value)
    }

    fun pop_front(): Int {
        if (seqs.isEmpty())
            return -1
        val result = seqs.removeFirst()
        if (result == mono.first())
            mono.removeFirst()
        return result
    }
}