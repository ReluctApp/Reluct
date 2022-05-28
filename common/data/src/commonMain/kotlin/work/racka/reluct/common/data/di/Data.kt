package work.racka.reluct.common.data.di

import org.koin.core.KoinApplication
import org.koin.dsl.module
import work.racka.reluct.common.data.usecases.app_usage.GetDailyAppUsageInfo
import work.racka.reluct.common.data.usecases.app_usage.GetDailyUsageStats
import work.racka.reluct.common.data.usecases.app_usage.GetWeeklyAppUsageInfo
import work.racka.reluct.common.data.usecases.app_usage.GetWeeklyUsageStats
import work.racka.reluct.common.data.usecases.app_usage.impl.GetDailyAppUsageInfoImpl
import work.racka.reluct.common.data.usecases.app_usage.impl.GetDailyUsageStatsImpl
import work.racka.reluct.common.data.usecases.app_usage.impl.GetWeeklyAppUsageInfoImpl
import work.racka.reluct.common.data.usecases.app_usage.impl.GetWeeklyUsageStatsImpl
import work.racka.reluct.common.data.usecases.tasks.GetDailyTasksUseCase
import work.racka.reluct.common.data.usecases.tasks.GetTasksUseCase
import work.racka.reluct.common.data.usecases.tasks.GetWeeklyTasksUseCase
import work.racka.reluct.common.data.usecases.tasks.ModifyTaskUseCase
import work.racka.reluct.common.data.usecases.tasks.impl.GetDailyTasksUseCaseImpl
import work.racka.reluct.common.data.usecases.tasks.impl.GetTasksUseCaseImpl
import work.racka.reluct.common.data.usecases.tasks.impl.GetWeeklyTasksUseCaseImpl
import work.racka.reluct.common.data.usecases.tasks.impl.ModifyTaskUseCaseImpl
import work.racka.reluct.common.data.usecases.time.GetWeekRangeFromOffset
import work.racka.reluct.common.data.usecases.time.impl.GetWeekRangeFromOffsetImpl

object Data {

    fun KoinApplication.dataModules() =
        this.apply {
            modules(
                commonModule(),
                Platform.platformTasksModule()
            )
        }

    private fun commonModule() = module {

        /** UseCases **/
        // Tasks
        factory<GetTasksUseCase> {
            GetTasksUseCaseImpl(
                dao = get(),
                backgroundDispatcher = CoroutineDispatchers.backgroundDispatcher
            )
        }

        factory<ModifyTaskUseCase> {
            ModifyTaskUseCaseImpl(
                dao = get(),
                backgroundDispatcher = CoroutineDispatchers.backgroundDispatcher
            )
        }

        factory<GetWeeklyTasksUseCase> {
            GetWeeklyTasksUseCaseImpl(
                dao = get(),
                backgroundDispatcher = CoroutineDispatchers.backgroundDispatcher
            )
        }

        factory<GetDailyTasksUseCase> {
            GetDailyTasksUseCaseImpl(
                weeklyTasks = get(),
                backgroundDispatcher = CoroutineDispatchers.backgroundDispatcher
            )
        }

        // Time
        factory<GetWeekRangeFromOffset> { GetWeekRangeFromOffsetImpl() }

        // App Usage Stats
        factory<GetDailyAppUsageInfo> {
            GetDailyAppUsageInfoImpl(
                usageManager = get(),
                backgroundDispatcher = get()
            )
        }

        factory<GetWeeklyAppUsageInfo> {
            GetWeeklyAppUsageInfoImpl(
                dailyAppUsageInfo = get(),
                backgroundDispatcher = get()
            )
        }

        factory<GetDailyUsageStats> {
            GetDailyUsageStatsImpl(
                usageManager = get(),
                backgroundDispatcher = get()
            )
        }

        factory<GetWeeklyUsageStats> {
            GetWeeklyUsageStatsImpl(
                dailyUsageStats = get(),
                backgroundDispatcher = get()
            )
        }
    }
}