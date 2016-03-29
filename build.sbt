import org.nlogo.build.NetLogoExtension.autoImport._

enablePlugins(org.nlogo.build.NetLogoExtension)

scalaVersion := "2.10.0"

netLogoVersion := "5.3.1"

netLogoExtName      := "rungekuta"

netLogoClassManager := "RungeKutaExtension"

netLogoZipSources   := false

scalaSource in Compile := baseDirectory.value / "src"

netLogoTarget :=
  org.nlogo.build.NetLogoExtension.directoryTarget(baseDirectory.value)

