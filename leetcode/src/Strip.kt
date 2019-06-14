class Strip {

    fun removeElement(nums: IntArray, target: Int): Int {
        var start = 0
        var index = 0
        while (index < nums.size) {
            if (target != nums[index++]) {
                nums[start++] = nums[index - 1]
            }
        }
        return start
    }
}

fun main() {
    val strip = Strip()
    val testCase = listOf<Int>(3, 2, 2, 3)
    strip.removeElement(testCase.toIntArray(), 3)
}