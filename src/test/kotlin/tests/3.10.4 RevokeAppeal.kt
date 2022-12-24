package tests

import org.testng.annotations.Test
import kotlin.test.*
import lists.*
import helpers.*
import pages.*

//ПРЕКРАЩЕНИЕ РАССМОТРЕНИЯ ОБРАЩЕНИЯ ИСПОЛНИТЕЛЕМ ПРИ ПОСТУПЛЕНИИ ОТЗЫВА ОТ РЕГИСТРАТОРА

class CancelAppealExecutionAfterRevoke (
    private var assert:Boolean = true,
    private var appealType: String = listOfAppealTypes[2],
) {
    @Test
    fun cancelAppealExecutionAfterRevokeTest() {
        //Направляем обращение Регистратором в работу Исполнителю
        SendToWorkByRegistrarToExecutor(false, appealType).sendToWorkTest()

        //Нажимаем кнопку "Отозвать", указываем комментарии и прикрепляем файл и подписываем отзыв
        org1Registrar1.page.click(appealCardPage.revokeAppeal_btn)
        org1Registrar1.page.click(appealCardPage.revokeComment_input)
        org1Registrar1.page.fill(appealCardPage.revokeComment_input, revokeComment)
        org1Registrar1.page.click(appealCardPage.attachRevokeDocs_btn)
        attachFileFromMac()
        org1Registrar1.page.click(appealCardPage.createRevoke_btn)
        org1Registrar1.page.click(appealCardPage.NUTS_btn)
        sign()

        //Переключаемся на Исполнителя
        switchOnUser(org1Executor1)

        //Открываем обращение
        org1Executor1.page.openAppeal(revokedByApplicant)

        //Нажимаем кнопку "Принять решение"
        org1Executor1.page.click(appealCardPage.takeDecision_btn)

        //Выбираем что заслушивание не будет проводиться, указываем решение и причину
        org1Executor1.page.click(appealCardPage.hearingHeld_dropdown)
        org1Executor1.page.click(appealCardPage.hearingHeldNo)
        org1Executor1.page.fill(appealCardPage.hearingNotHeldReason_input, appealCardPage.hearingNotHeldReason)
        org1Executor1.page.click(appealCardPage.decisionSelectForNotHearing_dropdown)
        org1Executor1.page.click(appealCardPage.decisionType2)
        org1Executor1.page.click(appealCardPage.reasonSelect_dropdown)
        org1Executor1.page.click(appealCardPage.reasonType4)

        //Вводим текст ответа, после чего сохраняем решение
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

        //Переключаемся на Руководителя
        switchOnUser(org1Chief1)

        //Открываем обращение, согласовываем и подписываем
        org1Chief1.page.openAppeal(approve)
        org1Chief1.page.click(appealCardPage.approve_btn)
        org1Chief1.page.click(appealCardPage.approveConfirm_btn)
        org1Chief1.page.click(appealCardPage.signDecision_btn)
        org1Chief1.page.click(appealCardPage.signDecisionConfirm_btn)
        org1Chief1.page.click(appealCardPage.NUTS_btn)

        sign()

        /*
        ПРОВЕРКА:
        В статусах обращения должен отображаться статус "Отозвано"
        */
        if (assert) {
            assertEquals(org1Chief1.page.innerText(appealCardPage.statusRevokedByExecutor), statusAppealRevoked)
            println("Test 3.10.2  passed ($appealType ЖТ-$APPEAL_NUMBER)")
        }
    }
}
