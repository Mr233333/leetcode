class Jump {
    fun jump(nums: IntArray): Int {
        val jumpTime = IntArray(nums.size)
        for ((index, limit) in nums.withIndex()) {
            var innerIndex = 1
            while (innerIndex <= limit) {
                if (index + innerIndex < nums.size) {
                    val step = jumpTime[index] + 1
                    if(jumpTime[innerIndex + index] == 0){
                        jumpTime[innerIndex + index] = step
                    }else{
                        if (step <= jumpTime[innerIndex + index]) {
                            jumpTime[innerIndex + index] = step
                        }
                    }
                }
                innerIndex++
            }
        }
        return jumpTime[nums.size - 1]
    }
}

fun main() {
    val jump = Jump()
    val testCase = listOf<Int>(2, 3, 1, 1, 4)
    jump.jump(testCase.toIntArray())
}