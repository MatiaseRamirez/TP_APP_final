package mylogin.com.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "card_table")

data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "numero")
    val numero: String,
    @ColumnInfo(name = "date")
    val date:String,
    @ColumnInfo(name = "name")
    val name:String

):Serializable
