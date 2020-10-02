package solution


fun threeConsecutiveOdds(arr: IntArray): Boolean {
    return (2 until arr.size).any {
        arr[it - 2] and arr[it - 1] and arr[it] and 1 == 1
    }
}