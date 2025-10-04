package org.example.david

class SquarepointQ6 {

    /**
     * for [...,a,b,...]
     * so long as a+b > 0, continue
     * otherwise, increment b
     */
    fun solution(list: MutableList<Long>): Int {
        if (list.size <= 1) {
            return 0
        }
        val maxVal = 1_000_000_000_000_000_000L
        var op = 0
        for (i in 1..list.size-1) {
            val a = list[i - 1]
            val b = list[i]
            if ((a <= 0 || b <= 0) && a+b < 0) {
                println("found issue at [$a,$b]")
                op++
                list[i] = maxVal
            }
        }
        return op
    }
}