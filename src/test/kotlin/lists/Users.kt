package lists


import com.microsoft.playwright.Page
import configs.*


data class User (
    val name: String,
    val IIN: String,
    val password: String,
    var page: Page = browserPage,
    var pageIsCreated: Boolean
)

//Org.1
val org1Registrar1 = User(
    "Регистратор-1 (Org.1)",
    "111100000001",
    "111100000001",
    pageIsCreated = false
)

val org1Chief1 = User(
    "Руководитель-1 (Org.1)",
    "111100000002",
    "111100000002",
    pageIsCreated = false
)

val org1Chief2 = User(
    "Руководитель-2 (Org.1)",
    "800329300581",
    "800329300581",
    pageIsCreated = false
)


val org1Executor1 = User(
    "Исполнитель-1 (Org.1)",
    "111100000003",
    "111100000003",
    pageIsCreated = false
)

val org1Executor2 = User(
    "Исполнитель-2 (Org.1)",
    "111100000033",
    "111100000033",
    pageIsCreated = false
)

val org1Executor3 = User(
    "Исполнитель-3 (Org.1)",
    "111100000333",
    "111100000333",
    pageIsCreated = false
)

val org1Executor4 = User(
    "Исполнитель-4 (Org.1)",
    "111100003333",
    "111100003333",
    pageIsCreated = false
)

val org1Controller1 = User(
    "Контролер-1 (Org.1)",
    "111100000004",
    "111100000004",
    pageIsCreated = false
)

val TSONOperator = User(
    "Оператор ЦОНа",
    "111100000005",
    "111100000005",
    pageIsCreated = false
)

//Org.2
val org2Registrar1 = User(
    "Регистратор-1 (Org.2)",
    "222200000001",
    "222200000001",
    pageIsCreated = false
)

val org2Chief1 = User(
    "Руководитель-1 (Org.2)",
    "222200000002",
    "222200000002",
    pageIsCreated = false
)

val org2Executor1 = User(
    "Исполнитель-1 (Org.2)",
    "222200000003",
    "222200000003",
    pageIsCreated = false
)

//Org.2 Un.1
val org2un1Executor1 = User(
    "Исполнитель-1 (Org.2 Un.1)",
    "222230000003",
    "222230000003",
    pageIsCreated = false
)

//Org.3
val org3Registrar1 = User(
    "Регистратор-1 (Org.3)",
    "333300000001",
    "333300000001",
    pageIsCreated = false
)

val org3Chief1 = User(
    "Руководитель-1 (Org.3)",
    "333300000002",
    "333300000002",
    pageIsCreated = false
)

val org3Executor1 = User(
    "Исполнитель-1 (Org.3)",
    "333300000003",
    "333300000003",
    pageIsCreated = false
)

//Org.3 Ch.1
val org3ch1Executor1 = User(
    "Исполнитель-1 (Org.3 Ch.1)",
    "333310000003",
    "333310000003",
    pageIsCreated = false
)

//Org.3 Un.1
val org3un1Executor1 = User(
    "Исполнитель-1 (Org.3 Un.1)",
    "333330000003",
    "333330000003",
    pageIsCreated = false
)