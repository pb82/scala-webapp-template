package security

import org.springframework.security.core.userdetails.{UserDetails, UserDetailsService}
import java.util
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import collection.JavaConversions._
import java.security.MessageDigest
import sun.misc.BASE64Encoder

/**
 * Created with IntelliJ IDEA.
 * User: peter
 * Date: 23.06.13
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 */
class UserService extends UserDetailsService {
  def loadUserByUsername(userName: String): UserDetails = {
    new UserDetails {
      def isEnabled: Boolean = true
      def getPassword: String = {
        val md = MessageDigest.getInstance("SHA-256")
        val bytes = md.digest("fluffy".toString.getBytes)
        new BASE64Encoder().encode(bytes)
      }
      def isAccountNonExpired: Boolean = true
      def isCredentialsNonExpired: Boolean = true
      def getAuthorities: util.Collection[_ <: GrantedAuthority] = {
        List[SimpleGrantedAuthority](new SimpleGrantedAuthority("ROLE_USER"))
      }

      def isAccountNonLocked: Boolean = true
      def getUsername: String = userName
    }
  }
}
