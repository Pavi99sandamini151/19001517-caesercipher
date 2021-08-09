object CiserCipher {
val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
val E=(c:Char,key:Int,a:String)=> a((a.indexOf(c.toUpper)+key)%a.size)
//val D: (Char, Int, String) => Char = (c: Char, key: Int, a: String) => a((a.indexOf(c.toUpper) - key) % a.length)
val D=(c:Char,key:Int,a:String)=> a(if((a.indexOf(c.toUpper)-key)%a.size >=0) 
      (a.indexOf(c.toUpper)-key)%a.size else a.size+(a.indexOf(c.toUpper)-key)%a.size)
val cipher: ((Char, Int, String) => Char, String, Int, String) => String = (algo: (Char, Int, String) =>
    Char, s: String, key: Int, a: String) =>
    s.map(algo(_, key, a))

def main(args: Array[String]): Unit = {
   println("Caeser cipher")
   println("enter 1 to encrypt")
   val choice = scala.io.StdIn.readInt()
   if(choice == 1)
    {
        println("Enter the key value: ")
        val b = scala.io.StdIn.readInt()
        println("Enter the string to Encrypt")
        val s=scala.io.StdIn.readLine()
        val ct: String = cipher(E, s, b, alphabet)
        println("String after encrypted: " + ct)
        val pt: String = cipher(D, ct, b, alphabet)
        println("string after decrypted: " + pt)
    } 
  }
}