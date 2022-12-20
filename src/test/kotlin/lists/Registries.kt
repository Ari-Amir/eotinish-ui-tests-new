package lists


//Реестры обращений
const val registeredAndWaitingForRoute = "text=Зарегистрированы и ожидают маршрутизации"

const val onExecution = "text=На исполнении"

const val incomingTasks_tab = "text=Входящие задачи"
const val inWork = "text=Находятся в работе"
const val approve = "text=Согласовать"
const val sign = "text=Подписать"
const val revokedByApplicant = "text=Отозванные заявителем"

const val AUTOTESTORG1_tab = "text=AUTOTEST ORG 1"
const val allAppeals = "text=Все обращения"
const val inExecutorsWork = "text=В работе у сотрудников"
const val finished = ":nth-match(:text(\"Завершенные\"), 2)"

const val TSONAppealRegistry  = "text=Реестр обращений"

//Реестры поручений
const val outgoingAssignments_tab = "text=Исходящие поручения"
const val allOutgoing = "text=Все исходящие"

const val assignments_tab = ":nth-match(:text(\"Поручения\"), 3)"
const val waitingForCheck = "text=Ожидают проверки"

const val incomingAssignments_tab = "text=Входящие поручения"
const val myTasks = "text=Мои задачи"
const val onApprove = "text=На согласовании"
const val waitingForRouting = ":nth-match(:text(\"Ожидают маршрутизации\"), 2)"
const val allIncoming = "text=Все входящие"

