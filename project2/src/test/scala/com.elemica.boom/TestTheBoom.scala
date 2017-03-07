package com.elemica.boom

import org.specs2._
  import mutable.Specification

class TestTheBoom extends Specification {
  "DoTheBoom" should {
    "create a ThisIsBoom2" in {
      (new DoTheBoom2).boomItOut must_== ThisIsBoom2("boom")
    }
  }
}