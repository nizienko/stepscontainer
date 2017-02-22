package content

import steps.Inject
import steps.Steps

/**
 * Created by def on 22.02.17.
 */
class Test2Steps: Steps() {

//    @Inject lateinit var testSteps: TestSteps

    fun doSomeStep(){
        println("doing something ${this.javaClass}")
    }
}