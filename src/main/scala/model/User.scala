package model

import javax.persistence._

/**
 * Created with IntelliJ IDEA.
 * User: peter
 * Date: 30.06.13
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  var Id: Int = _

  @Column(name="First_Name")
  var firstName: String = _

  @Column(name="Last_Name")
  var lastName: String = _

  @Column(name="User_Name")
  var userName: String = _

  @Column(name="Password")
  var password: String = _

  override def toString() = s"${firstName}, ${lastName}"
}
