package init

import com.typesafe.scalalogging.log4j.Logger
import org.apache.logging.log4j.LogManager
import javax.servlet.{ServletContextEvent, ServletContextListener}
import scala.slick.driver.SQLiteDriver.simple._
import scala.slick.session.Database.threadLocalSession
import scala.slick.session.Database
import model.Users

/**
 * Created with IntelliJ IDEA.
 * Date: 24.06.13
 * Time: 23:34
 */
class ApplicationStartup extends ServletContextListener {
  private val logger = Logger(LogManager getLogger classOf[ApplicationStartup])

  def contextInitialized(sce: ServletContextEvent) {
    Database.forURL("jdbc:sqlite:src/main/resources/sample.db", driver="org.sqlite.JDBC") withSession {
      Users.ddl create
    }

    logger debug "--- Application started ---"
  }

  def contextDestroyed(sce: ServletContextEvent) {
    logger debug "--- Application stopped ---"
  }
}
