open class Boss(var name: String= "Fluffi",
                var hp: Int= 720,
                var schaden: IntRange= 40..80){

    fun kampfSchreiBoss(){
        println("Ich $name bin Euer Tank und für den Kampf bereit Grrrr!")
    }

    fun angreifen(ork: Ork) {
        val schaden = schaden.random()
        ork.hp -= schaden
        println("$name greift ${ork.name} an und verursacht $schaden Schaden!")
        if (ork.hp <= 0) {
            println("Der Ork wurde besiegt!")
        }
    }
}

