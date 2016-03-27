import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class genkey {
   public static void main(String[] args) {
      SecretKey        key;
      String           keyFilename;
      FileOutputStream keyFile;
      
      try {
         if (args.length < 1) {
            System.out.println("Usage: genkey <keyfile>");
            System.exit(0);
         }

         // Get key filename from command-line arguments.

         keyFilename = args[0];

         // Load encryption provider (SunJCE).
         
         System.out.println("Loading provider...");

         Security.addProvider(new com.sun.crypto.provider.SunJCE());

         // Generate key.

         System.out.println("Generating key...");

         key = KeyGenerator.getInstance("Blowfish").generateKey();

         // Write raw key (bytes) to key file.

         System.out.println("Writing key to " + keyFilename + "...");

         keyFile = new FileOutputStream(keyFilename);

         try {
            keyFile.write(key.getEncoded());
         } finally {
            keyFile.close();
         }
      } catch(Exception ex) {
         System.out.println(ex);
      }
   }
}
