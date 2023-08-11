@file:Suppress("unused")

package kmm.utils.calendarism

interface Interval {
    val lengthInTicks : Long
    val lengthInSeconds : Double
    val lengthInMinutes : Double
    val lengthInHours : Double
    val lengthInDays : Double
    val lengthInMonths : Double
    val lengthInYears : Double

    val start: Instant
    val end: Instant
}
