package init

import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import com.typesafe.scalalogging.log4j.Logger
import org.apache.logging.log4j.LogManager

/**
 * Created with IntelliJ IDEA.
 * Date: 24.06.13
 * Time: 23:34
 */
class ApplicationStartup extends ApplicationListener[ContextRefreshedEvent] {
  private val logger = Logger(LogManager getLogger classOf[ApplicationStartup])

  def onApplicationEvent(p1: ContextRefreshedEvent) {
    logger debug s"--- ${p1.getApplicationContext.getDisplayName} started ---"
  }
}
