package tests


import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//ИСПОЛНЕНИЕ ЖАЛОБ С ЗАСЛУШИВАНИЕМ

class ExecuteComplaintsWithHearing (val assert:Boolean = true){
    private val typesOfCreatedComplaints = mutableListOf<String>()
    private val regNumbersOfCreatedComplaints = mutableListOf<String>()

    @Test
    fun executeComplaintsWithHearing() {
        //Проходимся по списку всех типов жалоб, по каждому элементу создаем жалобу Регистратором и направляем ее в работу Исполнителю
        for (i in listOfComplaintTypes.indices) {
            SendToWorkByRegistrarToExecutor(false, listOfComplaintTypes[i]).sendToWorkTest()
            typesOfCreatedComplaints.add(listOfComplaintTypes[i])
            regNumbersOfCreatedComplaints.add(APPEAL_NUMBER)
        }

        //Переключаемся на Исполнителя
        switchOnUser(org1Executor1)

        //Проходимся по списку жалоб, полученных в работу, принимаем по всем жалобам решения, и отправляем их на согласование и подписание
        for (i in regNumbersOfCreatedComplaints.indices) {
            org1Executor1.page.openComplaint(inWork, regNumbersOfCreatedComplaints[i])

            //Нажимаем кнопку "Принять решение", указываем категорию и подкатегорию
            org1Executor1.page.click(appealCardPage.takeDecision_btn)
            org1Executor1.page.click(appealCardPage.selectCategory_dropdown)
            org1Executor1.page.click(appealCardPage.category)
            org1Executor1.page.click(appealCardPage.categorySection)
            org1Executor1.page.click(appealCardPage.subCategory_dropdown)
            org1Executor1.page.click(appealCardPage.subCategory)

            //Выбираем проведение заслушивания и указываем способы заслушивания
            org1Executor1.page.click(appealCardPage.hearingWays_input)
            org1Executor1.page.fill(appealCardPage.hearingWays_input, appealCardPage.hearingWaysDescription)

            //Прикрепляем предварительное решение
            org1Executor1.page.click(appealCardPage.attachPreDecision_btn)
            attachFileFromMac()
            org1Executor1.page.fill(appealCardPage.attachedFilename_input, appealCardPage.attachedFilename)

            //Отправляем извещение
            org1Executor1.page.click(appealCardPage.sendNotice_btn)
            org1Executor1.page.click(appealCardPage.sendNoticeConfirmation_btn)

            //Нажимаем кнопку "Заслушивание проведено"
            org1Executor1.page.click(appealCardPage.hearingHeld_btn)

            //Прикрепляем протокол заслушивания
            org1Executor1.page.click(appealCardPage.attachFile_btn)
            attachFileFromMac()

            //Отправляем извещение
            org1Executor1.page.waitForSelector(appealCardPage.sendNotice_btn)
            org1Executor1.page.click(appealCardPage.sendNotice_btn)

            //Нажимаем кнопку "Принять окончательное решение", выбираем решение и причину
            org1Executor1.page.click(appealCardPage.takeFinalDecision)
            org1Executor1.page.click(appealCardPage.decisionSelectForHearing_dropdown)

            //Проверяем корректно ли отображаются все типы решений, все типы причин и оснований для вынесения решения
            if (assert) {
                org1Executor1.page.click(appealCardPage.decisionType6)
                org1Executor1.page.click(appealCardPage.basisForDecisionSelect_dropdown)
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision1))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision2))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision3))

                org1Executor1.page.click(appealCardPage.decisionSelectForHearing_dropdown)
                org1Executor1.page.click(appealCardPage.decisionType7)
                assertTrue(!org1Executor1.page.isVisible(appealCardPage.reasonSelect_dropdown))
                assertTrue(!org1Executor1.page.isVisible(appealCardPage.basisForDecisionSelect_dropdown))

                org1Executor1.page.click(appealCardPage.decisionSelectForHearing_dropdown)
                org1Executor1.page.click(appealCardPage.decisionType8)
                org1Executor1.page.click(appealCardPage.basisForDecisionSelect_dropdown)
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision1))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision2))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision3))

                org1Executor1.page.click(appealCardPage.decisionSelectForHearing_dropdown)
                org1Executor1.page.click(appealCardPage.decisionType9)
                org1Executor1.page.click(appealCardPage.basisForDecisionSelect_dropdown)
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision1))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision2))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision3))

                org1Executor1.page.click(appealCardPage.decisionSelectForHearing_dropdown)
                org1Executor1.page.click(appealCardPage.decisionType10)
                org1Executor1.page.click(appealCardPage.basisForDecisionSelect_dropdown)
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision1))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision2))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.basisForDecision3))

                org1Executor1.page.click(appealCardPage.decisionSelectForHearing_dropdown)
                org1Executor1.page.click(appealCardPage.decisionType11)
                org1Executor1.page.click(appealCardPage.reasonSelect_dropdown)
                org1Executor1.page.waitForSelector(appealCardPage.reason10)
                org1Executor1.page.waitForSelector(appealCardPage.reason11)
                org1Executor1.page.waitForSelector(appealCardPage.reason13)
                assertTrue(org1Executor1.page.isVisible(appealCardPage.reason10))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.reason11))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.reason13))

                org1Executor1.page.click(appealCardPage.decisionSelectForHearing_dropdown)
                org1Executor1.page.click(appealCardPage.decisionType12)
                assertTrue(!org1Executor1.page.isVisible(appealCardPage.reasonSelect_dropdown))
                assertTrue(!org1Executor1.page.isVisible(appealCardPage.basisForDecisionSelect_dropdown))
            }

            //Вводим текст ответа, после чего сохраняем решение
            org1Executor1.page.click(appealCardPage.decisionSelectForHearing_dropdown)
            org1Executor1.page.click(appealCardPage.decisionType6)
            org1Executor1.page.click(appealCardPage.basisForDecisionSelect_dropdown)
            org1Executor1.page.click(appealCardPage.basisForDecision1)
            org1Executor1.page.click(appealCardPage.answerText_input)
            org1Executor1.page.fill(appealCardPage.answerText_input, appealCardPage.answerText)
            org1Executor1.page.click(appealCardPage.saveDecision_btn)

            //Нажимаем кнопку "Отправить на согласование", выбираем согласующих и подписанта и отправляем
            org1Executor1.page.click(appealCardPage.sendToApprove_btn)
            org1Executor1.page.click(appealCardPage.selectApprovers_dropdown)
            org1Executor1.page.click(appealCardPage.org1_Chief1)
            org1Executor1.page.click(appealCardPage.selectSigner_dropdown)
            org1Executor1.page.click(appealCardPage.org1_Chief1)
            org1Executor1.page.click(appealCardPage.sendToApproveAndSign_btn)
        }

        //Переключаемся на Подписанта
        switchOnUser(org1Chief1)

        //Проходимся по каждой полученной на согласование и подписание жалобе, согласовываем и подписываем ее
        for (i in regNumbersOfCreatedComplaints.indices) {
            org1Chief1.page.openComplaint(approve, regNumbersOfCreatedComplaints[i])
            org1Chief1.page.click(appealCardPage.approve_btn)
            org1Chief1.page.click(appealCardPage.approveConfirm_btn)
            org1Chief1.page.click(appealCardPage.signDecision_btn)
            org1Chief1.page.click(appealCardPage.signDecisionConfirm_btn)
            org1Chief1.page.click(appealCardPage.NUTS_btn)

            sign()
        }

        /*
        ПРОВЕРКА:
        Открываем вкладку "AUTOTESTORG1" -> "Завершенные".
        Открываем жалобу.
        Проверяем отображается ли статус "Исполнено" в статусах жалоб.
        */
        if (assert) {
            for (i in regNumbersOfCreatedComplaints.indices){
                org1Chief1.page.openComplaint(finished, regNumbersOfCreatedComplaints[i])
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealFinished), statusAppealFinished)
            }

            println("Test 3.4.1   passed (${typesOfCreatedComplaints[0]}, ЖТ-${regNumbersOfCreatedComplaints[0]})")
            for (i in 1 until typesOfCreatedComplaints.size) {
                println("                    (${typesOfCreatedComplaints[i]}, ЖТ-${regNumbersOfCreatedComplaints[i]})")
            }
        }
    }
}
