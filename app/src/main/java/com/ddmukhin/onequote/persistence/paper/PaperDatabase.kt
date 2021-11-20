package com.ddmukhin.onequote.persistence.paper

import android.content.Context
import com.ddmukhin.onequote.persistence.Database
import io.paperdb.Paper
import java.lang.ref.WeakReference

class PaperDatabase : Database<PaperKey> {

    override fun <T> read(key: PaperKey): T = Paper.book().read(key.value)

    override fun <T> write(key: PaperKey, value: T): Boolean {
        return try{
            Paper.book().write(key.value, value)
            true
        }catch (e: Exception){
            false
        }
    }

    override fun <T> update(key: PaperKey, value: T): Boolean {
        return try{
            Paper.book().write(key.value, value)
            true
        }catch (e: Exception){
            false
        }
    }

    override fun delete(key: PaperKey): Boolean {
        return try{
            Paper.book().delete(key.value)
            true
        }catch (e: Exception){
            false
        }
    }
}