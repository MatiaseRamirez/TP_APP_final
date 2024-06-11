package mylogin.com.repository

import androidx.lifecycle.LiveData
import mylogin.com.data.AddresDB
import mylogin.com.data.PhoneDB
import mylogin.com.model.Addres
import mylogin.com.model.Phone

class AddresRepository {

    private val addresDao= AddresDB.getDatabase().addresDao()
    val readAllData: LiveData<List<Addres>> = addresDao.readAllData()

    suspend fun insertAddres(addres: Addres) {
        addresDao.insert(addres = addres)
    }


    suspend fun updateAddres(addres: Addres) {
        addresDao.update(addres = addres)
    }


    suspend fun deleteAddres(addres: Addres) {
        addresDao.deleteAddres(addres = addres)
    }

    suspend fun deleteAllAddress() {
        addresDao.deleteAll()
    }
}
