public class Fibonacci {
   public static int fib(int n) {
      int f;

      switch(n) {
         case 0:
            f = 0;
            break;

         case 1:
            f = 1;
            break;

         default:
            f = fib(n - 1) + fib(n - 2);
      }

      return f;
   }

   public static void main(String[] args) {
      int n = Integer.parseInt(args[0]);

      for (int i = 0; i <= n; i ++) {
         System.out.print((i > 0 ? " " : "") + fib(i));
      }
   }
}