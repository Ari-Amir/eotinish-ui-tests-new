package tests

import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import configs.*
import lists.*
import org.sikuli.basics.Settings
import pages.*


class Login(
    private val IIN: String = Akim5().IIN,
    private val password: String = Akim5().password,
    private var assert: Boolean = true
) {
    private val mainPage = MainPage()
    private val asideToggle = AsideToggle()
    private val loginPage = LoginPage()

    @Test
    fun loginTest() {
        Settings.ActionLogs = false
        page.setViewportSize(viewportWidth, viewportHeight)
        page.navigate(baseURL)

        page.click(loginPage.eotinish_gov_kz_btn)
        page.fill(loginPage.login_input, IIN)
        page.fill(loginPage.password_input, password)
        if (page.isVisible(loginPage.login_kz_btn)) {
            page.waitForNavigation { page.click(loginPage.login_kz_btn) }
        } else {
            page.waitForNavigation { page.click(loginPage.login_ru_btn) }
        }
        page.click(mainPage.language_ru_text)

        if (assert) {
            assertTrue(page.isVisible(asideToggle.asideToggleFix_btn))
        }
    }
}
