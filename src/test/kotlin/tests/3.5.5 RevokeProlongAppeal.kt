package tests

import helpers.*
import lists.*
import org.testng.annotations.Test
import pages.appealCardPage
import kotlin.test.assertEquals

//ОТЗЫВ ПРОДЛЕНИЯ СРОКА РАССМОТРЕНИЯ

class RevokeProlongAppeal (private var assert: Boolean = true, private var appealType: String = listOfAppealTypes[0]) {
    private val typesOfCreatedAppeals = mutableListOf<String>()
    private val regNumbersOfCreatedAppeals = mutableListOf<String>()

    @Test
    fun revokeProlongAppealTest() {
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

            //Продлеваем срок обращения и отзываем продление
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

            org1Chief1.page.click(appealCardPage.revokeDeadlinеProlong_btn)
            org1Chief1.page.click(appealCardPage.send_btn)

            if (assert) {
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusStartProlong), statusStartProlong)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusRevokeProlong), statusRevokeProlong)

            }
        }

        if (assert) {
            println("Test 3.5.5   passed (${typesOfCreatedAppeals[0]}, ЖТ-${regNumbersOfCreatedAppeals[0]})")
            for (i in 1 until typesOfCreatedAppeals.size) {
                println("                    (${typesOfCreatedAppeals[i]}, ЖТ-${regNumbersOfCreatedAppeals[i]})")
            }
        }
    }
}
