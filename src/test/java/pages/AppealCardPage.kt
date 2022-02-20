package pages

class AppealCardPage {
    val cardHead_text = "#kt_subheader > div > div > h5"
    val appealSourceGO = "#kt_content > div > div > app-appeal-registrar-view > div.row > div.col-md-7.col-xxl-8 > div > div > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div.field__value"
    val appealSourceTSON = "#kt_content > div > div > app-appeal-view > div.row > div.col-md-7.col-xxl-8.mb-8 > div > div > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div.field__value"
    val createAssignment_btn = "text=Поручение/запрос в другой ГО"

    //Assignment Creating Popup
    val region_dropdown = "app-location-picker >> text=Выберите регион"
    val country = "text=Республика Казахстан"
    val adresat_dropdown = "text=Выберите ГО*Выберите адресат >> span"
    val adresat = "text=Агентство по защите и развитию конкуренции (АЗРК)"
    val addCoExecutor_text = "text=Добавить организацию-соисполнителя"
    val region2_dropdown = ":nth-match(:text(\"Выберите регион\"), 3)"
    val country2 = ":nth-match(:text(\"Республика Казахстан\"), 2)"
    val adresat2_dropdown = ".ng-custom-select.ng-select.ng-select-single.ng-select-searchable.ng-select-clearable.ng-untouched .ng-select-container"
    val adresat2 = "div[role=\"option\"]:has-text(\"Министерство финансов Республики Казахстан\")"
    val appointSigner_text = "text=Назначить себя"
    val approvers_dropdown = "text=Выбрать согласующихВыбрать согласующих >> span"
    val approver = "div[role=\"option\"]:has-text(\"Замакима 5\")" //"div[role=\"option\"]:has-text(\"Аким Карагандинской области\")"
    val responsibles_dropdown = "text=Ответственный сотрудникВыбрать ответственного сотрудника >> span"
    val responsible = "div[role=\"option\"]:has-text(\"Замакима 5\")" //"div[role=\"option\"]:has-text(\"Аким Карагандинской области\")"
    val send_btn = "button:has-text(\"Отправить\")"
}
