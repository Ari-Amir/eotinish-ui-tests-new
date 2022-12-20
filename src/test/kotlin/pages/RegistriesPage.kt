package pages

//Локаторы в реестрах

//Поле для поиска обращений в реестрах
val appealSearch_input = "[placeholder=\"Введите ИИН, ФИО, телефон, адрес\"]"

//Поле для поиска обращений в реестрах (Оператор ЦОНа)
val appealsSearchTSON_input = "[placeholder=\"Введите ИИН или номер обращения\"]"

//Обращение, найденное в реестре "Зарегистрировано и ожидают маршрутизации"
val appealFoundInRegistered = "#kt_content > div > div > app-executor-list > div.card.card-custom.gutter-b > div > div > nat-table > div > table > tbody > tr:nth-child(1) > td.one-line.border-0.pl-10 > a"

//Обращение с дробью, найденное в реестре "Зарегистрировано и ожидают маршрутизации" (при частичной переадресации)
val appealFoundInRegisteredWithFraction = "#kt_content > div > div > app-executor-list > div.card.card-custom.gutter-b > div > div > nat-table > div > table > tbody > tr:nth-child(2) > td.one-line.border-0.pl-10 > a"

//Обращение, найденное в реестре "Реестр обращений" (Оператор ЦОНа)
val appealFoundInRegisteredTSON = "#kt_content > div > div > app-appeal-list > div > div > nat-table > div > table > tbody > tr:nth-child(1) > td:nth-child(1) > a"

//Обращение, найденное в других реестрах
val appealFoundInOtherRegistries = "#kt_content > div > div > app-executor-list > div.card.card-custom.gutter-b > div > div > nat-table > div > table > tbody > tr > td.one-line.pl-10 > a"

//Поручение, найденное в других реестрах
val assignmentFoundInOtherRegistries = "#kt_content > div > div > app-assignment-list > div > div > div > nat-table > div > table > tbody > tr:nth-child(1) > td.one-line.border-0.pl-10 > a"
