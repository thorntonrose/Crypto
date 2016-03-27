import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class genkeypair {

   private static void writeKeyFile(String keyFilename, Key aKey) throws IOException {
      FileOutputStream keyFile;

      keyFile = new FileOutputStream(keyFilename);

      try {
         keyFile.write(aKey.getEncoded());
      } finally {
         keyFile.close();
      }
   }
   
   public static void main(String[] args) {
      String           keyFilename1;
      String           keyFilename2;
      KeyPair          keyPair;
      
      try {
         if (args.length < 2) {
            System.out.println("Usage: genkeypair <keyfile1> <keyfile2>");
            System.exit(0);
         }

         // Get key filenames from command-line arguments.

         keyFilename1 = args[0];
         keyFilename2 = args[1];

         // Load encryption provider (SunJCE).
         
         System.out.println("Loading provider...");

         Security.addProvider(new com.sun.crypto.provider.SunJCE());

         // Generate key.

         System.out.println("Generating key pair...");

         keyPair = KeyPairGenerator.getInstance("DSA", "SUN").genKeyPair();

         // Write raw version of public key to file.

         System.out.println("Writing key to " + keyFilename1 + "...");

         writeKeyFile(keyFilename1, keyPair.getPublic());

         // Write raw version of private key to file.

         System.out.println("Writing key to " + keyFilename2 + "...");

         writeKeyFile(keyFilename2, keyPair.getPrivate());
      } catch(Exception ex) {
         System.out.println(ex);
      }
   }
   
}
