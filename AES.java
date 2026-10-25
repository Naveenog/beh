import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
public class AES {
public static void main(String[] args) throws Exception {
String plainText = "Hello BSc III Semester";
KeyGenerator keyGen = KeyGenerator.getInstance("AES");
keyGen.init(128);
SecretKey secretKey = keyGen.generateKey();
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] encrypted = cipher.doFinal(plainText.getBytes());
String encryptedText = Base64.getEncoder().encodeToString(encrypted);
System.out.println("Encrypted: " + encryptedText);
cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
System.out.println("Decrypted: " + new String(decrypted));
}
}
