package cn_solution

class Solution_478(val radius: Double, val x_center: Double, val y_center: Double) {

    fun randPoint(): DoubleArray {
        val alpha = Math.random() * 2 * Math.PI
        val length = Math.sqrt(Math.random()) * radius
        return doubleArrayOf(
            x_center + Math.cos(alpha) * length, y_center + Math.sin(alpha) * length
        )
    }
}