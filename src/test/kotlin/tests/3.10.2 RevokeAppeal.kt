package tests

import org.testng.annotations.Test
import kotlin.test.*
import lists.*
import helpers.*
import pages.*

//ОТЗЫВ ОБРАЩЕНИЯ ОПЕРАТОРОМ ЦОНА

class RevokeAppealByTSONOperator (
    private var assert:Boolean = true,
    private var appealType: String = listOfAppealTypes[2],
) {
    @Test
    fun revokeAppealByTSONOperatorTest() {
        //Создаем обращение Регистратором и открываеем его на Оператора ЦОНа
        switchOnUser(TSONOperator)
        APPEAL_NUMBER = createAppealInDB(appealType)
        TSONOperator.page.openAppeal(TSONAppealRegistry)

        //Нажимаем кнопку "Отозвать", указываем комментарии и прикрепляем файл и подписываем отзыв
        TSONOperator.page.click(appealCardPage.revokeAppeal_btn)
        TSONOperator.page.click(appealCardPage.revokeComment_input)
        TSONOperator.page.fill(appealCardPage.revokeComment_input, revokeComment)
        TSONOperator.page.click(appealCardPage.attachRevokeDocs_btn)
        attachFileFromMac()
        TSONOperator.page.click(appealCardPage.createRevoke_btn)
        TSONOperator.page.click(appealCardPage.NUTS_btn)
        sign()

        /*
        ПРОВЕРКА:
        В статусах обращения должен отображаться статус "Отозвано"
        */
        if (assert) {
            assertEquals(TSONOperator.page.innerText(appealCardPage.statusRevokeByTSONOperator), statusAppealRevoked)
            println("Test 3.10.4  passed ($appealType ЖТ-$APPEAL_NUMBER)")
        }
    }
}

