import gegner.Boss
import gegner.Bosshelfer
import gegner.Gegner
import helden.Barde
import helden.Zwerg

var heilTrank = 2
var vitamine = 1

var ork: Ork = Ork("Dorothan", 500, 20..35)
var barde: Barde = Barde("Morgan", 200, 20..35)
var zwerg: Zwerg = Zwerg("Gimli", 350, 50..701)

var boss: Boss = Boss("Fluffi", 720, 40..80)
var bossHelfer: Bosshelfer = Bosshelfer("Basilisk", 240, 10..20)

var HeldenListe: MutableList<Helden> = mutableListOf(ork, barde, zwerg)
var GegnerListe: MutableList<Gegner> = mutableListOf(boss, bossHelfer)

fun gameBegin() {
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
}

fun main() {
    val spiel: Boolean = (ork.hp >= 0 && barde.hp >= 0 && zwerg.hp >= 0 && boss.hp >=0 )


    gameBegin()
    while (spiel) {
        if (boss.hp > 360) {
            ork.kampfMenuOrk(ork, boss, helden = ork, bossHelfer)
            zwerg.kampfMenuZwerg(zwerg, boss, bossHelfer, helden = zwerg)
            barde.kampfMenuBarde(ork, zwerg, barde, boss, helden = barde, bossHelfer)
            boss.kampfMenuBoss(HeldenListe, boss)
        } else {
            while (bossHelfer.hp > 0) {
                ork.kampfMenuOrk(ork, boss, helden = zwerg, bossHelfer)
                zwerg.kampfMenuZwerg(zwerg, boss, bossHelfer, helden = zwerg)
                barde.kampfMenuBarde(ork, zwerg, barde, boss, helden = barde, bossHelfer)
                if (bossHelfer.hp <= 0) {
                    bossHelfer.hp = 0
                    println("${bossHelfer.name} wurde besiegt!")
                    break
                }
            }
        }
        /*if (boss.hp <= 0) {
            println("Gewonnen")
            break
        }*/
        ork.kampfMenuOrk(ork, boss, helden = ork, bossHelfer)
        zwerg.kampfMenuZwerg(zwerg, boss, bossHelfer, helden = zwerg)
        barde.kampfMenuBarde(ork, zwerg, barde, boss, helden = barde, bossHelfer)
        boss.kampfMenuBoss(HeldenListe, boss)
        if (boss.hp <= 0) {
            println("Gewonnen")
            break
        }
    }
}
