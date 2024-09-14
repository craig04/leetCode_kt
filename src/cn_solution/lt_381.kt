package cn_solution

class RandomizedCollection() {

    private val numbers = ArrayList<Int>()
    private val indices = HashMap<Int, HashSet<Int>>()

    fun insert(`val`: Int): Boolean {
        val list = indices.computeIfAbsent(`val`) { HashSet() }
        list.add(numbers.size)
        numbers.add(`val`)
        return list.size == 1
    }

    fun remove(`val`: Int): Boolean {
        val set = indices[`val`]
        if (set.isNullOrEmpty())
            return false
        val idx = set.first()
        if (set.size == 1)
            indices.remove(`val`)
        else
            set.remove(idx)
        val n = numbers.removeLast()
        if (idx != numbers.size) {
            numbers[idx] = n
            indices[n]?.run {
                remove(numbers.size)
                add(idx)
            }
        }
        return true
    }

    fun getRandom(): Int {
        return numbers[java.util.Random().nextInt(numbers.size)]
    }
}
