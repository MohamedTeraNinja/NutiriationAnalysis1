package com.mohammedragab.nutiriationanalysis1
import android.app.Application
import com.mohammedragab.nutiriationanalysis1.di.ApplicationComponent
import com.mohammedragab.nutiriationanalysis1.di.DaggerApplicationComponent


class MyApplication:Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}