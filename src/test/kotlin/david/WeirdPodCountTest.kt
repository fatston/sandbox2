package david

import io.kotest.matchers.shouldBe
import org.example.david.WeirdPodCount
import org.junit.jupiter.api.Test

class WeirdPodCountTest {
    val weirdPodCount = WeirdPodCount()

    @Test
    fun test1() {
        val n = 5
        val pods = mutableListOf(5,2,5,3,3)
        val cost = mutableListOf(3,7,8,6,9)
        weirdPodCount.solution(n,pods,cost) shouldBe 9
    }

    @Test
    fun testNoIncrementNeeded() {
        val n = 4
        val pods = mutableListOf(1, 2, 3, 4)
        val cost = mutableListOf(5, 5, 5, 5)

        weirdPodCount.solution(n, pods, cost) shouldBe 0
    }

    @Test
    fun testManyDuplicates() {
        val n = 5
        val pods = mutableListOf(2, 2, 2, 2, 2)
        val cost = mutableListOf(1, 2, 3, 4, 5)

        weirdPodCount.solution(n, pods, cost) shouldBe 20
    }

    @Test
    fun testCheaperIncrementsPreferred() {
        val n = 4
        val pods = mutableListOf(3, 3, 4, 4)
        val cost = mutableListOf(1, 10, 2, 20)

        weirdPodCount.solution(n, pods, cost) shouldBe 5
    }

    @Test
    fun testSingleElement() {
        val n = 1
        val pods = mutableListOf(7)
        val cost = mutableListOf(100)

        // Only one value, already unique -> no increments needed
        weirdPodCount.solution(n, pods, cost) shouldBe 0
    }

    @Test
    fun testAllSameCostDifferentPods() {
        val n = 5
        val pods = mutableListOf(1, 1, 2, 2, 3)
        val cost = mutableListOf(5, 5, 5, 5, 5)
        weirdPodCount.solution(n, pods, cost) shouldBe 30
    }

    @Test
    fun testLargeJumpsNeeded() {
        val n = 4
        val pods = mutableListOf(1, 1, 1, 1)
        val cost = mutableListOf(10, 1, 10, 1)
        weirdPodCount.solution(n, pods, cost) shouldBe 15
        // Cheap elements (cost=1) incremented first to avoid expensive increments
    }

    @Test
    fun testAlmostDistinctButOneDuplicate() {
        val n = 4
        val pods = mutableListOf(1, 2, 3, 3)
        val cost = mutableListOf(2, 2, 2, 2)
        weirdPodCount.solution(n, pods, cost) shouldBe 2
        // Increment one '3' to '4'; total cost 2
    }

    @Test
    fun testDescendingPods() {
        val n = 4
        val pods = mutableListOf(5, 4, 3, 2)
        val cost = mutableListOf(1, 1, 1, 1)
        weirdPodCount.solution(n, pods, cost) shouldBe 0
        // Already unique even though descending; no increments needed
    }

    @Test
    fun testMixedCostsAndDuplicates() {
        val n = 5
        val pods = mutableListOf(2, 2, 3, 3, 4)
        val cost = mutableListOf(9, 1, 8, 1, 2)
        weirdPodCount.solution(n, pods, cost) shouldBe 6
        // Increment cheap ones (cost=1) to 5 and 6; total minimal cost 3
    }

    @Test
    fun testChainReactionDuplicates() {
        val n = 4
        val pods = mutableListOf(1, 1, 2, 2)
        val cost = mutableListOf(1, 3, 1, 10)

        // Best is to keep the expensive ones at 1 and 2, and push the cheap ones past collisions → total cost = 4
        // e.g., keep 1(cost=3), keep 2(cost=10), move 1(cost=1)→3 (+2), move 2(cost=1)→4 (+2)
        weirdPodCount.solution(n, pods, cost) shouldBe 4
    }

    @Test
    fun testThreeDuplicatesBreaksLogic() {
        val n = 3
        val pods = mutableListOf(2, 2, 2)
        val cost = mutableListOf(3, 2, 1)

        // Correct total under per-step model = 4
        weirdPodCount.solution(n, pods, cost) shouldBe 4
    }

}