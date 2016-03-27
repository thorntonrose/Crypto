import sys
import string

def rot(s):
   map = string.maketrans(string.ascii_uppercase + string.ascii_lowercase,
      "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm")
   return s.translate(map)

if __name__ == '__main__':
   print rot(sys.argv[1])

# Note: Could also do this:
#
# import caesar
# print caesar.encrypt_text(13, sys.argv[1])
