package tests

import lists.*
import org.testng.annotations.Test
import configs.*
import pages.*
import kotlin.test.assertEquals


var appealNumber = ""
var appealType = ""

class CreateAppeal (private var assert:Boolean = true) {
    private val createAppealPage = CreateAppealPage()
    private val appealCardPage = AppealCardPage()
    private val mainPage = MainPage()
    private val appealsRegistryTsonPage = AppealsRegistryTsonPage()
    private val registeredAppealsListPage = RegisteredAppealsListPage()

    @Test
    fun createAppealTest() {
        timeout
        Login(assert = false).loginTest()
        page.waitForNavigation { page.click(mainPage.create_appeal_btn) }
        page.click(createAppealPage.appealType_dropdown)
        page.click(zapros)
        appealType = page.innerText(zapros)

        if (page.isVisible(createAppealPage.appealCategory_dropdown)) {
            page.click(createAppealPage.appealCategory_dropdown)
            page.click(createAppealPage.appealCategory)
            page.click(createAppealPage.appealSubCategory)
        }

        page.click(createAppealPage.appealForm_dropdown)
        page.click(paper)
        page.click(createAppealPage.appealLanguage_dropdown)
        page.click(createAppealPage.appealLanguage)

        if (page.isVisible(createAppealPage.region_dropdown)) {
            page.click(createAppealPage.region_dropdown)
            page.click(createAppealPage.country)
            page.click(createAppealPage.region)
            page.click(createAppealPage.adresat_dropdown)
            page.click(createAppealPage.adresat)
        }

        page.click(createAppealPage.desciption_textarea)
        page.fill(createAppealPage.desciption_textarea, appealDescription)
        page.click(createAppealPage.appealCharacter_dropdown)
        page.click(createAppealPage.appealCharacter)
        page.fill(createAppealPage.IIN_input, applicantsIIN)
        page.fill(createAppealPage.surname_input, applicantsSurname)
        page.fill(createAppealPage.name_input, applicantsName)
        page.fill(createAppealPage.address, applicantsAddress)
        page.fill(createAppealPage.mobilePhone_input, applicantsMobilePhone)
        page.click(createAppealPage.send_btn)
        page.click(createAppealPage.NUTS_btn)

        sign()

        appealNumber = page.innerText(createAppealPage.appealNumber_text)
        page.waitForNavigation { page.click(createAppealPage.goToRegistry_btn) }

        if (assert) {
            when {
                page.isVisible(registeredAppealsListPage.appealsSearch_input) -> {
                    page.click(registeredAppealsListPage.appealsSearch_input)
                    page.fill(registeredAppealsListPage.appealsSearch_input, appealNumber)
                    page.keyboard().press(enter_btn)
                    page.waitForNavigation { page.click(registeredAppealsListPage.appealInList) }
                    assertEquals(page.innerText(appealCardPage.cardHead_text), "$appealType №$appealNumber")
                    assertEquals(page.innerText(appealCardPage.appealSourceGO), GO)

                }
                else -> {
                    page.fill(appealsRegistryTsonPage.appealsSearchTSON_input, appealNumber)
                    page.keyboard().press(enter_btn)
                    page.waitForNavigation { page.click(appealsRegistryTsonPage.appealInListTSON) }
                    assertEquals(page.innerText(appealCardPage.cardHead_text), "$appealType №$appealNumber")
                    assertEquals(page.innerText(appealCardPage.appealSourceTSON), TSON)
                }
            }
        }
    }
}
