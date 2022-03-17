package work.racka.reluct.common.features.tasks.viewmodels

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import work.racka.reluct.common.features.tasks.add_edit_task.container.AddEditTaskContainerHost
import work.racka.reluct.common.features.tasks.add_edit_task.container.AddEditTaskContainerHostImpl
import work.racka.reluct.common.features.tasks.add_edit_task.repository.AddEditTaskRepository

actual class AddEditViewModel(
    addEditTask: AddEditTaskRepository,
    backgroundDispatcher: CoroutineDispatcher,
    scope: CoroutineScope
) {
    val host: AddEditTaskContainerHost by lazy {
        AddEditTaskContainerHostImpl(
            addEditTask = addEditTask,
            backgroundDispatcher = backgroundDispatcher,
            scope = scope
        )
    }
}