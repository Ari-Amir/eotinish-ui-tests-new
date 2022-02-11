package tests

import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import configs.*
import pages.*

class Logout {
    @Test
    fun logoutTest() {
        Login().loginTest()
        page.click(user_avatar)
        page.click(logout_text)
        assertTrue(page.isVisible(eotinish_gov_kz_btn))
    }
}
