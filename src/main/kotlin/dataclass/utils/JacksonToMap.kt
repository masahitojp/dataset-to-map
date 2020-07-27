package dataclass.utils

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


val mapper = jacksonObjectMapper()

fun <T> T.serializeToMapWithJackson(): Map<String, Any> {
    return mapper.convertValue(
        this,
        object : TypeReference<Map<String, Any>>() {})
}
