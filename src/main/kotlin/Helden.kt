open class Helden(zwerg: Zwerg,ork: Ork,barde: Barde,boss: Boss){

    private val ork = Ork()
    private val barde = Barde()
    private val zwerg = Zwerg()
    private val boss = Boss()
    var bossHelfer = Bosshelfer()


    fun kampf(){
    while (boss.hp >= 0) {
        zwerg.kampfMenuZwerg(zwerg, boss)
        ork.kampfMenuOrk(ork, boss)
        barde.kampfMenuBarde(ork, zwerg, barde, boss)
        boss.kampfMenuBoss(ork, zwerg, barde, boss)
    }

}


}