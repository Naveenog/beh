import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;
public class RSA {
public static void main(String[] args) throws Exception {
String plainText = "Hello RSA";
KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
keyGen.initialize(2048);
KeyPair pair = keyGen.generateKeyPair();
Cipher cipher = Cipher.getInstance("RSA");
cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
byte[] encrypted = cipher.doFinal(plainText.getBytes());
String encryptedText = Base64.getEncoder().encodeToString(encrypted);
System.out.println("Encrypted: " + encryptedText);
cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
System.out.println("Decrypted: " + new String(decrypted));
}
}
