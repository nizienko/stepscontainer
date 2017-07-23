package steps

/**
 * Created by def on 22.02.17.
 */

fun autoInject(o: Any) {
    o.javaClass.declaredFields.forEach {
        if (it.isAnnotationPresent(Inject::class.java)) {
            val field = get(it.type)
            it.isAccessible = true
            it.set(o, field)
            it.isAccessible = false
        }
    }
}
