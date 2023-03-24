package pt.ulusofona.cm.kotlin.challenge.models

import java.text.SimpleDateFormat

class Bicicleta(identificador: String) : Veiculo(identificador) {
    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }

    override fun toString(): String {
        val formatador = SimpleDateFormat("dd-MM-yyyy")
        return "Bicicleta | ${identificador} | ${formatador.parse(dataDeAquisicao.toString())} | ${posicao}"
    }
}