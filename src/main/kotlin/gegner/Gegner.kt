package gegner

import Helden
import Ork
import barde
import bissAlleZiele
import bissEinZiel
import giftBiss
import giftSpritze
import heilen
import helden.Barde
import helden.Zwerg
import kopfNuss
import ork
import rutenHieb
import schrei
import stampfen
import zwerg

open class Gegner(
    var name: String,
    var hp: Int,
    var schaden: IntRange,
) {

    fun kampfSchreiBoss() {
        println("Ich ${this.name} bin Euer Tank und für den Kampf bereit Grrrr!")
    }

    fun angreifen(helden: MutableList<Helden>) {
        val RandomHeld = helden.random()
        val schaden = bissEinZiel.schaden.random()
        if (RandomHeld == helden[0]) {
            helden[0].hp -= schaden
            println("$name greift ${helden[0].name} an und verursacht $schaden Schaden!")
            if (helden[0].hp <= 0) {
                println("Der ${helden[0].name} wurde besiegt!")
            }
        }
        if (RandomHeld == helden[1]) {
            helden[1].hp -= schaden
            println("$name greift ${helden[1].name} an und verursacht $schaden Schaden!")
            if (helden[1].hp <= 0) {
                println("Der ${helden[1].name} wurde besiegt!")
            }
        }
        if (RandomHeld == helden[2]) {
            helden[2].hp -= schaden
            println("$name greift ${helden[2].name} an und verursacht $schaden Schaden!")
            if (helden[2].hp <= 0) {
                println("Der ${helden[2].name} wurde besiegt!")
            }
        }
    }

    fun bissAlleZiele(helden: MutableList<Helden>) {
        val schaden = bissAlleZiele.schaden.random()
        helden[0].hp -= schaden
        helden[1].hp -= schaden
        helden[2].hp -= schaden
        println("$name hat allen Helden mit ${bissAlleZiele.name} $schaden Schaden zugefügt.")
        if (helden[0].hp <= 0) {
            println("Der ${helden[0].name} wurde besiegt!")
        }
        if (helden[1].hp <= 0) {
            println("Der ${helden[1].name} wurde besiegt!")
        }
        if (helden[2].hp <= 0) {
            println("Der ${helden[2].name} wurde besiegt!")
        }
    }

    fun stampfen(helden: MutableList<Helden>) {
        val schaden = stampfen.schaden.random()
        helden[0].hp -= schaden
        helden[1].hp -= schaden
        helden[2].hp -= schaden
        println("$name hat allen Helden mit ${stampfen.name} $schaden Schaden zugefügt.")
        if (helden[0].hp <= 0) {
            println("Der ${helden[0].name} wurde besiegt!")
        }
        if (helden[1].hp <= 0) {
            println("Der ${helden[1].name} wurde besiegt!")
        }
        if (helden[2].hp <= 0) {
            println("Der ${helden[2].name} wurde besiegt!")
        }
    }


    fun rutenHieb(helden: MutableList<Helden>) {
        val schaden = rutenHieb.schaden.random()
        helden[0].hp -= schaden
        helden[1].hp -= schaden
        helden[2].hp -= schaden
        println("$name hat allen Helden mit ${rutenHieb.name} $schaden Schaden zugefügt.")
        if (helden[0].hp <= 0) {
            println("Der ${helden[0].name} wurde besiegt!")
        }
        if (helden[1].hp <= 0) {
            println("Der ${helden[1].name} wurde besiegt!")
        }
        if (helden[2].hp <= 0) {
            println("Der ${helden[2].name} wurde besiegt!")
        }
    }

    fun heilen(boss: Boss) {
        val heilung = heilen.heilung
        boss.hp += heilung

        if (boss.hp >= 720) {
            boss.hp = 720
            println("${boss.name} hat wieder volle Lebenspunkte.")
        }
        println("${boss.name} heilt sich um $heilung und hat wieder ${boss.hp} Lebenspunkte.")
    }

    fun heulerBoss(ork: Ork, barde: Barde, zwerg: Zwerg) {
        val helden = listOf(ork, barde, zwerg)
        val randomHero = helden.random()
        // val schaden = heuler.schaden.random()
        if (randomHero == ork) {
            var orkHp = ork.hp
            val prozentAbzug = 0.1
            while (orkHp > ork.hp * 0.2) {
                val schaden = (orkHp * prozentAbzug).toInt()
                orkHp -= schaden
                if (orkHp <= 0) {
                    println("${ork.name} wurde besiegt.")
                } else {
                    println("${ork.name} hat $schaden Schaden erlitten und hat noch $orkHp Lebenspunkte.")
                }
            }
        }
        if (randomHero == barde) {
            while (barde.hp > (barde.hp * 0.2)) {
                val schaden = (barde.hp * 0.1).toInt()
                barde.hp -= schaden
                println("$name greift ${barde.name} an und verursacht $schaden Schaden!")
                if (barde.hp <= 0) {
                    println("Der ${barde.name} wurde besiegt!")
                }
            }

        }
        if (randomHero == zwerg) {
            while (zwerg.hp > (zwerg.hp * 0.2)) {
                val schaden = (zwerg.hp * 0.1).toInt()
                zwerg.hp -= schaden
                println("$name greift ${zwerg.name} an und verursacht $schaden Schaden!")
                if (zwerg.hp <= 0) {
                    println("Der ${zwerg.name} wurde besiegt!")
                }
            }

        }
    }

    fun kampfMenuBoss(helden: MutableList<Helden>, boss: Boss) {
        val zufall = (0..4).random()

        when (zufall) {
            0 -> boss.angreifen(helden)
            1 -> boss.bissAlleZiele(helden)
            2 -> boss.stampfen(helden)
            3 -> boss.rutenHieb(helden)
            4 -> boss.heilen(boss)
        }
    }

    fun giftBiss(helden: MutableList<Helden>) {
        val giftbissSchaden = giftBiss.schaden.random()
        val giftSchaden1 = (giftbissSchaden * 0.75).toInt()
        val giftSchaden2 = (giftbissSchaden * 0.50).toInt()
        val giftSchaden3 = (giftbissSchaden * 0.25).toInt()
        val helden = listOf(ork, barde, zwerg)
        val zufälligerHeld = helden.random()
        val schaden = bissEinZiel.schaden.random()
        if (zufälligerHeld == ork) {
            ork.hp -= giftSchaden1
            ork.hp -= giftSchaden2
            ork.hp -= giftSchaden3
            println("$name greift ${ork.name} an und verursacht $schaden Schaden!")
            if (ork.hp <= 0) {
                println("Der ${ork.name} wurde besiegt!")
            }
        }
        if (zufälligerHeld == barde) {
            barde.hp -= giftSchaden1
            barde.hp -= giftSchaden2
            barde.hp -= giftSchaden3
            println("$name greift ${barde.name} an und verursacht $schaden Schaden!")
            if (barde.hp <= 0) {
                println("Der ${barde.name} wurde besiegt!")
            }
        }
        if (zufälligerHeld == zwerg) {
            zwerg.hp -= giftSchaden1
            zwerg.hp -= giftSchaden2
            zwerg.hp -= giftSchaden3
            println("$name greift ${zwerg.name} an und verursacht $schaden Schaden!")
            if (zwerg.hp <= 0) {
                println("Der ${zwerg.name} wurde besiegt!")
            }
        }
    }

    fun giftSpritze(helden: MutableList<Helden>) {
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

    fun kopfNuss(zwerg: Zwerg, barde: Barde, ork: Ork) {
        val schaden = kopfNuss.schaden.random()
        val helden = listOf(ork, barde, zwerg)
        val zufälligerHeld = helden.random()
        if (zufälligerHeld == ork) {
            ork.hp -= schaden
            println("$name greift ${ork.name} an und verursacht $schaden Schaden!")
            if (ork.hp <= 0) {
                println("Der ${ork.name} wurde besiegt!")
            }
        }
        if (zufälligerHeld == barde) {
            barde.hp -= schaden
            println("$name greift ${barde.name} an und verursacht $schaden Schaden!")
            if (barde.hp <= 0) {
                println("Der ${barde.name} wurde besiegt!")
            }
        }
        if (zufälligerHeld == zwerg) {
            zwerg.hp -= schaden
            println("$name greift ${zwerg.name} an und verursacht $schaden Schaden!")
            if (zwerg.hp <= 0) {
                println("Der ${zwerg.name} wurde besiegt!")
            }
        }
    }

    fun schrei(bosshelfer: Bosshelfer) {
        val schild = schrei.schild
        bosshelfer.hp += schild
        println("$name nutzt ${schrei.name} und erhält ein Schild von $schild Lebenspunkten.")
    }

    fun kampfMenuBossHelfer(helden: MutableList<Helden>, bosshelfer: Bosshelfer){
        val zufall = (0..3).random()
        when (zufall){
            0 -> bosshelfer.giftBiss(helden)
            1 -> bosshelfer.giftSpritze(helden)
            2 -> bosshelfer.kopfNuss(zwerg, barde, ork)
            3 -> bosshelfer.schrei(bosshelfer)
        }
    }
}


