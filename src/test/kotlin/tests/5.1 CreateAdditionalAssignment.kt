package tests

import org.testng.annotations.Test
import kotlin.test.assertEquals
import helpers.*
import lists.*
import pages.*

//СОЗДАНИЕ ДОПОЛНИИТЕЛЬНОГО ПОРУЧЕНИЯ

class CreateAdditionalAssignment (private var assert:Boolean = true) {

    @Test
    fun createAdditionalAssignmentTest() {
        //Создаем поручение Регистратором и открываем его
        CreateAssignmentByRegistrar(false).createAssignmentByRegistrarTest()

        switchOnUser(org1Registrar1)
        org1Registrar1.page.openAssignment(allOutgoing)

        //Нажимаем кнопку "Создать поручение/запрос"
        org1Registrar1.page.click(assignmentCardPage.createAdditionalAssignment_btn)

        //Добавляем ГО-исполнителей и ГО-Соисполнителей
        org1Registrar1.page.click(assignmentCardPage.region_dropdown)
        org1Registrar1.page.click(assignmentCardPage.country)
        org1Registrar1.page.click(assignmentCardPage.adresat_dropdown)
        org1Registrar1.page.click(assignmentCardPage.org2)
        org1Registrar1.page.click(assignmentCardPage.addCoExecutor_text)
        org1Registrar1.page.click(assignmentCardPage.region2_dropdown)
        org1Registrar1.page.click(assignmentCardPage.country2)
        org1Registrar1.page.click(assignmentCardPage.adresat2_dropdown)
        org1Registrar1.page.click(assignmentCardPage.org3)

        //Указываем срок, согласующих и подписантов
        org1Registrar1.page.click(assignmentCardPage.deadline_input)
        org1Registrar1.page.locator(assignmentCardPage.deadline_input).evaluate(assignmentCardPage.removeReadonly)
        org1Registrar1.page.fill(assignmentCardPage.deadline_input, Dates().getNextWorkingDateFromToday())
        org1Registrar1.page.keyboard().press(enter_btn)
        ADDITIONAL_ASSIGNMENT_DEADLINE = org1Registrar1.page.inputValue(assignmentCardPage.deadline_input)
        org1Registrar1.page.click(assignmentCardPage.signers_dropdown)
        org1Registrar1.page.click(assignmentCardPage.signerOrg1Chief1)
        org1Registrar1.page.click(assignmentCardPage.approvers_dropdown)
        org1Registrar1.page.click(assignmentCardPage.signerOrg1Chief1)
        org1Registrar1.page.click(assignmentCardPage.send_btn)

        //TODO (Доделать согласование, подписание и проверку дополнительного поручения)

        /*
        ПРОВЕРКА:
        Срок дополнительного поручения должен быть таким же, который мы указывали при создании дополнительного поручения.
        В статусах дополнительного поручения должны отображаться статусы:
        "Создано дополнительное поручение",
        "Дополнительное поручение согласовано",
        "Дополнительное поручение подписано",
        "Проверен проект "Поручение/запрос"
        */
        if (assert) {
            assertEquals(Dates().dateFormatChange(org1Registrar1.page.innerText(assignmentCardPage.additionalAssignmentDeadline)), ADDITIONAL_ASSIGNMENT_DEADLINE)
            assertEquals(org1Registrar1.page.innerText(assignmentCardPage.statusAdditionalAssignmentCreated), statusAdditionalAssignmentCreated)
            assertEquals(org1Registrar1.page.innerText(assignmentCardPage.statusAdditionalAssignmentApproved), statusAdditionalAssignmentApproved)
            assertEquals(org1Registrar1.page.innerText(assignmentCardPage.statusAdditionalAssignmentSigned), statusAdditionalAssignmentSigned)
            //TODO (Доделать проверку статуса после проверки контролером)
        }
    }
}
