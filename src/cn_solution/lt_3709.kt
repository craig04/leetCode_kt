package cn_solution

class ExamTracker() {

    val times = ArrayList<Int>()
    val pre = arrayListOf(0L)

    fun record(time: Int, score: Int) {
        times.add(time)
        pre.add(pre.last() + score)
    }

    fun totalScore(startTime: Int, endTime: Int): Long {
        var s = times.binarySearch(startTime)
        s = maxOf(s, s.inv())
        var e = times.binarySearch(endTime + 1)
        e = maxOf(e, e.inv())
        return pre[e] - pre[s]
    }
}