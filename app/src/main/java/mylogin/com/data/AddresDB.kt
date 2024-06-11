package mylogin.com.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mylogin.com.BurgerApp
import mylogin.com.constants.Constants
import mylogin.com.model.Addres

@Database(entities = [Addres::class], version = 2, exportSchema = false)
abstract class AddresDB : RoomDatabase() {

    abstract fun addresDao(): AddresDao

    companion object {
        @Volatile
        private var INSTANCE: AddresDB? = null

        // Singleton
        fun getDatabase(): AddresDB {
            val tempInstance = INSTANCE

            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    BurgerApp.instance.applicationContext,
                    AddresDB::class.java,
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