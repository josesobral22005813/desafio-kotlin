package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(var cavalos: Int, var cilindrada: Int) : Ligavel {
    private var ligado = false

    override fun ligar() {
        ligado = true
    }

    override fun desligar() {
        ligado = false
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun toString(): String {
        return "Motor(cavalos=$cavalos, cilindrada=$cilindrada, ligado=$ligado)"
    }

}