package mylogin.com.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import mylogin.com.model.Card

@Dao
interface CardDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(card: Card)


    @Query("SELECT * FROM card_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Card>>

    @Update
    suspend fun update(card: Card)

    @Delete
    suspend fun deleteCard(card: Card)

    @Query("DELETE FROM card_table")
    suspend fun deleteAll()}