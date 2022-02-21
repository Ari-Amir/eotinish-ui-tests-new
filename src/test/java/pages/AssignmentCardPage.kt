package pages

class AssignmentCardPage {
    //Statuses
    val statusCreated = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--CREATED_DRAFT.is--DRAFT > div.i2-timeline__status"
    val statusApproved = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--APPROVE_DRAFT.is--DRAFT > div.i2-timeline__status"
    val statusSigned = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--ACTIVE.is--SIGN_DRAFT > div.i2-timeline__status"

    val sendToWork_btn = "text=Направить в работу"

    //Send to work popup
    val responsibleSpecialist_dropdown = "text=Ответственный специалистВыбрать исполнителя >> span"
    val responsibleSpecialistAZRK = "text=Жумангарин Серик Макашевич (Председатель)"
    val responsibleSpecialistMinfin = "text=Министр финансов (Министр финансов)"
    val assign_btn = "text=Назначить"

    val answerToAssignment_btn = "text=Ответить на поручение"

    //Answer to assignment popup
    val answerToAssignment_rbtn = "label:has-text(\"Ответить на поручение\")"
    val requestToProlong_rbtn = "label:has-text(\"Запрос на продление срока\")"
    val answerText_input = "textarea"
    val answerAZRK = "Ответ на поручение от АЗРК"
    val answerMinfin = "Ответ на поручение от Минфина"
    val attachFile_btn = "text=Прикрепить документы"
    val fileName_input = "[placeholder=\"Название\"]"
    val fileNameAZRK = "Файл АЗРК"
    val fileNameMinfin = "Файл Минфина"
    val send_btn = "text=Отправить"

    val sendToApprove_btn = "text=Отправить на согласование ответ на поручение"

    //Send to approve and sign popup
    val approvers_dropdown = "text=Выбрать согласующихВыбрать согласующих >> span"
    val approverAZRK = "div[role=\"option\"]:has-text(\"Жумангарин Серик Макашевич\")"
    val approverMinfin = "div[role=\"option\"]:has-text(\"Министр финансов\")"
    val signers_dropdown = "text=Выберите подписантаВыбрать подписанта >> span"
    val signerAZRK = "[aria-label=\"Options list\"] >> text=Жумангарин Серик Макашевич"
    val signerMinfin = "[aria-label=\"Options list\"] >> text=Министр финансов"
    val sendtToApproveAndSign_btn = "div[role=\"document\"] >> text=Отправить"

    val approve_btn = "text=Cогласовать ответ"
    val approve_btn_popup = "button:has-text(\"Согласовать\")"
    val sign_btn = "button:has-text(\"Подписать\")"
    val NUTS_btn = "text=НУЦ РК"

}