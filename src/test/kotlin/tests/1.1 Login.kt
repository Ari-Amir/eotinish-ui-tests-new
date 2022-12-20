package tests


import org.testng.annotations.Test
import org.testng.Assert.assertTrue
import com.microsoft.playwright.*
import org.sikuli.basics.*
import configs.*
import lists.*
import pages.*

var needNewPage: Boolean = false

class Login (
    private val user: User = org1Registrar1,
    private val assert: Boolean = true
) {
    @Test
    fun loginTest() {
        if (user.pageIsCreated) {
            user.page.bringToFront()
        }else{
            if (needNewPage) {
                user.page = createNewPage()
            }
            Settings.ActionLogs = false
            user.page.navigate(demoURL)
            removeFirstPopup(user)
            user.page.click(loginPage.language_ru_text)
            user.page.click(loginPage.eotinish_gov_kz_btn)
            user.page.fill(loginPage.login_input, user.IIN)
            user.page.fill(loginPage.password_input, user.password)
            user.page.click(loginPage.login_btn)
            user.page.waitForSelector(mainPage.asideToggleFix_btn)
            user.pageIsCreated = true
            needNewPage = true
        }


        if (assert) {
            assertTrue(user.page.isVisible(mainPage.user_name))
            assertTrue(user.page.isVisible(mainPage.asideToggleFix_btn))
            println("Test 1.1     passed")
        }
    }

    private fun createNewPage() : Page {
        Settings.ActionLogs = false
        val browserContext: BrowserContext = browser.newContext(Browser.NewContextOptions().setViewportSize(1650, 1080))
        return browserContext.newPage()
    }

    private fun removeFirstPopup(user: User) {
        user.page.locator("ngb-modal-window").evaluate("(el) => el.remove()")
        user.page.locator("ngb-modal-backdrop").evaluate("(el) => el.remove()")
    }
}
