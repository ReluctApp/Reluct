package work.racka.reluct.common.core.navigation.composeDestinations.dashboard

import work.racka.reluct.common.core.navigation.destination.NavDestination

object DashboardStatsDestination :
    NavDestination {
    private const val BASE_URI = "dashboard_statistics"
    override val route: String = "$BASE_URI-route"
    override val destination: String = "$BASE_URI-destination"
}
