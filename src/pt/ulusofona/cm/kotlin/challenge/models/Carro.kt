package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.text.SimpleDateFormat

class Carro(identificador: String, motor: Motor): Veiculo(identificador), Ligavel {
    val motor = motor
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if(estaLigado()){
            posicao.alterarPosicaoPara(x, y)
        }
    }

    override fun ligar() {
        if(estaLigado()){
            throw VeiculoLigadoException("O Veiculo já se encontra ligado")
        }
        motor.ligar()
    }

    override fun desligar() {
        if(!estaLigado()){
            throw VeiculoDesligadoException("O Veiculo já se encontra desligado")
        }
        motor.desligar()
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }

    override fun toString(): String {
        val formatador = SimpleDateFormat("dd-MM-yyyy")
        return "Carro | ${identificador} | ${formatador.format(dataDeAquisicao.time)} | ${posicao}"
    }
}