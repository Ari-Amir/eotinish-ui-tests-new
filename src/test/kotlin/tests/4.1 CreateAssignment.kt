package tests

import okhttp3.internal.trimSubstring
import org.testng.annotations.Test
import kotlin.test.assertEquals
import pages.*
import helpers.*
import lists.*

//СОЗДАНИЕ ПОРУЧЕНИЯ РЕГИСТРАТОРОМ ДЛЯ ГО-ИСПОЛНИТЕЛЯ ORG.2 И ГО-СОИСПОЛНИТЕЛЯ ORG.3

class CreateAssignmentByRegistrar (private var assert:Boolean = true) {
    @Test
    fun createAssignmentByRegistrarTest() {
        //Переключаемся на Регистратора и создаем обращение
        switchOnUser(org1Registrar1)
        APPEAL_NUMBER = createAppealInDB(listOfAppealTypes[0])

        //Открываем обращение и создаем поручение
        org1Registrar1.page.openAppeal(registeredAndWaitingForRoute)
        org1Registrar1.page.click(appealCardPage.createAssignment_btn)
        org1Registrar1.page.click(appealCardPage.region_dropdown)
        org1Registrar1.page.click(appealCardPage.country)
        org1Registrar1.page.click(appealCardPage.adresat_dropdown)
        org1Registrar1.page.click(appealCardPage.org2)
        org1Registrar1.page.click(appealCardPage.addCoExecutor_text)
        org1Registrar1.page.click(appealCardPage.region2_dropdown)
        org1Registrar1.page.click(appealCardPage.country2)
        org1Registrar1.page.click(appealCardPage.adresat2_dropdown)
        org1Registrar1.page.click(appealCardPage.org3)

        //Указываем срок исполнения
        org1Registrar1.page.click(appealCardPage.deadline_input)
        org1Registrar1.page.locator(appealCardPage.deadline_input).evaluate(appealCardPage.removeReadonly)
        org1Registrar1.page.fill(appealCardPage.deadline_input, Dates().getNextWorkingDateFromToday())
        org1Registrar1.page.keyboard().press(enter_btn)
        ASSIGNMENT_DEADLINE = org1Registrar1.page.inputValue(appealCardPage.deadline_input)

        //Выбираем согласующих, подписанта, ответственного сотрудника и отправляем
        org1Registrar1.page.click(appealCardPage.signer_dropdown)
        org1Registrar1.page.click(appealCardPage.signer)
        org1Registrar1.page.click(appealCardPage.approvers_dropdown)
        org1Registrar1.page.click(appealCardPage.approver)
        org1Registrar1.page.click(appealCardPage.responsibleWorker_dropdown)
        org1Registrar1.page.click(appealCardPage.responsibleWorker)
        org1Registrar1.page.click(appealCardPage.send_btn)

        //Получаем номер поручения из вкладки "История поручений"
        org1Registrar1.page.click(appealCardPage.assignmentHistory_tab)
        ASSIGNMENT_NUMBER = org1Registrar1.page.innerText(appealCardPage.assignmentNumber).substring(4)

        //Переключаемся на Руководителя, открываем обращение, согласовываем и подписываем его
        switchOnUser(org1Chief1)
        org1Chief1.page.openAssignment(allOutgoing)
        org1Chief1.page.click(assignmentCardPage.approve_btn)
        org1Chief1.page.click(assignmentCardPage.approveOnPopup_btn)
        org1Chief1.page.click(assignmentCardPage.sign_btn)
        org1Chief1.page.click(assignmentCardPage.NUTS_btn)
        sign()
        assertEquals(org1Chief1.page.innerText(assignmentCardPage.statusAssignmentSigned), statusAssignmentSigned)


        //Переключаемся на Контролера и открываем поручение во вкладке "Поручения" -> "Ожидают проверки"
        switchOnUser(org1Controller1)
        org1Controller1.page.openAssignment(waitingForCheck)

        //Нажимаем кнопку "Проверено"
        org1Controller1.page.click(assignmentCardPage.checked_btn)
        org1Controller1.page.click(assignmentCardPage.confirm_btn)
//        ASSIGNMENT_NUMBER = org1Controller1.page.innerText(assignmentCardPage.assignmentNumber).trimSubstring(19,29)

        /*
        ПРОВЕРКА:
        Срок поручения должен быть таким же, который мы указывали при создании поручения.
        В статусах поручения должны отображаться статусы:
        "Создан проект",
        "Согласован проект",
        "Подписан проект",
        "Проверен проект"
        */
        if (assert) {
            assertEquals(Dates().dateFormatChange(org1Controller1.page.innerText(assignmentCardPage.assignmentDeadline)), ASSIGNMENT_DEADLINE)
            assertEquals(org1Controller1.page.innerText(assignmentCardPage.statusAssignmentCreated), statusAssignmentCreated)
            assertEquals(org1Controller1.page.innerText(assignmentCardPage.statusAssignmentApproved), statusAssignmentApproved)
            assertEquals(org1Controller1.page.innerText(assignmentCardPage.statusAssignmentSigned), statusAssignmentSigned)
            assertEquals(org1Controller1.page.innerText(assignmentCardPage.statusAssignmentChecked), statusAssignmentChecked)
            println("Test 4.1     passed (Поручение №ЖТ-${ASSIGNMENT_NUMBER})")
        }
    }
}
