package design_patterns

// CreationalPattern
// FactoryMethodPattern
// In class-based programming, the factory method pattern is a creational pattern that uses factory methods to deal with the problem of creating objects without having to specify the exact class of the object that will be created.
// This is done by creating objects by calling a factory method—either specified in an interface and implemented by child classes, or implemented in a base class and optionally overridden by derived classes—rather than by calling a constructor.
// This design pattern deals with the creation of objects without explicitly specifying the actual class that the instance will have—it could be something that is decided at runtime based on many factors. Some of these factors can include operating systems, different data types, or input parameters.
// It gives developers the peace of mind of just calling a method rather than invoking a concrete constructor.

import java.util

trait Room {
  def connect(r: Room): Room
}

class MagicRoom extends Room {
  def connect(r: Room): Room = this
}

class OrdinaryRoom extends Room {
  def connect(r: Room): Room = this
}

abstract class MazeGame() {
  final private val rooms = new util.ArrayList[Room]

  val room1: Room = makeRoom
  val room2: Room = makeRoom
  room1.connect(room2)
  rooms.add(room1)
  rooms.add(room2)
  protected def makeRoom: Room
}

class MagicMazeGame() extends MazeGame {
  override protected def makeRoom: Room = new MagicRoom
}

class OrdinaryMazeGame() extends MazeGame {
  override protected def makeRoom: Room = new OrdinaryRoom
}

object FactoryMethodPattern extends App {
  val ordinaryMazeGame = new OrdinaryMazeGame()
}
