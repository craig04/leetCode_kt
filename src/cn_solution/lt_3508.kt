package cn_solution

class Router(val memoryLimit: Int) {

    data class Packet(val src: Int, val dst: Int, val ts: Int)

    private val q = ArrayDeque<Packet>()
    private val set = HashSet<Packet>()
    private val map = HashMap<Int, ArrayDeque<Packet>>()

    fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
        val packet = Packet(source, destination, timestamp)
        if (!set.add(packet))
            return false
        if (q.size == memoryLimit)
            forwardPacket()
        q.addLast(packet)
        map.computeIfAbsent(destination) { ArrayDeque() }.addLast(packet)
        return true
    }

    fun forwardPacket(): IntArray {
        val packet = q.removeFirstOrNull() ?: return IntArray(0)
        map[packet.dst]?.removeFirst()
        set.remove(packet)
        return intArrayOf(packet.src, packet.dst, packet.ts)
    }

    fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
        val q = map[destination] ?: return 0
        fun greater(x: Int): Int {
            var l = 0
            var r = q.size
            while (l != r) {
                val m = (l + r) / 2
                if (q[m].ts > x)
                    r = m
                else
                    l = m + 1
            }
            return l
        }
        return greater(endTime) - greater(startTime - 1)
    }
}