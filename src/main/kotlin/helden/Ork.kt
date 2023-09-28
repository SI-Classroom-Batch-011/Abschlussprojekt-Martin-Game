class Ork(name: String,
          hp: Int,
          schaden: IntRange,
) : Helden (name, hp, schaden) {

    override fun kampfSchrei() {
        println("Ich $name bin euer Tank und werde die Angriffe auf mich ziehen!")
    }
}
