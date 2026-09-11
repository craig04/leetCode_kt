package cn_solution

class Solution_1916 {

    companion object {
        const val MOD = 1000000007
        val fac = LongArray(100001)

        init {
            fac[0] = 1
            for (i in 1 until fac.size)
                fac[i] = fac[i - 1] * i % MOD
        }
    }

    fun waysToBuildRooms(prevRoom: IntArray): Int {
        val n = prevRoom.size
        val g = Array(n) { ArrayList<Int>() }
        for (i in 1 until n)
            g[prevRoom[i]] += i
        var div = 1L
        fun dfs(x: Int): Int {
            val res = 1 + g[x].sumOf(::dfs)
            div = div * res % MOD
            return res
        }
        dfs(0)
        var pow = MOD - 2
        var mul = 1L
        while (pow != 0) {
            if (pow and 1 == 1)
                mul = mul * div % MOD
            div = div * div % MOD
            pow /= 2
        }
        return (fac[n] * mul).mod(MOD)
    }
}