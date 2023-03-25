package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import java.text.SimpleDateFormat
import java.util.*

class Pessoa(var nome: String, var dataDeNascimento: Date) {
    var veiculos: MutableList<Veiculo> = mutableListOf()
    var carta: Carta? = null
    var posicao: Posicao = Posicao()

    fun comprarVeiculo(veiculo: Veiculo?) {
        if(veiculo == null) {
            return
        } else {
            veiculos.add(veiculo)
        }

    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        for (veiculo in veiculos) {
            if(veiculo.identificador == identificador) {
                return veiculo
            }
        }
        throw VeiculoNaoEncontradoException("O Veiculo com o identificador especificado não foi encontrado")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        val veiculoParaVender = pesquisarVeiculo(identificador)

        comprador.comprarVeiculo(veiculoParaVender)
        veiculos.remove(veiculoParaVender)
        veiculoParaVender.dataDeAquisicao = Date()
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val veiculoParaMover = pesquisarVeiculo(identificador)
        if(veiculoParaMover is Carro && carta == null) {
            throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
        }
        veiculoParaMover.moverPara(x, y)
    }

    fun temCarta(): Boolean {
        if(carta == null) {
            return false
        }
        return true
    }

    fun tirarCarta() {
        val data18AnosAtras = Date()
        data18AnosAtras.year = data18AnosAtras.year - 18

        if(dataDeNascimento.after(data18AnosAtras)){
            throw MenorDeIdadeException("A pessoa é menor de idade")
        }
        this.carta = Carta()
    }

    override fun toString(): String {
        val formatador = SimpleDateFormat("dd-MM-yyyy")
        return "Pessoa | ${nome} | ${formatador.format(dataDeNascimento.time)} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }
}