package controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{ResponseBody, RequestMapping}
import org.springframework.ui.Model
import org.springframework.web.servlet.ModelAndView

/**
 * Created with IntelliJ IDEA.
 * Date: 15.06.13
 * Time: 16:12
 */

@Controller
class HomeController {
  @RequestMapping(Array("/"))
  def home(): String = "index"
}
