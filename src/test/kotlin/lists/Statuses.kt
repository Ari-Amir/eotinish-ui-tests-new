package lists

//Статусы обращений
const val statusAppealForwarding = "Переадресация в другую организацию"
const val statusAppealForwardingApproved = "Согласовано письмо о переадресации"
const val statusAppealForwardingSigned = "Подписано письмо о переадресации"
const val statusAppealForwardedPartly = "Переадресовано в части"
const val statusAppealForwardedFully = "Переадресовано"
const val statusAppealFinished = "Исполнено"
const val statusAppealRevoked = "Отозвано"
const val statusAppealAligned = "Приведено в соответствие" //Appeal63 & Appeal93

//Статусы поручений
const val statusAssignmentCreated = "Создан проект «Поручение/запрос»"
const val statusAssignmentApproved = "Согласован проект «Поручение/запрос»"
const val statusAssignmentSigned = "Подписан проект «Поручение/запрос»"
const val statusAssignmentChecked =  "Проверен проект \"Поручение/запрос\""

//Статусы доппоручений
const val statusAdditionalAssignmentCreated = "Создано дополнительное поручение"
const val statusAdditionalAssignmentApproved = "Дополнительное поручение согласовано"
const val statusAdditionalAssignmentSigned = "Дополнительное поручение подписано"
