package mylogin.com.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "phone_table")

data class Phone (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "phone")
    val phone: String

): Serializable