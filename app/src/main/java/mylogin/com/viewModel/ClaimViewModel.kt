package mylogin.com.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mylogin.com.model.Claim
import mylogin.com.repository.ClaimRepository

class ClaimViewModel : ViewModel(){

private val repository = ClaimRepository()

    val readAllData: LiveData<List<Claim>> = repository.readAllData

    fun insertClaim(claim: Claim) {
        viewModelScope.launch { //(Dispatchers.IO)
            repository.insertClaim(claim = claim)
        }
    }

    fun updateClaim(claim: Claim) {
        viewModelScope.launch {
            repository.updateClaim(claim = claim)
        }
    }


    fun deleteClaim(claim: Claim) {
        viewModelScope.launch {
            repository.deleteClaim(claim = claim)
        }
    }

    fun deleteAllClaims() {
        viewModelScope.launch {
            repository.deleteAllClaim()
        }
    }

}