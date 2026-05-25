package ua.education.platformspecific.data.common.preferences

import kotlinx.coroutines.flow.Flow

interface Preferences {

    var aboutVisitedCount: Int

    var aboutVisitedDate: LastTimeScreenOpened?

    val observableAboutVisitedCount: Flow<Int>

    val observableAboutVisitedDate: Flow<LastTimeScreenOpened>

    fun cleanStorage()
}