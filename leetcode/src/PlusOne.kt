class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        var inStep = 0
        var index = digits.size - 1
        if (digits[index] + 1 >= 10) {
            inStep = 1
            digits[index] = 0
        } else {
            digits[index] = digits[index] + 1
        }
        index -= 1
        if (inStep != 0) {
            while (index >= 0) {
                if (inStep == 0) {
                    break
                } else {
                    if (digits[index] + 1 >= 10) {
                        digits[index] = 0
                        inStep = 1
                    } else {
                        inStep = 0;
                        digits[index] +=1
                    }
                }
                index -= 1
            }
        }
        if (inStep == 1) {
            var result = ArrayList<Int>()
            result.add(1)
            result.addAll(digits.asList())
            return result.toIntArray()
        }
        return digits
    }
}

fun main(){
    val plusOne = PlusOne()
    plusOne.plusOne((listOf<Int>(8,9,9,9)).toIntArray())
}