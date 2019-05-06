package com.asyaminor.visitor

import java.util.Date

import com.asyaminor.json._

sealed trait Visitor {
  def id: String
  def createdAt: Date
  def age: Long = new Date().getTime() - createdAt.getTime()
}

final case class Anonymous(
                            id: String,
                            createdAt: Date = new Date()
                          ) extends Visitor

final case class User(
                       id: String,
                       email: String,
                       createdAt: Date = new Date()
                     ) extends Visitor

object Visitor {
  implicit object AnonymousWriter extends JsWriter[Anonymous] {
    override def write(a: Anonymous): JsValue = JsObject(Map("id" -> JsString(a.id), "createdAt" -> JsString(a.createdAt.toString)))
  }

  implicit object UserWriter extends JsWriter[User] {
    override def write(u: User): JsValue = JsObject(Map(
      "id" -> JsString(u.id),
      "email" -> JsString(u.email),
      "createdAt" -> JsString(u.createdAt.toString)
    ))
  }

  implicit object VisitorWriter extends JsWriter[Visitor] {
    def write(value: Visitor) = value match {
      case anon: Anonymous => JsUtil.toJson(anon)
      case user: User      => JsUtil.toJson(user)
    }
  }
}