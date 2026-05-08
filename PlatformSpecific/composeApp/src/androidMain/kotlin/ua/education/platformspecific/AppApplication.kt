package ua.education.platformspecific

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import ua.education.platformspecific.di.initKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@AppApplication)
            androidLogger()
        }
    }
}