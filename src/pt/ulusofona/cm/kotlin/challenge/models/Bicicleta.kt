package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import java.text.SimpleDateFormat

class Bicicleta(identificador: String) : Veiculo(identificador) {
    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        if(posicao.x != x && posicao.y != y) {
            posicao.alterarPosicaoPara(x, y)
        } else {
            throw AlterarPosicaoException("O veiculo já se encontra nessa posição")
        }
    }

    override fun toString(): String {
        val formatador = SimpleDateFormat("dd-MM-yyyy")
        return "Bicicleta | ${identificador} | ${formatador.format(dataDeAquisicao.time)} | ${posicao}"
    }
}