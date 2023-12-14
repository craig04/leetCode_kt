package cn_solution

fun maxCandies(
    status: IntArray,
    candies: IntArray,
    keys: Array<IntArray>,
    containedBoxes: Array<IntArray>,
    initialBoxes: IntArray
): Int {
    var result = 0
    val closed = HashSet<Int>()
    val q = ArrayDeque<Int>()
    for (box in initialBoxes) {
        if (status[box] == 1)
            q.addLast(box)
        else
            closed.add(box)
    }
    while (q.isNotEmpty()) {
        val box = q.removeFirst()
        result += candies[box]
        for (k in keys[box])
            if (closed.remove(k))
                q.addLast(k)
            else
                status[k] = 1
        for (cb in containedBoxes[box])
            if (status[box] == 1)
                q.addLast(cb)
            else
                closed.add(cb)
    }
    return result
}