@file:Suppress("unused")

// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json    = Json { allowStructuredMapKeys = true }
// val welcome = json.parse(Welcome.serializer(), jsonString)

package kmm.utils.calendarism.data

import kotlinx.serialization.*

@Serializable
data class CalendarTransitionData (
    val google: List<CalendarTransition>
)

