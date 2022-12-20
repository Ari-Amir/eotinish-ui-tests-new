package helpers

import java.lang.Thread.sleep
import lists.*
import pages.*
import tests.*

//Переключение на юзера
fun switchOnUser(user: User) {
    if (user.pageIsCreated) {                                           //Если страница браузера юзера создана,
        user.page.bringToFront()                                        //то выносим его страницу поверх остальных,
        user.page.reload()                                              //на всякий случай перезагружаем страницу браузера (вдруг юзера разлогинило),
        user.page.waitForLoadState()                                    //дожидаемся окончания перезагрузки страницы браузера
        sleep(1000)
        when {
            user.page.isVisible(mainPage.user_name) -> {                //Код выполняется когда на странице отображается имя юзера
                if (!user.page.isVisible(mainPage.user_name)) {         //Если после перезагрузки страницы браузера, имя юзера около аватарки НЕ отображается,
                    user.page.close()                                   //закрываем разлогиненную страницу,
                    user.pageIsCreated = false                          //указываем что страница не создана
                    Login(user, false).loginTest()               //и логинимся заново
                }
            }
            user.page.isVisible(mainPage.TSONOperator_name) -> {        //Код выполняется когда на странице отображается имя оператора ЦОНа
                if (!user.page.isVisible(mainPage.TSONOperator_name)) { //Если после перезагрузки страницы браузера, имя юзера около аватарки НЕ отображается,
                    user.page.close()                                   //закрываем разлогиненную страницу,
                    user.pageIsCreated = false                          //указываем что страница не создана
                    Login(user, false).loginTest()               //и логинимся заново
                }
            }
        }

    }else{                                                              //Если страница браузера юзера Не создана,
        Login(user, false).loginTest()                           //то логинимся
    }
}
