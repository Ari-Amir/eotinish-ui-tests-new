package tests


import configs.*
import helpers.Dates
import lists.*
import org.testng.annotations.Test
import pages.*
import java.lang.Thread.sleep
import kotlin.test.assertEquals


var assignmentDeadline = ""

class CreateAssignment (private var assert:Boolean = true) {
    private val appealCardPage = AppealCardPage()
    private val asideToggle = AsideToggle()
    private val allOutgoingAssignmentsPage = AllOutgoingAssignmentsPage()
    private val assignmentProjectCardPage = AssignmentProjectCardPage()
    private val registeredAppealsListPage = RegisteredAppealsListPage()
    private val assignmentCardPage = AssignmentCardPage()


    @Test
    fun createAssignmentTest() {
        CreateAppeal(false).createAppealTest()
        page.click(registeredAppealsListPage.appealsSearch_input)
        page.fill(registeredAppealsListPage.appealsSearch_input, appealNumber)
        page.keyboard().press(enter_btn)
        page.waitForNavigation { page.click(registeredAppealsListPage.appealInList) }
        page.click(appealCardPage.createAssignment_btn)

        page.click(appealCardPage.region_dropdown)
        page.click(appealCardPage.country)
        page.click(appealCardPage.adresat_dropdown)
        page.click(appealCardPage.adresat)

        page.click(appealCardPage.addCoExecutor_text)

        page.click(appealCardPage.region2_dropdown)
        page.click(appealCardPage.country2)
        page.click(appealCardPage.adresat2_dropdown)
        page.click(appealCardPage.adresat2)

        page.click(appealCardPage.deadline_input)
        page.click(appealCardPage.changeMonth_btn)
        page.click(appealCardPage.date_btn)
        assignmentDeadline = page.inputValue(appealCardPage.deadline_input)

        page.click(appealCardPage.appointSigner_text)
        page.click(appealCardPage.approvers_dropdown)
        page.click(appealCardPage.approver)
        page.click(appealCardPage.responsibles_dropdown)
        page.click(appealCardPage.responsible)
        page.click(appealCardPage.send_btn)

        page.click(asideToggle.asideToggleFix_btn)
        page.click(asideToggle.outgoingAssignments)
        page.waitForNavigation { page.click(asideToggle.allOutgoingAssignments) }
        page.click(asideToggle.asideToggleFix_btn)

        page.click(allOutgoingAssignmentsPage.firstAssignmentInList)
        page.click(assignmentProjectCardPage.approve_btn)
        page.click(assignmentProjectCardPage.approve_btn_popup)
        page.click(assignmentProjectCardPage.sign_btn)
        page.click(assignmentProjectCardPage.NUTS_btn)

        sign()

        if (assert) {
            assertEquals(Dates().dateFormat(page.innerText(assignmentCardPage.assignmentDeadline)), assignmentDeadline)
            assertEquals(page.innerText(assignmentCardPage.statusAssignmentCreated), statusAssignmentCreated)
            assertEquals(page.innerText(assignmentCardPage.statusAssignmentApproved), statusAssignmentApproved)
            assertEquals(page.innerText(assignmentCardPage.statusAssignmentSigned), statusAssignmentSigned)
        }
    }
}
