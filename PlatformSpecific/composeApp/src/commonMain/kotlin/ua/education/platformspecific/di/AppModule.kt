package ua.education.platformspecific.di

import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module
import org.koin.plugin.module.dsl.create
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel
import ua.education.platformspecific.data.about.AboutRepository
import ua.education.platformspecific.data.about.Platform
import ua.education.platformspecific.data.common.db.DatabaseDriverFactory
import ua.education.platformspecific.data.common.db.DbDataSource
import ua.education.platformspecific.data.common.db.LocalDataSource
import ua.education.platformspecific.data.common.preferences.AppPreferences
import ua.education.platformspecific.data.common.preferences.Preferences
import ua.education.platformspecific.data.reminders.RemindersRepository
import ua.education.platformspecific.db.Organise
import ua.education.platformspecific.ui.about.AboutViewModel
import ua.education.platformspecific.ui.reminders.ReminderViewModel


private fun createSettings() : Settings = Settings()

private fun createDb(driver: DatabaseDriverFactory) : Organise = Organise(driver.create())

val dataModule = module {
    single { create(::createSettings) } binds arrayOf(Settings::class, ObservableSettings::class)
    singleOf(::AppPreferences) bind Preferences::class
    single<DatabaseDriverFactory>()
    single { create(::createDb) }
    singleOf(::DbDataSource) bind LocalDataSource::class
}

val appModule = module {
    includes(dataModule)
    single<Platform>()
    single<AboutRepository>()
    viewModel<AboutViewModel>()
    single<RemindersRepository>()
    viewModel<ReminderViewModel>()
}