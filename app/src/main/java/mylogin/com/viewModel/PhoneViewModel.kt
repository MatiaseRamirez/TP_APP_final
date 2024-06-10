package mylogin.com.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mylogin.com.model.Phone
import mylogin.com.repository.PhoneRepository

class PhoneViewModel():ViewModel(){

    private val repository =PhoneRepository()

    val readAllData: LiveData<List<Phone>> = repository.readAllData

    fun insertPhone(phone: Phone) {
        viewModelScope.launch { //(Dispatchers.IO)
            repository.insertPhone(phone = phone)
        }
    }
    fun updatePhone(phone: Phone) {
        viewModelScope.launch {
            repository.updatePhone(phone = phone)
        }
    }


    fun deletePhone(phone: Phone) {
        viewModelScope.launch {
            repository.deletePhone(phone =phone)
        }
    }

    fun deleteAllPhones() {
        viewModelScope.launch {
            repository.deleteAllPhones()
        }
    }

}