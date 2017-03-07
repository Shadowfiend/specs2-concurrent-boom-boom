package com.elemica.boom

import org.specs2._
  import mutable.Specification

class TestTheBoom extends Specification {
  "DoTheBoom" should {
    "create a ThisIsBoom" in {
      (new DoTheBoom).boomItOut must_== ThisIsBoom("boom")
    }
  }
}