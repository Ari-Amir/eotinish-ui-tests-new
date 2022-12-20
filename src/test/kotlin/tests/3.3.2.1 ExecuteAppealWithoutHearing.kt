package tests


import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//ИСПОЛНЕНИЕ ОБРАЩЕНИЙ ПЕРВОЙ ГРУППЫ (ЗАПРОСЫ, СООБЩЕНИЕ, ОТКЛИК, ПРЕДЛОЖЕНИЕ) БЕЗ ЗАСЛУШИВАНИЯ

class ExecuteAppealsGroupOneWithoutHearing (private val assert:Boolean = true) {
    private val typesOfCreatedAppeals = mutableListOf<String>()
    private val regNumbersOfCreatedAppeals = mutableListOf<String>()

    @Test
    fun executeAppealsGroupOneWithoutHearing() {
        for (i in listOfAppealsGroup1.indices) {
            //Проходимся по списку обращений первой группы, по каждому элементу создаем обращение Регистратором и направляем его в работу Исполнителю
            SendToWorkByRegistrarToExecutor(false, listOfAppealsGroup1[i]).sendToWorkTest()
            typesOfCreatedAppeals.add(listOfAppealsGroup1[i])
            regNumbersOfCreatedAppeals.add(APPEAL_NUMBER)
        }

        //Переключаемся на Исполнителя
        switchOnUser(org1Executor1)

        //Проходимся по списку обращений, полученных в работу, принимаем по всем обращениям решения, и отправляем их на согласование и подписание
        for (i in regNumbersOfCreatedAppeals.indices) {
            org1Executor1.page.openAppeal(inWork, regNumbersOfCreatedAppeals[i])

            //Нажимаем кнопку "Принять решение", указываем категорию и подкатегорию
            org1Executor1.page.click(appealCardPage.takeDecision_btn)
            org1Executor1.page.click(appealCardPage.selectCategory_dropdown)
            org1Executor1.page.click(appealCardPage.category)
            org1Executor1.page.click(appealCardPage.categorySection)
            org1Executor1.page.click(appealCardPage.subCategory_dropdown)
            org1Executor1.page.click(appealCardPage.subCategory)

            //Выбираем что заслушивание не будет проводиться и указываем причину
            org1Executor1.page.click(appealCardPage.hearingHeld_dropdown)
            org1Executor1.page.click(appealCardPage.hearingHeldNo)
            org1Executor1.page.fill(appealCardPage.hearingNotHeldReason_input, appealCardPage.hearingNotHeldReason)
            org1Executor1.page.click(appealCardPage.decisionSelectForNotHearing_dropdown)


            //Проверяем корректно ли отображаются все типы решений и все типы причин и характеров
            if (assert) {
                org1Executor1.page.scrollDown()
                org1Executor1.page.click(appealCardPage.decisionType1)
                assertTrue(!org1Executor1.page.isVisible(appealCardPage.reasonSelect_dropdown))
                assertTrue(!org1Executor1.page.isVisible(appealCardPage.characterSelect_dropdown))

                org1Executor1.page.click(appealCardPage.decisionSelectForNotHearing_dropdown)
                org1Executor1.page.click(appealCardPage.decisionType2)
                org1Executor1.page.click(appealCardPage.reasonSelect_dropdown)
                org1Executor1.page.waitForSelector(appealCardPage.reasonType1)
                org1Executor1.page.waitForSelector(appealCardPage.reasonType2)
                org1Executor1.page.waitForSelector(appealCardPage.reasonType3)
                assertTrue(org1Executor1.page.isVisible(appealCardPage.reasonType1))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.reasonType2))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.reasonType3))

                org1Executor1.page.click(appealCardPage.decisionSelectForNotHearing_dropdown)
                org1Executor1.page.click(appealCardPage.decisionType3)
                org1Executor1.page.click(appealCardPage.characterSelect_dropdown)
                assertTrue(org1Executor1.page.isVisible(appealCardPage.answerCharacter1))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.answerCharacter2))
                assertTrue(org1Executor1.page.isVisible(appealCardPage.answerCharacter3))
            }

            //Вводим текст ответа, после чего сохраняем решение
            org1Executor1.page.click(appealCardPage.decisionSelectForNotHearing_dropdown)
            org1Executor1.page.click(appealCardPage.decisionType2)
            org1Executor1.page.click(appealCardPage.reasonSelect_dropdown)
            org1Executor1.page.click(appealCardPage.reasonType1)
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

        //Проходимся по каждому полученному на согласование и подписание обращению и согласовываем и подписываем
        for (i in regNumbersOfCreatedAppeals.indices) {
            org1Chief1.page.openAppeal(approve, regNumbersOfCreatedAppeals[i])
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
    Открываем обращение.
    Проверяем отображается ли статус "Исполнено" в статусах обращения.
    */
        if (assert) {
            for (i in regNumbersOfCreatedAppeals.indices){
                org1Chief1.page.openAppeal(finished, regNumbersOfCreatedAppeals[i])
                assertEquals(org1Chief1.page.innerText(appealCardPage.statusAppealFinished), statusAppealFinished)
            }

            println("Test 3.3.2.1 passed (${typesOfCreatedAppeals[0]}, ЖТ-${regNumbersOfCreatedAppeals[0]})")
            for (i in 1 until typesOfCreatedAppeals.size) {
                println("                    (${typesOfCreatedAppeals[i]}, ЖТ-${regNumbersOfCreatedAppeals[i]})")
            }
        }
    }
}
