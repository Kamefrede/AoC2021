package days

class Day3 : Day(3) {
    override fun partOne(): Any {
        val bitCount = getBitCount(inputList)
        val (epsilon, gamma) = getGammaEpsilon(bitCount)
        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
    }

    override fun partTwo(): Any {
        val co2 = mostCommon(inputList, 0, false)
        val oxygen = mostCommon(inputList, 0, true)
        return Integer.parseInt(co2, 2) * Integer.parseInt(oxygen, 2)
    }

    private fun getBitCount(inputList: List<String>): Array<IntArray> {
        val bitCount = Array(2) {IntArray(inputList[0].length)}
        inputList.forEach { bits ->
            bits.forEachIndexed { index, bit ->
                if (bit == '1') bitCount[1][index] = bitCount[1][index] + 1
                else bitCount[0][index] = bitCount[0][index] + 1
            }
        }
        return bitCount
    }

    private fun mostCommon(list: List<String>, idxToCheck: Int, mostCommon: Boolean): String {
        if(list.size == 1) return list[0]
        val bitCount = getBitCount(list)
        var toCheckAgainst = ""

        bitCount[1].zip(bitCount[0]) { oneCount, zeroCount ->
            if(oneCount == zeroCount) {
                toCheckAgainst += if (mostCommon) '1' else '0'
                return@zip
            }

            toCheckAgainst += if(oneCount > zeroCount) {
                if (mostCommon)
                    '1'
                else
                    '0'
            } else {
                if (mostCommon)
                    '0'
                else
                    '1'
            }
        }

        val newList = list.filter { it[idxToCheck] == toCheckAgainst[idxToCheck] }
        return mostCommon(newList, idxToCheck + 1, mostCommon)
    }

    private fun getGammaEpsilon(bitCount: Array<IntArray>): Pair<String, String> {
        var epsilon = ""
        var gamma = ""
        bitCount[1].zip(bitCount[0]) { oneCount, zeroCount ->
            if (oneCount > zeroCount) {
                gamma += '1'
                epsilon += '0'
            } else {
                gamma += '0'
                epsilon += '1'
            }
        }
        return Pair(epsilon, gamma)
    }
}