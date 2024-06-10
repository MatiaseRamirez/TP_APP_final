package mylogin.com.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import mylogin.com.model.Phone
@Dao
interface PhoneDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(phone: Phone)

    @Query("SELECT * FROM phone_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Phone>>
    @Update
    suspend fun update(phone: Phone)

    @Delete
    suspend fun deletePhone(phone: Phone)

    @Query("DELETE FROM phone_table")
    suspend fun deleteAll()

}