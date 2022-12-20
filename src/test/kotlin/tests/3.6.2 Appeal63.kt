package tests

import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//Пометка обращения Исполнителем как несоответствующее 63й статье и приведение его в соответствие Регистратором

class Appeal63Registrar (private var assert: Boolean = true, private var appealType: String = listOfAppealTypes[0]) {
    private val typesOfCreatedAppeals = mutableListOf<String>()
    private val regNumbersOfCreatedAppeals = mutableListOf<String>()


    @Test
    fun appeal63RegistrarTest() {
        //Проходимся по списку обращений, по каждому элементу создаем обращение Регистратором и направляем его в работу Исполнителю
        for (i in listOfAppealTypes.indices) {
            SendToWorkByRegistrarToExecutor(false, listOfAppealTypes[i]).sendToWorkTest()
            typesOfCreatedAppeals.add(listOfAppealTypes[i])
            regNumbersOfCreatedAppeals.add(APPEAL_NUMBER)
        }

        //Переключаемся на Исполнителя
        switchOnUser(org1Executor1)

        for (i in regNumbersOfCreatedAppeals.indices) {
            //Открываем обращение
            org1Executor1.page.openAppeal(inWork, regNumbersOfCreatedAppeals[i])

            //Нажимаем кнопку "Не соответствует статье 63", выбираем причину и указываем срок (следующий рабочий день)
            org1Executor1.page.click(appealCardPage.appeal63_btn)
            org1Executor1.page.fill(appealCardPage.appeal63Reasons_input, appeal63Reason)
            org1Executor1.page.click(appealCardPage.appeal63Deadline_input)
            org1Executor1.page.locator(appealCardPage.appeal63Deadline_input).evaluate(appealCardPage.removeReadonly)
            org1Executor1.page.fill(appealCardPage.appeal63Deadline_input, Dates().getNextWorkingDateFromToday())
            org1Executor1.page.keyboard().press(enter_btn)
            org1Executor1.page.click(appealCardPage.sendNotice63_btn)
        }

        //Переключаемся на Регистратора и приводим в соответствие, дополняя обращения новыми данными
        switchOnUser(org1Registrar1)

        for (i in regNumbersOfCreatedAppeals.indices) {
            //Открываем обращение
            org1Registrar1.page.openAppeal(onExecution, regNumbersOfCreatedAppeals[i])

            //Нажимаем кнопку "Дополнить данные", заполняем новыми данными, отправляем и подписываем
            org1Registrar1.page.click(appealCardPage.addAdditionalData_btn)
            org1Registrar1.page.fill(appealCardPage.additionalData_input, aligned)
            org1Registrar1.page.click(appealCardPage.sendAppeal_btn)
            org1Registrar1.page.click(appealCardPage.NUTS_btn)

            sign()
        }

        /*
        ПРОВЕРКА:
        Переключаемся на Исполнителя.
        Открываем обращение.
        Убеждаемся что отображаются статус "Приведено в соответствие" и кнопка "Принять решение"
        */
        if (assert) {
            switchOnUser(org1Executor1)
            for (i in regNumbersOfCreatedAppeals.indices) {
                org1Executor1.page.openAppeal(inWork, regNumbersOfCreatedAppeals[i])
                assertEquals(org1Executor1.page.innerText(appealCardPage.statusAligned), statusAppealAligned)
                assertTrue(org1Executor1.page.isVisible("text=$aligned"))
                org1Executor1.page.scrollDown()
                assertTrue(org1Executor1.page.isVisible(appealCardPage.takeDecision_btn))
            }
            println("Test 3.6.2   passed (${typesOfCreatedAppeals[0]}, ЖТ-${regNumbersOfCreatedAppeals[0]})")
            for (i in 1 until typesOfCreatedAppeals.size) {
                println("                    (${typesOfCreatedAppeals[i]}, ЖТ-${regNumbersOfCreatedAppeals[i]})")

            }
        }
    }
}
