package steps

/**
 * Created by def on 21.02.17.
 */
open abstract class Steps {
    init {
        autoInject(this)
        println("${this.javaClass} inited")
    }
}