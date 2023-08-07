@file:Suppress("unused")

package kmm.utils.calendarism


interface Calendar {
    val name: String
    val initialDate: String
    val finalDate: String?
    val description: String?
    val numberOfMonths: Int
    val months: Array<CalendarMonth>
    val hasAdjustment: Boolean
    val adjustmentDays: Int
    fun getAdjustmentDays(year: Int): Int
    fun getAdjustmentMonths(year: Int): Array<CalendarMonth>
    fun isActive(year: Int): Boolean
    fun isActive(year: IntRange): Boolean
    fun getTransition(year: Int): CalendarTransition

}