package pl.filip.util;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryptor {
    private static final String SECRET_KEY="1234567812345678";
    private static final String ALGHORITHM="AES";

    public static String encrypt(String plainText) throws Exception {
        SecretKeySpec key=new SecretKeySpec(SECRET_KEY.getBytes(),ALGHORITHM);
        Cipher cipher=Cipher.getInstance(ALGHORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] encrypted=cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);

    }

    public static String decrypt(String encryptedText) throws Exception {
        SecretKeySpec key=new SecretKeySpec(SECRET_KEY.getBytes(),ALGHORITHM);
        Cipher cipher=Cipher.getInstance(ALGHORITHM);
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] decrypted=cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decrypted);
    }

}
