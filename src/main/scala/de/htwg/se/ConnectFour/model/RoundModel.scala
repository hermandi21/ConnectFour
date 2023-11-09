package de.htwg.se.ConnectFour.model

case class RoundModel(columnIndex:Int, matchfield: MatchfieldModel[PlayerModel], player: PlayerModel)
