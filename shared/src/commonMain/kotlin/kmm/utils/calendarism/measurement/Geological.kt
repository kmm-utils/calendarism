//@file:Suppress("unused")

package kmm.utils.calendarism.measurement

enum class GeologicalSuperEon(val years: LongRange, val eons: Array<GeologicalEon>) {
    PreHadean(Long.MIN_VALUE until GeologicalEon.Hadean.years.first, emptyArray()),
    Precambrian(
        GeologicalEon.Hadean.years.first until GeologicalEon.Proterozoic.years.last,
        arrayOf(GeologicalEon.Hadean, GeologicalEon.Archean, GeologicalEon.Proterozoic)
    ),
    Phanerozoic(
        GeologicalEon.Phanerozoic.years.first..GeologicalEon.Phanerozoic.years.last,
        arrayOf(GeologicalEon.Phanerozoic)
    )
}

enum class GeologicalEon(val years: LongRange, val eras: Array<GeologicalEra>) {
    Hadean(-4_600_000_000L until GeologicalEra.EoArchean.years.first, emptyArray()),
    Archean(
        GeologicalEra.EoArchean.years.first until GeologicalEra.NeoArchean.years.last,
        arrayOf(
            GeologicalEra.EoArchean,
            GeologicalEra.PaleoArchean,
            GeologicalEra.MesoArchean,
            GeologicalEra.NeoArchean
        )
    ),
    Proterozoic(
        GeologicalEra.PaleoProterozoic.years.first until GeologicalEra.NeoProterozoic.years.last,
        arrayOf(
            GeologicalEra.PaleoProterozoic,
            GeologicalEra.MesoProterozoic,
            GeologicalEra.NeoProterozoic
        )
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

enum class GeologicalEra(val years: LongRange, val periods: Array<GeologicalPeriod>) {
    EoArchean(-2_800_000_000L until -2_500_000_000L, emptyArray()),
    PaleoArchean(-2_800_000_000L until -2_500_000_000L, emptyArray()),
    MesoArchean(-3_200_000_000L until -2_800_000L, emptyArray()),
    NeoArchean(-2_800_000_000L until -2_500_000_000L, emptyArray()),
    PaleoProterozoic(
        GeologicalPeriod.Siderian.years.first until GeologicalPeriod.Statherian.years.last,
        arrayOf(
            GeologicalPeriod.Siderian,
            GeologicalPeriod.Rhyacian,
            GeologicalPeriod.Orosirian,
            GeologicalPeriod.Statherian
        )
    ),
    MesoProterozoic(
        GeologicalPeriod.Calymmian.years.first until GeologicalPeriod.Stenian.years.last,
        arrayOf(GeologicalPeriod.Calymmian, GeologicalPeriod.Ectasian, GeologicalPeriod.Stenian)
    ),
    NeoProterozoic(
        GeologicalPeriod.Tonian.years.first until GeologicalPeriod.Ediacaran.years.last,
        arrayOf(GeologicalPeriod.Tonian, GeologicalPeriod.Cryogenian, GeologicalPeriod.Ediacaran)
    ),
    Paleozoic(
        GeologicalPeriod.Cambrian.years.first until GeologicalPeriod.Permian.years.last,
        arrayOf(
            GeologicalPeriod.Cambrian,
            GeologicalPeriod.Ordovician,
            GeologicalPeriod.Silurian,
            GeologicalPeriod.Devonian,
            GeologicalPeriod.Carboniferous,
            GeologicalPeriod.Permian
        )
    ),
    Mesozoic(
        GeologicalPeriod.Triassic.years.first until GeologicalPeriod.Cretaceous.years.last,
        arrayOf(GeologicalPeriod.Triassic, GeologicalPeriod.Jurassic, GeologicalPeriod.Cretaceous)
    ),
    Cenozoic(
        GeologicalPeriod.Paleogene.years.first..GeologicalPeriod.Quaternary.years.last,
        arrayOf(GeologicalPeriod.Paleogene, GeologicalPeriod.Neogene, GeologicalPeriod.Quaternary)
    ),
}

enum class GeologicalPeriod(val years: LongRange, val epochs: Array<GeologicalEpoch>) {
    Quaternary(
        GeologicalEpoch.Pleistocene.years.first..GeologicalEpoch.Holocene.years.last,
        arrayOf(GeologicalEpoch.Pleistocene, GeologicalEpoch.Holocene)
    ),
    Neogene(
        GeologicalEpoch.Miocene.years.first until GeologicalEpoch.Pliocene.years.last,
        arrayOf(GeologicalEpoch.Miocene, GeologicalEpoch.Pliocene)
    ),
    Paleogene(
        GeologicalEpoch.Paleocene.years.first until GeologicalEpoch.Oligocene.years.last,
        arrayOf(GeologicalEpoch.Paleocene, GeologicalEpoch.Eocene, GeologicalEpoch.Oligocene)
    ),
    Cretaceous(
        GeologicalEpoch.LowerCretaceous.years.first until GeologicalEpoch.UpperCretaceous.years.last,
        arrayOf(GeologicalEpoch.LowerCretaceous, GeologicalEpoch.UpperCretaceous)
    ),
    Jurassic(
        GeologicalEpoch.LowerJurassic.years.first until GeologicalEpoch.UpperJurassic.years.last,
        arrayOf(
            GeologicalEpoch.LowerJurassic,
            GeologicalEpoch.MiddleJurassic,
            GeologicalEpoch.UpperJurassic
        )
    ),
    Triassic(
        GeologicalEpoch.LowerTriassic.years.first until GeologicalEpoch.UpperTriassic.years.last,
        arrayOf(
            GeologicalEpoch.LowerTriassic,
            GeologicalEpoch.MiddleTriassic,
            GeologicalEpoch.UpperTriassic
        )
    ),
    Permian(
        GeologicalEpoch.Cisuralian.years.first until GeologicalEpoch.Lopingian.years.last,
        arrayOf(GeologicalEpoch.Cisuralian, GeologicalEpoch.Guadalupian, GeologicalEpoch.Lopingian)
    ),
    Carboniferous(
        GeologicalEpoch.LowerMississippian.years.first until GeologicalEpoch.UpperPennsylvanian.years.last,
        arrayOf(
            GeologicalEpoch.LowerMississippian,
            GeologicalEpoch.MiddleMississippian,
            GeologicalEpoch.UpperMississippian,
            GeologicalEpoch.LowerPennsylvanian,
            GeologicalEpoch.MiddlePennsylvanian,
            GeologicalEpoch.UpperPennsylvanian
        )
    ),
    Devonian(
        GeologicalEpoch.LowerDevonian.years.first until GeologicalEpoch.UpperDevonian.years.last,
        arrayOf(
            GeologicalEpoch.LowerDevonian,
            GeologicalEpoch.MiddleDevonian,
            GeologicalEpoch.UpperDevonian
        )
    ),
    Silurian(
        GeologicalEpoch.Llandovery.years.first until GeologicalEpoch.Pridoli.years.last,
        arrayOf(
            GeologicalEpoch.Llandovery,
            GeologicalEpoch.Wenlock,
            GeologicalEpoch.Ludlow,
            GeologicalEpoch.Pridoli
        )
    ),
    Ordovician(
        GeologicalEpoch.LowerOrdovician.years.first until GeologicalEpoch.UpperOrdovician.years.last,
        arrayOf(
            GeologicalEpoch.LowerOrdovician,
            GeologicalEpoch.MiddleOrdovician,
            GeologicalEpoch.UpperOrdovician
        )
    ),
    Cambrian(
        GeologicalEpoch.Terreneuvian.years.first until GeologicalEpoch.Furongian.years.last,
        arrayOf(
            GeologicalEpoch.Terreneuvian,
            GeologicalEpoch.Series2,
            GeologicalEpoch.Series3,
            GeologicalEpoch.Furongian
        )
    ),
    Ediacaran(-635_000_000L until GeologicalEpoch.Terreneuvian.years.first, arrayOf()),
    Cryogenian(-720_000_000L until -635_000_000L, arrayOf()),
    Tonian(-1_000_000_000L until -720_000_000L, arrayOf()),
    Stenian(-1_200_000_000L until -1_000_000_000L, arrayOf()),
    Ectasian(-1_400_000_000L until -1_200_000_000L, arrayOf()),
    Calymmian(-1_600_000_000L until -1_400_000_000L, arrayOf()),
    Statherian(-1_800_000_000L until -1_600_000_000L, arrayOf()),
    Orosirian(-2_050_000_000L until -1_800_000_000L, arrayOf()),
    Rhyacian(-2_300_000_000L until -2_050_000_000L, arrayOf()),
    Siderian(-2_500_000_000L until -2_300_000_000L, arrayOf()),
}

enum class GeologicalEpoch(val years: LongRange) {
    Holocene(-11_700L until 0L),
    Pleistocene(-2_588_000L until -11_700L),
    Pliocene(-5_333_000L until -2_588_000L),
    Miocene(-23_030_000L until -5_333_000L),
    Oligocene(-33_900_000L until -23_030_000L),
    Eocene(-56_000_000L until -33_900_000L),
    Paleocene(-66_000_000L until -56_000_000L),
    UpperCretaceous(-100_500_000L until -66_000_000L),
    LowerCretaceous(-145_000_000L until -100_500_000L),
    UpperJurassic(-163_500_000L until -145_000_000L),
    MiddleJurassic(-174_100_000L until -163_500_000L),
    LowerJurassic(-201_300_000L until -174_100_000L),
    UpperTriassic(-237_000_000L until -201_300_000L),
    MiddleTriassic(-247_200_000L until -237_000_000L),
    LowerTriassic(-252_170_000L until -247_200_000L),
    Lopingian(-259_800_000L until -252_170_000L),
    Guadalupian(-272_300_000L until -259_800_000L),
    Cisuralian(-298_900_000L until -272_300_000L),
    UpperPennsylvanian(-307_000_000L until -298_900_000L),
    MiddlePennsylvanian(-315_200_000L until -307_000_000L),
    LowerPennsylvanian(-323_200_000L until -315_200_000L),
    UpperMississippian(-330_900_000L until -323_200_000L),
    MiddleMississippian(-346_700_000L until -330_900_000L),
    LowerMississippian(-358_900_000L until -346_700_000L),
    UpperDevonian(-382_700_000L until -358_900_000L),
    MiddleDevonian(-393_300_000L until -382_700_000L),
    LowerDevonian(-419_200_000L until -393_300_000L),
    Pridoli(-423_000_000L until -358_900_000L),
    Ludlow(-427_400_000L until -423_000_000L),
    Wenlock(-433_400_000L until -427_400_000L),
    Llandovery(-443_400_000L until -433_400_000L),
    UpperOrdovician(-458_400_000L until -443_400_000L),
    MiddleOrdovician(-470_000_000L until -458_400_000L),
    LowerOrdovician(-485_400_000L until -470_000_000L),
    Furongian(-497_000_000L until -485_400_000L),
    Series3(-509_000_000L until -497_000_000L),
    Series2(-521_000_000L until -509_000_000L),
    Terreneuvian(-541_000_000L until -521_000_000L),
}


typealias LongRange = kotlin.ranges.LongRange
