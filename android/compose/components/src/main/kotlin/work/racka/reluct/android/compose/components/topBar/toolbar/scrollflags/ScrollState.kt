package work.racka.reluct.android.compose.components.topBar.toolbar.scrollflags

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import work.racka.reluct.android.compose.components.topBar.toolbar.ScrollFlagState

class ScrollState(
    heightRange: IntRange,
    scrollOffset: Float = 0f
) : ScrollFlagState(heightRange) {
    override var _scrollOffset: Float by mutableStateOf(
        value = scrollOffset.coerceIn(0f, maxHeight.toFloat()),
        policy = structuralEqualityPolicy()
    )

    override var scrollOffset: Float
        get() = _scrollOffset
        set(value) {
            if (scrollTopLimitReached) {
                val oldOffset = _scrollOffset
                _scrollOffset = value.coerceIn(0f, maxHeight.toFloat())
                _consumed = oldOffset - _scrollOffset
            } else _consumed = 0f
        }

    override val offset: Float
        get() = -(scrollOffset - rangeDifference).coerceIn(0f, minHeight.toFloat())

    companion object {
        val Saver = run {
            val minHeightKey = "MinHeight"
            val maxHeightKey = "MaxHeight"
            val scrollOffsetKey = "ScrollOffset"

            mapSaver(
                save = {
                    mapOf(
                        minHeightKey to it.minHeight,
                        maxHeightKey to it.maxHeight,
                        scrollOffsetKey to it.scrollOffset
                    )
                },
                restore = {
                    ScrollState(
                        heightRange = (it[minHeightKey] as Int)..(it[maxHeightKey] as Int),
                        scrollOffset = it[scrollOffsetKey] as Float,
                    )
                }
            )
        }
    }
}