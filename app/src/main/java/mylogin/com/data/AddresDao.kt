package mylogin.com.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import mylogin.com.model.Addres

@Dao
interface AddresDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(addres: Addres)


    @Query("SELECT * FROM addres_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Addres>> //getall

    @Update
    suspend fun update(addres: Addres)

    @Delete
    suspend fun deleteAddres(addres: Addres)

    @Query("DELETE FROM addres_table")
    suspend fun deleteAll()}