package days

class Day2 : Day(2) {
    override fun partOne(): Any {
        var depth = 0
        var horizonal = 0
        inputList
            .map {
                val split = it.split(" ")
                Pair(split[0], Integer.parseInt(split[1]))
            }
            .forEach { direction ->
                when (direction.first[0]) {
                    'u' -> depth -= direction.second
                    'd' -> depth += direction.second
                    'f' -> horizonal += direction.second
                }
            }
        return depth * horizonal
    }

    override fun partTwo(): Any {
        var depth = 0
        var horizonal = 0
        var aim = 0
        inputList
            .map {
                val split = it.split(" ")
                Pair(split[0], Integer.parseInt(split[1]))
            }
            .forEach { direction ->
                when (direction.first[0]) {
                    'u' -> aim -= direction.second
                    'd' -> aim += direction.second
                    'f' -> {
                        horizonal += direction.second
                        depth += aim * direction.second
                    }
                }
            }
        return depth * horizonal
    }
}