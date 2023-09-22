class Ork(var name: String = "Durotan",
          var hp: Int = 500,
          var schaden: IntRange= 10..25,
          var attackliste: MutableList<angriffe> = mutableListOf(angriffOrk,angriffBlock,selbstHeilung,schildStoß)
){

    fun kampfSchrei(){
        println("Ich $name bin Euer Tank und für den Kampf bereit Grrrr!")
    }


    fun angriffe(){
        println("Welchen Angriff soll ich für dich ausführen mein Meister?")
        println("""
            1 für Normaler Angriff
            2 für Angriff Block
            3 für Selbst Heilung
            4 für Schild
        """.trimIndent())
    }


    fun normalerAngriffOrk(boss: Boss){
        val schaden = schaden.random()
        boss.hp -= schaden
        println("$name greift ${boss.name} mit *${angriffOrk.name}* an und hat ihm $schaden zugefügt.")
        println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
        if (boss.hp <= 0){
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

    fun selbstHeilen(ork: Ork){
        val heilung = selbstHeilung.heilung
        println("$name hat noch $hp Lebenspunkte und heilt sich.")
        ork.hp += heilung

        if (ork.hp >= 500){
            ork.hp = 500
            println("$name hat wieder volle Lebenspunkte.")
        }
        println("$name hat jetzt wieder $hp Lebenspunkte.")

    }

    fun blocken(ork: Ork,boss: Boss){
        val bossSchaden = boss.schaden.random()
        val geblockterSchaden = (bossSchaden * 0.00)
        ork.hp -= geblockterSchaden.toInt()
        println("${ork.name} hat $geblockterSchaden von ${boss.name} bekommen.")
        println("${ork.name} hat den Angriff von ${boss.name} erfolgreich geblockt!")
    }


    fun schildStoß(boss: Boss){
        val schaden = schildStoß.schaden.random()
        boss.hp -= schaden
        println("$name hat ${boss.name} $schaden Schaden zugefügt.")
        println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
        if (boss.hp <= 0) {
            println("${boss.name} wurde besiegt...hurrah !")
        }
        if (boss.hp <= 0){
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

}
