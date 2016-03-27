import java.math.*
import java.security.*
import javax.crypto.*
import javax.crypto.spec.*

if (args.size() < 2) {
   println "usage: ${this.class.name} <key> <[secure:]text>"
   return
}

key = args[0]
text = args[1]
keySpec = new SecretKeySpec(key.getBytes(), "Blowfish")
cipher = Cipher.getInstance("Blowfish")

prefix = "secure:"
p = text.indexOf(prefix)

if (p > -1) {
   text = text.substring(prefix.length())

   cipher.init(Cipher.DECRYPT_MODE, keySpec)
   encoding = new BigInteger(text, 16).toByteArray()
   decoding = cipher.doFinal(encoding)
   System.out.println(new String(decoding))
} else {
   cipher.init(Cipher.ENCRYPT_MODE, keySpec)
   encoding = cipher.doFinal(text.getBytes())
   System.out.println(new BigInteger(encoding).toString(16))
}