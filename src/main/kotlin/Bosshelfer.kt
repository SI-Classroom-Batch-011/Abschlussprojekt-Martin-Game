class Bosshelfer(var name: String= "Basilisk",
                 var hp: Int= 240,
                 var schaden: IntRange= 10..20) {


    //var giftBiss:angriffe= angriffe("Gift Biss",30..40,0,0)
    fun giftBiss(barde: Barde,zwerg: Zwerg,ork: Ork){
        val giftbissSchaden = giftBiss.schaden.random()
        val giftSchaden1 = (giftbissSchaden * 0.75).toInt()
        val giftSchaden2 = (giftbissSchaden * 0.50).toInt()
        val giftSchaden3 = (giftbissSchaden * 0.25).toInt()
        val helden = listOf(ork,barde,zwerg)
        val zufälligerHeld = helden.random()
        val schaden = bissEinZiel.schaden.random()
        if (zufälligerHeld==ork){
            ork.hp -= giftSchaden1
            ork.hp -= giftSchaden2
            ork.hp -= giftSchaden3
            println("$name greift ${ork.name} an und verursacht $schaden Schaden!")
            if (ork.hp <= 0) {
                println("Der ${ork.name} wurde besiegt!")
            }
        }
        if (zufälligerHeld==barde) {
            barde.hp -= giftSchaden1
            barde.hp -= giftSchaden2
            barde.hp -= giftSchaden3
            println("$name greift ${barde.name} an und verursacht $schaden Schaden!")
            if (barde.hp <= 0) {
                println("Der ${barde.name} wurde besiegt!")
            }
        }
        if (zufälligerHeld==zwerg) {
            zwerg.hp -= giftSchaden1
            zwerg.hp -= giftSchaden2
            zwerg.hp -= giftSchaden3
            println("$name greift ${zwerg.name} an und verursacht $schaden Schaden!")
            if (zwerg.hp <= 0) {
                println("Der ${zwerg.name} wurde besiegt!")
            }
        }
    }

    //var giftSpritze:angriffe =angriffe("Gift Spritze",15..25,0,0)
    fun giftSpritze(ork: Ork,zwerg: Zwerg,barde: Barde){
        val schaden = giftSpritze.schaden.random()
        ork.hp -= schaden
        barde.hp -= schaden
        zwerg.hp -= schaden
        println("$name hat allen Helden mit ${giftSpritze.name} $schaden Schaden zugefügt.")
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

    //var kopfNuss:angriffe= angriffe("Kopfnuss",30..40,0,0)
    fun kopfNuss(zwerg: Zwerg,barde: Barde,ork: Ork){
        val schaden = kopfNuss.schaden.random()
        val helden = listOf(ork,barde,zwerg)
        val zufälligerHeld = helden.random()
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

    //var schrei:angriffe= angriffe("Schrei",0..0,0,0)
    fun schrei(bosshelfer: Bosshelfer){
        val schild = schrei.schild
        bosshelfer.hp += schild
        println("$name nutzt ${schrei.name} und erhält ein Schild von $schild Lebenspunkten.")
    }
}

