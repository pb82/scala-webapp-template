package controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{ResponseBody, RequestMethod, RequestMapping}
import org.springframework.security.access.prepost.PreAuthorize
import model.User
import org.springframework.transaction.annotation.Transactional
import javax.persistence.{EntityManager, PersistenceContext}
import scala.collection.JavaConversions._

/**
 * Created with IntelliJ IDEA.
 * Date: 15.06.13
 * Time: 16:12
 */

@Controller
class HomeController {
  @PersistenceContext
  private val em: EntityManager = null

  @PreAuthorize("isFullyAuthenticated()")
  @RequestMapping(Array("/"))
  def home() = "index"

  @ResponseBody
  @PreAuthorize("isFullyAuthenticated()")
  @RequestMapping(value= Array("/users"), method = Array(RequestMethod.GET))
  def users() = {
    val users = em.createQuery("Select u from User u", classOf[User]).getResultList
    <ul>
      {for (user <- users) yield <li>{user.toString}</li>}
    </ul>.toString
  }
}
