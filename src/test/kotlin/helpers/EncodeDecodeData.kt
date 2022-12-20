package helpers

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.security.SecureRandom
import org.testng.annotations.Test
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

//Шифрование/дешифрование данных
class EncodeDecodeData {
    private val algorithm = "AES"
    private val initVector = "encryptionIntVec"
    private val keyValue = "2g49uJ7qF^m4MDaV"

    private fun generateKey(keyValue: String): Key {
        return SecretKeySpec(keyValue.toByteArray(StandardCharsets.UTF_8), algorithm)
    }

    private fun encrypt(keyValue: String, valueToEncode: String?): String? {
        val iv = IvParameterSpec(initVector.toByteArray(StandardCharsets.UTF_8))
        val key = generateKey(keyValue)
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.ENCRYPT_MODE, key, iv)
        val encrypted = cipher.doFinal(valueToEncode!!.toByteArray())
        return Base64.getMimeEncoder().encodeToString(encrypted)
    }

    private fun decrypt(keyValue: String, encryptedValue: String?): String {
        val iv = IvParameterSpec(initVector.toByteArray(StandardCharsets.UTF_8))
        val key = generateKey(keyValue)
        val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        cipher.init(Cipher.DECRYPT_MODE, key, iv)
        return String(cipher.doFinal(Base64.getMimeDecoder().decode(encryptedValue)))
    }

    @Test
    fun getEncryptedData() {
        println("Login:    ${encrypt(keyValue, "110000000005")}") //Здесь вставляешь, чтоб зашифровать данные
        println("Password: ${BCryptPasswordEncoder(6, SecureRandom()).encode("110000000005")}") //Здесь вставляешь, чтоб получить hex пароля
    }

    @Test
    fun getDecryptedData() {
        println(decrypt(keyValue, "HP318L4JiaHACjCn6hkIZg==")) //Здесь вставляешь, чтоб расшифровать данные
    }
}











