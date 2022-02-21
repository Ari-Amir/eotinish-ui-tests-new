package tests

import pages.*
import configs.*
import lists.*
import org.testng.annotations.Test
import kotlin.test.assertEquals


class CreateAssignment (private var assert:Boolean = true) {
    private val appealCardPage = AppealCardPage()
    private val asideToggle = AsideToggle()
    private val allOutgoingAssignmentsPage = AllOutgoingAssignmentsPage()
    private val assignmentProjectCardPage = AssignmentProjectCardPage()
    private val registeredAppealsPage = RegisteredAppealsPage()
    private val assignmentCardPage = AssignmentCardPage()

    @Test
    fun createAssignmentTest() {
        CreateAppeal(false).createAppealTest()
        page.click(registeredAppealsPage.appealsSearch_input)
        page.fill(registeredAppealsPage.appealsSearch_input, appealNumber)
        page.keyboard().press(enter_btn)
        page.waitForNavigation { page.click(registeredAppealsPage.appealInList) }
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
            assertEquals(page.innerText(assignmentCardPage.statusCreated), statusCreated)
            assertEquals(page.innerText(assignmentCardPage.statusApproved), statusApproved)
            assertEquals(page.innerText(assignmentCardPage.statusSigned), statusSigned)
        }
    }
}
