package helpers

class DateFormat {
    fun dateFormat (date: String) : String {
       return date.replace("/", "-")
    }
}