package com.elemica.boom

case class ThisIsBoom2(thing: String)

class DoTheBoom2 {
  def boomItOut = {
    println((new DoTheBoom2).getClass.getClassLoader)
    println(Thread.currentThread.getContextClassLoader)
    Thread.currentThread.getContextClassLoader.loadClass("com.elemica.boom.ThisIsBoom2")
    Class
      .forName("com.elemica.boom.ThisIsBoom2")
      .getConstructor(classOf[String])
      .newInstance("boom")
  }
}