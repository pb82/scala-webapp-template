package security

import org.springframework.security.core.userdetails.{UserDetails, UserDetailsService}
import java.util
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import collection.JavaConversions._

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
        val md = java.security.MessageDigest.getInstance("SHA-256")
        val buffer = new StringBuffer()
        md.digest("gabba".getBytes) map(
          (f: Byte) => buffer.append(Integer.toString((f & 0xff) + 0x100, 16).substring(1))
        )
        buffer.toString
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
