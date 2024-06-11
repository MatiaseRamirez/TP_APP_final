package mylogin.com.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mylogin.com.model.Addres
import mylogin.com.repository.AddresRepository

class AddresViewModel : ViewModel(){

private val repository = AddresRepository()

    val readAllData: LiveData<List<Addres>> = repository.readAllData

    fun insertAddres(addres: Addres) {
        viewModelScope.launch { //(Dispatchers.IO)
            repository.insertAddres(addres = addres)
        }
    }

    fun updateAddres(addres: Addres) {
        viewModelScope.launch {
            repository.updateAddres(addres = addres)
        }
    }


    fun deleteAddres(addres: Addres) {
        viewModelScope.launch {
            repository.deleteAddres(addres = addres)
        }
    }

    fun deleteAllAddress() {
        viewModelScope.launch {
            repository.deleteAllAddress()
        }
    }

}