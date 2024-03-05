package cn_solution

class FrequencyTracker() {

    val freq = HashMap<Int, HashSet<Int>>()
    val nums = HashMap<Int, Int>()

    fun add(number: Int) {
        updateFreq(number, 1)
    }

    fun deleteOne(number: Int) {
        updateFreq(number, -1)
    }

    private fun updateFreq(number: Int, delta: Int) {
        val f = nums.remove(number) ?: 0
        if (f + delta < 0)
            return
        nums[number] = f + delta
        freq[f]?.let {
            it.remove(number)
            if (it.isEmpty())
                freq.remove(f)
        }
        freq.computeIfAbsent(f + delta) { HashSet() }.add(number)
    }

    fun hasFrequency(frequency: Int): Boolean {
        return frequency in freq
    }

}