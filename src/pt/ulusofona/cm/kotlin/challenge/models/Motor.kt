package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(var cavalos: Int, var cilindrada: Int) : Ligavel {
    private var ligado = false

    override fun ligar() {
        if(ligado){
            throw VeiculoLigadoException("O Veiculo já se encontra ligado")
        }
        ligado = true
    }

    override fun desligar() {
        if(!ligado){
            throw VeiculoLigadoException("O Veiculo já se encontra desligado")
        }
        ligado = false
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }

}