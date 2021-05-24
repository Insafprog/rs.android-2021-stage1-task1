package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        // calculate should refund
        val result = b - (bill.sum() - bill[k]) / 2

        if (result == 0) return "Bon Appetit"
        return result.toString()
    }
}
