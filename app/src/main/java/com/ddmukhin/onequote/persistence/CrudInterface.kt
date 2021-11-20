package com.ddmukhin.onequote.persistence

interface CrudInterface<K> {

    fun <V> read(key: K): V

    fun <V> write(key: K, value: V): Boolean

    fun <V> update(key: K, value: V): Boolean

    fun delete(key: K): Boolean

}