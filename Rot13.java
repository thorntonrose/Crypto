public abstract class Rot13 {
   public static void main(String[] args) {
      System.out.println(rot(args[0]));
   }

   public static String rot(String s) {
      StringBuffer sb = new StringBuffer(s.length());

      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         char uc = Character.toUpperCase(c);

         if ((uc >= 'A') && (uc <= 'M')) {
            sb.append(c += 13);
         } else if ((uc >= 'N') && (uc <= 'Z')) {
            sb.append(c -= 13);
         } else {
            sb.append(c);
         }
      }

      return sb.toString();
   }
}