package ua.education.platformspecific.data.common.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import ua.education.platformspecific.db.Organise

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(
            schema = Organise.Schema,
            context = context,
            name = "organise.db"
        )
    }
}