package kmm.utils.calendarism

class JSlatform : Platform {
    override val name: String = "JavaScript"
}

actual fun getPlatform(): Platform = JSlatform()