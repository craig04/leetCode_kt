package cn_solution

fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
    val range = minOf(start, destination) until maxOf(start, destination)
    var forward = 0
    var backward = 0
    for (i in distance)
        if (i in range)
            forward += distance[i]
        else
            backward += distance[i]
    return minOf(forward, backward)
}