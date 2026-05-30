package ua.education.platformspecific.data.common.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import ua.education.platformspecific.db.Organise

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:organise.db")
        if (!java.io.File("organise.db").exists()) {
            Organise.Schema.create(driver)
        }
        return driver
    }
}