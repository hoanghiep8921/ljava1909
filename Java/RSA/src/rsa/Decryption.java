package rsa;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Decryption {
    public static void main(String[] args) {
        try {
            // Đọc file chứa private key
            FileInputStream fis = new FileInputStream("D:/privateKey.txt");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            // Tạo private key
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = factory.generatePrivate(spec);

            // Giải mã dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, priKey);
            byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(
                    "CF3zxaG+eU32Vrc8aqRyXf0jLFnsouzVDbwUWqErdWGAxpCRaC9Mo77SG+fnoHDOj0n0IVzcHsXhOBagI1i0CSVu5Z3fQqqIdsQO7xIy4AExj8k6vNVvVJZthNVfDr3eZrpKeKhdagq+cumsW+Fc9QjajxlBFyg98KggSK9gkJL7n3MuCOp4YJjwpBEBJ8hugoFKw6tMj6cWHzGjQxjVIg6ULIaYQpFDSLW/OGJA5CgXkL3MCCLrdGHRmsvrudGEAIA9uOPTdFZEls4o2RTqU2KlBGNYBjMI6dzyl2OzKFZlGTqW2N9wuF4HPrfIO1W/8RIf+veShvECrmUTWbmUtQ=="));
            System.out.println("Dữ liệu sau khi giải mã: " + new String(decryptOut));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
