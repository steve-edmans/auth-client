import PlayCrossCompilation._
import sbt._

private object BuildDependencies {

  val compile: Seq[ModuleID] = dependencies(
    shared = Seq("com.iheart" %% "ficus" % "1.4.7",
      "org.julienrf" %% "play-json-derived-codecs" % "6.0.0",
      "ai.x" %% "play-json-extensions" % "0.40.2"
    ),
    play25 = Seq("uk.gov.hmrc" %% "http-verbs-play-25" % "10.11.0" % Provided),
    play26 = Seq("uk.gov.hmrc" %% "http-verbs-play-26" % "10.11.0" % Provided),
    play27 = Seq("uk.gov.hmrc" %% "http-verbs-play-27" % "10.11.0" % Provided)
  )

  val test: Seq[ModuleID] = dependencies(
    shared = Seq("org.pegdown" % "pegdown" % "1.6.0" % Test,
                 "org.mockito" % "mockito-core" % "2.10.0" % Test,
                 "org.scalamock" %% "scalamock" % "4.4.0" % Test
    ),
    play25 = Seq("org.scalatestplus.play" %% "scalatestplus-play" % "2.0.1" % Test),
    play26 = Seq("org.scalatestplus.play" %% "scalatestplus-play" % "3.1.3" % Test),
    play27 = Seq("org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test)
  )

  def apply(): Seq[ModuleID] = compile ++ test
}
