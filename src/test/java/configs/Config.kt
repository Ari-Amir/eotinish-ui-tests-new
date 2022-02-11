package configs

import com.microsoft.playwright.*
import org.sikuli.script.Screen
import java.io.File

val NCALayer = File("/Applications/NCALayer.app")
val screen = Screen()
const val viewportWidth = 1650
const val viewportHeight = 1080
val playWrite: Playwright = Playwright.create()
val browser: Browser = playWrite.chromium().launch(BrowserType.LaunchOptions().setHeadless(false))
val browserContext: BrowserContext = browser.newContext()
val page: Page = browserContext.newPage()
const val baseURL = "https://backoffice.dev.eotinish.btsdapps.net/auth/login"


