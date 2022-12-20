package tests

import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//ПЕРЕНАЗНАЧЕНИЕ СОИСПОЛНИТЕЛЯ

class ReassignCoExecutor(private var assert: Boolean = true) {
    @Test
    fun reassignCoExecutor() {
        //Отправляем обращение в работу от Регистратора Руководителю
        SendToWorkByRegistrarToChief(false).sendToWorkTest()

        //Переключаемся на Руководителя и направляем в работу Исполнителю-1 и Исполнителю-2(Соисполнитель-1)
        switchOnUser(org1Chief1)
        org1Chief1.page.openAppeal(inWork)
        org1Chief1.page.click(appealCardPage.sendToWork_btn)
        org1Chief1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor1)
        org1Chief1.page.click(appealCardPage.addCoExecutor)
        org1Chief1.page.click(appealCardPage.coExecutorOrg_dropdown)
        org1Chief1.page.click(appealCardPage.org1)
        org1Chief1.page.click(appealCardPage.coExecutor_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor2)
        org1Chief1.page.click(appealCardPage.appoint_btn)
        org1Chief1.page.waitForSelector(appealCardPage.statusSendToWorkFromChief1ToExec1AndExec2Text)

        ////Удаляем из соисполнителей Исполнителя-2(Соисполнитель-1) и назначаем соисполнителем Исполнителя-3(Соисполнитель-2)
        org1Chief1.page.openAppeal(inExecutorsWork)
        org1Chief1.page.click(appealCardPage.sendToWork_btn)
        org1Chief1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor1)
        org1Chief1.page.click(appealCardPage.deleteCoExecutor_btn)
        org1Chief1.page.click(appealCardPage.addCoExecutor)
        org1Chief1.page.click(appealCardPage.coExecutorOrg_dropdown)
        org1Chief1.page.click(appealCardPage.org1)
        org1Chief1.page.click(appealCardPage.coExecutor_dropdown)
        org1Chief1.page.click(appealCardPage.org1_Executor3)
        org1Chief1.page.click(appealCardPage.appoint_btn)
        org1Chief1.page.waitForSelector(appealCardPage.statusSendToWorkFromChief1ToExec1AndExec3Text)

        /*
        ПРОВЕРКА:
        Переключаемся на Исполнителя-3(Соисполнитель-2).
        Открываем обращение.
        Проверяем что в карточке обращения указаны корректный тип и номер обращения.
        Проверяем что у соисполнителя есть кнопка "Сформировать ответ"
        */
        if (assert) {
            switchOnUser(org1Executor3)
            org1Executor3.page.openAppeal(inWork)
            assertEquals(org1Executor3.page.innerText(appealCardPage.cardHead_text), "$APPEAL_TYPE №ЖТ-$APPEAL_NUMBER")
            assertTrue(org1Executor3.page.isVisible(appealCardPage.coExecutorsComment_btn))
            println("Test 3.2.6   passed ($APPEAL_TYPE ЖТ-$APPEAL_NUMBER)")
        }
    }
}
