package tests

import appealTypesAndForms.*
import org.testng.Assert.assertTrue
import org.testng.annotations.Test
import configs.*
import pages.*

class CreateAppeal {
    @Test
    fun createAppealTest() {
        Login().loginTest() //"test_tson_operator", "test_tson_operator"
        page.waitForNavigation { page.click(create_appeal_btn) }
        page.click(appealType_dropdown)
        page.click(zapros)

        if (page.isVisible(appealCategory_dropdown)) {
            page.click(appealCategory_dropdown)
            page.click(appealCategory)
            page.click(appealSubCategory)
        }

        page.click(appealForm_dropdown)
        page.click(paper)
        page.click(appealLanguage_dropdown)
        page.click(appealLanguage)

        if (page.isVisible(region_dropdown)) {
            page.click(region_dropdown)
            page.click(country)
            page.click(region)
            page.click(adresat_dropdown)
            page.click(adresat)
        }

        page.click(desciption_textarea)
        page.fill(desciption_textarea, "TEST DESCRIPTION")
        page.click(appealCharacter_dropdown)
        page.click(appealCharacter)
        page.fill(IIN_input, "123123123123")
        page.fill(surname_input, "TESTOV")
        page.fill(name_input, "TEST")
        page.fill(address, "TEST ADDRESS")
        page.fill(mobilePhone_input, "+7 (701) 485 67 74")
        page.click(send_btn)
        page.click(NUTS_btn)

        sign()
    }
}
