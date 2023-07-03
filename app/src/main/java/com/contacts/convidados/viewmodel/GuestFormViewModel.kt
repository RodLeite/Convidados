package com.contacts.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.contacts.convidados.model.GuestModel
import com.contacts.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    fun insert (guest: GuestModel) {
        repository.insert(guest)
    }
}