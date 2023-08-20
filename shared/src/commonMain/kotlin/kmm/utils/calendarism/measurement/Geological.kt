@file:Suppress("unused")

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

enum class GeologicalEpoch(val years: LongRange, val ages: Array<GeologicalAge>) {
    Holocene(
        GeologicalAge.Greenlandian.years.first until GeologicalAge.Meghalayan.years.last,
        arrayOf(GeologicalAge.Greenlandian, GeologicalAge.Northgrippian, GeologicalAge.Meghalayan)
    ),
    Pleistocene(
        GeologicalAge.Gelasian.years.first until -GeologicalAge.UpperPleistocene.years.last,
        arrayOf(
            GeologicalAge.Gelasian,
            GeologicalAge.Calabrian,
            GeologicalAge.MiddlePleistocene,
            GeologicalAge.UpperPleistocene
        )
    ),
    Pliocene(
        GeologicalAge.Zanclean.years.first until GeologicalAge.Piacenzian.years.last,
        arrayOf(GeologicalAge.Zanclean, GeologicalAge.Piacenzian)
    ),
    Miocene(
        GeologicalAge.Aquitanian.years.first until GeologicalAge.Messinian.years.last,
        arrayOf(
            GeologicalAge.Aquitanian,
            GeologicalAge.Burdigalian,
            GeologicalAge.Langhian,
            GeologicalAge.Serravallian,
            GeologicalAge.Tortonian,
            GeologicalAge.Messinian
        )
    ),
    Oligocene(
        GeologicalAge.Rupelian.years.first until GeologicalAge.Chattian.years.last,
        arrayOf(GeologicalAge.Rupelian, GeologicalAge.Chattian)
    ),
    Eocene(
        GeologicalAge.Ypresian.years.first until GeologicalAge.Priabonian.years.last,
        arrayOf(
            GeologicalAge.Ypresian,
            GeologicalAge.Lutetian,
            GeologicalAge.Bartonian,
            GeologicalAge.Priabonian
        )
    ),
    Paleocene(
        GeologicalAge.Danian.years.first until GeologicalAge.Thanetian.years.last,
        arrayOf(GeologicalAge.Danian, GeologicalAge.Selandian, GeologicalAge.Thanetian)
    ),
    UpperCretaceous(
        GeologicalAge.Cenomanian.years.first until GeologicalAge.Maastrichtian.years.last,
        arrayOf(
            GeologicalAge.Cenomanian,
            GeologicalAge.Turonian,
            GeologicalAge.Coniacian,
            GeologicalAge.Santonian,
            GeologicalAge.Campanian,
            GeologicalAge.Maastrichtian
        )
    ),
    LowerCretaceous(
        GeologicalAge.Berriasian.years.first until GeologicalAge.Albian.years.last,
        arrayOf(
            GeologicalAge.Berriasian,
            GeologicalAge.Valanginian,
            GeologicalAge.Hauterivian,
            GeologicalAge.Barremian,
            GeologicalAge.Aptian,
            GeologicalAge.Albian,
        )
    ),
    UpperJurassic(
        GeologicalAge.Oxfordian.years.first until GeologicalAge.Tithonian.years.last,
        arrayOf(GeologicalAge.Oxfordian, GeologicalAge.Kimmeridgian, GeologicalAge.Tithonian)
    ),
    MiddleJurassic(
        GeologicalAge.Aalenian.years.first until GeologicalAge.Callovian.years.last,
        arrayOf(
            GeologicalAge.Aalenian,
            GeologicalAge.Bajocian,
            GeologicalAge.Bathonian,
            GeologicalAge.Callovian
        )
    ),
    LowerJurassic(
        GeologicalAge.Hettangian.years.first until GeologicalAge.Toarcian.years.last,
        arrayOf(
            GeologicalAge.Hettangian,
            GeologicalAge.Sinemurian,
            GeologicalAge.Pliensbachian,
            GeologicalAge.Toarcian
        )
    ),
    UpperTriassic(
        GeologicalAge.Carnian.years.first until GeologicalAge.Rhaetian.years.last,
        arrayOf(GeologicalAge.Carnian, GeologicalAge.Norian, GeologicalAge.Rhaetian)
    ),
    MiddleTriassic(
        GeologicalAge.Anisian.years.first until GeologicalAge.Ladinian.years.last,
        arrayOf(GeologicalAge.Anisian, GeologicalAge.Ladinian)
    ),
    LowerTriassic(
        GeologicalAge.Induan.years.first until GeologicalAge.Olenekian.years.last,
        arrayOf(GeologicalAge.Induan, GeologicalAge.Olenekian)
    ),
    Lopingian(
        GeologicalAge.Wuchiapingian.years.first until GeologicalAge.Changhsingian.years.last,
        arrayOf(GeologicalAge.Wuchiapingian, GeologicalAge.Changhsingian)
    ),
    Guadalupian(
        GeologicalAge.Kungurian.years.first until GeologicalAge.Capitanian.years.last,
        arrayOf(
            GeologicalAge.Kungurian,
            GeologicalAge.Roadian,
            GeologicalAge.Wordian,
            GeologicalAge.Capitanian
        )
    ),
    Cisuralian(
        GeologicalAge.Asselian.years.first until GeologicalAge.Artinskian.years.last,
        arrayOf(GeologicalAge.Asselian, GeologicalAge.Sakmarian, GeologicalAge.Artinskian)
    ),
    UpperPennsylvanian(
        GeologicalAge.Kasimovian.years.first until GeologicalAge.Gzhelian.years.last,
        arrayOf(GeologicalAge.Kasimovian, GeologicalAge.Gzhelian)
    ),
    MiddlePennsylvanian(
        GeologicalAge.Moscovian.years.first until GeologicalAge.Moscovian.years.last,
        arrayOf(GeologicalAge.Moscovian)
    ),
    LowerPennsylvanian(
        GeologicalAge.Bashkirian.years.first until GeologicalAge.Bashkirian.years.last,
        arrayOf(GeologicalAge.Bashkirian)
    ),
    UpperMississippian(
        GeologicalAge.Serpukhovian.years.first until GeologicalAge.Serpukhovian.years.last,
        arrayOf(GeologicalAge.Serpukhovian)
    ),
    MiddleMississippian(
        GeologicalAge.Visean.years.first until GeologicalAge.Visean.years.last,
        arrayOf(GeologicalAge.Visean)
    ),
    LowerMississippian(
        GeologicalAge.Tournaisian.years.first until GeologicalAge.Tournaisian.years.last,
        arrayOf(GeologicalAge.Tournaisian)
    ),
    UpperDevonian(
        GeologicalAge.Frasnian.years.first until GeologicalAge.Famennian.years.last,
        arrayOf(GeologicalAge.Frasnian, GeologicalAge.Famennian)
    ),
    MiddleDevonian(
        GeologicalAge.Eifelian.years.first until GeologicalAge.Givetian.years.last,
        arrayOf(GeologicalAge.Eifelian, GeologicalAge.Givetian)
    ),
    LowerDevonian(
        GeologicalAge.Lochkovian.years.first until GeologicalAge.Emsian.years.last,
        arrayOf(GeologicalAge.Lochkovian, GeologicalAge.Pragian, GeologicalAge.Emsian)
    ),
    Pridoli(
        GeologicalAge.Pridoli.years.first until GeologicalAge.Pridoli.years.last,
        arrayOf(GeologicalAge.Pridoli)
    ),
    Ludlow(
        GeologicalAge.Gorstian.years.first until GeologicalAge.Ludfordian.years.last,
        arrayOf(GeologicalAge.Gorstian, GeologicalAge.Ludfordian)
    ),
    Wenlock(
        GeologicalAge.Sheinwoodian.years.first until GeologicalAge.Homerian.years.last,
        arrayOf(GeologicalAge.Sheinwoodian, GeologicalAge.Homerian)
    ),
    Llandovery(
        GeologicalAge.Rhuddanian.years.first until GeologicalAge.Telychian.years.last,
        arrayOf(GeologicalAge.Rhuddanian, GeologicalAge.Aeronian, GeologicalAge.Telychian)
    ),
    UpperOrdovician(
        GeologicalAge.Sandbian.years.first until GeologicalAge.Hirnantian.years.last,
        arrayOf(GeologicalAge.Sandbian, GeologicalAge.Katian, GeologicalAge.Hirnantian)
    ),
    MiddleOrdovician(
        GeologicalAge.Dapingian.years.first until GeologicalAge.Darriwilian.years.last,
        arrayOf(GeologicalAge.Dapingian, GeologicalAge.Darriwilian)
    ),
    LowerOrdovician(
        GeologicalAge.Tremadocian.years.first until -GeologicalAge.Floian.years.last,
        arrayOf(GeologicalAge.Tremadocian, GeologicalAge.Floian)
    ),
    Furongian(
        GeologicalAge.Stage8.years.first until GeologicalAge.Stage10.years.last,
        arrayOf(GeologicalAge.Stage8, GeologicalAge.Stage9, GeologicalAge.Stage10)
    ),
    Series3(
        GeologicalAge.Stage5.years.first until GeologicalAge.Stage7.years.last,
        arrayOf(GeologicalAge.Stage5, GeologicalAge.Stage6, GeologicalAge.Stage7)
    ),
    Series2(
        GeologicalAge.Stage3.years.first until GeologicalAge.Stage4.years.last,
        arrayOf(GeologicalAge.Stage3, GeologicalAge.Stage4)
    ),
    Terreneuvian(
        GeologicalAge.Stage2.years.first until GeologicalAge.Stage1.years.last,
        arrayOf(GeologicalAge.Stage2, GeologicalAge.Stage1)
    ),
}

