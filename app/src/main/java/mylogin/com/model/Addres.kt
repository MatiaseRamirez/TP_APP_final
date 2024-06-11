package mylogin.com.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "addres_table")

data class Addres(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "street")
    val street: String,
    @ColumnInfo(name = "height")
    val height:String,
    @ColumnInfo(name = "postalcode")
    val postalcode:String,
    @ColumnInfo(name = "state")
    val state:String

):Serializable
