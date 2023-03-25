package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import java.text.SimpleDateFormat

class Carro(identificador: String, motor: Motor): Veiculo(identificador) {
    val motor = motor
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if(motor.estaLigado() && (posicao.x != x && posicao.y != y)) {
            posicao.alterarPosicaoPara(x, y)
        } else if(!motor.estaLigado()){
            throw VeiculoDesligadoException("O veiculo está desligado")
        } else {
            throw AlterarPosicaoException("O veiculo já se encontra nessa posição")
        }
    }

    override fun toString(): String {
        val formatador = SimpleDateFormat("dd-MM-yyyy")
        return "Carro | ${identificador} | ${formatador.format(dataDeAquisicao.time)} | ${posicao}"
    }
}