package tests


import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//ПЕРЕНАЗНАЧЕНИЕ ИСПОЛНИТЕЛЯ И СОИСПОЛНИТЕЛЯ

class ReassignExecutorAndCoExecutor(private var assert: Boolean = true) {
    @Test
    fun reassignExecutorAndCoExecutor() {
        //Отправляем обращение в работу от Руководителя Исполнителю-1 и Исполнителю-2(Соисполнитель-1)
        SendToWorkByChiefToExecutorAndCoExecutor(false).sendToWorkTest()

        //Переключаемся на Руководителя и направляем в работу Исполнителю-3 и Исполнителю-4(Соисполнитель-2)
        switchOnUser(org1Chief1)
        org1Chief1.page.openAppeal(inExecutorsWork)
        org1Chief1.page.click(appealCardPage.sendToWork_btn)
        org1Chief1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor3)
        org1Chief1.page.click(appealCardPage.deleteCoExecutor_btn)
        org1Chief1.page.click(appealCardPage.addCoExecutor)
        org1Chief1.page.click(appealCardPage.coExecutorOrg_dropdown)
        org1Chief1.page.click(appealCardPage.org1)
        org1Chief1.page.click(appealCardPage.coExecutor_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor4)
        org1Chief1.page.click(appealCardPage.appoint_btn)
        org1Chief1.page.waitForSelector(appealCardPage.statusSendToWorkFromChief1ToExec1AndExec3Text)

        /*
        ПРОВЕРКА:
        Переключаемся на Исполнителя-3.
        Открываем обращение.
        Проверяем что в карточке обращения указаны корректный тип и номер обращения.

        Переключаемся на Исполнителя-4(Соисполнитель-2).
        Открываем обращение.
        Проверяем что в карточке обращения указаны корректный тип и номер обращения.
        */
        if (assert) {
            switchOnUser(org1Executor3)
            org1Executor3.page.openAppeal(inWork)
            assertEquals(org1Executor3.page.innerText(appealCardPage.cardHead_text), "$APPEAL_TYPE №ЖТ-$APPEAL_NUMBER")

            switchOnUser(org1Executor4)
            org1Executor4.page.openAppeal(inWork)
            assertEquals(org1Executor4.page.innerText(appealCardPage.cardHead_text), "$APPEAL_TYPE №ЖТ-$APPEAL_NUMBER")

            println("Test 3.2.7   passed ($APPEAL_TYPE ЖТ-$APPEAL_NUMBER)")
        }
    }
}
