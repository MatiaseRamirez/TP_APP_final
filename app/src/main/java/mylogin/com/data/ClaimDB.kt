package mylogin.com.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mylogin.com.BurgerApp
import mylogin.com.constants.Constants
import mylogin.com.model.Claim

@Database(entities = [Claim::class], version = 3, exportSchema = false)
abstract class ClaimDB : RoomDatabase() {

    abstract fun claimDao(): ClaimDao

    companion object {
        @Volatile
        private var INSTANCE: ClaimDB? = null

        // Singleton
        fun getDatabase(): ClaimDB {
            val tempInstance = INSTANCE

            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    BurgerApp.instance.applicationContext,
                    ClaimDB::class.java,
                    Constants.DB_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }

    }

}