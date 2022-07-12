package br.com.curso.extension

import kotlin.reflect.KProperty1

class GenericExtensionFunction {
    companion object {
        fun <T> ReadInstanceProperty(instance: Any, propertyName: String): T {
            val property = instance::class.members
                .first { it.name == propertyName } as KProperty1<Any, *>
            return property.get(instance) as T
        }
    }
}