package tests

import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//ПЕРЕНАЗНАЧЕНИЕ ИСПОЛНИТЕЛЯ

class ReassignExecutor(private var assert: Boolean = true) {
    @Test
    fun reassignExecutor() {
        //Отправляем обращение в работу от Руководителя Исполнителю-1
        SendToWorkByChiefToExecutor(false).sendToWorkTest()

        //Переназначаем исполнителем Исполнителя-2
        org1Chief1.page.openAppeal(inExecutorsWork)
        org1Chief1.page.click(appealCardPage.sendToWork_btn)
        org1Chief1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor2)
        org1Chief1.page.click(appealCardPage.appoint_btn)
        org1Chief1.page.waitForSelector(appealCardPage.statusSendToWorkFromChief1ToExec2Text)

        /*
        ПРОВЕРКА:
        Переключаемся на Исполнителя-2.
        Открываем обращение.
        Проверяем что в карточке обращения указаны корректный тип и номер обращения.
        */
        if (assert) {
            switchOnUser(org1Executor2)
            org1Executor2.page.openAppeal(inWork)
            assertEquals(org1Executor2.page.innerText(appealCardPage.cardHead_text), "$APPEAL_TYPE №ЖТ-$APPEAL_NUMBER")
            println("Test 3.2.5   passed ($APPEAL_TYPE ЖТ-$APPEAL_NUMBER)")
        }
    }
}