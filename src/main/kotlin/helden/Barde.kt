package helden

import gegner.Boss
import Helden
import alleHeilen
import alleSchilden
import angriffBarde
import selbstHeilungBarde

class Barde (name: String,
             hp: Int,
             schaden: IntRange)
    : Helden (name, hp, schaden){

    override fun kampfSchrei() {
        println("Ich $name bin Heiler und werde meine Leute unterstützen!")
    }

    }
