package lists

//Данные для создания обращений и жалоб
const val paper = "text=Бумажная (нарочно)"
const val electronic = "text=Электронная"
const val appealDescription = "AUTOTEST APPEAL DESCRIPTION"
const val appealDescriptionChanged = "AUTOTEST APPEAL DESCRIPTION CHANGED"
const val complainDescription = "AUTOTEST COMPLAIN DESCRIPTION"
const val applicantsIIN = "123123123123"
const val applicantsIINChanged = "321321321321"
const val applicantsName = "AUTOTEST"
const val applicantsSurname = "AUTOTEST"
const val applicantsAddress = "AUTOTEST ADDRESS"
const val applicantsAddressChanged = "AUTOTEST ADDRESS CHANGED"
const val applicantsMobilePhone = "+7 (701) 111 11 11"
const val appeal63Reason = "DOES NOT COMPLY WITH ARTICLE 63"
const val appeal93Reason = "DOES NOT COMPLY WITH ARTICLE 93"
const val aligned = "AUTOTEST APPEAL DESCRIPTION\nALIGNED"
const val revokeComment = "REVOKE COMMENT"

//Переменные номеров и сроков исполнений обращений, жалоб, поручений и доппоручений, а также переменные внутренних сроков
var APPEAL_NUMBER = ""
var APPEAL_TYPE = ""
var COMPLAINT_NUMBER = ""
var COMPLAINT_TYPE = ""

var ASSIGNMENT_DEADLINE = ""
var ASSIGNMENT_NUMBER = ""
var ASSIGNMENT_INNER_DEADLINE_FOR_EXECUTOR1 = ""
var ASSIGNMENT_INNER_DEADLINE_FOR_EXECUTOR2 = ""
var ADDITIONAL_ASSIGNMENT_DEADLINE = ""