enum class GeologicalAge(val years: LongRange) {
    Meghalayan(-4_200L until 0L),
    Northgrippian(-8_200L until -4_200L),
    Greenlandian(-11_700L until -8_200L),
    UpperPleistocene(-126_000L until -11_700L),
    MiddlePleistocene(-781_000L until -126_000L),
    Calabrian(-1_800_000L until -781_000L),
    Gelasian(-2_580_000L until -1_800_000L),
    LowerPleistocene(-2_580_000L until -781_000L),
    Piacenzian(-3_600_000L until -2_580_000L),
    Zanclean(-5_333_000L until -3_600_000L),
    Messinian(-7_246_000L until -5_333_000L),
    Tortonian(-11_630_000L until -7_246_000L),
    Serravallian(-13_820_000L until -11_630_000L),
    Langhian(-15_970_000L until -13_820_000L),
    Burdigalian(-20_440_000L until -15_970_000L),
    Aquitanian(-23_030_000L until -20_440_000L),
    Chattian(-28_100_000L until -23_030_000L),
    Rupelian(-33_900_000L until -28_100_000L),
    Priabonian(-38_000_000L until -33_900_000L),
    Bartonian(-41_300_000L until -38_000_000L),
    Lutetian(-47_800_000L until -41_300_000L),
    Ypresian(-56_000_000L until -47_800_000L),
    Thanetian(-59_200_000L until -56_000_000L),
    Selandian(-61_600_000L until -59_200_000L),
    Danian(-66_000_000L until -61_600_000L),
    Maastrichtian(-72_100_000L until -66_000_000L),
    Campanian(-83_600_000L until -72_100_000L),
    Santonian(-86_300_000L until -83_600_000L),
    Coniacian(-89_800_000L until -86_300_000L),
    Turonian(-93_900_000L until -89_800_000L),
    Cenomanian(-100_500_000L until -93_900_000L),
    Albian(-113_000_000L until -100_500_000L),
    Aptian(-125_000_000L until -113_000_000L),
    Barremian(-129_400_000L until -125_000_000L),
    Hauterivian(-132_900_000L until -129_400_000L),
    Valanginian(-139_8000_000L until -132_900_000L),
    Berriasian(-145_000_000L until -139_800_000L),
    Tithonian(-152_100_000L until -145000_000L),
    Kimmeridgian(-157_300_000L until -152_100_000L),
    Oxfordian(-163_500_000L until -157_300_000L),
    Callovian(-166_100_000L until -163_500_000L),
    Bathonian(-168_300_000L until -166_100_000L),
    Bajocian(-170_300_000L until -168_300_000L),
    Aalenian(-174_100_000L until -170_300_000L),
    Toarcian(-182_700_000L until -174_100_000L),
    Pliensbachian(-190_800_000L until -182_700_000L),
    Sinemurian(-199_300_000L until -190_800_000L),
    Hettangian(-201_300_000L until -199_300_000L),
    Rhaetian(-208_500_000L until 201_300_000L),
    Norian(-227_000_000L until 208_500_000L),
    Carnian(-237_000_000L until 227_000_000L),
    Ladinian(-242_000_000L until 237_000_000L),
    Anisian(-247_200_000L until -242_000_000L),
    Olenekian(-251_200_000L until -247_200_000L),
    Induan(-251_902_000L until -251_200_000L),
    Changhsingian(-254_200_000L until -251_902_000L),
    Wuchiapingian(-259_100_000L..-254_200_000L),
    Capitanian(-265_100_000L until -259_100_000L),
    Wordian(-268_800_000L until -265_100_000L),
    Roadian(-272_300_000L until -268_800_000L),
    Kungurian(-279_300_000L until -272_300_000L),
    Artinskian(-290_100_000L until -279_300_000L),
    Sakmarian(-295_000_000L until -290_100_000L),
    Asselian(-298_900_000L until -295_000_000L),
    Gzhelian(-303_700_000L until -298_900_000L),
    Kasimovian(-307000_000L until -303_700_000L),
    Moscovian(-315_200_000L until -307000_000L),
    Bashkirian(-323_200_000L until -315_200_000L),
    Serpukhovian(-330_900_000L until -323_200_000L),
    Visean(-346_700_000L until -330_900_000L),
    Tournaisian(-358_900_000L until -346_700_00),
    Famennian(-372_200_000L until -358_900_000L),
    Frasnian(-382_700_000L until -372_200_000L),
    Givetian(-387_700_000L until -382_700_000L),
    Eifelian(-393_300_000L until -387_700_000L),
    Emsian(-407_600_000L until -393_300_000L),
    Pragian(-410_800_000L until -407_600_000L),
    Lochkovian(-419_200_000L until -410_800_000L),
    Pridoli(-423_000_000L until -419_200_000L),
    LateSilurian(-427_400_000L until -423_000_000L),
    Ludfordian(-425_600_000L until -423_000_000L),
    Gorstian(-427_400_000L until -425_600_000L),
    MiddleSilurian(-433_400_000L until -427_400_000L),
    Homerian(-430_500_000L until -427_400_000L),
    Sheinwoodian(-433_400_000L until -430_500_000L),
    EarlySilurian(-443_800_000L until -433_400_000L),
    Telychian(-438_500_000L until -433_400_000L),
    Aeronian(-440_800_000L until -438_500_000L),
    Rhuddanian(-443_800_000L until -440_800_000L),
    Hirnantian(-445_200_000L until -443_800_000L),
    Katian(-453_000_000L until -445_200_000L),
    Sandbian(-458_400_000L until -453_000_000L),
    Darriwilian(-467_300_000L until -458_400_000L),
    Dapingian(-470_000_000L until -467_300_000L),
    Floian(-477_700_000L until -470_000_000L),
    Tremadocian(-485_400_000L until -477_700_000L),
    Stage10(-488_300_000L until -485_400_000L),
    Stage9(-492_000_000L until -488_300_000L),
    Stage8(-497_000_000L until -492_000_000L),
    Stage7(-501_000_000L until -497_000_000L),
    Stage6(-504_000_000L until -501_000_000L),
    Stage5(-509_000_000L until -504_000_000L),
    Stage4(-514_000_000L until -509_000_000L),
    Stage3(-521_000_000L until -514_000_000L),
    Stage2(-529_000_000L until -521_000_000L),
    Stage1(-541_000_000L until -529_000_000L),
    ;

    companion object {
        val Ionian = MiddlePleistocene
        val Furongian = Stage10
        val Jiangshanian = Stage9
        val Paibian = Stage8
        val Guzhangian = Stage7
        val Drumian = Stage6
        val Fortunian = Stage1
    }
}

typealias LongRange = kotlin.ranges.LongRange
