package org.example.david

class WeirdPodCount {
    fun solution(
        n: Int,
        pods: MutableList<Int>,
        cost: MutableList<Int>,
    ): Int {
        // prepare data
        val m = mutableMapOf<Int, MutableList<PodCost>>()
        for (i in 0..n-1) {
            val pc = PodCost(pods[i],cost[i],i)
            addOrInsert(m, pc)
        }

        var cheapDupe = getCheapDupe(m)
        var cumCost = 0
        while (cheapDupe != null) {
            println("cheap dupe: $cheapDupe")
            cumCost += cheapDupe.cost
            println("cumCost: $cumCost")
            m[cheapDupe.pods]!!.remove(cheapDupe)
            val newCheapDupe = cheapDupe.copy(pods = cheapDupe.pods + 1)
            addOrInsert(m, newCheapDupe)

            cheapDupe = getCheapDupe(m)
        }
        return cumCost
    }

    private fun getCheapDupe(
        m: Map<Int, List<PodCost>>,
    ): PodCost? {
        for (v in m) {
            if (v.value.size > 1) {
                val cost1 = v.value[0].cost
                val cost2 = v.value[1].cost
                return if (cost1 > cost2) v.value[1] else v.value[0]
            }
        }
        return null
    }

    private fun addOrInsert(m: MutableMap<Int, MutableList<PodCost>>, pc: PodCost) {
        m.getOrPut(pc.pods) { mutableListOf() }.add(pc)
    }

    private data class PodCost (
        var pods: Int,
        var cost: Int,
        var index: Int,
    )
}