package tests


import org.testng.annotations.Test
import kotlin.test.*
import lists.*
import pages.*
import helpers.*

//НАПРАВЛЕНИЕ ОБРАЩЕНИЯ В РАБОТУ ОТ РЕГИСТРАТОРА ИСПОЛНИТЕЛЮ

class SendToWorkByRegistrarToExecutor(private var assert: Boolean = true, private var appealType: String = listOfAppealTypes[1]) {
    @Test
    fun sendToWorkTest() {
        //Переключаемся на Регистратора
        switchOnUser(org1Registrar1)

        //Создаем обращение в базе данных
        APPEAL_TYPE = appealType
        APPEAL_NUMBER = createAppealInDB(APPEAL_TYPE)

        //Открываем созданное обращение, нажимаем кнопку "Направить в работу" и направляем в работу Исполнителю
        org1Registrar1.page.openAppeal(registeredAndWaitingForRoute)
        org1Registrar1.page.click(appealCardPage.sendToWork_btn)
        org1Registrar1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Registrar1.page.click(appealCardPage.org1_Executor1)
        org1Registrar1.page.click(appealCardPage.appoint_btn)
        org1Registrar1.page.waitForSelector(appealCardPage.statusSendToWorkFromReg1ToExec1Text)

        /*
        ПРОВЕРКА:
        Переключаемся на Исполнителя.
        Открываем вкладку "Входящие задачи" -> "Находятся в работе".
        Открываем обращение.
        Проверяем что в карточке обращения указаны корректный тип и номер обращения.
        */
        if (assert) {
            switchOnUser(org1Executor1)
            org1Executor1.page.openAppeal(inWork)
            assertEquals(org1Executor1.page.innerText(appealCardPage.cardHead_text), "$APPEAL_TYPE №ЖТ-$APPEAL_NUMBER")
            println("Test 3.2.2   passed ($APPEAL_TYPE ЖТ-$APPEAL_NUMBER)")
        }
    }
}