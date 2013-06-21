package security

import org.springframework.security.authentication.{UsernamePasswordAuthenticationToken, AuthenticationProvider}
import org.springframework.security.core.Authentication

/**
 * Created with IntelliJ IDEA.
 * Date: 20.06.13
 * Time: 01:05
 */
class AuthProvider extends AuthenticationProvider {
  def supports(p1: Class[_]): Boolean = true
  def authenticate(auth: Authentication): Authentication = auth
}
