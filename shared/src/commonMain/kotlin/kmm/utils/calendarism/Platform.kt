package kmm.utils.calendarism

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform