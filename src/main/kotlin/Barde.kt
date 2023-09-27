class Barde (var name: String= "Morgan",
             var hp: Int= 200,
             var schaden: IntRange=8..15){

    fun kampfSchrei(){
        println("Ich $name bin Heiler und  werde meine Leute unterstützen!")
    }

    //var alleHeilen: angriffe= angriffe("Alle Heilen",0..0,200,0)

    fun alleHeilen(ork: Ork,zwerg: Zwerg,barde: Barde){
        val heilung = alleHeilen.heilung
        println("$name hat noch $hp Lebenspunkte und heilt sich, heilt ${ork.name} und ${zwerg.name} um $heilung Lebenspunkte.")
        ork.hp += heilung
        zwerg.hp += heilung
        barde.hp += heilung

        if (ork.hp >= 500){
            ork.hp = 500
            println("${ork.name} hat wieder volle Lebenspunkte.")
        }
        if (zwerg.hp >= 350){
            ork.hp = 350
            println("${zwerg.name} hat wieder volle Lebenspunkte.")
        }
        if (barde.hp >= 200){
            barde.hp = 200
            println("$name hat wieder volle Lebenspunkte.")
        }
        println("$name hat jetzt wieder $hp Lebenspunkte.")
        println("${ork.name} hat jetzt wieder ${ork.hp} Lebenspunkte.")
        println("${zwerg.name} hat jetzt wieder ${zwerg.hp} Lebenspunkte.")
    }


    //var angriffBarde: angriffe= angriffe("Normaler Angriff",8..15,0,0)

    fun angriffBarde(boss: Boss){
        val schaden = angriffBarde.schaden.random()
        boss.hp -= schaden
        println("$name greift ${boss.name} mit *${angriffBarde.name}* an und hat ihm $schaden zugefügt.")
        println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
        if (boss.hp <= 0){
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

    //var selbstHeilungBarde: angriffe= angriffe("Selbst Heilen",0..0,150,0)

    fun selbstHeilungBarde(barde: Barde){
        val heilung = selbstHeilungBarde.heilung
        barde.hp += heilung
        println("$name heilt sich um $heilung Lebenspunkte.")
        if (barde.hp >= 200){
            barde.hp = 200
            println("$name hat wieder volle Lebenspunkte.")
        }
        println("$name hat noch $hp Lebenspunkte.")
    }

    //var alleSchilden: angriffe= angriffe("Alle Schilden",0..0,0,80)

    fun alleSchilden(barde: Barde,ork: Ork,zwerg: Zwerg){
        val schild = alleSchilden.schild
        barde.hp += schild
        ork.hp += schild
        zwerg.hp += schild
        println("Alle Gruppen Mitglieder wurden geschildet.")
    }

    fun kampfMenuBarde(ork: Ork,zwerg: Zwerg,barde: Barde,boss: Boss){
        println("Mit welcher Attacke soll ${barde.name} angreifen?")
        println("""
            1 -> Alle heilen
            2 -> Normaler Angriff
            3 -> Selbst Heilung
            4 -> Alle schilden
        """.trimIndent())

        val eingabe: String = readln()

        when(eingabe){
            "1" -> {
                alleHeilen(ork, zwerg, barde)
                }
            "2" -> {
                angriffBarde(boss)
                }
            "3" -> {
                selbstHeilungBarde(barde)
                }
            "4" -> {
                alleSchilden(barde,ork,zwerg)
                }
        }
    }

}
