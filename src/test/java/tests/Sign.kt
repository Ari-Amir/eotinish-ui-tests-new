package tests

import configs.NCALayer
import configs.screen
import java.awt.Desktop
import java.lang.Thread.sleep


fun sign() {
    Desktop.getDesktop().open(NCALayer)
    sleep(800)
    screen.type("RSA.p12")
    sleep(300)
    screen.type("\n")
    sleep(300)
    sleep(5000)
    screen.type("")
    screen.type("\n")
    screen.type("\n")
}