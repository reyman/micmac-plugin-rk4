import org.nlogo.build.NetLogoExtension.autoImport._

enablePlugins(org.nlogo.build.NetLogoExtension)

scalaVersion := "2.12.0"

netLogoVersion := "6.0.1-RC1"

netLogoExtName      := "rungekuta"

netLogoClassManager := "RungeKutaExtension"

netLogoZipSources   := false

scalaSource in Compile := baseDirectory.value / "src"

netLogoTarget :=
  org.nlogo.build.NetLogoExtension.directoryTarget(baseDirectory.value)

