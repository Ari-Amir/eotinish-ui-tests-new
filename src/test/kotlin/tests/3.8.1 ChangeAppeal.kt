package tests

import org.testng.annotations.Test
import kotlin.test.*
import helpers.*
import lists.*
import pages.*

//РЕДАКТИРОВАНИЕ ОБРАЩЕНИЯ РЕГИСТРАТОРОМ

class ChangeAppealByRegistrar (private var assert: Boolean = true) {
    @Test
    fun changeAppealByRegistrarTest() {
        //Создаем обращение Регистратором и открываем его
        switchOnUser(org1Registrar1)
        APPEAL_NUMBER = createAppealInDB(ArrayList(listOfAppealAndComplaintDeadlines.keys)[0])
        org1Registrar1.page.openAppeal(registeredAndWaitingForRoute)

        //ИЗМЕНЕНИЕ ДАННЫХ, КОТОРЫЕ НЕ ТРЕБУЮТ ПОДПИСАНИЯ (ВИД ОБРАЩЕНИЯ)
        //Нажимаем на редактирование обращения, меняем вид обращения, сохраняемся и после каждого сохранения проверяем дедлайн, и так по всем обращениям и жалобам
        for (i in listOfAppealAndComplaintDeadlines) {
            org1Registrar1.page.click(appealCardPage.editAppeal_btn)
            org1Registrar1.page.click(appealCardPage.ok)
            org1Registrar1.page.click(changeAppealPage.appealType_dropdown)
            org1Registrar1.page.click("text=${i.key}")
            org1Registrar1.page.click(changeAppealPage.saveChanges_btn)
            assertEquals(org1Registrar1.page.innerText(appealCardPage.deadline2), Dates().calculateAppealDeadline(i.key))
        }

        //ИЗМЕНЕНИЕ ДАННЫХ, КОТОРЫЕ НЕ ТРЕБУЮТ ПОДПИСАНИЯ (ФОРМА ПОДАЧИ, ЯЗЫК, КАТЕГОРИЯ/ПОДКАТЕГОРИЯ ОБРАЩЕНИЯ)
        //Нажимаем на редактирование обращения, меняем форму подачи, язык и категорию/подкатегорию
        org1Registrar1.page.click(appealCardPage.editAppeal_btn)
        org1Registrar1.page.click(appealCardPage.ok)
        org1Registrar1.page.click(changeAppealPage.appealForm_dropdown)
        org1Registrar1.page.click(electronic)
        org1Registrar1.page.click(changeAppealPage.appealLanguage_dropdown)
        org1Registrar1.page.click(changeAppealPage.appealLanguage)
        org1Registrar1.page.click(changeAppealPage.appealCategoryForRegistrar_dropdown)
        org1Registrar1.page.click(changeAppealPage.appealCategoryForRegistrar)
        org1Registrar1.page.click(changeAppealPage.appealSubCategoryForRegistrar)
        org1Registrar1.page.click(changeAppealPage.saveChanges_btn)
        org1Registrar1.page.click(appealCardPage.editAppeal_btn)
        org1Registrar1.page.click(appealCardPage.ok)

        //ИЗМЕНЕНИЕ ДАННЫХ, КОТОРЫЕ ТРЕБУЮТ ПОДПИСАНИЯ (СУТЬ ВОПРОСА, ИИН И АДРЕС ЗАЯВИТЕЛЯ)
        //Нажимаем на редактирование обращения, меняем суть вопроса, ИИН и адрес заявителя
        org1Registrar1.page.click(changeAppealPage.desciption_textarea)
        org1Registrar1.page.fill(changeAppealPage.desciption_textarea, appealDescriptionChanged)
        org1Registrar1.page.click(changeAppealPage.IIN_input)
        org1Registrar1.page.fill(changeAppealPage.IIN_input, applicantsIINChanged)
        org1Registrar1.page.click(changeAppealPage.address)
        org1Registrar1.page.fill(changeAppealPage.address, applicantsAddressChanged)
        org1Registrar1.page.click(changeAppealPage.saveChanges_btn)
        org1Registrar1.page.click(appealCardPage.ok)
        org1Registrar1.page.click(appealCardPage.NUTS_btn)

        //Подписываем обращение
        sign()

        /*
//        ПРОВЕРКА:
//        Переключаемся на Исполнителя.
//        Открываем жалобу.
//        Убеждаемся что отображаются статус "Приведено в соответствие" и кнопка "Принять решение"
        */

        if (assert) {
            println("Test 3.8.1   passed (Сообщение, ЖТ-$APPEAL_NUMBER)")
        }
    }
}
