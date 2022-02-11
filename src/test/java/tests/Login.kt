package tests

import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import configs.*
import org.sikuli.basics.Settings
import pages.*
import users.*

class Login (private val IIN: String = akimIIN, private val password: String = akimPassword) {
    @Test
    fun loginTest() {
        Settings.ActionLogs = false
        page.setViewportSize(viewportWidth, viewportHeight)
        page.navigate(baseURL)

        page.click(eotinish_gov_kz_btn)
        page.fill(login_input, IIN)
        page.fill(password_input, password)
        if (page.isVisible(login_kz_btn)) {
            page.waitForNavigation { page.click(login_kz_btn) }
        } else {
            page.waitForNavigation { page.click(login_ru_btn) }
        }
        page.click(language_ru_text)
        assertTrue(page.isVisible(aside_toggle))
    }
}
