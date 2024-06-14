package mylogin.com.repository

import androidx.lifecycle.LiveData
import mylogin.com.data.CardDB
import mylogin.com.model.Card

class CardRepository {

    private val cardDao= CardDB.getDatabase().cardDao()
    val readAllData: LiveData<List<Card>> = cardDao.readAllData()

    suspend fun insertCard(card: Card) {
        cardDao.insert(card = card)
    }


    suspend fun updateCard(card: Card) {
        cardDao.update(card = card)
    }


    suspend fun deleteCard(card: Card) {
        cardDao.deleteCard(card = card)
    }

    suspend fun deleteAllCards() {
        cardDao.deleteAll()
    }
}
