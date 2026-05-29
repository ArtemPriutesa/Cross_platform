package ua.education.platformspecific.data.reminders

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

internal class RemindersRepository {
    private val _reminders: MutableList<Reminder> = mutableListOf()

    val reminders: List<Reminder>
        get() = _reminders


    @OptIn(ExperimentalUuidApi::class)
    fun createReminder(title: String) {
        val newReminder = Reminder(
            id = Uuid.random().toString(),
            title = title,
            isCompleted = false
        )
        _reminders.add(newReminder)
    }

    fun markReminder(id: String, isCompleted: Boolean) {
        val index = _reminders.indexOfFirst { it.id == id }
        if (index != -1) {
            _reminders[index] = _reminders[index].copy(isCompleted = isCompleted)
        }
    }
}