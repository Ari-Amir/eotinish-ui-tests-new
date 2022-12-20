package tests

import org.testng.annotations.Test
import helpers.*
import lists.*
import pages.*

/*
НАПРАВЛЕНИЕ ПОРУЧЕНИЯ В РАБОТУ И ЕГО ИСПОЛНЕНИЕ

ГО-1 (Org.1) направляет в:
ГО-2 (Org.2)
ГО-3 (Org.3)

ГО-2 направляет:
Исполнителю из корня организации
Соисполнителю из структурного подразделения

ГО-3 направляет:
Соисполнителю из подведомственной организации
*/


class SendAssignmentToWork2(private var assert: Boolean = true) {
    @Test
    fun sendAssignmentToWorkTest() {
        //Создаем обращение Регистратором Org.1 и направляем в работу в Org.2 и в Org.3
        CreateAssignmentByRegistrar(assert = false).createAssignmentByRegistrarTest()

        //Переключаемся на Регистратора из Org.2 и открываем поручение
        switchOnUser(org2Registrar1)
        org2Registrar1.page.openAssignment(waitingForRouting)

        //Направляем поручение в работу Исполнителю из Org.2
        org2Registrar1.page.click(assignmentCardPage.sendToWork_btn)
        org2Registrar1.page.click(assignmentCardPage.responsibleExecutor_dropdown)
        org2Registrar1.page.click(assignmentCardPage.org2_Executor1)

        //Направляем поручение в работу Соисполнителю из структурного подразделения в Org.2
        org2Registrar1.page.click(assignmentCardPage.addCoExecutor_btn)
        org2Registrar1.page.click(assignmentCardPage.coExecutor1Org_dropdown)
        org2Registrar1.page.click(assignmentCardPage.coExecutorOrg)
        org2Registrar1.page.click(assignmentCardPage.responsibleCoExecutor1_dropdown)
        org2Registrar1.page.click(assignmentCardPage.org2un1_Executor1)

        //Указываем внутренний срок и нажимаем кнопку "Назначить"
        org2Registrar1.page.click(assignmentCardPage.assignmentInnerDeadline_input)
        org2Registrar1.page.locator(assignmentCardPage.assignmentInnerDeadline_input).evaluate(assignmentCardPage.removeReadonly)
        org2Registrar1.page.fill(assignmentCardPage.assignmentInnerDeadline_input, Dates().getNextWorkingDateFromToday())
        org2Registrar1.page.keyboard().press(enter_btn)
        ASSIGNMENT_INNER_DEADLINE_FOR_EXECUTOR1 = org2Registrar1.page.inputValue(assignmentCardPage.assignmentInnerDeadline_input)
        org2Registrar1.page.click(assignmentCardPage.assign_btn)


        //Переключаемся на Регистратора из Org.3 и открываем поручение
        switchOnUser(org3Registrar1)
        org3Registrar1.page.openAssignment(waitingForRouting)

        //Направляем поручение в работу Исполнителю из подведомственной организации в Org.3
        org3Registrar1.page.click(assignmentCardPage.sendToWork_btn)
        org3Registrar1.page.click(assignmentCardPage.executorForOrg3_dropdown)
        org3Registrar1.page.click(assignmentCardPage.org3ch1)
        org3Registrar1.page.click(assignmentCardPage.responsibleExecutor_dropdown)
        org3Registrar1.page.click(assignmentCardPage.org3ch1_Executor1)

        //Указываем внутренний срок и нажимаем кнопку "Назначить"
        org3Registrar1.page.click(assignmentCardPage.assignmentInnerDeadline_input)
        org3Registrar1.page.locator(assignmentCardPage.assignmentInnerDeadline_input).evaluate(assignmentCardPage.removeReadonly)
        org3Registrar1.page.fill(assignmentCardPage.assignmentInnerDeadline_input, Dates().getNextWorkingDateFromToday())
        org3Registrar1.page.keyboard().press(enter_btn)
        ASSIGNMENT_INNER_DEADLINE_FOR_EXECUTOR2 = org3Registrar1.page.inputValue(assignmentCardPage.assignmentInnerDeadline_input)
        org3Registrar1.page.click(assignmentCardPage.assign_btn)

        //TODO(исполнение поручения от ГО-2 и ГО-3 и если нужно, то добавить необходимые проверки проверки)

        if (assert) {
            println("Test 4.2.2   passed (Поручение №ЖТ-2022-${ASSIGNMENT_NUMBER})")
        }
    }
}