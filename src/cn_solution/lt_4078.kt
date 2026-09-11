package cn_solution

class Solution_4078 {

    companion object {
        val fibs = arrayListOf(0, 1)

        init {
            do {
                val n = fibs.size
                val x = fibs[n - 2] + fibs[n - 1]
                if (x > 500000000)
                    break
                fibs += x
            } while (true)
        }
    }

    fun threeFibonacciSum(n: Int): Boolean {
        return n % 2 == 0 && n / 2 in fibs
    }
}