package days

class Day1 : Day(1) {

    override fun partOne(): Any {
        val numArray = inputList.map { Integer.parseInt(it) }

        return numArray
            .foldIndexed(0) { index, acc, number ->
                if (index == 0) acc else if (numArray[index - 1] < number) (acc + 1) else acc
            }
    }

    override fun partTwo(): Any {
        val numArray = inputList.map { Integer.parseInt(it) }
        var a = numArray[0]
        var b = numArray[1]
        var c = numArray[2]
        val answer = numArray.drop(3).fold(0) { acc, d ->
            var newAcc = acc
            if (b + c + d > a + b + c) newAcc = acc + 1
            a = b
            b = c
            c = d
            newAcc
        }
        return answer
    }
}
