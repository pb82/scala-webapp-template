package controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{ResponseBody, RequestMapping}
import org.springframework.ui.Model

/**
 * Created with IntelliJ IDEA.
 * User: peter
 * Date: 15.06.13
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */

@Controller
class HomeController {
  @ResponseBody
  @RequestMapping(Array("/"))
  def home(): String = {
    return "Hello from Scala & Spring"
  }
}
