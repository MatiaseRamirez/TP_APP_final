package mylogin.com.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mylogin.com.model.Card
import mylogin.com.repository.CardRepository

class CardViewModel : ViewModel(){

private val repository = CardRepository()

    val readAllData: LiveData<List<Card>> = repository.readAllData

    fun insertCard(card: Card) {
        viewModelScope.launch { //(Dispatchers.IO)
            repository.insertCard(card = card)
        }
    }

    fun updateCard(card: Card) {
        viewModelScope.launch {
            repository.updateCard(card = card)
        }
    }


    fun deleteCard(card: Card) {
        viewModelScope.launch {
            repository.deleteCard(card = card)
        }
    }

    fun deleteAllCards() {
        viewModelScope.launch {
            repository.deleteAllCards()
        }
    }

}