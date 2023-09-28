package helden
import Helden

class Zwerg (name: String,
             hp: Int,
             schaden: IntRange)
    : Helden (name, hp, schaden) {

    override fun kampfSchrei() {
        println("Ich $name bin DD und werde alle Gegner mit meinem Hammer vernichten")
    }
}
