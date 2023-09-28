import gegner.Boss
import gegner.Bosshelfer
import helden.Barde
import helden.Zwerg


open class Helden(
    var name: String,
    var hp: Int,
    var schaden: IntRange,
) {
    open fun kampfSchrei() {
        println("Ich $name und Beispieltext")
    }

    fun alleHeilen(ork: Ork, zwerg: Zwerg, barde: Barde) {
        val heilung = alleHeilen.heilung
        println("$name hat noch $hp Lebenspunkte und heilt sich, heilt ${ork.name} und ${zwerg.name} um $heilung Lebenspunkte.")
        ork.hp += heilung
        zwerg.hp += heilung
        barde.hp += heilung

        if (ork.hp >= 500) {
            ork.hp = 500
            println("${ork.name} hat wieder volle Lebenspunkte.")
        } else {
            println("${ork.name} hat jetzt wieder ${ork.hp} Lebenspunkte.")
        }
        if (zwerg.hp >= 350) {
            ork.hp = 350
            println("${zwerg.name} hat wieder volle Lebenspunkte.")
        } else {
            println("${zwerg.name} hat jetzt wieder ${zwerg.hp} Lebenspunkte.")
        }
        if (barde.hp >= 200) {
            barde.hp = 200
            println("$name hat wieder volle Lebenspunkte.")
            println()
        } else {
            println("$name hat jetzt wieder $hp Lebenspunkte.")
        }
    }


    fun angriffBarde(boss: Boss, bosshelfer: Bosshelfer) {
        val schaden = angriffBarde.schaden.random()
        if (boss.hp >= 360 || bossHelfer.hp <= 0) {
            boss.hp -= schaden
            println("$name greift ${boss.name} mit *${angriffBarde.name}* an und hat ihm $schaden zugefügt.")
            println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
            println()
        }
        if (boss.hp <= 360) {
            if (bosshelfer.hp <= 0) {
                bosshelfer.hp = 0
                println("${bosshelfer.name} hat ${bosshelfer.hp} Lebenspunkte und ist vernichtet!")
                println()
            } else {
                bosshelfer.hp -= schaden
                println("$name greift ${bosshelfer.name} mit *${angriffBarde.name}* an und hat ihm $schaden zugefügt.")
                println("${bosshelfer.name} hat noch ${bosshelfer.hp} Lebenspunkte!")
                println()
            }
        }
        if (boss.hp <= 0) {
            boss.hp = 0
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }


    fun selbstHeilungBarde(barde: Barde) {
        val heilung = selbstHeilungBarde.heilung
        barde.hp += heilung
        println("$name heilt sich um $heilung Lebenspunkte.")
        println("$name hat noch $hp Lebenspunkte.")
        println()

        if (barde.hp >= 200) {
            barde.hp = 200
            println("$name hat wieder volle Lebenspunkte.")
            println()
        }

    }


    fun alleSchilden(barde: Barde, ork: Ork, zwerg: Zwerg) {
        val schild = alleSchilden.schild
        barde.hp += schild
        ork.hp += schild
        zwerg.hp += schild
        println("Alle Gruppen Mitglieder wurden geschildet.")
        println()
    }

    fun kampfMenuBarde(ork: Ork, zwerg: Zwerg, barde: Barde, boss: Boss, helden: Helden, bosshelfer: Bosshelfer) {
        println("Mit welcher Attacke soll ${barde.name} angreifen?")
        println(
            """
            1 -> Alle heilen
            2 -> Normaler Angriff
            3 -> Selbst Heilung
            4 -> Alle schilden
            5 -> Inventar
        """.trimIndent()
        )

        val beutel = Inventar("Inventar")
        val input = readln().toInt()
        when (input) {
            1 -> alleHeilen(ork, zwerg, barde)
            2 -> angriffBarde(boss, bosshelfer)
            3 -> selbstHeilungBarde(barde)
            4 -> alleSchilden(barde, ork, zwerg)
            5 -> beutel.invKampfmenu(helden)
        }
    }

    fun normalerAngriffOrk(boss: Boss, bosshelfer: Bosshelfer) {
        val schaden = angriffOrk.schaden.random()
        if (boss.hp >= 360 || bossHelfer.hp <= 0) {
            boss.hp -= schaden
            println("$name greift ${boss.name} mit *${angriffOrk.name}* an und hat ihm $schaden zugefügt.")
            println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
            println()
        }
        if (boss.hp <= 360) {

            if (bosshelfer.hp <= 0) {
                bosshelfer.hp = 0
                println("${bosshelfer.name} hat ${bosshelfer.hp} Lebenspunkte und ist vernichtet!")
            } else {
                bosshelfer.hp -= schaden
                println("$name greift ${bosshelfer.name} mit *${angriffOrk.name}* an und hat ihm $schaden zugefügt.")
                println("${bosshelfer.name} hat noch ${bosshelfer.hp} Lebenspunkte!")
                println()
            }
        }
        if (boss.hp <= 0) {
            boss.hp = 0
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

    fun selbstHeilen(ork: Ork) {
        val heilung = selbstHeilung.heilung
        println("$name hat noch $hp Lebenspunkte und heilt sich.")
        ork.hp += heilung
        println("$name hat jetzt wieder $hp Lebenspunkte.")
        println()

        if (ork.hp >= 500) {
            ork.hp = 500
            println("$name hat wieder volle Lebenspunkte.")
        }


    }

    fun blocken(ork: Ork, boss: Boss) {
        val bossSchaden = boss.schaden.random()
        val geblockterSchaden = (bossSchaden * 0.00)
        ork.hp -= geblockterSchaden.toInt()
        println("${ork.name} hat $geblockterSchaden von ${boss.name} bekommen.")
        println("${ork.name} hat den Angriff von ${boss.name} erfolgreich geblockt!")
        println()
    }


    fun schildStoß(boss: Boss, bosshelfer: Bosshelfer) {
        val schaden = schildStoß.schaden.random()
        if (boss.hp >= 360 || bossHelfer.hp <= 0) {
            boss.hp -= schaden
            println("$name hat ${boss.name} $schaden Schaden zugefügt.")
            println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
            println()
        }
        if (boss.hp <= 360) {
            if (bosshelfer.hp <= 0) {
                bosshelfer.hp = 0
                println("${bosshelfer.name} hat ${bosshelfer.hp} Lebenspunkte und ist vernichtet!")
            } else {
                bosshelfer.hp -= schaden
                println("$name greift ${bosshelfer.name} mit *${schildStoß.name}* an und hat ihm $schaden zugefügt.")
                println("${bosshelfer.name} hat noch ${bosshelfer.hp} Lebenspunkte!")
                println()
            }
        }
        if (boss.hp <= 0) {
            boss.hp = 0
            println("${boss.name} wurde besiegt...hurrah !")
        }

    }

    fun kampfMenuOrk(ork: Ork, boss: Boss, helden: Helden, bosshelfer: Bosshelfer) {
        println("Mit welcher Attacke soll ${ork.name} angreifen?")
        println(
            """
            1 -> Normaler Angriff
            2 -> Angriff Block
            3 -> Selbst Heilung
            4 -> Schildstoß
            5 -> Inventar
        """.trimIndent()
        )

        val beutel = Inventar("Inventar")
        val input = readln().toInt()
        when (input) {
            1 -> normalerAngriffOrk(boss, bosshelfer)
            2 -> blocken(ork, boss)
            3 -> selbstHeilen(ork)
            4 -> schildStoß(boss, bosshelfer)
            5 -> beutel.invKampfmenu(helden)
        }
    }


    fun normalerAngriffZwerg(boss: Boss, bosshelfer: Bosshelfer) {
        val schaden = angriffZwerg.schaden.random()
        if (boss.hp >= 360 || bossHelfer.hp <= 0) {
            boss.hp -= schaden
            println("$name greift ${boss.name} mit *${angriffZwerg.name}* an und hat ihm $schaden zugefügt.")
            println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
            println()
        }
        if (boss.hp <= 360) {
            if (bosshelfer.hp <= 0) {
                bosshelfer.hp = 0
                println("${bosshelfer.name} hat ${bosshelfer.hp} Lebenspunkte und ist vernichtet!")
            } else {
                bosshelfer.hp -= schaden
                println("$name greift ${bosshelfer.name} mit *${angriffZwerg.name}* an und hat ihm $schaden zugefügt.")
                println("${bosshelfer.name} hat noch ${bosshelfer.hp} Lebenspunkte!")
                println()
            }
        }
        if (boss.hp <= 0) {
            boss.hp = 0
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

    fun blutungZwerg(boss: Boss, bosshelfer: Bosshelfer) {
        val zwergSchadenBlutung = blutungZufügen.schaden.random()
        val blutungsSchaden1 = (zwergSchadenBlutung * 0.75)
        val blutungsSchaden2 = (zwergSchadenBlutung * 0.50)
        val blutungsSchaden3 = (zwergSchadenBlutung * 0.25)
        if (boss.hp >= 360 || bossHelfer.hp <= 0) {
            boss.hp -= zwergSchadenBlutung
            println("$name hat ${boss.name} eine klaffende Wunde und $zwergSchadenBlutung Schaden zugefügt. ")
            boss.hp -= blutungsSchaden1.toInt()
            println("${boss.name} blutet (-$blutungsSchaden1)")
            boss.hp -= blutungsSchaden2.toInt()
            println("${boss.name} blutet (-$blutungsSchaden2)")
            boss.hp -= blutungsSchaden3.toInt()
            println("${boss.name} blutet (-$blutungsSchaden3)")
            println("${boss.name} hat noch ${boss.hp} Lebenspunkte")
            println()
        }
        if (boss.hp <= 360) {
            if (bosshelfer.hp <= 0) {
                bosshelfer.hp = 0
                println("${bosshelfer.name} hat ${bosshelfer.hp} Lebenspunkte und ist vernichtet!")
            } else {
                bosshelfer.hp -= zwergSchadenBlutung
                println("$name hat ${bosshelfer.name} eine klaffende Wunde und $zwergSchadenBlutung Schaden zugefügt. ")
                bosshelfer.hp -= blutungsSchaden1.toInt()
                println("${bosshelfer.name} blutet (-$blutungsSchaden1)")
                bosshelfer.hp -= blutungsSchaden2.toInt()
                println("${bosshelfer.name} blutet (-$blutungsSchaden2)")
                bosshelfer.hp -= blutungsSchaden3.toInt()
                println("${bosshelfer.name} blutet (-$blutungsSchaden3)")
                println("${bosshelfer.name} hat noch ${bosshelfer.hp} Lebenspunkte")
                println()
            }

        }
        if (boss.hp <= 0) {
            boss.hp = 0
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

    fun schwererAngriffZwerg(boss: Boss, bosshelfer: Bosshelfer) {
        val schaden = schwererAngriff.schaden.random()
        if (boss.hp >= 360 || bossHelfer.hp <= 0) {
            boss.hp -= schaden
            println("$name greift ${boss.name} mit *${schwererAngriff.name}* an und hat ihm $schaden zugefügt.")
            println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
            println()
        }
        if (boss.hp <= 360) {
            if (bosshelfer.hp <= 0) {
                bosshelfer.hp = 0
                println("${bosshelfer.name} hat ${bosshelfer.hp} Lebenspunkte und ist vernichtet!")
            } else {
                bosshelfer.hp -= schaden
                println("$name greift ${bosshelfer.name} mit *${schwererAngriff.name}* an und hat ihm $schaden zugefügt.")
                println("${bosshelfer.name} hat noch ${bosshelfer.hp} Lebenspunkte!")
                println()
            }
        }
        if (boss.hp <= 0) {
            boss.hp = 0
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

    fun lebensRaubZwerg(zwerg: Zwerg, boss: Boss, bosshelfer: Bosshelfer) {
        val schaden = lebensRaub.schaden.random()
        if (boss.hp >= 360 || bossHelfer.hp <= 0) {
            boss.hp -= schaden
            zwerg.hp += schaden
            println("$name greift ${boss.name} mit *${lebensRaub.name}* an und hat ihm $schaden zugefügt.")
            println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
            println()
        }
        if (boss.hp <= 360) {
            if (bosshelfer.hp <= 0) {
                bosshelfer.hp = 0
                println("${bosshelfer.name} hat ${bosshelfer.hp} Lebenspunkte und ist vernichtet!")
            } else {
                bosshelfer.hp -= schaden
                zwerg.hp += schaden
                println("$name greift ${bosshelfer.name} mit *${lebensRaub.name}* an und hat ihm $schaden zugefügt.")
                println("${bosshelfer.name} hat noch ${bosshelfer.hp} Lebenspunkte!")
                println()
            }
        }
        if (boss.hp <= 0) {
            boss.hp = 0
            println("${boss.name} wurde besiegt...hurrah !")
        }
        println("${zwerg.name} hat wieder ${zwerg.hp} Lebenspunkte")
    }

    fun kampfMenuZwerg(zwerg: Zwerg, boss: Boss, bosshelfer: Bosshelfer, helden: Helden) {
        println("Mit welcher Attacke soll ${zwerg.name} angreifen?")
        println(
            """
            1 -> Normaler Angriff
            2 -> Blutung zufügen
            3 -> Schwerer Angriff
            4 -> Lebens Raub
            5 -> Inventar
        """.trimIndent()
        )
        val beutel = Inventar("Inventar")
        val input: Int = readln().toInt()
        when (input) {
            1 -> normalerAngriffZwerg(boss, bosshelfer)
            2 -> blutungZwerg(boss, bosshelfer)
            3 -> schwererAngriffZwerg(boss, bosshelfer)
            4 -> lebensRaubZwerg(zwerg, boss, bosshelfer)
            5 -> beutel.invKampfmenu(helden)
        }

    }


}
