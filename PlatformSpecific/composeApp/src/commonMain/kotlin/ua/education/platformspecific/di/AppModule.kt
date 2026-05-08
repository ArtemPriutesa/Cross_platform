package ua.education.platformspecific.di

import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel
import ua.education.platformspecific.data.about.AboutRepository
import ua.education.platformspecific.data.about.Platform
import ua.education.platformspecific.ui.about.AboutViewModel


val appModule = module {
    single<Platform>()
    single<AboutRepository>()
    viewModel<AboutViewModel>()
}