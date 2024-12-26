package cn_solution

class ATM() {

    private val denomination = intArrayOf(20, 50, 100, 200, 500)
    private val count = IntArray(5)

    fun deposit(banknotesCount: IntArray) {
        count.indices.forEach { count[it] += banknotesCount[it] }
    }

    fun withdraw(amount: Int): IntArray {
        val ans = IntArray(5)
        var remain = amount
        for (i in count.indices.reversed()) {
            ans[i] = minOf(remain / denomination[i], count[i])
            remain -= ans[i] * denomination[i]
        }
        if (remain != 0)
            return intArrayOf(-1)
        count.indices.forEach { count[it] -= ans[it] }
        return ans
    }
}