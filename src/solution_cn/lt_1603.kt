package solution_cn

class ParkingSystem(big: Int, medium: Int, small: Int) {

    private val remain = intArrayOf(big, medium, small)

    fun addCar(carType: Int): Boolean {
        if (remain[carType - 1] == 0) {
            return false
        }
        remain[carType - 1]--
        return true
    }
}
