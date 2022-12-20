package tests


import org.testng.annotations.Test
import kotlin.test.*
import lists.*
import helpers.*
import pages.*

//СОЗДАНИЕ ОБРАЩЕНИЯ ОПЕРАТОРОМ ЦОНА

class CreateAppealByTSONOperator (
    private var assert:Boolean = true,
    private var appealType: String = listOfAppealTypes[1],
) {

    @Test
    fun createAppealTest() {
        //Переключаемся на Оператора ЦОНа
        switchOnUser(TSONOperator)

        //Заполняем обязательные поля обращения
        TSONOperator.page.waitForNavigation { TSONOperator.page.click(mainPage.create_appeal_btn) }
        TSONOperator.page.click(createAppealPage.appealType_dropdown)
        TSONOperator.page.click("text=$appealType")
        APPEAL_TYPE = appealType

        TSONOperator.page.click(createAppealPage.appealForm_dropdown)
        TSONOperator.page.click(paper)
        TSONOperator.page.click(createAppealPage.appealLanguage_dropdown)
        TSONOperator.page.click(createAppealPage.appealLanguage)

        TSONOperator.page.click(createAppealPage.region_dropdown)
        TSONOperator.page.click(createAppealPage.country)
        TSONOperator.page.click(createAppealPage.adresat_dropdown)
        TSONOperator.page.click(createAppealPage.adresat)

        TSONOperator.page.click(createAppealPage.desciption_textarea)
        TSONOperator.page.fill(createAppealPage.desciption_textarea, appealDescription)
        TSONOperator.page.click(createAppealPage.appealCharacter_dropdown)
        TSONOperator.page.click(createAppealPage.appealCharacter)
        TSONOperator.page.fill(createAppealPage.IIN_input, applicantsIIN)
        TSONOperator.page.fill(createAppealPage.surname_input, applicantsSurname)
        TSONOperator.page.fill(createAppealPage.name_input, applicantsName)
        TSONOperator.page.fill(createAppealPage.address, applicantsAddress)
        TSONOperator.page.fill(createAppealPage.mobilePhone_input, applicantsMobilePhone)
        TSONOperator.page.click(createAppealPage.send_btn)
        TSONOperator.page.click(createAppealPage.NUTS_btn)

        //Подписываем обращение
        sign()

        //Получаем номер созданного обращения из модального окна и переходим в реестр обращений
        APPEAL_NUMBER = TSONOperator.page.innerText(createAppealPage.appealNumber_text)
        TSONOperator.page.waitForNavigation { TSONOperator.page.click(createAppealPage.goToRegistry_btn) }

        /*
        ПРОВЕРКА:
        Открываем обращение.
        Проверяем что в карточке обращения указаны корректный тип и номер обращения.
        Проверяем дедлайн обращения, который соответствует текущему типу обращения.
        */
        if (assert) {
            TSONOperator.page.openAppeal(TSONAppealRegistry)
            assertEquals(TSONOperator.page.innerText(appealCardPage.cardHead_text), "$APPEAL_TYPE №$APPEAL_NUMBER")
            assertEquals(TSONOperator.page.innerText(appealCardPage.deadlineOnTSONCard), Dates().calculateAppealDeadline(APPEAL_TYPE))
            println("Test 3.1.1.2 passed ($APPEAL_TYPE $APPEAL_NUMBER)")
        }
    }
}
