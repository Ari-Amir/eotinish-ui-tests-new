package tests

import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import configs.*
import pages.*


class Logout (private var assert:Boolean = true) {
    private val mainPage = MainPage()
    private val loginPage = LoginPage()

    @Test
    fun logoutTest() {
        if (!page.isVisible(mainPage.user_avatar)) {
            Login().loginTest()
            page.click(mainPage.user_avatar)
            page.click(mainPage.logout_text)
        } else {
            page.click(mainPage.user_avatar)
            page.click(mainPage.logout_text)
        }

        if (assert) {
            assertTrue(page.isVisible(loginPage.eotinish_gov_kz_btn))
        }
    }
}
