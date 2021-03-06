package steps.extensions

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.api.extension.ParameterResolver
import steps.Steps
import steps.get

/**
 * Created by def on 21.02.17.
 */

class StepsResolver : ParameterResolver {
    override fun resolveParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Any {
        if (parameterContext != null) {
            return get(parameterContext.parameter.type)
        }
        throw IllegalStateException("No such type $parameterContext")
    }

    override fun supportsParameter(parameterContext: ParameterContext?, extensionContext: ExtensionContext?): Boolean {
        if (parameterContext != null) {
            if (parameterContext.parameter.type.superclass == Steps::class.java) {
                return true
            }
        }
        return false
    }

}