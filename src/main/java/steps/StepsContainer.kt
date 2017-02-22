package steps

import java.util.*


/**
 * Created by def on 21.02.17.
 */
class StepsContainer {
    companion object {
        val container: MutableMap<String, Steps> = HashMap()
        val inProgressList: MutableList<String> = ArrayList()

        @Synchronized
        fun getSteps(kClass: Class<*>): Steps {
            if (!container.containsKey(kClass.name)) {
                val name = kClass.name
                if (inProgressList.contains(name)) {
                    throw IllegalStateException("$name циклически зависим")
                }
                inProgressList.add(name)
                container.put(name, kClass.newInstance() as Steps)
                inProgressList.remove(name)
            }
            return container[kClass.name] as Steps
        }
    }
}