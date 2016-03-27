import sys

def encrypt(n, text):
   """Encrypt text with Caesar cypher with rotation n."""

   es = ""

   for c in text:
      if (c >= "A") and (c <= "Z"):
         b = ord("A")
      elif (c >= "a") and (c <= "z"):
         b = ord("a")

      es += chr(((ord(c) - b + n) % 26) + b)

   return es

if __name__ == '__main__':
   if len(sys.argv) < 3:
      print "Usage: " + sys.argv[0] + " n text"
   else:
      print encrypt(int(sys.argv[1]), sys.argv[2])
