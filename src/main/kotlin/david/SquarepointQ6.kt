package org.example.david

import kotlin.math.max

class SquarepointQ6 {

    /**
     * [...,a,b,c,...]
     * if a+b <= 0 or a+b+c <= 0 then make b big
     */
    fun solution(list: MutableList<Long>): Int {
        if (list.size < 2) return 0
        val big = Math.pow(10.0, 18.0).toLong()
        var ops = 0

        for (i in 1 until list.size) {
            val badPair = list[i - 1] + list[i] < 0
            val badTriple = ((i >= 2) && (list[i - 2] + list[i - 1] + list[i] < 0))
            if (badPair || badTriple) {
                ops++
                list[i] = big
            }
        }
        return ops
    }
}