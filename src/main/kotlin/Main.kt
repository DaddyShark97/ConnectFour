package connectfour

fun main() {
    println("Connect Four")
    println("First player's name:")
    val player1 = readln()

    println("Second player's name:")
    val player2 = readln()

    var rows = 6
    var columns = 7

    val regex = """(\d+)\s*[xX]\s*(\d+)""".toRegex()

    while (true) {
        print("Set the board dimensions (Rows x Columns)\nPress Enter for default ($rows x $columns)\n")
        val input = readln().trim()

        if (input.isEmpty()) {
            break
        }

        val matchResult = regex.matchEntire(input)
        if (matchResult != null) {
            val (newRowsStr, newColumnsStr) = matchResult.destructured
            val newRows = newRowsStr.toInt()
            val newColumns = newColumnsStr.toInt()

            if (newRows in 5..9 && newColumns in 5..9) {
                rows = newRows
                columns = newColumns
                break
            } else {
                if (newRows !in 5..9) {
                    println("Board rows should be from 5 to 9")
                }
                if (newColumns !in 5..9) {
                    println("Board columns should be from 5 to 9")
                }
            }
        } else {
            println("Invalid input")
        }
    }

    println("$player1 VS $player2")
    println("$rows X $columns board")


}