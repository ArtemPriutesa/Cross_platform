package ua.education.platformspecific.ui.reminders

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import ua.education.platformspecific.data.reminders.Reminder
import ua.education.platformspecific.data.reminders.RemindersRepository

@Stable
internal class ReminderViewModel(
    private val reminderRepository: RemindersRepository
) : ViewModel() {

    private val reminders: List<Reminder>
        get() = reminderRepository.reminders

    var onRemindersUpdated: ((List<Reminder>) -> Unit)? = null
        set(value) {
            field = value
            onRemindersUpdated?.invoke(reminders)
        }

    fun createReminder(title: String) {
        val trimmed = title.trim()
        if (trimmed.isNotEmpty()) {
            reminderRepository.createReminder(title = trimmed)
            onRemindersUpdated?.invoke(reminders)
        }
    }

    fun markReminder(id: Long, isCompleted: Boolean) {
        reminderRepository.markReminder(id = id, isCompleted = isCompleted)
        onRemindersUpdated?.invoke(reminders)
    }


}