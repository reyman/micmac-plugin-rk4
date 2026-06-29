import org.nlogo.build.NetLogoExtension

enablePlugins(NetLogoExtension)

scalaVersion := "3.7.0"

netLogoVersion := "7.0.2"

netLogoExtName      := "rungekuta"

netLogoClassManager := "org.netlogo.extension.rungeKuta.RungeKutaExtension"

scalaSource in Compile := baseDirectory.value / "src"

netLogoTarget :=
  org.nlogo.build.NetLogoExtension.directoryTarget(baseDirectory.value)

