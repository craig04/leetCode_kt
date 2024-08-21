package cn_solution

fun checkRecord(s: String): Boolean {
    var absent = 0
    var late = 0
    return s.all {
        if (it == 'L')
            return@all ++late < 3
        late = 0
        it == 'P' || ++absent < 2
    }
}