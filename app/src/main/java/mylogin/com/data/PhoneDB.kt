package mylogin.com.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mylogin.com.BurgerApp
import mylogin.com.constants.Constants
import mylogin.com.model.Phone

@Database(entities = [Phone::class], version = 1, exportSchema = false)
abstract class PhoneDB :RoomDatabase() {

    abstract fun phoneDao(): PhoneDao

    companion object {
        @Volatile
        private var INSTANCE: PhoneDB? = null

        fun getDatabase():PhoneDB{
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    BurgerApp.instance.applicationContext,
                    PhoneDB::class.java,
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