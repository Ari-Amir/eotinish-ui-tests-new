package configs


import com.microsoft.playwright.*
import org.sikuli.script.*


const val demoURL = "https://demo.e-otinish.kz/auth/login"
const val devURL = "https://backoffice.dev.eotinish.btsdapps.net/auth/login"
const val stageURL = "https://backoffice.stg.eotinish.btsdapps.net/auth/login"
const val localhostURL = "http://localhost:4200/auth/login"

val NCALayer = App("NCALayer")
val screen: Screen by lazy { Screen() }
val playWrite: Playwright = Playwright.create()
var browser: Browser = playWrite.chromium().launch(BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100.0).setTimeout(50000.0))
val browserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(1650, 1080))
val browserPage: Page = browserContext.newPage()
val process: Process = Runtime.getRuntime().exec("ssh -L 127.0.0.1:3333:s2166.j:5432 kuntuar.tleubergenov@s2684.j")
val testTimeout = browserContext.setDefaultTimeout(500000.0)


