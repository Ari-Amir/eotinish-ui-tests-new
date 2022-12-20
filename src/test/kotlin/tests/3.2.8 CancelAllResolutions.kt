package tests


import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//ОТМЕНА РЕЗОЛЮЦИЙ РЕГИСТРАТОРОМ И НАЗНАЧЕНИЕ НОВОГО ИСПОЛНИТЕЛЯ

class CancelAllResolutions (private var assert: Boolean = true) {
    @Test
    fun cancelAllResolutions() {
        //Отправляем обращение в работу от Руководителя Исполнителю-1 и Исполнителю-2(Соисполнитель-1)
        SendToWorkByChiefToExecutorAndCoExecutor(false).sendToWorkTest()

        //Переключаемся на Регистратора, открываем обращение, нажимаем кнопку "Изменить исполнителя" и назначаем исполнителем Исполнителя-3
        switchOnUser(org1Registrar1)
        org1Registrar1.page.openAppeal(onExecution)
        org1Registrar1.page.click(appealCardPage.changeExecutor)
        org1Registrar1.page.click(appealCardPage.newStructuralSubdivision_dropdown)
        org1Registrar1.page.click(appealCardPage.org1)
        org1Registrar1.page.click(appealCardPage.responsibleSpecialist_dropdown)
        org1Registrar1.page.click(appealCardPage.org1_Executor3)
        org1Registrar1.page.click(appealCardPage.appoint_btn)
        org1Registrar1.page.waitForSelector(appealCardPage.statusSendToWorkFromReg1ToChief1Text)

        /*
        ПРОВЕРКА:
        Переключаемся на Исполнителя-1.
        Открываем вкладку "Входящие задачи" -> "Находятся в работе".
        Убеждаемся что обращение отсутствует в реестре.

        Переключаемся на Исполнителя-2(Соисполнитель-2).
        Открываем вкладку "Входящие задачи" -> "Находятся в работе".
        Убеждаемся что обращение отсутствует в реестре.

        Переключаемся на Исполнителя-3.
        Открываем вкладку "Входящие задачи" -> "Находятся в работе".
        Открываем обращение.
        Проверяем что в карточке обращения указаны корректный тип и номер обращения.
        */
        if (assert) {
//            switchOnUser(org1Executor1)
//            org1Executor1.page.openAppeal(inWork)
//            assertTrue(!org1Executor1.page.isVisible(appealFoundInOtherTabs))
//
//            switchOnUser(org1Executor2)
//            org1Executor1.page.openAppeal(inWork)
//            assertTrue(!org1Executor2.page.isVisible(appealFoundInOtherTabs))

            switchOnUser(org1Executor3)
            org1Executor3.page.openAppeal(inWork)
            assertEquals(org1Executor3.page.innerText(appealCardPage.cardHead_text), "$APPEAL_TYPE №ЖТ-$APPEAL_NUMBER")

            println("Test 3.2.8   passed ($APPEAL_TYPE ЖТ-$APPEAL_NUMBER)")
        }
    }
}