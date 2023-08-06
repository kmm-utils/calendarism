package kmm.utils.library

import kotlin.test.Test
import kotlin.test.assertTrue

class AppleGreetingTest {

    @Test
    fun testExample() {
        assertTrue(Greeting().greet().contains("Apple"), "Check Apple is mentioned")
    }
}