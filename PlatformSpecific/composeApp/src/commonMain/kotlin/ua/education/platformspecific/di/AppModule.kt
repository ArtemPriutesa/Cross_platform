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
import ua.education.platformspecific.data.common.preferences.AppPreferences
import ua.education.platformspecific.data.common.preferences.Preferences
import ua.education.platformspecific.data.reminders.RemindersRepository
import ua.education.platformspecific.ui.about.AboutViewModel
import ua.education.platformspecific.ui.reminders.ReminderViewModel


private fun createSettings() : Settings = Settings()

val dataModule = module {
    single { create(::createSettings) } binds arrayOf(Settings::class, ObservableSettings::class)
    singleOf(::AppPreferences) bind Preferences::class
}

val appModule = module {
    includes(dataModule)
    single<Platform>()
    single<AboutRepository>()
    viewModel<AboutViewModel>()
    single<RemindersRepository>()
    viewModel<ReminderViewModel>()
}