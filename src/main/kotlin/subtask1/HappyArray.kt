package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        // check for empty array
        if (sadArray.isEmpty())
            return sadArray

        val result = mutableListOf(sadArray.first())
        for (i in 1..sadArray.size - 2) {
            if (sadArray[i-1]+sadArray[i+1] >= sadArray[i])
                result.add(sadArray[i])
        }
        result.add(sadArray.last())

        // check again
        if (sadArray.size != result.size)
            return convertToHappy(result.toIntArray())
        return result.toIntArray()
    }
}
