@file:Suppress("unused")

package kmm.utils.calendarism

interface CalendarDate {
    val ticks: Long
    val calendar: Calendar
    val day: Int
    val month: CalendarMonth
    val year: Int
    override fun toString(): String
}
