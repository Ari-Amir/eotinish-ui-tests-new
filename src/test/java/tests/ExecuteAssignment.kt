package tests

import configs.page
import configs.screen
import helpers.Dates
import lists.AZRK
import lists.Minfin
import org.testng.annotations.Test
import pages.AllIncomingAssignmentsPage
import pages.AsideToggle
import pages.AssignmentCardPage
import java.lang.Thread.sleep
import kotlin.test.assertEquals
import kotlin.test.assertFalse

var assignmentInnerDeadlineForExecutor1 = ""
var assignmentInnerDeadlineForExecutor2 = ""


class ExecuteAssignment(private var assert: Boolean = true) {
    private val asideToggle = AsideToggle()
    private val allIncomingAssignmentsPage = AllIncomingAssignmentsPage()
    private val assignmentCardPage = AssignmentCardPage()

    @Test
    fun executeAssignmentTest() {
        CreateAssignment(assert = false).createAssignmentTest()
        Logout(assert = false).logoutTest()
        Login(AZRK().IIN, AZRK().password, assert = false).loginTest()

        page.click(asideToggle.asideToggleFix_btn)
        page.click(asideToggle.incomingAssignments)
        page.click(asideToggle.allIncomingAssignments)
        page.click(asideToggle.asideToggleFix_btn)

        page.click(allIncomingAssignmentsPage.firstAssignmentInList)

        page.click(assignmentCardPage.sendToWork_btn)
        page.click(assignmentCardPage.responsibleSpecialist_dropdown)
        page.click(assignmentCardPage.responsibleSpecialistAZRK)
        assignmentInnerDeadlineForExecutor1 = page.inputValue(assignmentCardPage.assignmentInnerDeadline_input)
        page.click(assignmentCardPage.assign_btn)

        page.click(assignmentCardPage.answerToAssignment_btn)
        page.click(assignmentCardPage.answerToAssignment_rbtn)
        page.fill(assignmentCardPage.answerText_input, assignmentCardPage.answerAZRK)
        page.click(assignmentCardPage.attachFile_btn)

        screen.click()
        screen.keyDown("t")
        screen.keyUp("t")
        sleep(800)
        screen.type("\n")

        page.fill(assignmentCardPage.fileName_input, assignmentCardPage.fileNameAZRK)
        page.click(assignmentCardPage.send_btn)

        page.click(assignmentCardPage.sendToApprove_btn)
        page.click(assignmentCardPage.approvers_dropdown)
        page.click(assignmentCardPage.approverAZRK)
        page.click(assignmentCardPage.signers_dropdown)
        page.click(assignmentCardPage.signerAZRK)
        page.click(assignmentCardPage.sendtToApproveAndSign_btn)

        page.click(assignmentCardPage.assignmentApprove_btn)
        page.click(assignmentCardPage.approve_btn_popup)
        page.click(assignmentCardPage.sign_btn)
        page.click(assignmentCardPage.NUTS_btn)

        sign()

        if (assert) {
            assertFalse(page.isVisible(assignmentCardPage.innerDeadline))
        }


        Logout(assert = false).logoutTest()
        Login(Minfin().IIN, Minfin().password, assert = false).loginTest()

        page.click(asideToggle.asideToggleFix_btn)
        page.click(asideToggle.incomingAssignments)
        page.click(asideToggle.allIncomingAssignments)
        page.click(asideToggle.asideToggleFix_btn)

        page.click(allIncomingAssignmentsPage.firstAssignmentInList)

        page.click(assignmentCardPage.sendToWork_btn)
        page.click(assignmentCardPage.responsibleSpecialist_dropdown)
        page.click(assignmentCardPage.responsibleSpecialistMinfin)
        page.click(assignmentCardPage.assignmentInnerDeadline_input)
        page.click(assignmentCardPage.assignmentInnerDeadlineChangeMonth_btn)
        page.click(assignmentCardPage.assignmentInnerDeadlineDate_btn)
        assignmentInnerDeadlineForExecutor2 = page.inputValue(assignmentCardPage.assignmentInnerDeadline_input)
        page.click(assignmentCardPage.assign_btn)

        page.click(assignmentCardPage.answerToAssignment_btn)
        page.click(assignmentCardPage.requestToProlong_rbtn)
        page.fill(assignmentCardPage.answerText_input, assignmentCardPage.answerMinfin)
        page.click(assignmentCardPage.attachFile_btn)

        screen.click()
        screen.keyDown("t")
        screen.keyUp("t")
        sleep(800)

        screen.type("\n")
        page.fill(assignmentCardPage.fileName_input, assignmentCardPage.fileNameMinfin)
        page.click(assignmentCardPage.send_btn)

        page.click(assignmentCardPage.sendToApprove_btn)
        page.click(assignmentCardPage.approvers_dropdown)
        page.click(assignmentCardPage.approverMinfin)
        page.click(assignmentCardPage.signers_dropdown)
        page.click(assignmentCardPage.signerMinfin)
        page.click(assignmentCardPage.sendtToApproveAndSign_btn)

        page.click(assignmentCardPage.assignmentApprove_btn)
        page.click(assignmentCardPage.approve_btn_popup)
        page.click(assignmentCardPage.sign_btn)
        page.click(assignmentCardPage.NUTS_btn)

        sign()

        if (assert) {
            assertEquals(Dates().dateFormat(page.innerText(assignmentCardPage.innerDeadline)), assignmentInnerDeadlineForExecutor2)
        }
    }
}