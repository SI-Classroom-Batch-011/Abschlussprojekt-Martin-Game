fun main() {
    val spiel : Boolean = (ork.hp >= 0 && barde.hp >= 0 && zwerg.hp >= 0 && boss.hp >= 360)
    val bossTod : Boolean = (boss.hp >= 0)
    val helferBoss : Boolean = (bossHelfer.hp >= 0)


    gameBegin()
    while (spiel){
        ork.kampfMenuOrk(ork, boss, helden = ork,bossHelfer)
        zwerg.kampfMenuZwerg(zwerg,boss,bossHelfer, helden = zwerg)
        barde.kampfMenuBarde(ork, zwerg, barde, boss, helden = barde,bossHelfer)
        if ( boss.hp >= 0 ){
            boss.kampfMenuBoss(HeldenListe,boss)
             while (boss.hp <= 360 && helferBoss){
                ork.kampfMenuOrk(ork,boss, helden = zwerg,bossHelfer)
                zwerg.kampfMenuZwerg(zwerg,boss,bossHelfer, helden = zwerg)
                barde.kampfMenuBarde(ork,zwerg,barde,boss, helden = barde,bossHelfer)
                bossHelfer.kampfMenuBossHelfer(HeldenListe,bossHelfer)
                if (bossHelfer.hp <= 0){
                    bossHelfer.hp = 0
                    println("${bossHelfer.name} wurde besiegt!")
                }
            }
        }else{
            println("Gewonnen")
            break
        }

    }


}