package model.playerComponent

trait PlayerInterface:
    def getChip(): Chip
    def getName(): String
    def getHumanPlayer(name: String, chip: Chip): PlayerInterface = new HumansPlayer(name, chip)
    def getBotPlayer(name: String, chip: Chip): PlayerInterface = new BotPlayer(name, chip)
    
