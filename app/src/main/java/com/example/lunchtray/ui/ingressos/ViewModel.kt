package com.example.lunchtray.ui.ingressos

import Ticket
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TicketViewModel : ViewModel() {
    private val _savedTickets = MutableLiveData<List<Ticket>>(emptyList())
    val savedTickets: LiveData<List<Ticket>> get() = _savedTickets
    fun addTicket(ticket: Ticket) {
        val updatedList = _savedTickets.value.orEmpty().toMutableList().apply {
            add(ticket)
        }
        _savedTickets.value = updatedList
    }
    fun deleteTicket(ticket: Ticket) {
        val updatedList = _savedTickets.value.orEmpty().toMutableList().apply {
            remove(ticket)
        }
        _savedTickets.value = updatedList
    }
}
