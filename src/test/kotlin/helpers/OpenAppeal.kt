package helpers

import com.microsoft.playwright.Page
import java.lang.Thread.sleep
import lists.*
import pages.*

/*
Открытие обращения.
При вызове метода, нужно указать реестр, откуда должно быть открыто обращение.
По умолчанию открывает тот номер обращения, который был присвоен полю "APPEAL_NUMBER" при создании обращения.
Если нужно открыть определенное обращение или несколько обращений поочереди, то нужно указать нужный номер обращения или список обращений с нужным индексом.
В методе описаны два поведения открытия, для оператора ЦОНа и для остальных юзеров.
При открытии остальными юзерами предусмотрено две опции:
- открытие из реестра "Зарегистрированы и ожидают маршрутизации"
- открытие из остальных реестров.
*/
fun Page.openAppeal(registry: String, appealNumber: String = APPEAL_NUMBER) {
    sleep(500)
    when (registry) {
        TSONAppealRegistry -> {
            this.openRegistry(registry)
            this.click(appealsSearchTSON_input)
            this.fill(appealsSearchTSON_input, appealNumber)
            this.keyboard().press(enter_btn)
            this.click(appealFoundInRegisteredTSON)
            this.removeTagPopup()
        }
        else -> {
            this.openRegistry(registry)
            this.click(appealSearch_input)
            this.fill(appealSearch_input, appealNumber)
            this.keyboard().press(enter_btn)
            when (registry) {
                registeredAndWaitingForRoute -> this.click(appealFoundInRegistered)
                else -> this.click(appealFoundInOtherRegistries)
            }
            this.removeTagPopup()
        }
    }
}

/*
То же самое, только для открытия обращений с дробью (нужно при проверке при частичной переадресации)
*/
fun Page.openAppealWithFraction(registry: String = registeredAndWaitingForRoute, appealNumber: String = APPEAL_NUMBER) {
    sleep(500)
    when (registry) {
        TSONAppealRegistry -> {
            this.openRegistry(registry)
            this.click(appealsSearchTSON_input)
            this.fill(appealsSearchTSON_input, appealNumber)
            this.keyboard().press(enter_btn)
            this.click(appealFoundInRegisteredTSON)
            this.removeTagPopup()
        }
        else -> {
            this.openRegistry(registry)
            this.click(appealSearch_input)
            this.fill(appealSearch_input, appealNumber)
            this.keyboard().press(enter_btn)
            this.click(appealFoundInRegisteredWithFraction)
            this.removeTagPopup()
        }
    }
}

/*
То же самое, только для открытия жалоб
*/
fun Page.openComplaint(registry: String, complaintNumber: String = COMPLAINT_NUMBER) {
    sleep(500)
    when (registry) {
        TSONAppealRegistry -> {
            this.openRegistry(registry)
            this.click(appealsSearchTSON_input)
            this.fill(appealsSearchTSON_input, complaintNumber)
            this.keyboard().press(enter_btn)
            this.click(appealFoundInRegisteredTSON)
            this.removeTagPopup()
        }
        else -> {
            this.openRegistry(registry)
            this.click(appealSearch_input)
            this.fill(appealSearch_input, complaintNumber)
            this.keyboard().press(enter_btn)
            when (registry) {
                registeredAndWaitingForRoute -> this.click(appealFoundInRegistered)
                else -> this.click(appealFoundInOtherRegistries)
            }
            this.removeTagPopup()
        }
    }
}

/*
То же самое, только для открытия жалоб с дробью
*/
fun Page.openComplaintWithFraction(registry: String, complaintNum: String = COMPLAINT_NUMBER) {
    sleep(500)
    when (registry) {
        TSONAppealRegistry -> {
            this.openRegistry(registry)
            this.click(appealsSearchTSON_input)
            this.fill(appealsSearchTSON_input, complaintNum)
            this.keyboard().press(enter_btn)
            this.waitForNavigation { this.click(registry) }
            this.removeTagPopup()
        }
        else -> {
            this.openRegistry(registry)
            this.click(appealSearch_input)
            this.fill(appealSearch_input, complaintNum)
            this.keyboard().press(enter_btn)
            when (registry) {
                registeredAndWaitingForRoute -> this.click(appealFoundInRegisteredWithFraction)
                else -> this.click(appealFoundInOtherRegistries)
            }
            this.removeTagPopup()
        }
    }
}

/*
Открытие реестра.
В методе описаны несколько вариантов открытия реестров:
- когда реестр находится в определенной вкладке (например "Входящие задачи" -> "Находятся в работе"), тогда открывается сначала вкладка, а потом реестр
- когда реестр находится в корне боковой панели (например "На исполнении"), тогда открывается сразу сам реестр
*/
fun Page.openRegistry (registry: String) {
    when(registry) {
        inWork, approve, sign, revokedByApplicant -> {
            this.click(mainPage.asideToggleFix_btn)
            this.click(incomingTasks_tab)
            this.click(registry)
            this.click(incomingTasks_tab)
            this.click(mainPage.asideToggleFix_btn)
        }
        allAppeals, inExecutorsWork, finished -> {
            this.click(mainPage.asideToggleFix_btn)
            this.click(AUTOTESTORG1_tab)
            this.click(registry)
            this.click(AUTOTESTORG1_tab)
            this.click(mainPage.asideToggleFix_btn)
        }
        allOutgoing -> {
            this.click(mainPage.asideToggleFix_btn)
            this.click(outgoingAssignments_tab)
            this.click(registry)
            this.click(outgoingAssignments_tab)
            this.click(mainPage.asideToggleFix_btn)
        }
        waitingForCheck -> {
            this.click(mainPage.asideToggleFix_btn)
            this.click(assignments_tab)
            this.click(registry)
            this.click(assignments_tab)
            this.click(mainPage.asideToggleFix_btn)
        }
        myTasks, waitingForRouting, onApprove -> {
            this.click(mainPage.asideToggleFix_btn)
            this.click(incomingAssignments_tab)
            this.click(registry)
            this.click(incomingAssignments_tab)
            this.click(mainPage.asideToggleFix_btn)
        }
        else -> {
            this.click(mainPage.asideToggleFix_btn)
            this.click(registry)
            this.click(mainPage.asideToggleFix_btn)
        }
    }
}

/*
Открытие поручения.
При вызове метода, нужно указать реестр, откуда должно быть открыто поручение.
По умолчанию открывает тот номер поручения, который был присвоен полю "ASSIGNMENT_NUMBER" при создании поручения.
Если нужно открыть определенное поручение или несколько поручений поочереди, то нужно указать нужный номер поручения или список поручений с нужным индексом.
*/
fun Page.openAssignment(registry: String, assignmentNumber: String = ASSIGNMENT_NUMBER) {
    sleep(500)
    this.openRegistry(registry)
    this.click(appealSearch_input)
    this.fill(appealSearch_input, assignmentNumber)
    this.keyboard().press(enter_btn)
    this.click(assignmentFoundInOtherRegistries)
}

//Убирает попап для указания тэгов, который появляется при первом открытии обращения
private fun Page.removeTagPopup () {
    sleep(500)
    if (this.isVisible(appealCardPage.cancelTag_button)) {
        this.click(appealCardPage.cancelTag_button)
    }
}
