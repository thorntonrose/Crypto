public class Caesar {
   private static String encryptText(int n, String text) {
      String es = "";

      for (int i = 0; i < text.length(); i ++) {
         char c = text.charAt(i);

         if ((c >= 'A') && (c <= 'Z')) {
            es += encryptChar(n, 'A', c);
         } else if ((c >= 'a') && (c <= 'z')) {
            es += encryptChar(n, 'a', c);
         } else {
            es += c;
         }
      }

      return es;
   }

   private static char encryptChar(int n, char b, char c) {
      return (char) ((((c - b) + n) % 26) + (int) b);
   }

   public static void main(String[] args) {
      System.out.println(encryptText(Integer.parseInt(args[0]), args[1]));
   }
}