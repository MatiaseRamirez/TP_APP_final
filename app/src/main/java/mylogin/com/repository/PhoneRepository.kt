package mylogin.com.repository

import androidx.lifecycle.LiveData
import mylogin.com.data.PhoneDB
import mylogin.com.model.Phone
class PhoneRepository {
    private val phoneDao=PhoneDB.getDatabase().phoneDao()
    val readAllData:LiveData<List<Phone>> = phoneDao.readAllData()

    suspend fun insertPhone(phone: Phone) {
        phoneDao.insert(phone = phone)
    }


    suspend fun updatePhone(phone: Phone) {
        phoneDao.update(phone = phone)
    }


    suspend fun deletePhone(phone: Phone) {
        phoneDao.deletePhone(phone = phone)
    }

    suspend fun deleteAllPhones() {
        phoneDao.deleteAll()
    }
}