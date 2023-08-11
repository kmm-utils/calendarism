@file:Suppress("unused")

package kmm.utils.calendarism

enum class Measurement(val ticks: Double, val abbreviations: Array<String>) {
    Tick(1.0, arrayOf("tick")),
    Millisecond(1e4, arrayOf("ms")),
    Moment(0.0, emptyArray()),
    Second(1e7, arrayOf("s", "sec")),
    Minute(6e8, arrayOf("min")),
    Hour(3.6e10, arrayOf("h", "hr")),
    Day(8.64e11, arrayOf("d")),
    Year(3.15e14, arrayOf("y")),
    Decade(3.15e15, arrayOf("y")),
    Century(3.15e16, arrayOf("y")),

    // https://en.wikipedia.org/wiki/Year#SI_prefix_multipliers
    Kiloannus(3.15e17, arrayOf("ka", "kyr", "kya")),
    Megannus(3.15e20, arrayOf("Ma", "myr", "mya")),
    Gigaannus(3.15e23, arrayOf("Ga", "byr", "gyr", "gya")),
    Teraannus(3.15e26, arrayOf("Ta")),
    Petaannus(3.15e29, arrayOf("Pa")),
    Exaannus(3.15e32, arrayOf("Ea"));

    companion object {
        // https://en.wikipedia.org/wiki/Saeculum
        val Saeculum = 80.years

        // https://en.wikipedia.org/wiki/Generation
        val Generation = 80.years

        // https://en.wikipedia.org/wiki/Aeon
        val Aeon = 80.years

        // https://en.wikipedia.org/wiki/Kalpa_(time)
        val Mahakalpa = 1_334_240_000.years
    }
}

inline val Int.centuries: Double get() = this * Measurement.Century.ticks
inline val Int.decades: Double get() = this * Measurement.Decade.ticks
inline val Int.years: Double get() = this * Measurement.Year.ticks
inline val Int.days: Double get() = this * Measurement.Day.ticks
inline val Int.hours: Double get() = this * Measurement.Hour.ticks
inline val Int.minutes: Double get() = this * Measurement.Minute.ticks
inline val Int.seconds: Double get() = this * Measurement.Second.ticks
inline val Int.milliseconds: Double get() = this * Measurement.Millisecond.ticks
