import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class encrypt {
   public static void main(String[] args) {
      String             keyFilename;
      String             inFilename;
      String             outFilename;
      File               keyFile;
      FileInputStream    keyStream;
      FileInputStream    inStream;
      CipherOutputStream outStream;
      byte[]             rawKey;
      SecretKeySpec      keySpec;
      Cipher             cipher;
      byte[]             inData = new byte[1024];
      int                byteCount = 0;

      try {
         if (args.length < 3) {
            System.out.println("Usage: encrypt <keyfile> <infile> <outfile>");
            System.exit(0);
         }

         // Get filenames from command-line arguments.

         keyFilename = args[0];
         inFilename  = args[1];
         outFilename = args[2];

         // Load crypto service provider.

         System.out.println("Loading provider...");

         Security.addProvider(new com.sun.crypto.provider.SunJCE());

         // Read raw key from key file.

         System.out.println("Reading key file...");

         keyFile   = new File(keyFilename);
         keyStream = new FileInputStream(keyFile);

         try {
            rawKey = new byte[(int) keyFile.length()];
            keyStream.read(rawKey);
         } finally {
            keyStream.close();
         }

         // Convert raw key to secret key specification.

         System.out.println("Converting raw key to secret key...");

         keySpec = new SecretKeySpec(rawKey, "Blowfish");

         // Create cipher for encrypting.

         System.out.println("Creating encryption cipher...");

         cipher = Cipher.getInstance("Blowfish");
         cipher.init(Cipher.ENCRYPT_MODE, keySpec);

         // Open input file.

         inStream = new FileInputStream(inFilename);

         try {
            // Open output file.

            outStream = new CipherOutputStream(new FileOutputStream(outFilename), cipher);

            try {
               // Read data from input stream and write encrypted data to output stream.

               System.out.println("Encrypting input file...");

               do {
                  byteCount = inStream.read(inData, 0, inData.length);
                  
                  if (byteCount > 0) {
                     outStream.write(inData, 0, byteCount);
                  }
               } while (byteCount != -1);
            } finally {
               outStream.flush();
               outStream.close();
            }
         } finally {
            inStream.close();
         }
      } catch(Exception ex) {
         System.out.println(ex);
      }
   }
}
