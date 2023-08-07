@file:Suppress("unused")

package kmm.utils.calendarism.data

import kotlinx.serialization.Serializable

@Serializable
sealed class DaysOmitted {
    class IntegerValue(val value: Long)  : DaysOmitted()
    class StringValue(val value: String) : DaysOmitted()
    class NullValue : DaysOmitted()
}