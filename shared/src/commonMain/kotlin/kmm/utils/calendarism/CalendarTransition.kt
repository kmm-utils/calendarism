@file:Suppress("unused")

package kmm.utils.calendarism

interface CalendarTransition {
    val oldCalendar: Calendar
    val newCalendar: Calendar
    val getNewDate: CalendarDate
    val getOldDate: CalendarDate
}
