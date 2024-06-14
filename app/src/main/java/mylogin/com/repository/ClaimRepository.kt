package mylogin.com.repository

import androidx.lifecycle.LiveData
import mylogin.com.data.ClaimDB

import mylogin.com.model.Claim


class ClaimRepository {

    private val claimDao= ClaimDB.getDatabase().claimDao()
    val readAllData: LiveData<List<Claim>> = claimDao.readAllData()

    suspend fun insertClaim(claim: Claim) {
        claimDao.insert(claim = claim)
    }


    suspend fun updateClaim(claim: Claim) {
        claimDao.update(claim = claim)
    }


    suspend fun deleteClaim(claim: Claim) {
        claimDao.deleteClaim(claim = claim)
    }

    suspend fun deleteAllClaim() {
        claimDao.deleteAll()
    }
}
