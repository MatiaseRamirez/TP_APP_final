package mylogin.com.construc

import java.io.Serializable

data class Usuario(
    val name:String,
    val email:String,
    val password:String
):Serializable
