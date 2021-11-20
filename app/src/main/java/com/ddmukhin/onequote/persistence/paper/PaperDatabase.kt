package com.ddmukhin.onequote.persistence.paper

import com.ddmukhin.onequote.persistence.Database
import com.ddmukhin.onequote.persistence.DatabaseKey
import io.paperdb.Paper

class PaperDatabase : Database {

    override fun <T> read(key: DatabaseKey): T = Paper.book().read(key.value)

    override fun <T> write(key: DatabaseKey, value: T): Boolean {
        return try{
            Paper.book().write(key.value, value)
            true
        }catch (e: Exception){
            false
        }
    }

    override fun <T> update(key: DatabaseKey, value: T): Boolean {
        return try{
            Paper.book().write(key.value, value)
            true
        }catch (e: Exception){
            false
        }
    }

    override fun delete(key: DatabaseKey): Boolean {
        return try{
            Paper.book().delete(key.value)
            true
        }catch (e: Exception){
            false
        }
    }
}