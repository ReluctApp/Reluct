rootProject.name = "Reluct"
include(
    ":desktop:app",
    ":android:app",
    ":android:compose:components",
    ":android:compose:charts",
    ":android:compose:destinations",
    ":android:compose:navigation",
    ":android:compose:theme",
    ":android:screens",
    ":common:app-usage-stats",
    ":common:data",
    ":common:features:goals",
    ":common:features:settings",
    ":common:features:tasks",
    ":common:integration",
    ":common:model",
    ":common:persistence:database",
    ":common:persistence:settings",
)
