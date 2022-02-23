class playerStatistics(var year: Int, var playerName: String, var country: String, var matches: Int, var runs: Int, var wickets: Int) {}

object playerStatistics {
  def Desc[T: Ordering]: Ordering[T] = implicitly[Ordering[T]].reverse

  def insert(year: Int, playerName: String, country: String, matches: Int, runs: Int, wickets: Int): playerStatistics = {
    val playerInfo = new playerStatistics(year, playerName, country, matches, runs, wickets)
    playerInfo
  }

  def main(args: Array[String]): Unit = {

    var players = List(insert(2021, "Sam", "India", 23, 2300, 3))
    players = players :+ insert(2021, "Ram", "India", 23, 300, 30)
    players = players :+ insert(2021, "Mano", "India", 23, 300, 13)
    players = players :+ insert(2019, "MS Dhoni", "India", 26, 3220, 27)
    players = players :+ insert(2018, "Brendon McCullum", "New Zealand", 25, 2200, 18)
    players = players :+ insert(2014, "Virat Kohli", "India", 32, 22300, 24)
    players = players :+ insert(2018, "Adam Gilchrist", "Australia", 27, 3200, 23)
    players = players :+ insert(2020, "Ben Stokes", "England", 28, 2700, 28)


    print("1. Player with the best highest run scored --> ")
    val playerWithHighestRun = players.sortBy(x => x.runs).reverse
    print(playerWithHighestRun.head.playerName)


    println("\n2. Top 5 players by run scored -- ")
    for (player <- playerWithHighestRun.take(5)) {
      print(player.playerName+" ")
    }


    println("\n3. Top 5 players by wicket taken -- ")
    val playerWithHighestWickets = players.sortBy(x => x.wickets).reverse
    for (player <- playerWithHighestWickets.take(5)) {
      print(player.playerName + " ")
    }


    println("\n4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored -- ")
    players = players.sortBy(x => x.wickets * 5).sortBy(x => x.runs * 0.05).reverse
    var cnt: Int = 1
    for (player <- players) {
      println(s"Rank $cnt --> " + player.playerName)
      cnt += 1
    }
  }
}

