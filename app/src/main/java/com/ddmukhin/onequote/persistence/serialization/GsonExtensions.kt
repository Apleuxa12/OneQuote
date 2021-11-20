package com.ddmukhin.onequote.persistence.serialization

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun Any.toJson() = Gson().toJson(this)

inline fun <reified T> String.fromJson() = Gson().fromJson<T>(this, object: TypeToken<T>() { }.type)