fun main() {

    val ork = Ork()
    val barde = Barde()
    val zwerg = Zwerg()
    val boss = Boss()
    var bossHelfer = Bosshelfer()



    println("-----Die tapferen Helden-----")
    println()
    Thread.sleep(2500)
    ork.kampfSchrei()
    println()
    Thread.sleep(2500)
    barde.kampfSchrei()
    println()
    Thread.sleep(2500)
    zwerg.kampfSchrei()
    println()
    Thread.sleep(2500)
    println("------------------------------")
    println()
    println("Der Endboss -> Fluffi <- ist aufgetaucht")
    Thread.sleep(2500)
    println()
    println("...ein dreiköpfiger übergroßer Hund der Hölle!!!")
    Thread.sleep(2500)
    println()
    println("Fluffi fletscht mit den Zähnen....")
    println("-------------------------------")
    Thread.sleep(2500)
    println("Fluffi macht sich kampfbereit...")
    Thread.sleep(2500)
    println("DER KAMPF BEGINNT !!!")
    println("-------------------------------")


    zwerg.kampfMenuZwerg(zwerg, boss,bossHelfer)
    ork.kampfMenuOrk(ork, boss)
    barde.kampfMenuBarde(ork, zwerg, barde, boss)
    boss.kampfMenuBoss(ork, zwerg, barde, boss)


    fun kampf(ork: Ork,zwerg: Zwerg,barde: Barde,boss: Boss,bosshelfer: Bosshelfer){
        while (boss.hp >= 0) {
            if (boss.hp <= boss.hp /2){
                println("${bosshelfer.name} wurde gerufen!!!")
                while (bossHelfer.hp > 0){
                    zwerg.kampfMenuZwerg(zwerg, bosshelfer)
                    ork.kampfMenuOrk(ork, bosshelfer)
                    barde.kampfMenuBarde(ork, zwerg, barde, boss,bosshelfer)
                    boss.kampfMenuBoss(ork, zwerg, barde, boss,bosshelfer)
                }
            }
        }

    }


}