package work.racka.reluct.common.core.navigation.composeDestinations.screentime

import work.racka.reluct.common.core.navigation.destination.NavDestination

object ScreenTimeStatsDestination :
    NavDestination {
    private const val BASE_URI = "screen_time_statistics"
    override val route: String = "$BASE_URI-route"
    override val destination: String = "$BASE_URI-destination"
}
