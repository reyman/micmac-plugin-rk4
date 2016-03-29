/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netlogo.extension.rungeKuta

import org.nlogo.api._
import org.netlogo.extension.rungeKuta._
import org.nlogo.api.ScalaConversions._

class RungeKutaExtension extends DefaultClassManager {
   
  def load (manager:PrimitiveManager) = {
    manager.addPrimitive("compute-SIR", new RungeKuta)
  }

}
