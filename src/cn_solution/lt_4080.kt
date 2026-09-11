package cn_solution

class BusBooking(n: Int) {

    var acc = 0
    var cnt = 0
    val map = Array(100001) { IntArray(4) }

    fun toggle(seat: String) {
        val i = seat.drop(1).toInt()
        val j = seat.first() - 'A'
        if (map[i][j] != 0) {
            acc -= map[i][j]
            cnt--
            map[i][j] = 0
        } else {
            var cost = 1
            if ((j == 0 || j == 3) && map[i][j xor 1] != 0)
                cost = 3
            acc += cost
            cnt++
            map[i][j] = cost
        }
    }

    fun getTotalTime(): Int {
        return acc
    }

    fun getMinTime(): Int {
        return cnt
    }

}