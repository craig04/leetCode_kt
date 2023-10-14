package cn_solution

import java.util.PriorityQueue

fun topStudents(
    positive_feedback: Array<String>,
    negative_feedback: Array<String>,
    report: Array<String>,
    student_id: IntArray,
    k: Int
): List<Int> {
    val words = HashMap<String, Int>()
    positive_feedback.forEach { words[it] = 3 }
    negative_feedback.forEach { words[it] = -1 }
    val score = IntArray(report.size) { i ->
        report[i].split(' ').sumOf { words[it] ?: 0 }
    }
    val q = PriorityQueue<Int> { l, r ->
        val diff = score[l] - score[r]
        if (diff == 0) student_id[r] - student_id[l] else diff
    }
    student_id.indices.forEach {
        q.add(it)
        if (q.size > k)
            q.poll()
    }
    val result = ArrayList<Int>()
    while (q.isNotEmpty())
        result.add(student_id[q.poll()])
    return result.asReversed()
}