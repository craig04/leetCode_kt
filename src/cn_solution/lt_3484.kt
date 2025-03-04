package cn_solution

class Spreadsheet(rows: Int) {

    private val cells = HashMap<String, Int>()

    fun setCell(cell: String, value: Int) {
        cells[cell] = value
    }

    fun resetCell(cell: String) {
        cells.remove(cell)
    }

    fun getValue(formula: String): Int {
        val pos = formula.indexOf('+')
        val x = formula.substring(1, pos)
        val y = formula.substring(pos + 1)
        return parse(x) + parse(y)
    }

    private fun parse(s: String) =
        if (s[0].isDigit()) s.toInt() else cells[s] ?: 0
}