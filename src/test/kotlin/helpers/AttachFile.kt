package helpers

import configs.screen
import java.lang.Thread.sleep


/*
Прикрепление файла.
В каталог, который система открывает по умолчанию при прикреплении файла, нужно добавить файл.
Название файла должно начинаться на букву "t".
Желательно чтоб в данном каталоге был один такой файл, во избежание прикрепления не того файла.
*/

fun attachFile() {
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
