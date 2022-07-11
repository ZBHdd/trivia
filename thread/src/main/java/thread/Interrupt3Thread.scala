package thread

import scala.runtime.BoxedUnit

object Interrupt3Thread {
  val list = List("apples", "oranges", "pears")
  val threadLocal = new ThreadLocal()
  def testMap(num: java.lang.Long): Unit = {
    list.map { l =>
      if(threadLocal.get() == null){
        InterruptThread.test(num)
      }
      l
    }.reduce(_.union(_))
  }
}