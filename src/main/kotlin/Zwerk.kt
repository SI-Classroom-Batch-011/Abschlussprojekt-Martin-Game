class Zwerg (var name: String= "Gimli",
             var hp: Int= 350,
             var schaden: IntRange= 35..60){

    fun kampfSchrei(){
        println("Ich $name schwinge für Euch meinen Hammer und werde Eure Feinde zerschmettern!")
    }


    fun normalerAngriffZwerg(boss: Boss){
        val schaden = angriffZwerg.schaden.random()
        boss.hp -= schaden
        println("$name greift ${boss.name} mit *${angriffZwerg.name}* an und hat ihm $schaden zugefügt.")
        println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
        if (boss.hp <= 0){
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

    fun blutungZwerg(boss: Boss){
        val zwergSchadenBlutung = blutungZufügen.schaden.random()
        val blutungsSchaden1 = (zwergSchadenBlutung * 0.75)
        val blutungsSchaden2 = (zwergSchadenBlutung * 0.50)
        val blutungsSchaden3 = (zwergSchadenBlutung * 0.25)
        boss.hp -= zwergSchadenBlutung
        println("$name hat ${boss.name} eine klaffende Wunde und $zwergSchadenBlutung Schaden zugefügt. ")
        boss.hp -= blutungsSchaden1.toInt()
        println("${boss.name} blutet (-$blutungsSchaden1)")
        boss.hp -= blutungsSchaden2.toInt()
        println("${boss.name} blutet (-$blutungsSchaden2)")
        boss.hp -= blutungsSchaden3.toInt()
        println("${boss.name} blutet (-$blutungsSchaden3)")
        println("${boss.name} hat noch ${boss.hp} Lebenspunkte")
        if (boss.hp <= 0){
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

    fun schwererAngriffZwerg(boss: Boss){
        val schaden = schwererAngriff.schaden.random()
        boss.hp -= schaden
        println("$name greift ${boss.name} mit *${schwererAngriff.name}* an und hat ihm $schaden zugefügt.")
        println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
        if (boss.hp <= 0){
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

    fun lebensRaubZwerg(zwerg: Zwerg,boss: Boss,){
        val schaden = lebensRaub.schaden.random()
        boss.hp -= schaden
        zwerg.hp += schaden
        println("${zwerg.name} hat wieder ${zwerg.hp} Lebenspunkte")
        if (zwerg.hp >= hp){
            zwerg.hp = hp
        }
        println("$name greift ${boss.name} mit *${lebensRaub.name}* an und hat ihm $schaden zugefügt.")
        println("${boss.name} hat noch ${boss.hp} Lebenspunkte!")
        if (boss.hp <= 0){
            println("${boss.name} wurde besiegt...hurrah !")
        }
    }

}

