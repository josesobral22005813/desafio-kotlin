package pt.ulusofona.cm.kotlin.challenge.models

import java.text.SimpleDateFormat

class Carro(identificador: String, motor: Motor): Veiculo(identificador) {
    val motor = motor
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if(motor.estaLigado()) {
            posicao.alterarPosicaoPara(x, y)
        }
    }

    override fun toString(): String {
        val formatador = SimpleDateFormat("dd-MM-yyyy")
        return "Carro | ${identificador} | ${formatador.format(dataDeAquisicao.time)} | ${posicao}"
    }
}