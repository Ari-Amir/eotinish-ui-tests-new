package tests

import helpers.*
import lists.*
import org.testng.annotations.Test
import pages.appealCardPage
import kotlin.test.assertEquals

//ПРОДЛЕНИЕ СРОКА РАССМОТРЕНИЯ

class ProlongAppeal (private var assert: Boolean = true, private var appealType: String = listOfAppealTypes[0]) {
    private val typesOfCreatedAppeals = mutableListOf<String>()
    private val regNumbersOfCreatedAppeals = mutableListOf<String>()

    @Test
    fun prolongAppealTest() {
        //Проходимся по списку обращений, по каждому элементу создаем обращение Регистратором и направляем его в работу Исполнителю:
        for (i in listOfAppealTypes.indices) {
            SendToWorkByRegistrarToChief(false, listOfAppealTypes[i]).sendToWorkTest()
            typesOfCreatedAppeals.add(listOfAppealTypes[i])
            regNumbersOfCreatedAppeals.add(APPEAL_NUMBER)
        }

        //Переключаемся на Исполнителя
        switchOnUser(org1Chief1)

        for (i in regNumbersOfCreatedAppeals.indices) {
            //Открываем обращение
            org1Chief1.page.openAppeal(inWork, regNumbersOfCreatedAppeals[i])


            //Продлеваем срок обращения и подписываем продление
            org1Chief1.page.click(appealCardPage.prolongDeadline_btn)
            org1Chief1.page.locator(appealCardPage.dateInput).evaluate(appealCardPage.removeReadonly)
            org1Chief1.page.fill(
                appealCardPage.dateInput,
                Dates().getNextWorkingDateFromDeadline(typesOfCreatedAppeals[i])
            )
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

            sign()

            if (assert) {
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusStartProlong), statusStartProlong)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusApproveProlong), statusApproveProlong)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusSignProlong), statusSignProlong)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusFinishedProlong), statusFinishedProlong)

                //TODO сделать проверку на измененную дату


            }
        }

        if (assert) {
            println("Test 3.5.4   passed (${typesOfCreatedAppeals[0]}, ЖТ-${regNumbersOfCreatedAppeals[0]})")
            for (i in 1 until typesOfCreatedAppeals.size) {
                println("                    (${typesOfCreatedAppeals[i]}, ЖТ-${regNumbersOfCreatedAppeals[i]})")
            }
        }
    }
}
