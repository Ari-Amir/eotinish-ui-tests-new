package helpers

import org.testng.annotations.Test
import java.text.SimpleDateFormat
import java.util.*

class Dates {
    fun dateFormat (date: String) : String {
        return when {
            date.contains("/") -> date.replace("/", "-")
            date.contains(".") -> date.replace(".", "-")
            else -> date
        }
    }

    fun getNextMonthDay() : String {
        return SimpleDateFormat("dd").format(Date())
    }
}
