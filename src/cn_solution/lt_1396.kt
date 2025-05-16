package cn_solution

class UndergroundSystem() {

    private val passenger = HashMap<Int, Pair<String, Int>>()
    private val stations = HashMap<String, Pair<Long, Int>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        passenger[id] = Pair(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val (src, time) = passenger.remove(id)!!
        val trip = "$src->$stationName"
        val (cost, cnt) = stations[trip] ?: Pair(0L, 0)
        stations[trip] = Pair(cost + t - time, cnt + 1)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val (cost, cnt) = stations["$startStation->$endStation"]!!
        return 1.0 * cost / cnt
    }
}