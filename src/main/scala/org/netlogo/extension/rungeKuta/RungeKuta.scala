package org.netlogo.extension.rungeKuta

import org.nlogo.api._
import scala.Array
import org.nlogo.api.Syntax._
import org.nlogo.api.ScalaConversions._

class RungeKuta extends DefaultReporter {

  override def getSyntax(): Syntax =
  Syntax.reporterSyntax(Array(NumberType, NumberType, NumberType, NumberType, NumberType, NumberType, NumberType, NumberType, NumberType, NumberType, NumberType), ListType)

  @throws(classOf[ExtensionException])
  @throws(classOf[LogoException])
  override def report(args: Array[Argument], context: Context) =
  {
    val S = args.apply(0).getDoubleValue
    val I = args.apply(1).getDoubleValue
    val R = args.apply(2).getDoubleValue

    val alpha = args.apply(3).getDoubleValue
    val beta = args.apply(4).getDoubleValue
    val gamma = args.apply(5).getDoubleValue

    val b = args.apply(6).getDoubleValue
    val d1 = args.apply(7).getDoubleValue
    val d2 = args.apply(8).getDoubleValue

    val n = args.apply(9).getDoubleValue

    val h = args.apply(10).getDoubleValue

    rungeKuta4( Array(S,I,R), alpha, beta, gamma, b, d1, d2, n, h).toLogoList
  }

  def rungeKuta4(init:Array[Double], alpha: Double, beta: Double, gamma :Double, b:Double, d1:Double, d2:Double, n: Double, h:Double):Array[Double] = {

  val temp = init

   val Q1 = SIR(temp,alpha,beta, gamma, b, d1, d2,n)

   var sir = (temp zip Q1).map{
     case (t,q1) =>
    t + (h / 2.0) * q1
   }

   val Q2 = SIR(sir, alpha, beta,gamma, b, d1, d2, n)

    sir = (temp zip Q2).map {
      case (t, q2) =>
        t + (h / 2.0) * q2
    }

    val Q3 = SIR(sir, alpha, beta,gamma, b, d1, d2, n)

    sir = (temp zip Q3).map {
      case (t, q3) =>
        t + h * q3
    }

    val Q4 = SIR(sir, alpha, beta,gamma, b, d1, d2, n)

    for (i <- 0 to 2) {
      sir(i) = temp(i) + (h / 6.0) * (Q1(i) + 2.0 * Q2(i) + 2.0 * Q3(i) + Q4(i))
    }

    sir
  }

  def SIR(sir:Array[Double],alpha:Double,beta:Double, gamma:Double, b: Double, d1:Double, d2:Double, n:Double):Array[Double]= {
    val ds = (- beta * sir(0) * sir(1) / n) + (gamma * sir(2)) + (b * n)  - (d1 * sir(0))
    val di = (beta * sir(0) * sir(1) / n) - (alpha * sir(1))  - (d2 * sir(1))
    val dr = (alpha * sir(1)) - (gamma * sir(2)) - (d1 * sir(2))
    Array(ds,di,dr)
  }

}
