package tests


import org.testng.annotations.Test
import kotlin.test.*
import pages.*
import helpers.*
import lists.*

//РЕДАКТИРОВАНИЕ ОБРАЩЕНИЯ ИСПОЛНИТЕЛЕМ (РУКОВОДИТЕЛЕМ)

class ChangeAppealByExecutor (private var assert: Boolean = true) {
    @Test
    fun changeAppealByExecutorTest() {
        //Направляем обращение Регистратором в работу Руководителю
        SendToWorkByRegistrarToChief(false, listOfComplaintTypes[0]).sendToWorkTest()

        //Переключаемся на Руководителя
        switchOnUser(org1Chief1)

        //Открываем обращение
        org1Chief1.page.openAppeal(inWork, APPEAL_NUMBER)

        //ИЗМЕНЕНИЕ ДАННЫХ, КОТОРЫЕ НЕ ТРЕБУЮТ ПОДПИСАНИЯ (ВИД ОБРАЩЕНИЯ)
        //Нажимаем на редактирование обращения, меняем вид обращения, сохраняемся и после каждого сохранения проверяем дедлайн, и так по всем обращениям и жалобам
        for (i in listOfAppealAndComplaintDeadlines) {
            org1Chief1.page.click(appealCardPage.editAppeal_btn)
            org1Chief1.page.click(appealCardPage.ok)
            org1Chief1.page.click(changeAppealPage.appealType_dropdown)
            org1Chief1.page.click("text=${i.key}")
            org1Chief1.page.click(changeAppealPage.saveChanges_btn)
            assertEquals(org1Chief1.page.innerText(appealCardPage.deadlineOnExecitorCard), Dates().calculateAppealDeadline(i.key))
        }

        //ИЗМЕНЕНИЕ ДАННЫХ, КОТОРЫЕ НЕ ТРЕБУЮТ ПОДПИСАНИЯ (ФОРМА ПОДАЧИ, ЯЗЫК, КАТЕГОРИЯ/ПОДКАТЕГОРИЯ ОБРАЩЕНИЯ)
        //Нажимаем на редактирование обращения, меняем форму подачи, язык и категорию/подкатегорию
        org1Chief1.page.click(appealCardPage.editAppeal_btn)
        org1Chief1.page.click(appealCardPage.ok)
        org1Chief1.page.click(changeAppealPage.appealForm_dropdown)
        org1Chief1.page.click(electronic)
        org1Chief1.page.click(changeAppealPage.appealLanguage_dropdown)
        org1Chief1.page.click(changeAppealPage.appealLanguage)
        org1Chief1.page.click(changeAppealPage.appealCategoryForExecutor_dropdown)
        org1Chief1.page.click(changeAppealPage.appealCategoryForExecutor)
        org1Chief1.page.click(changeAppealPage.appealCategory1ForExecutor)
        org1Chief1.page.click(changeAppealPage.appealSubCategoryForExecutor_dropdown)
        org1Chief1.page.click(changeAppealPage.appealSubCategoryForExecutor)
        org1Chief1.page.click(changeAppealPage.saveChanges_btn)

        //Продлеваем срок обращения на следующий рабочий день и подписываем продление
        org1Chief1.page.click(appealCardPage.prolongDeadline_btn)
        org1Chief1.page.locator(appealCardPage.dateInput).evaluate(appealCardPage.removeReadonly)
        org1Chief1.page.fill(appealCardPage.dateInput, Dates().getNextWorkingDateFromDeadline(listOfAppealTypes[11]))
        org1Chief1.page.click(appealCardPage.prolongReason_input)
        org1Chief1.page.fill(appealCardPage.prolongReason_input, appealCardPage.prolongReason)
        org1Chief1.page.click(appealCardPage.prolongApprovers_dropdown)
        org1Chief1.page.click(appealCardPage.prolongApprover)
        org1Chief1.page.click(appealCardPage.prolongSigner_dropdown)
        org1Chief1.page.click(appealCardPage.prolongSigner)
        org1Chief1.page.click(appealCardPage.send_btn)
        org1Chief1.page.click(appealCardPage.prolongAppove_btn)
        org1Chief1.page.click(appealCardPage.prolongApproveConfirmation_btn)
        org1Chief1.page.click(appealCardPage.prolongSign_btn)
        org1Chief1.page.click(appealCardPage.NUTS_btn)

        //Подписываем обращение
        sign()

        /*
        ПРОВЕРКА:
        После продления срока пытаемся изменить вид обращения (не должно давать).
        Должна отобразиться ошибка в верхнем правом углу (красный бокс).
        Кнопка "Сохранить изменения" должна продолжать отображаться
        */
        if (assert) {
            org1Chief1.page.click(appealCardPage.editAppeal_btn)
            org1Chief1.page.click(appealCardPage.ok)
            org1Chief1.page.click("text=${listOfAppealTypes[11]}")
            org1Chief1.page.click("text=${listOfAppealTypes[1]}")
            org1Chief1.page.click(changeAppealPage.saveChanges_btn)
            assertTrue(org1Chief1.page.isVisible(changeAppealPage.saveChanges_btn))

            println("Test 3.8.2   passed (Сообщение, ЖТ-$APPEAL_NUMBER)")
        }
    }
}
