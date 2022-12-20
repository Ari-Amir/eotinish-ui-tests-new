package tests

import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import java.lang.Thread.sleep
import helpers.*
import lists.*
import pages.*


class Logout (private var assert:Boolean = true) {
    @Test
    fun logoutTest() {
        switchOnUser(org1Registrar1)
        org1Registrar1.page.click(mainPage.user_avatar)
        org1Registrar1.page.click(mainPage.logout_text)
        org1Registrar1.pageIsCreated = false
        sleep(1000)

        if (assert) {
            assertTrue(org1Registrar1.page.isVisible(loginPage.welcome_text))
            println("Test 2.1     passed")
        }
    }
}
