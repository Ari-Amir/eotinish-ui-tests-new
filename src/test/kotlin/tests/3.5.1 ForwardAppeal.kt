package tests


import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//ПЕРЕАДРЕСАЦИЯ ОБРАЩЕНИЙ (ПОЛНАЯ И ЧАСТИЧНАЯ)

class ForwardAppeal (private var assert: Boolean = true, private var appealType: String = listOfAppealTypes[0]) {
    private val typesOfCreatedAppeals = mutableListOf<String>()
    private val regNumbersOfCreatedAppeals = mutableListOf<String>()

    @Test
    fun forwardAppealTest() {
        //Проходимся по списку обращений, по каждому элементу создаем обращение Регистратором и направляем его в работу Руководителю
        for (i in listOfAppealTypes.indices) {
            SendToWorkByRegistrarToChief(false, listOfAppealTypes[i]).sendToWorkTest()
            typesOfCreatedAppeals.add(listOfAppealTypes[i])
            regNumbersOfCreatedAppeals.add(APPEAL_NUMBER)
        }

        //Переключаемся на Руководителя
        switchOnUser(org1Chief1)

        //Проходимся по списку обращений, полученных в работу, подготавливаем к переадресации и отправляем их на согласование и подписание
        for (i in regNumbersOfCreatedAppeals.indices) {
            //Открываем обращение
            org1Chief1.page.openComplaint(inWork, regNumbersOfCreatedAppeals[i])

            //Нажимаем кнопку "Переадресация в другой ГО", выбираем ГО для переадресации, указываем согласующего и подписанта, ставим галочку "Переадресовать в части"
            org1Chief1.page.click(appealCardPage.forward_btn)
            org1Chief1.page.click(appealCardPage.region_dropdown)
            org1Chief1.page.click(appealCardPage.country)
            org1Chief1.page.click(appealCardPage.adresat_dropdown)
            org1Chief1.page.click(appealCardPage.org2)
            org1Chief1.page.click(appealCardPage.approvers_dropdown)
            org1Chief1.page.click(appealCardPage.approver)
            org1Chief1.page.click(appealCardPage.appointMyself_text)
            org1Chief1.page.click(appealCardPage.forwardPartly_checkbox)
            org1Chief1.page.click(appealCardPage.send_btn)

            //Согласовываем и подписываем переадресацию
            org1Chief1.page.click(appealCardPage.approveForwarding_btn)
            org1Chief1.page.click(appealCardPage.approveForwarding_btn_popup)
            org1Chief1.page.click(appealCardPage.signForwarding_btn)
            org1Chief1.page.click(appealCardPage.sign_btn)
            org1Chief1.page.click(appealCardPage.NUTS_btn)

            sign()

            //Проверяем статусы согласования и подписания переадресации, а также срок исполнения в карточке обращения
            if (assert) {
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwarding), statusAppealForwarding)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingApproved), statusAppealForwardingApproved)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingSigned), statusAppealForwardingSigned)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardedPartly), statusAppealForwardedPartly)
                assertEquals(org1Chief1.page.innerText(appealCardPage.deadlineOnExecitorCard), Dates().calculateAppealDeadline(typesOfCreatedAppeals[i]))
            }

            //Нажимаем кнопку "Переадресация в другой ГО", выбираем ГО для переадресации, указываем согласующего и подписанта, ставим галочку "Переадресовать полностью"
            org1Chief1.page.click(appealCardPage.forward_btn)
            org1Chief1.page.click(appealCardPage.region_dropdown)
            org1Chief1.page.click(appealCardPage.country)
            org1Chief1.page.click(appealCardPage.adresat_dropdown)
            org1Chief1.page.click(appealCardPage.org2)
            org1Chief1.page.click(appealCardPage.approvers_dropdown)
            org1Chief1.page.click(appealCardPage.approver)
            org1Chief1.page.click(appealCardPage.appointMyself_text)
            org1Chief1.page.click(appealCardPage.forwardFully_checkbox)
            org1Chief1.page.click(appealCardPage.send_btn)

            //Согласовываем и подписываем переадресацию
            org1Chief1.page.click(appealCardPage.approveForwarding_btn)
            org1Chief1.page.click(appealCardPage.approveForwarding_btn_popup)
            org1Chief1.page.click(appealCardPage.signForwarding_btn)
            org1Chief1.page.click(appealCardPage.sign_btn)
            org1Chief1.page.click(appealCardPage.NUTS_btn)

            sign()

            //Проверяем статусы согласования и подписания переадресации, а также срок исполнения в карточке обращения
            if (assert) { assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwarding), statusAppealForwarding)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingApproved), statusAppealForwardingApproved)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingSigned), statusAppealForwardingSigned)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardedFully), statusAppealForwardedFully)
                assertEquals(org1Chief1.page.innerText(appealCardPage.deadlineOnExecitorCard), Dates().calculateAppealDeadline(typesOfCreatedAppeals[i]))
            }
        }

        /*
           ПРОВЕРКА:
           Переключаемся на Регистратора АДРЕСАТА.
           Открываем обращение переадресованное полностью.
           Проверяем дедлайн в карточке обращения.

           Открываем обращение переадресованное частично (с дробью).
           Проверяем дедлайн в карточке обращения.
           */
        if (assert) {
            switchOnUser(org2Registrar1)
            for (i in regNumbersOfCreatedAppeals.indices) {
                org2Registrar1.page.openAppeal(registeredAndWaitingForRoute, regNumbersOfCreatedAppeals[i])
                assertEquals(org2Registrar1.page.innerText(appealCardPage.deadline2), Dates().calculateAppealDeadline(typesOfCreatedAppeals[i]))

                org2Registrar1.page.openAppealWithFraction(registeredAndWaitingForRoute, regNumbersOfCreatedAppeals[i])
                assertEquals(org2Registrar1.page.innerText(appealCardPage.deadline2), Dates().calculateAppealDeadline(typesOfCreatedAppeals[i]))
            }
            println("Test 3.5.1   passed (${typesOfCreatedAppeals[0]}, ЖТ-${regNumbersOfCreatedAppeals[0]}, ЖТ-${regNumbersOfCreatedAppeals[0]}/1)")
            for (i in 1 until typesOfCreatedAppeals.size) {
                println("                    (${typesOfCreatedAppeals[i]}, ЖТ-${regNumbersOfCreatedAppeals[i]}, ЖТ-${regNumbersOfCreatedAppeals[i]}/1)")
            }
        }
    }
}
