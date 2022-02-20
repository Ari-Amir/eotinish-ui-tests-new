package tests

import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import configs.*
import pages.*


class Logout {
    private val mainPage = MainPage()
    private val loginPage = LoginPage()

    @Test
    fun logoutTest() {
        Login().loginTest()
        page.click(mainPage.user_avatar)
        page.click(mainPage.logout_text)
        assertTrue(page.isVisible(loginPage.eotinish_gov_kz_btn))
    }
}
