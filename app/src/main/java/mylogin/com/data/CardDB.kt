package mylogin.com.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mylogin.com.BurgerApp
import mylogin.com.constants.Constants
import mylogin.com.model.Card

@Database(entities = [Card::class], version = 4, exportSchema = false)
abstract class CardDB : RoomDatabase() {

    abstract fun cardDao(): CardDao

    companion object {
        @Volatile
        private var INSTANCE: CardDB? = null

        // Singleton
        fun getDatabase(): CardDB {
            val tempInstance = INSTANCE

            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    BurgerApp.instance.applicationContext,
                    CardDB::class.java,
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