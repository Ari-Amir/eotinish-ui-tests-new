package tests

import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//НАПРАВЛЕНИЕ ОБРАЩЕНИЯ В РАБОТУ ОТ РУКОВОДИТЕЛЯ ИСПОЛНИТЕЛЮ

class SendToWorkByChiefToExecutor(private var assert: Boolean = true) {
    @Test
    fun sendToWorkTest() {
        //Отправляем обращение в работу от Регистратора Руководителю
        SendToWorkByRegistrarToChief(false).sendToWorkTest()

        //Переключаемся на Руководителя
        switchOnUser(org1Chief1)

        //Открываем полученное обращение, нажимаем кнопку "Направить в работу" и направляем в работу Исполнителю
        org1Chief1.page.openAppeal(inWork)
        org1Chief1.page.click(appealCardPage.sendToWork_btn)
        org1Chief1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor1)
        org1Chief1.page.click(appealCardPage.appoint_btn)
        org1Chief1.page.waitForSelector(appealCardPage.statusSendToWorkFromChief1ToExec1Text)

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
            println("Test 3.2.3   passed ($APPEAL_TYPE ЖТ-$APPEAL_NUMBER)")
        }
    }
}