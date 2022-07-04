package work.racka.reluct.common.data.usecases.limits

import work.racka.reluct.common.model.domain.limits.AppLimits

interface ModifyAppLimits {
    suspend fun insertApp(appLimits: AppLimits)
    suspend fun removeApp(packageName: String)
    suspend fun removeAllApp(packageName: String)
    suspend fun resumeAllApps()
    suspend fun setLimit(packageName: String, timeLimit: Long)
    suspend fun pauseApp(packageName: String, isPaused: Boolean)
    suspend fun makeDistractingApp(packageName: String, isDistracting: Boolean)
    suspend fun overrideLimit(packageName: String, overridden: Boolean)
}