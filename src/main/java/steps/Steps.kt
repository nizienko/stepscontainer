package steps

/**
 * Created by def on 21.02.17.
 */
open abstract class Steps {
    init {
        StepsInjector.autoInjectSteps(this)
        println("${this.javaClass} inited")
    }
}