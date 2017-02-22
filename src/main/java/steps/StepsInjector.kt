package steps

/**
 * Created by def on 22.02.17.
 */

class StepsInjector {
    companion object {
        fun autoInjectSteps(o: Any) {
            o.javaClass.declaredFields.forEach {
                if (it.isAnnotationPresent(Inject::class.java)) {
                    val field = StepsContainer.getSteps(it.type)
                    it.isAccessible = true
                    it.set(o, field)
                    it.isAccessible = false
                }
            }
        }
    }
}