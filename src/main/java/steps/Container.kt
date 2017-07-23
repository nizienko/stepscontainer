package steps

import java.util.*


/**
 * Created by def on 21.02.17.
 */

val container: MutableMap<String, Any> = HashMap()
val inProgressList: MutableList<String> = ArrayList()

@Synchronized
fun get(kClass: Class<*>): Any {
    if (!container.containsKey(kClass.name)) {
        val name = kClass.name
        if (inProgressList.contains(name)) {
            throw IllegalStateException("$name циклически зависим")
        }
        inProgressList.add(name)
        container.put(name, kClass.newInstance())
        inProgressList.remove(name)
    }
    return container[kClass.name]!!
}
