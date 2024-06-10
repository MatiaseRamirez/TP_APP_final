package mylogin.com

import android.app.Application

class BurgerApp :Application(){

    companion object{
        lateinit var instance: BurgerApp
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }
}
