package steps

/**
 * Created by def on 25.02.17.
 */


class Repeat(val action: () -> Unit) {

    companion object {
        fun repeat(action: () -> Unit) : Repeat {
            return Repeat(action)
        }
    }

    fun waitingFor(condition:()->Boolean) {
        while (true) {
            action()
            if(condition()) {
                break
            }
        }
    }
}
