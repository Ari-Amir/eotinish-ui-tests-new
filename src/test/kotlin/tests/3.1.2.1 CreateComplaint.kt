package tests


import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//СОЗДАНИЕ ЖАЛОБЫ РЕГИСТРАТОРОМ

class CreateComplaintByRegistrar (
    private var assert:Boolean = true,
    private var complaintType: String = listOfComplaintTypes[1]
) {
    @Test
    fun createComplaintTest() {
        //Переключаемся на Регистратора
        switchOnUser(org1Registrar1)

        //Выбираем тип обращения "Жалоба"
        org1Registrar1.page.waitForNavigation { org1Registrar1.page.click(mainPage.create_appeal_btn) }
        org1Registrar1.page.click(createComplaintPage.complainType_dropdown)
        org1Registrar1.page.click("text=$complaintType")
        COMPLAINT_TYPE = complaintType

        //Вводим ИИН и выбираем создание жалобы вручную
        org1Registrar1.page.fill(createComplaintPage.findAppeal_input, applicantsIIN)
        org1Registrar1.page.keyboard().press(enter_btn)
        org1Registrar1.page.click(createComplaintPage.createComplain_btn)

        //Заполняем обязательные поля жалобы
        org1Registrar1.page.click(createComplaintPage.complainForm_dropdown)
        org1Registrar1.page.click(createComplaintPage.complainForm)
        org1Registrar1.page.click(createComplaintPage.complainLanguage_dropdown)
        org1Registrar1.page.click(createComplaintPage.complainLanguage)

        org1Registrar1.page.click(createComplaintPage.region_dropdown2)
        org1Registrar1.page.click(createComplaintPage.country2)
        org1Registrar1.page.click(createComplaintPage.region2)
        org1Registrar1.page.click(createComplaintPage.adresat_dropdown2)
        org1Registrar1.page.click(createComplaintPage.adresat2)

        org1Registrar1.page.click(createComplaintPage.complainTo_dropdown)
        org1Registrar1.page.click(createComplaintPage.complainTo)

        org1Registrar1.page.click(createComplaintPage.desciption_textarea)
        org1Registrar1.page.fill(createComplaintPage.desciption_textarea, complainDescription)

        org1Registrar1.page.click(createAppealPage.appealCategory_dropdown)
        org1Registrar1.page.click(createAppealPage.appealCategory)
        org1Registrar1.page.click(createAppealPage.appealSubCategory)

        org1Registrar1.page.click(createComplaintPage.complainCharacter_dropdown)
        org1Registrar1.page.click(createComplaintPage.appealCharacter)
        org1Registrar1.page.fill(createComplaintPage.IIN_input, applicantsIIN)
        org1Registrar1.page.fill(createComplaintPage.surname_input, applicantsSurname)
        org1Registrar1.page.fill(createComplaintPage.name_input, applicantsName)
        org1Registrar1.page.fill(createComplaintPage.address, applicantsAddress)
        org1Registrar1.page.fill(createComplaintPage.mobilePhone_input, applicantsMobilePhone)
        org1Registrar1.page.click(createComplaintPage.send_btn)
        org1Registrar1.page.click(createComplaintPage.NUTS_btn)

        //Подписываем жалобу
        sign()

        //Получаем номер созданной жалобы из модального окна и переходим в реестр обращений
        COMPLAINT_NUMBER = org1Registrar1.page.innerText(createComplaintPage.complainNumber_text)
        org1Registrar1.page.waitForNavigation { org1Registrar1.page.click(createComplaintPage.goToRegistry_btn) }

        /*
        ПРОВЕРКА:
        Открываем жалобу.
        Проверяем что в карточке обращения указаны корректный тип и номер жалобы.
        Проверяем дедлайн, который соответствует текущему типу жалобы.
        */
        if (assert) {
            org1Registrar1.page.openComplaint(registeredAndWaitingForRoute)
            assertEquals(org1Registrar1.page.innerText(appealCardPage.cardHead_text), "$complaintType №$COMPLAINT_NUMBER")
            assertEquals(org1Registrar1.page.innerText(appealCardPage.deadline), Dates().calculateAppealDeadline(COMPLAINT_TYPE))
            println("Test 3.1.2.1 passed ($COMPLAINT_TYPE $COMPLAINT_NUMBER)")
        }
    }
}
