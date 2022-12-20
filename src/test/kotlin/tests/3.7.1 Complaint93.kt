package tests

import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//Пометка жалобы Исполнителем как несоответствующей 93й статье и приведение ее в соответствие Оператором ЦОНа

class Complaint93TSON (private var assert: Boolean = true, private var complaintType: String = listOfComplaintTypes[0]) {
    private val typesOfCreatedComplaints = mutableListOf<String>()
    private val regNumbersOfCreatedComplaints = mutableListOf<String>()

    @Test
    fun complaint93TSONTest() {
        //Проходимся по списку жалоб, по каждому элементу создаем жалобу Регистратором и направляем ее в работу Исполнителю
        for (i in listOfComplaintTypes.indices) {
            SendToWorkByRegistrarToExecutor(false, listOfComplaintTypes[i]).sendToWorkTest()
            typesOfCreatedComplaints.add(listOfComplaintTypes[i])
            regNumbersOfCreatedComplaints.add(APPEAL_NUMBER)
        }

        //Переключаемся на Исполнителя
        switchOnUser(org1Executor1)

        for (i in regNumbersOfCreatedComplaints.indices) {
            //Открываем жалобу
            org1Executor1.page.openComplaint(inWork, regNumbersOfCreatedComplaints[i])

            //Нажимаем кнопку "Не соответствует статье 93", выбираем причину и указываем срок
            org1Executor1.page.click(appealCardPage.complaint93)
            org1Executor1.page.fill(appealCardPage.complaint93Reasons_input, appeal93Reason)
            org1Executor1.page.click(appealCardPage.complaint93Deadline_input)
            org1Executor1.page.locator(appealCardPage.complaint93Deadline_input).evaluate(appealCardPage.removeReadonly)
            org1Executor1.page.fill(appealCardPage.complaint93Deadline_input, Dates().getNextWorkingDateFromToday())
            org1Executor1.page.keyboard().press(enter_btn)
            org1Executor1.page.click(appealCardPage.sendNotice93_btn)
        }

        //Переключаемся на Оператора ЦОНа
        switchOnUser(TSONOperator)

        for (i in regNumbersOfCreatedComplaints.indices) {
            //Открываем жалобу
            TSONOperator.page.openComplaint(TSONAppealRegistry, regNumbersOfCreatedComplaints[i])

            //Нажимаем кнопку "Дополнить данные", заполняем новыми данными, отправляем и подписываем
            TSONOperator.page.click(appealCardPage.addAdditionalData_btn)
            TSONOperator.page.fill(appealCardPage.additionalData_input, aligned)
            TSONOperator.page.click(appealCardPage.sendAppeal_btn)
            TSONOperator.page.click(appealCardPage.NUTS_btn)

            sign()
        }

        /*
        ПРОВЕРКА:
        Переключаемся на Исполнителя.
        Открываем жалобу.
        Убеждаемся что отображаются статус "Приведено в соответствие" и кнопка "Принять решение"
        */
        if (assert) {
            switchOnUser(org1Executor1)
            for (i in regNumbersOfCreatedComplaints.indices) {
                org1Executor1.page.openComplaint(inWork, regNumbersOfCreatedComplaints[i])
                assertEquals(org1Executor1.page.innerText(appealCardPage.statusAligned), statusAppealAligned)
                assertTrue(org1Executor1.page.isVisible("text=$aligned"))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.takeDecision_btn))
            }
            println("Test 3.7.1   passed (${typesOfCreatedComplaints[0]}, ЖТ-${regNumbersOfCreatedComplaints[0]})")
            for (i in 1 until typesOfCreatedComplaints.size) {
                println("                    (${typesOfCreatedComplaints[i]}, ЖТ-${regNumbersOfCreatedComplaints[i]})")

            }
        }
    }
}
