package helpers

import com.microsoft.playwright.Page
import java.lang.Thread.sleep

//Прокрутка вниз
fun Page.scrollDown() {
    sleep(1000)
    this.mouse().wheel(0.0, 1000.0)
    sleep(1000)
}

const val enter_btn = "Enter"
