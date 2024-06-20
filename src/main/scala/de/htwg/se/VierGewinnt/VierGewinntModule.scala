package de.htwg.se.VierGewinnt

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import de.htwg.se.VierGewinnt.controller.controllerComponent.{ControllerInterface, controllerBaseImpl}
import de.htwg.se.VierGewinnt.model.gridComponent.GridInterface
import de.htwg.se.VierGewinnt.model.gridComponent.gridBaseImpl.{Chip, Grid}
import de.htwg.se.VierGewinnt.model.playerComponent.playerBaseImpl
import de.htwg.se.VierGewinnt.model.playgroundComponent.PlaygroundInterface
import de.htwg.se.VierGewinnt.model.playgroundComponent.playgroundBaseImpl._
import net.codingwell.scalaguice.ScalaModule

class VierGewinntModule extends AbstractModule {
  override def configure(): Unit =
    bind(classOf[ControllerInterface]).to(classOf[controllerBaseImpl.Controller])

    bind(classOf[PlaygroundInterface]).annotatedWith(Names.named("DefaultPlayground")).toInstance(new PlaygroundPvP())
    bind(classOf[Int]).annotatedWith(Names.named("DefaultGameType")).toInstance(0)

}
