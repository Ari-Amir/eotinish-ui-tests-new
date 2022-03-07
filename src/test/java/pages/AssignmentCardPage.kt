package pages

class AssignmentCardPage {
    val assignmentApprove_btn = "text=Cогласовать ответ"
    val approve_btn_popup = "button:has-text(\"Согласовать\")"
    val approveAdditionalAssignment_btn = "text=Cогласовать"
    val sign_btn = "button:has-text(\"Подписать\")"
    val sendToWork_btn = "text=Направить в работу"
    val assignmentDeadline = "#kt_content > div > div > app-view > div.row > div.col-md-7.col-xxl-8 > div > div > div:nth-child(2) > div:nth-child(3) > div.field__value"
    val additionalAssignmentDeadline = "#kt_content > div > div > app-view > div.row > div.col-md-7.col-xxl-8 > app-additional-assignment-list > div:nth-child(1) > div > section > div:nth-child(1) > div:nth-child(3) > div.field__value"
    val createAdditionalAssignment_btn = "#kt_content > div > div > app-view > div.row > div.col-md-7.col-xxl-8 > div > div > div.d-flex.border-top.flex-wrap.pt-10 > app-create-assignment > button"
    val innerDeadline = "#kt_content > div > div > app-view > div.row > div.col-md-7.col-xxl-8 > div > div > div:nth-child(4) > div:nth-child(2) > div.field__value"

    //Statuses
    val statusAssignmentCreated = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--CREATED_DRAFT.is--DRAFT > div.i2-timeline__status"
    val statusAssignmentApproved = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--APPROVE_DRAFT.is--DRAFT > div.i2-timeline__status"
    val statusAssignmentSigned = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--ACTIVE.is--SIGN_DRAFT > div.i2-timeline__status"
    val statusAdditionalAssignmentCreated = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--ACTIVE.is--CREATED_ADDITIONAL_ASSIGNMENT > div.i2-timeline__status"
    val statusAdditionalAssignmentApproved = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--ACTIVE.is--APPROVE_ADDITIONAL_ASSIGNMENT > div.i2-timeline__status"
    val statusAdditionalAssignmentSigned = "#kt_content > div > div > app-view > div.row > div.col-md-5.col-xxl-4 > div > app-assignment-history > div.history.pb-8.pl-8.pr-8 > div > div.i2-timeline__item.is--ACTIVE.is--SIGN_ADDITIONAL_ASSIGNMENT > div.i2-timeline__status"


    //Send to work popup
    val responsibleSpecialist_dropdown = "text=Ответственный специалистВыбрать исполнителя >> span"
    val responsibleSpecialistAZRK = "text=Жумангарин Серик Макашевич (Председатель)"
    val responsibleSpecialistMinfin = "text=Министр финансов (Министр финансов)"
    val assignmentInnerDeadline_input = "#kt_body > ngb-modal-window > div > div > div.modal-body > div > div:nth-child(3) > div > div > app-datepicker > div > div.input-group > dp-date-picker > div:nth-child(1) > div > input"
    val assignmentInnerDeadlineChangeMonth_btn = "#kt_body > ngb-modal-window > div > div > div.modal-body > div > div:nth-child(3) > div > div > app-datepicker > div > div.input-group > dp-date-picker > div:nth-child(2) > div > dp-day-calendar > div > dp-calendar-nav > div > div.dp-nav-btns-container > div.dp-calendar-nav-container-right > button"
    val assignmentInnerDeadlineDate_btn = "button:has-text(\"${helpers.Dates().getNextMonthDay()}\")"

    val assign_btn = "text=Назначить"

    val answerToAssignment_btn = "text=Ответить на поручение"

    //Answer to assignment popup
    val answerToAssignment_rbtn = "label:has-text(\"Ответить на поручение\")"
    val requestToProlong_rbtn = "label:has-text(\"Запрос на продление срока\")"
    val answerText_input = "textarea"
    val answerAZRK = "Ответ на поручение от АЗРК"
    val answerMinfin = "Запрос на продление срока от Минфина"
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
    val NUTS_btn = "text=НУЦ РК"

    //Create additional assignment popup
    val region_dropdown = "app-location-picker >> text=Выберите регион"
    val country = "text=Республика Казахстан"
    val adresat_dropdown = "text=Выберите ГО*Выберите адресат >> span"
    val adresat = "[aria-label=\"Options\\ list\"] >> text=Агентство по защите и развитию конкуренции (АЗРК)"
    val addCoExecutor_text = "text=Добавить организацию-соисполнителя"
    val region2_dropdown = ":nth-match(:text(\"Выберите регион\"), 3)"
    val country2 = ":nth-match(:text(\"Республика Казахстан\"), 2)"
    val adresat2_dropdown = ".ng-custom-select.ng-select.ng-select-single.ng-select-searchable.ng-select-clearable.ng-untouched .ng-select-container"
    val adresat2 = "[aria-label=\"Options\\ list\"] >> text=Министерство финансов Республики Казахстан"
    val deadline_input = "#kt_body > ngb-modal-window > div > div > div.modal-body > form > div:nth-child(2) > div > div > app-datepicker > div > div.input-group > dp-date-picker > div:nth-child(1) > div > input"
    val changeMonth_btn = "#kt_body > ngb-modal-window > div > div > div.modal-body > form > div:nth-child(2) > div > div > app-datepicker > div > div.input-group > dp-date-picker > div:nth-child(2) > div > dp-day-calendar > div > dp-calendar-nav > div > div.dp-nav-btns-container > div.dp-calendar-nav-container-right"
    val date_btn = "button:has-text(\"${helpers.Dates().getNextMonthDay()}\")"
    val appointSigner_text = "text=Назначить себя"
    val approver = "div[role=\"option\"]:has-text(\"Замакима 5\")" //"div[role=\"option\"]:has-text(\"Аким Карагандинской области\")"
}
