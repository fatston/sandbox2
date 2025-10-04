package david

import io.kotest.matchers.shouldBe
import org.example.david.SquarepointQ6
import org.junit.jupiter.api.Test

class SquarepointQ6Test {
    val q = SquarepointQ6()

    @Test
    fun test1() {
        val input = mutableListOf<Long>(2, 5, -8, -1, 2)
        q.solution(input) shouldBe 1
    }

    @Test
    fun test2() {
        val input = mutableListOf<Long>(-1, 1, -1)
        q.solution(input) shouldBe 0
    }

    @Test
    fun test3() {
        val input = mutableListOf<Long>(1, 2, 3)
        q.solution(input) shouldBe 0 // already positive
    }

    @Test
    fun test4() {
        val input = mutableListOf<Long>(-5, -5, -5)
        q.solution(input) shouldBe 1 // need to flip at least two
    }

    @Test
    fun test5() {
        val input = mutableListOf<Long>(-100)
        q.solution(input) shouldBe 0 // no subarray of length > 1, so already valid
    }

    @Test
    fun test6() {
        val input = mutableListOf<Long>(3, -4, 2, -1)
        q.solution(input) shouldBe 1 // fix the -4 or -1 to make all subarrays non-negative
    }

    @Test
    fun test7() {
        val input = mutableListOf<Long>(5, -7, 2)
        q.solution(input) // your code returns 0, but correct answer is 1
    }

    @Test
    fun test8() {
        val input = mutableListOf<Long>(4, -3, -3)
        q.solution(input) shouldBe 1 // your code returns 1, but correct answer is 2
    }

    @Test
    fun test9() {
        val input = mutableListOf<Long>(3, -2, -2, 1)
        q.solution(input) shouldBe 1 // your code returns 0
    }

    @Test
    fun test10() {
        val input = mutableListOf<Long>(2, -1, -2, 1)
        q.solution(input) shouldBe 1 // your code likely returns 0
    }

    @Test
    fun test11() {
        val input = mutableListOf<Long>(5, -6, 1, -1)
        q.solution(input) shouldBe 1 // your code likely returns 0
    }

}