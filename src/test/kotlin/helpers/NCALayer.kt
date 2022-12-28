package helpers

import configs.*
import java.lang.Thread.sleep

/*
В пакете configs создать Котлин файл с именем Settings.kt
В этот файл добавить: const val password = "Сюда вписать ваш пароль от ЭЦП"
*/


//Подписание файлом ЭЦП (RSA)
fun sign() {
    NCALayer.focus()
    sleep(500)
    screen.type("RSA.p12")
    sleep(300)
    screen.type("\n")
    sleep(300)
    screen.type(password)
    screen.type("\n")
    screen.type("\n")
    NCALayer.reset()
}

//Авторизация файлом ЭЦП (AUTH)
fun auth() {
    NCALayer.focus()
    sleep(500)
    screen.type("AUTH.p12")
    sleep(300)
    screen.type("\n")
    sleep(300)
    screen.type(password)
    screen.type("\n")
    screen.type("\n")
    NCALayer.reset()
}
