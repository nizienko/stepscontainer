package tests

import content.Test2Steps
import content.TestSteps
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import steps.extensions.StepsResolver

/**
 * Created by def on 21.02.17.
 */

@ExtendWith(StepsResolver::class)
class StepsContainerTest(
        val testSteps: TestSteps,
        val test2Steps: Test2Steps
) {

    @Test fun test2() {
        println("Test")
        testSteps
                .doSomeStep()
    }

    @Test fun test3() {
        println("Test2")
        testSteps
                .doSomeStep()
        testSteps
                .test2Steps
                .doSomeStep()
        test2Steps.doSomeStep()
    }
}