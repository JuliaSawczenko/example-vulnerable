package engineering;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class WeakCryptoExample {

    public byte[] md5Digest(byte[] input) throws Exception {
        // Should trigger SEC_WEAK_CRYPTO for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(input);
    }

    public byte[] aesEcbEncrypt(byte[] input, byte[] key) throws Exception {
        // Should trigger SEC_WEAK_CRYPTO for AES/ECB
        SecretKeySpec skey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skey);
        return cipher.doFinal(input);
    }
}