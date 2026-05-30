package ua.education.platformspecific.data.common.db

import ua.education.platformspecific.db.Organise
import ua.education.platformspecific.db.Task

class DbDataSource(
    private val db: Organise
) : LocalDataSource {

    override fun insertTask(description: String) {
        db.tasksQueries.insertTask(task_desc = description)
    }

    override fun getAllTasks(): List<Task> {
        return db.tasksQueries.selectAllTasks().executeAsList()
    }

    override fun markTaskCompleted(id: Long) {
        db.tasksQueries.markTaskCompleted(id = id)
    }

    override fun markTaskPending(id: Long) {
        db.tasksQueries.markTaskPending(id = id)
    }

    override fun deleteTask(id: Long) {
        db.tasksQueries.deleteTaskById(id = id)
    }
}