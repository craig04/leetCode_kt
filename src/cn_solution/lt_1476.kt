package cn_solution

class SubrectangleQueries(val rectangle: Array<IntArray>) {

    val update = ArrayList<IntArray>()

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        update.add(intArrayOf(row1, col1, row2, col2, newValue))
    }

    fun getValue(row: Int, col: Int): Int {
        for ((row1, col1, row2, col2, newValue) in update.asReversed())
            if (row in row1..row2 && col in col1..col2)
                return newValue
        return rectangle[row][col]
    }
}