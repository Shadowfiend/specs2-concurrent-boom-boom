package com.elemica.boom

case class ThisIsBoom(thing: String)

class DoTheBoom {
  def boomItOut = {
    println((new DoTheBoom).getClass.getClassLoader)
    println(Thread.currentThread.getContextClassLoader)
    Thread.currentThread.getContextClassLoader.loadClass("com.elemica.boom.ThisIsBoom")
    Class
      .forName("com.elemica.boom.ThisIsBoom")
      .getConstructor(classOf[String])
      .newInstance("boom")
  }
}