package content

import steps.Inject
import steps.Steps

/**
 * Created by def on 21.02.17.
 */
class TestSteps: Steps() {

    @Inject lateinit var test2Steps: Test2Steps

    fun doSomeStep(){
        println("doing something ${this.javaClass}")
    }
}