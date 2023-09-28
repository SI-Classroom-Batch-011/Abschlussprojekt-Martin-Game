class Inventar(name: String) {

    fun heilTrankBenutzen(helden: Helden) {


        if (heilTrank > 0) {
            heilTrank--
            helden.hp += (helden.hp * 0.5).toInt()
            println("Heiltrank wurde benutzt")

        } else {
            println("Keine Heiltränke mehr vorhanden")
        }
    }


    fun vitaminePlusSchaden(helden: Helden) {
        if (vitamine > 0) {
            var int = helden.schaden.first
            var range = helden.schaden.last
            var erhoeterint = (int * 1.1).toInt()
            var erhoeterrange = (range * 1.1).toInt()
            helden.schaden = erhoeterint..erhoeterrange
            println("Vitamin wurde benutzt!")
            vitamine--
        } else {
            println("Keine Vitamine mehr vorhanden!!!")
        }
    }

    fun invKampfmenu(helden: Helden) {

        println("Was willst du aus dem Inventar benutzen?")
        println(
            """
            1 -> Heiltrank
            2 -> Vitamin
        """.trimIndent()
        )

        val input = readln().toInt()
        when (input) {
            1 -> heilTrankBenutzen(helden)
            2 -> vitaminePlusSchaden(helden)
        }
    }
}