open class Boss(var name: String= "Fluffi",
                var hp: Int= 720,
                var schaden: IntRange= 40..80){

    fun kampfSchreiBoss(){
        println("Ich $name bin Euer Tank und für den Kampf bereit Grrrr!")
    }

    fun angreifen(ork: Ork,barde: Barde,zwerg: Zwerg) {
        val helden = listOf(ork,barde,zwerg)
        val zufälligerHeld = helden.random()
        val schaden = bissEinZiel.schaden.random()
        if (zufälligerHeld==ork){
            ork.hp -= schaden
            println("$name greift ${ork.name} an und verursacht $schaden Schaden!")
            if (ork.hp <= 0) {
                println("Der ${ork.name} wurde besiegt!")
            }
        }
        if (zufälligerHeld==barde) {
            barde.hp -= schaden
            println("$name greift ${barde.name} an und verursacht $schaden Schaden!")
            if (barde.hp <= 0) {
                println("Der ${barde.name} wurde besiegt!")
            }
        }
        if (zufälligerHeld==zwerg) {
            zwerg.hp -= schaden
            println("$name greift ${zwerg.name} an und verursacht $schaden Schaden!")
            if (zwerg.hp <= 0) {
                println("Der ${zwerg.name} wurde besiegt!")
            }
        }
    }


    //var bissAlleZiele:angriffe= angriffe("Biss alle Ziele",30..40,0,0)
    fun bissAlleZiele(ork: Ork,zwerg: Zwerg,barde: Barde){
        val schaden = bissAlleZiele.schaden.random()
        ork.hp -= schaden
        barde.hp -= schaden
        zwerg.hp -= schaden
        println("$name hat allen Helden mit ${bissAlleZiele.name} $schaden Schaden zugefügt.")
        if (ork.hp <= 0) {
            println("Der ${ork.name} wurde besiegt!")
        }
        if (barde.hp <= 0) {
            println("Der ${barde.name} wurde besiegt!")
        }
        if (zwerg.hp <= 0) {
            println("Der ${zwerg.name} wurde besiegt!")
        }
    }

    //var stampfen:angriffe= angriffe("Stampfen",15..20,0,0)
    fun stampfen(ork: Ork,zwerg: Zwerg,barde: Barde){
        val schaden = stampfen.schaden.random()
        ork.hp -= schaden
        barde.hp -= schaden
        zwerg.hp -= schaden
        println("$name hat allen Helden mit ${stampfen.name} $schaden Schaden zugefügt.")
        if (ork.hp <= 0) {
            println("Der ${ork.name} wurde besiegt!")
        }
        if (barde.hp <= 0) {
            println("Der ${barde.name} wurde besiegt!")
        }
        if (zwerg.hp <= 0) {
            println("Der ${zwerg.name} wurde besiegt!")
        }
    }

    //var rutenHieb:angriffe= angriffe("Rutenhieb",40..60,0,0)

    fun rutenHieb(ork: Ork,zwerg: Zwerg,barde: Barde){
        val schaden = rutenHieb.schaden.random()
        ork.hp -= schaden
        barde.hp -= schaden
        zwerg.hp -= schaden
        println("$name hat allen Helden mit ${rutenHieb.name} $schaden Schaden zugefügt.")
        if (ork.hp <= 0) {
            println("Der ${ork.name} wurde besiegt!")
        }
        if (barde.hp <= 0) {
            println("Der ${barde.name} wurde besiegt!")
        }
        if (zwerg.hp <= 0) {
            println("Der ${zwerg.name} wurde besiegt!")
        }
    }

    //var heilen:angriffe= angriffe("Heilung",0..0,100,0)
    fun heilen(boss: Boss){
        val heilung = heilen.heilung
        boss.hp += heilung

        if (boss.hp >= 720){
            boss.hp = 720
            println("${boss.name} hat wieder volle Lebenspunkte.")
        }
        println("${boss.name} heilt sich um $heilung und hat wieder ${boss.hp} Lebenspunkte.")
    }

    fun heulerBoss(ork: Ork, barde: Barde, zwerg: Zwerg) {
        val helden = listOf(ork, barde, zwerg)
        val zufälligerHeld = helden.random()
       // val schaden = heuler.schaden.random()
        if (zufälligerHeld==ork){
            var orkHp = ork.hp
            val prozentAbzug = 0.1
            while (orkHp > ork.hp * 0.2){
                val schaden = (orkHp * prozentAbzug).toInt()
                orkHp -= schaden
                if (orkHp <= 0){
                    println("${ork.name} wurde besiegt.")
                }else{
                    println("${ork.name} hat $schaden Schaden erlitten und hat noch $orkHp Lebenspunkte.")
                }
            }
        }
        if (zufälligerHeld==barde) {
            while (barde.hp > (barde.hp * 0.2)){
                val schaden = (barde.hp * 0.1).toInt()
                barde.hp -= schaden
                println("$name greift ${barde.name} an und verursacht $schaden Schaden!")
                if (barde.hp <= 0) {
                    println("Der ${barde.name} wurde besiegt!")
                }
            }

        }
        if (zufälligerHeld==zwerg) {
            while (zwerg.hp > (zwerg.hp * 0.2)){
                val schaden = (zwerg.hp * 0.1).toInt()
                zwerg.hp -= schaden
                println("$name greift ${zwerg.name} an und verursacht $schaden Schaden!")
                if (zwerg.hp <= 0) {
                    println("Der ${zwerg.name} wurde besiegt!")
                }
            }

        }
    }

    fun kampfMenuBoss(ork: Ork,zwerg: Zwerg,barde: Barde,boss: Boss){
        val zufall = (0..4).random()

        when(zufall){
            0 -> boss.angreifen(ork, barde, zwerg)
            1 -> boss.bissAlleZiele(ork, zwerg, barde)
            2 -> boss.stampfen(ork, zwerg, barde)
            3 -> boss.rutenHieb(ork, zwerg, barde)
            4 -> boss.heilen(boss)
        }
    }
}

