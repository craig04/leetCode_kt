package cn_solution

class RideSharingSystem() {

    val rider = ArrayDeque<Int>()
    val driver = ArrayDeque<Int>()
    val pending = HashSet<Int>()

    fun addRider(riderId: Int) {
        rider += riderId
        pending += riderId
    }

    fun addDriver(driverId: Int) {
        driver += driverId
    }

    fun matchDriverWithRider(): IntArray {
        while (rider.isNotEmpty() && rider.first() !in pending)
            rider.removeFirst()
        return if (rider.isEmpty() || driver.isEmpty())
            intArrayOf(-1, -1)
        else {
            pending -= rider.first()
            intArrayOf(driver.removeFirst(), rider.removeFirst())
        }
    }

    fun cancelRider(riderId: Int) {
        pending -= riderId
    }
}