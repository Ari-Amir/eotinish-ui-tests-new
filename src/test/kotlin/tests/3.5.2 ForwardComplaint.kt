package tests

import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//ПЕРЕАДРЕСАЦИЯ ЖАЛОБ (ПОЛНАЯ И ЧАСТИЧНАЯ)

class ForwardComplaint (private var assert: Boolean = true, private var complaintType: String = listOfComplaintTypes[0]) {
    private val typesOfCreatedComplaints = mutableListOf<String>()
    private val regNumbersOfCreatedComplaints = mutableListOf<String>()


    @Test
    fun forwardComplaintTest() {
        //Проходимся по списку жалоб, по каждому элементу создаем жалобу Регистратором и направляем ее в работу Руководителю
        for (i in listOfComplaintTypes.indices) {
            SendToWorkByRegistrarToChief(false, listOfComplaintTypes[i]).sendToWorkTest()
            typesOfCreatedComplaints.add(listOfComplaintTypes[i])
            regNumbersOfCreatedComplaints.add(APPEAL_NUMBER)
        }

        //Переключаемся на Руководителя
        switchOnUser(org1Chief1)

        //Проходимся по списку жалоб, полученных в работу, подготавливаем к переадресации и отправляем их на согласование и подписание
        for (i in regNumbersOfCreatedComplaints.indices) {
            //Открываем жалобу
            org1Chief1.page.openComplaint(inWork, regNumbersOfCreatedComplaints[i])

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

            //Проверяем статусы согласования и подписания переадресации, а также срок исполнения в карточке жалобы
            if (assert) {
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwarding), statusAppealForwarding)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingApproved), statusAppealForwardingApproved)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingSigned), statusAppealForwardingSigned)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardedPartly), statusAppealForwardedPartly)
                assertEquals(org1Chief1.page.innerText(appealCardPage.deadlineOnExecitorCard), Dates().calculateAppealDeadline(typesOfCreatedComplaints[i]))
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

            //Проверяем статусы согласования и подписания переадресации, а также срок исполнения в карточке Жалобы
            if (assert) {
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwarding), statusAppealForwarding)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingApproved), statusAppealForwardingApproved)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardingSigned), statusAppealForwardingSigned)
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealForwardedFully), statusAppealForwardedFully)
                assertEquals(org1Chief1.page.innerText(appealCardPage.deadlineOnExecitorCard), Dates().calculateAppealDeadline(typesOfCreatedComplaints[i]))
            }
        }

        /*
          ПРОВЕРКА:
          Переключаемся на Регистратора АДРЕСАТА.
          Открываем жалобу переадресованную полностью.
          Проверяем дедлайн в карточке жалобы.

          Открываем жалобу переадресованную частично.
          Проверяем дедлайн в карточке жалобы.
          */
        if (assert) {
            switchOnUser(org2Registrar1)
            for (i in regNumbersOfCreatedComplaints.indices) {
                org2Registrar1.page.openComplaint(registeredAndWaitingForRoute, regNumbersOfCreatedComplaints[i])
                assertEquals(org2Registrar1.page.innerText(appealCardPage.deadline2), Dates().calculateAppealDeadline(typesOfCreatedComplaints[i]))

                org2Registrar1.page.openComplaintWithFraction(registeredAndWaitingForRoute, regNumbersOfCreatedComplaints[i])
                assertEquals(org2Registrar1.page.innerText(appealCardPage.deadline2), Dates().calculateAppealDeadline(typesOfCreatedComplaints[i]))
            }
            println("Test 3.5.2   passed (${typesOfCreatedComplaints[0]}, ЖТ-${regNumbersOfCreatedComplaints[0]}, ЖТ-${regNumbersOfCreatedComplaints[0]}/1)")
            for (i in 1 until typesOfCreatedComplaints.size) {
                println("                    (${typesOfCreatedComplaints[i]}, ЖТ-${regNumbersOfCreatedComplaints[i]}, ЖТ-${regNumbersOfCreatedComplaints[i]}/1)")
            }
        }
    }
}
