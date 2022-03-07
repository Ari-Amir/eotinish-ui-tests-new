package tests


import configs.*
import helpers.Dates
import lists.*
import org.testng.annotations.Test
import pages.*
import java.lang.Thread.sleep
import kotlin.test.assertEquals


var additionalAssignmentDeadline = ""

class CreateAdditionalAssignment (private var assert:Boolean = true) {
    private val assignmentCardPage = AssignmentCardPage()


    @Test
    fun createAdditionalAssignmentTest() {
        CreateAssignment(false).createAssignmentTest()
        page.click(assignmentCardPage.createAdditionalAssignment_btn)

        page.click(assignmentCardPage.region_dropdown)
        page.click(assignmentCardPage.country)
        page.click(assignmentCardPage.adresat_dropdown)
        page.click(assignmentCardPage.adresat)

        page.click(assignmentCardPage.addCoExecutor_text)

        page.click(assignmentCardPage.region2_dropdown)
        page.click(assignmentCardPage.country2)
        page.click(assignmentCardPage.adresat2_dropdown)
        page.click(assignmentCardPage.adresat2)

        page.click(assignmentCardPage.deadline_input)
        page.click(assignmentCardPage.changeMonth_btn)
        page.click(assignmentCardPage.date_btn)
        additionalAssignmentDeadline = page.inputValue(assignmentCardPage.deadline_input)

        page.click(assignmentCardPage.appointSigner_text)
        page.click(assignmentCardPage.approvers_dropdown)
        page.click(assignmentCardPage.approver)
        page.click(assignmentCardPage.send_btn)

        page.click(assignmentCardPage.approveAdditionalAssignment_btn)
        page.click(assignmentCardPage.approve_btn_popup)
        page.click(assignmentCardPage.sign_btn)
        page.click(assignmentCardPage.NUTS_btn)

        sign()

        if (assert) {
            assertEquals(Dates().dateFormat(page.innerText(assignmentCardPage.additionalAssignmentDeadline)), additionalAssignmentDeadline)
            assertEquals(page.innerText(assignmentCardPage.statusAdditionalAssignmentCreated), statusAdditionalAssignmentCreated)
            assertEquals(page.innerText(assignmentCardPage.statusAdditionalAssignmentApproved), statusAdditionalAssignmentApproved)
            assertEquals(page.innerText(assignmentCardPage.statusAdditionalAssignmentSigned), statusAdditionalAssignmentSigned)
        }
    }
}
