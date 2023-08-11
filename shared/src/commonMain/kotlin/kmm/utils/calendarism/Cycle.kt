@file:Suppress("unused")

package kmm.utils.calendarism

interface Cycle {
    val name: String
    val cycles: Array<Cycle>
    val lengths: Array<Interval>

    fun hasAdjustment(year: Long) : Boolean
    fun hasAdjustment(interval: Interval) : Boolean
    fun getAdjustment (year: Long): Long?
}