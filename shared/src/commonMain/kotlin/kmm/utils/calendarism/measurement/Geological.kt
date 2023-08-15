//@file:Suppress("unused")

package kmm.utils.calendarism.measurement

enum class GeologicalSuperEon(val years: LongRange, eras: Array<GeologicalEon>) {
    PreHadean(
        Long.MIN_VALUE until GeologicalEon.Hadean.years.first,
        emptyArray()
    ),
    Precambrian(
        GeologicalEon.Hadean.years.first until GeologicalEon.Proterozoic.years.last,
        arrayOf(GeologicalEon.Hadean, GeologicalEon.Archean, GeologicalEon.Proterozoic)
    ),
    Phanerozoic(
        GeologicalEon.Phanerozoic.years.first..GeologicalEon.Phanerozoic.years.last,
        arrayOf(GeologicalEon.Phanerozoic)
    )
}

enum class GeologicalEon(val years: LongRange, eras: Array<GeologicalEra>) {
    Hadean(
        -4_600_000_000L..-4_000_000_000L,
        emptyArray()
    ),
    Archean(
        -4_000_000_000L..-2_500_000_000L, emptyArray()
    ),
    Proterozoic(
        -2_500_000_000L..-541_000_000L,
        emptyArray()
    ),
    Phanerozoic(
        GeologicalEra.Paleozoic.years.first..GeologicalEra.Cenozoic.years.last,
        arrayOf(GeologicalEra.Paleozoic, GeologicalEra.Mesozoic, GeologicalEra.Cenozoic)
    );


    companion object {
        val PreArchean = Hadean
        val Priscoan = Hadean
    }
}

enum class GeologicalEra(val years: LongRange) {
    EoArchean(-2_800_000_000L until -2_500_000_000L),
    PaleoArchean(-2_800_000_000L until -2_500_000_000L),
    MesoArchean(-3_200_000_000L until -2_800_000L),
    NeoArchean(-2_800_000_000L until -2_500_000_000L),
    PaleoProterozoic(-2_500_000_000L until -1_600_000_000L),
    MesoProterozoic(-1_600_000_000L until -1_000_000_000L),
    NeoProterozoic(-1_000_000_000L until -541_000_000L),
    Paleozoic(-541_000_000L until -252_000_000L),
    Mesozoic(-252_000_000L until -66_000_000L),
    Cenozoic(-66_000_000L until 0L)
}

enum class GeologicalPeriod(val years: LongRange) {
    Quaternary(-2_800_000_000L until -2_500_000_000L),
    Neogene(-23_000_000L until -2_580_000L),
    Paleogene(-66_000_000L until -23_000_000L),
    Cretaceous(-145_500_000L until -66_000_000L),
    Jurassic(-201_300_000L until -145_500_000L),
    Triassic(-252_170_000L until -201_300_000L),
    Permian(-298_900_000L until -252_170_000L),
    Carboniferous(-358_900_000L until -298_900_000L),
    Devonian(-419_200_000L until -358_900_000L),
    Silurian(-443_800_000L until -419_200_000L),
    Ordovician(-485_400_000L until -443_800_000L),
    Cambrian(-541_000_000L until -485_400_000L),

}

typealias LongRange = kotlin.ranges.LongRange
