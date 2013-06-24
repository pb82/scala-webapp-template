package controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping}
import org.springframework.security.access.prepost.PreAuthorize

/**
 * Created with IntelliJ IDEA.
 * Date: 15.06.13
 * Time: 16:12
 */

@Controller
class HomeController {
  @PreAuthorize("isFullyAuthenticated()")
  @RequestMapping(Array("/"))
  def home() = "index"
}
