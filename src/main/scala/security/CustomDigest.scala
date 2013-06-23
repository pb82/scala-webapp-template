package security

import java.security.MessageDigest
import sun.misc.BASE64Encoder

/**
 * Created with IntelliJ IDEA.
 * User: peter
 * Date: 23.06.13
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
object CustomDigest {
  private val digester = MessageDigest.getInstance("SHA-256")
  private val encoder = new BASE64Encoder
  def digest(word: String) = encoder encode (digester digest word.toString.getBytes)
  def apply(word: String) = digest(word)
}