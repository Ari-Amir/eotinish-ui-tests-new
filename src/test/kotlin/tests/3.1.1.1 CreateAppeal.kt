package tests


import org.testng.annotations.Test
import kotlin.test.*
import lists.*
import helpers.*
import pages.*

//СОЗДАНИЕ ОБРАЩЕНИЯ РЕГИСТРАТОРОМ

class CreateAppealByRegistrar (
    private var assert:Boolean = true,
    private var appealType: String = listOfAppealTypes[4],
) {

    @Test
    fun createAppealTest() {
        //Переключаемся на Регистратора
        switchOnUser(org1Registrar1)

        //Заполняем обязательные поля обращения
        org1Registrar1.page.waitForNavigation { org1Registrar1.page.click(mainPage.create_appeal_btn) }
        org1Registrar1.page.click(createAppealPage.appealType_dropdown)
        org1Registrar1.page.click("text=$appealType")
        APPEAL_TYPE = appealType

        org1Registrar1.page.click(createAppealPage.appealForm_dropdown)
        org1Registrar1.page.click(paper)
        org1Registrar1.page.click(createAppealPage.appealLanguage_dropdown)
        org1Registrar1.page.click(createAppealPage.appealLanguage)

        org1Registrar1.page.click(createAppealPage.desciption_textarea)
        org1Registrar1.page.fill(createAppealPage.desciption_textarea, appealDescription)

        org1Registrar1.page.click(createAppealPage.appealCategory_dropdown)
        org1Registrar1.page.click(createAppealPage.appealCategory)
        org1Registrar1.page.click(createAppealPage.appealSubCategory)

        org1Registrar1.page.click(createAppealPage.appealCharacter_dropdown)
        org1Registrar1.page.click(createAppealPage.appealCharacter)
        org1Registrar1.page.fill(createAppealPage.IIN_input, applicantsIIN)
        org1Registrar1.page.fill(createAppealPage.surname_input, applicantsSurname)
        org1Registrar1.page.fill(createAppealPage.name_input, applicantsName)
        org1Registrar1.page.fill(createAppealPage.address, applicantsAddress)
        org1Registrar1.page.fill(createAppealPage.mobilePhone_input, applicantsMobilePhone)
        org1Registrar1.page.click(createAppealPage.send_btn)
        org1Registrar1.page.click(createAppealPage.NUTS_btn)

        //Подписываем обращение
        sign()

        //Получаем номер созданного обращения из модального окна и переходим в реестр обращений
        APPEAL_NUMBER = org1Registrar1.page.innerText(createAppealPage.appealNumber_text)
        org1Registrar1.page.waitForNavigation { org1Registrar1.page.click(createAppealPage.goToRegistry_btn) }

        /*
        ПРОВЕРКА:
        Открываем обращение.
        Проверяем что в карточке обращения указаны корректный тип и номер обращения.
        Проверяем дедлайн обращения, который соответствует текущему типу обращения.
        */
        if (assert) {
            org1Registrar1.page.openAppeal(registeredAndWaitingForRoute)
            assertEquals(org1Registrar1.page.innerText(appealCardPage.cardHead_text), "$APPEAL_TYPE №$APPEAL_NUMBER")
            assertEquals(org1Registrar1.page.innerText(appealCardPage.deadline), Dates().calculateAppealDeadline(APPEAL_TYPE))
            println("Test 3.1.1.1 passed ($APPEAL_TYPE $APPEAL_NUMBER)")
        }
    }
}
