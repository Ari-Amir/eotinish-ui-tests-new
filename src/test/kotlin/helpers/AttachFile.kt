package helpers

import configs.screen
import org.sikuli.script.Key
import java.lang.Thread.sleep


/*
Прикрепление файла.
В каталог, который система открывает по умолчанию при прикреплении файла, нужно добавить файл.
Название файла должно начинаться на букву "t".
В случае с Ubuntu, надо чтоб название файла было "test" с любым расширением pdf, doc, xls итд.
Желательно чтоб в данном каталоге был один такой файл, во избежание прикрепления не того файла.
*/

fun attachFileFromMac() {
    sleep(500)
    screen.click()
    sleep(500)
    screen.click()
    screen.keyDown("t")
    screen.keyUp("t")
    sleep(800)
    screen.type("\n")
    sleep(1000)
}

fun attachFileFromUbuntu() {
    sleep(500)
    screen.click()
    sleep(500)
    screen.click()
    screen.type("test")
    sleep(1000)
    screen.keyDown(Key.DOWN)
    sleep(500)
    screen.keyUp()
    screen.type("\n")
    sleep(1000)
}
