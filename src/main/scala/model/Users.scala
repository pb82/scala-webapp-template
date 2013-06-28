package model

import scala.slick.driver.SQLiteDriver.simple._
import scala.slick.lifted.ColumnBase

/**
 * Created with IntelliJ IDEA.
 * Date: 25.06.13
 * Time: 21:03
 */
object Users extends Table[(Int, String, String)]("Users") {
  def id = column[Int]("ID", O.PrimaryKey)
  def first_name = column[String]("FIRST_NAME")
  def last_name = column[String]("LAST_NAME")

  def * : ColumnBase[(Int, String, String)] = id ~ first_name ~ last_name
}
