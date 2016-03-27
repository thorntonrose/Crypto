def encrypt(n, text)
   es = ""

   text.scan(/./) { |c|
      if c =~ /[A-Z]/ then
         b = "A"[0]
      elsif c =~ /[a-z]/ then
         b = "a"[0]
      end

      es << (((c[0] - b + n) % 26) + b)
   }

   return es
end

if ARGV.length < 2 then
   puts "Usage: ruby " + $0 + " n text"
else
   puts encrypt(ARGV[0].to_i(), ARGV[1])
end
