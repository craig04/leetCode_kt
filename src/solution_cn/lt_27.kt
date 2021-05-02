package solution_cn

fun removeElement(nums: IntArray, `val`: Int): Int {
    var p = 0
    var end = nums.size
    while (p != end) {
        if (nums[p] == `val`) {
            nums[p] = nums[--end]
        } else {
            p++
        }
    }
    return p
}