package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {

        fun parseString(input:String, regex: String): List<String>{
            val rgx = Regex(regex)
            val sequenceResult = rgx.findAll(input)
            val result = mutableListOf<String>()
            for (matchResult in sequenceResult) {
                result.add(matchResult.value)
                if (rgx.containsMatchIn(matchResult.value)) {
                    result.addAll(parseString(matchResult.value, regex))
                }
            }
            return result
        }

        val result = parseString(inputString,"""(?<=\[)([^\[]*?|.*?(\[.*?])+.
            |*?)(?=])|(?<=<)([^<]*?|.*?(<.*?>)+.*?)(?=>)|(?<=\()([^(]*?|.*?
            |(\(.*?\))+.*?)(?=\))""".trimMargin()).toMutableList()

        // function find other valid text

        fun otherResult(regex: String) {
            for (str in parseString(inputString, regex)) {
                if (str !in result)
                    result.add(str)
            }
        }

        otherResult("""(?<=\[)([^\[]*?|.*?(\[.*?])+.*?)(?=])""")
        otherResult("""(?<=<)([^<]*?|.*?(<.*?>)+.*?)(?=>)""")
        otherResult("""(?<=\()([^(]*?|.*?(\(.*?\))+.*?)(?=\))""")

        return result.toTypedArray()
    }
}