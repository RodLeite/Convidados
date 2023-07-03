package com.contacts.convidados.repository

import android.content.ContentValues
import android.content.Context
import androidx.core.content.contentValuesOf
import com.contacts.convidados.constans.DataBaseConstants
import com.contacts.convidados.model.GuestModel
import java.lang.Exception

class GuestRepository private constructor(context: Context){

    private val guestDataBase = GuestDataBase(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }

            return repository
        }


    }

    fun insert (guest: GuestModel): Boolean {
        return try {
            val db = guestDataBase.writableDatabase
            val presence = if (guest.presence) 1 else 0

            val values = ContentValues()
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values)
             true
        } catch (e: Exception) {
             false
        }
    }

    fun update () {

    }
}