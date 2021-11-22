package com.ddmukhin.onequote.persistence

sealed class DatabaseKey(val value: String){

    object Language : DatabaseKey("LANGUAGE")

}
