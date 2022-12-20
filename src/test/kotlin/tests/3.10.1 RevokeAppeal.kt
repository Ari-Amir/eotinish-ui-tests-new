package tests

import org.testng.annotations.Test
import kotlin.test.*
import lists.*
import helpers.*
import pages.*

//ОТЗЫВ ОБРАЩЕНИЯ РЕГИСТРАТОРОМ

class RevokeAppealByRegistrar (
    private var assert:Boolean = true,
    private var appealType: String = listOfAppealTypes[2],
) {

    @Test
    fun revokeAppealByRegistrarTest() {
        //Создаем обращение Регистратором и открываем его
        switchOnUser(org1Registrar1)
        APPEAL_NUMBER = createAppealInDB(appealType)
        org1Registrar1.page.openAppeal(registeredAndWaitingForRoute, APPEAL_NUMBER)

        //Нажимаем кнопку "Отозвать", указываем комментарии и прикрепляем файл и подписываем отзыв
        org1Registrar1.page.click(appealCardPage.revokeAppeal_btn)
        org1Registrar1.page.click(appealCardPage.revokeComment_input)
        org1Registrar1.page.fill(appealCardPage.revokeComment_input, revokeComment)
        org1Registrar1.page.click(appealCardPage.attachRevokeDocs_btn)
        attachFile()
        org1Registrar1.page.click(appealCardPage.createRevoke_btn)
        org1Registrar1.page.click(appealCardPage.NUTS_btn)
        sign()

        /*
        ПРОВЕРКА:
        В статусах обращения должен отображаться статус "Отозвано"
        */
        if (assert) {
            assertEquals(org1Registrar1.page.innerText(appealCardPage.statusRevokedByRegistrar), statusAppealRevoked)
            println("Test 3.10.1  passed ($appealType ЖТ-$APPEAL_NUMBER)")
        }
    }
}
