import com.sun.xml.internal.fastinfoset.util.StringArray

class PhoneNumber {

    fun letterCombinations(digits: String): List<String> {
        val keyToChar = HashMap<String, List<String>>()
        keyToChar["2"] = listOf("a", "b", "c")
        keyToChar["3"] = listOf("d", "e", "f")
        keyToChar["4"] = listOf("g", "h", "i")
        keyToChar["5"] = listOf("j", "k", "l")
        keyToChar["6"] = listOf("m", "n", "o", "p")
        keyToChar["7"] = listOf("q", "r", "s")
        keyToChar["8"] = listOf("t", "u", "v")
        keyToChar["9"] = listOf("w", "x", "y", "z")
        val result = ArrayList<StringBuilder>()
        val returnResult = ArrayList<String>()
        var index = 0
        for (single in digits.toCharArray()) {
            index += 1
            val singleList = keyToChar[single.toString()]
            if (result.isEmpty()) {
                for(key in singleList!!) {
                    val midVar = StringBuilder(key)
                    result.add(midVar)
                    if(midVar.length == digits.length){
                        returnResult.add(midVar.toString())
                    }
                }
            } else {
                var i =0
                while(i<result.size) {
                    val midVar =result[i++]
                    if(midVar.length<index) {
                        result.remove(midVar)
                        i-=1
                        for(key in singleList!!) {
                            val temp = StringBuilder(midVar)
                            result.add(temp.append(key))
                        }
                    }
                    if(midVar.length == digits.length){
                        returnResult.add(midVar.toString())
                    }
                }
            }
        }
        return returnResult
    }
}
fun main(args: Array<String>){
    val phoneNumber = PhoneNumber()
    print(phoneNumber.letterCombinations("2"))
}