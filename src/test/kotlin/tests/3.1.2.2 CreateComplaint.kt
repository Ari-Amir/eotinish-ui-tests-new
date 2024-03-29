package tests

import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//СОЗДАНИЕ ЖАЛОБЫ ОПЕРАТОРОМ ЦОНА

class CreateComplaintByTSONOperator (
    private var assert:Boolean = true,
    private var complaintType: String = listOfComplaintTypes[3],
) {

    @Test
    fun createComplaintTest() {
        //Переключаемся на оператора ЦОНа
        switchOnUser(TSONOperator)

        //Выбираем тип обращения "Жалоба"
        TSONOperator.page.waitForNavigation { TSONOperator.page.click(mainPage.create_appeal_btn) }
        TSONOperator.page.click(createComplaintPage.complainType_dropdown)
        TSONOperator.page.click("text=$complaintType")
        COMPLAINT_TYPE = complaintType

        //Вводим ИИН и выбираем создание жалобы вручную
        TSONOperator.page.fill(createComplaintPage.findAppeal_input, applicantsIIN)
        TSONOperator.page.keyboard().press(enter_btn)
        TSONOperator.page.click(createComplaintPage.createComplain_btn)

        //Заполняем обязательные поля жалобы
        TSONOperator.page.click(createComplaintPage.complainForm_dropdown)
        TSONOperator.page.click(createComplaintPage.complainForm)
        TSONOperator.page.click(createComplaintPage.complainLanguage_dropdown)
        TSONOperator.page.click(createComplaintPage.complainLanguage)

        TSONOperator.page.click(createComplaintPage.region_dropdown1)
        TSONOperator.page.click(createComplaintPage.country1)
        TSONOperator.page.click(createComplaintPage.adresat_dropdown1_TSON)
        TSONOperator.page.click(createComplaintPage.adresat1)

        TSONOperator.page.click(createComplaintPage.region_dropdown2)
        TSONOperator.page.click(createComplaintPage.country2)
        TSONOperator.page.click(createComplaintPage.region2)
        TSONOperator.page.click(createComplaintPage.adresat_dropdown2)
        TSONOperator.page.click(createComplaintPage.adresat2)

        TSONOperator.page.click(createComplaintPage.complainTo_dropdown)
        TSONOperator.page.click(createComplaintPage.complainTo)

        TSONOperator.page.click(createComplaintPage.desciption_textarea)
        TSONOperator.page.fill(createComplaintPage.desciption_textarea, complainDescription)
        TSONOperator.page.click(createComplaintPage.complainCharacter_dropdown)
        TSONOperator.page.click(createComplaintPage.appealCharacter)
        TSONOperator.page.fill(createComplaintPage.IIN_input, applicantsIIN)
        TSONOperator.page.fill(createComplaintPage.surname_input, applicantsSurname)
        TSONOperator.page.fill(createComplaintPage.name_input, applicantsName)
        TSONOperator.page.fill(createComplaintPage.address, applicantsAddress)
        TSONOperator.page.fill(createComplaintPage.mobilePhone_input, applicantsMobilePhone)
        TSONOperator.page.click(createComplaintPage.send_btn)
        TSONOperator.page.click(createComplaintPage.NUTS_btn)

        //Подписываем жалобу
        sign()

        //Получаем номер созданной жалобы из модального окна и переходим в реестр обращений
        COMPLAINT_NUMBER = TSONOperator.page.innerText(createComplaintPage.complainNumber_text)
        TSONOperator.page.waitForNavigation { TSONOperator.page.click(createComplaintPage.goToRegistry_btn) }

        /*
        ПРОВЕРКА:
        Открываем жалобу.
        Проверяем что в карточке обращения указаны корректный тип и номер жалобы.
        Проверяем дедлайн, который соответствует текущему типу жалобы.
        */
        if (assert) {
            TSONOperator.page.openComplaint(TSONAppealRegistry)
            assertEquals(TSONOperator.page.innerText(appealCardPage.cardHead_text), "$COMPLAINT_TYPE №$COMPLAINT_NUMBER")
            assertEquals(TSONOperator.page.innerText(appealCardPage.deadlineOnTSONCard), Dates().calculateAppealDeadline(COMPLAINT_TYPE))
            println("Test 3.1.2.2 passed ($COMPLAINT_TYPE $COMPLAINT_NUMBER)")
        }
    }
}
