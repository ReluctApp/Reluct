package work.racka.reluct.common.features.tasks.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import work.racka.reluct.common.features.tasks.viewmodels.AddEditTaskViewModel
import work.racka.reluct.common.features.tasks.viewmodels.CompletedTasksViewModel
import work.racka.reluct.common.features.tasks.viewmodels.PendingTasksViewModel
import work.racka.reluct.common.features.tasks.viewmodels.TaskDetailsViewModel

internal actual object Platform {
    actual fun platformTasksModule() = module {
        val viewModelScope = CoroutineScope(Dispatchers.Main)
        factory {
            CompletedTasksViewModel(
                getTasksUseCase = get(),
                modifyTasksUsesCase = get(),
                scope = viewModelScope
            )
        }

        factory {
            PendingTasksViewModel(
                getTasksUseCase = get(),
                modifyTasksUsesCase = get(),
                scope = viewModelScope
            )
        }

        factory { (taskId: String?) ->
            TaskDetailsViewModel(
                getTasksUseCase = get(),
                modifyTasksUsesCase = get(),
                taskId = taskId,
                scope = viewModelScope
            )
        }

        factory { (taskId: String?) ->
            AddEditTaskViewModel(
                modifyTasksUseCase = get(),
                taskId = taskId,
                scope = viewModelScope
            )
        }
    }
}
