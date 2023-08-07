@file:Suppress("unused")

package kmm.utils.calendarism.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CalendarTransition (
    @SerialName("current_name")
    val currentName: String,

    @SerialName("year_of_transition")
    val yearOfTransition: DaysOmitted,

    @SerialName("date_before_transition")
    val dateBeforeTransition: String? = null,

    @SerialName("date_after_transition")
    val dateAfterTransition: String? = null,

    @SerialName("days_omitted")
    val daysOmitted: DaysOmitted,

    val particulars: String,
    val source: String,

    @SerialName("historic_area")
    val historicArea: String? = null
)