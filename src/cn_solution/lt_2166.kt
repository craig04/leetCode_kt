package cn_solution

class Bitset(size: Int) {

    private val mask = BooleanArray(size)
    private var flip = false
    private var bits = 0

    fun fix(idx: Int) {
        if (flip == mask[idx]) {
            mask[idx] = !flip
            bits++
        }
    }

    fun unfix(idx: Int) {
        if (flip != mask[idx]) {
            mask[idx] = flip
            bits--
        }
    }

    fun flip() {
        flip = !flip
        bits = mask.size - bits
    }

    fun all(): Boolean {
        return bits == mask.size
    }

    fun one(): Boolean {
        return bits > 0
    }

    fun count(): Int {
        return bits
    }

    override fun toString(): String {
        val ans = StringBuilder()
        for (bit in mask)
            ans.append(if (bit == flip) '0' else '1')
        return ans.toString()
    }
}