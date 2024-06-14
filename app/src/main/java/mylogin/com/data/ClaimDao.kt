package mylogin.com.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import mylogin.com.model.Claim

@Dao
interface ClaimDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(claim: Claim)
//

    @Query("SELECT * FROM claim_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Claim>> //getall

    @Update
    suspend fun update(claim: Claim)

    @Delete
    suspend fun deleteClaim(claim: Claim)

    @Query("DELETE FROM claim_table")
    suspend fun deleteAll()}