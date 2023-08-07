@file:Suppress("unused")

package kmm.utils.calendarism

interface CalendarMonth {
    val name: String
    val ordinal: Int
    val abbreviation: String
    val description: String?
    val numberOfDays: Int
    val hasAdjustment: Boolean
    val adjustmentDays: Int
    fun getAdjustment(year: Int): Int
    fun getAdjustment(years: IntRange): Int
    override fun toString(): String
}
