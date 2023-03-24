import java.time.LocalDate
import java.time.Period


class Pessoa(var nome: String, var dataDeNascimento: LocalDate) {
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

    fun pesquisarVeiculo(identificador: String): Veiculo? {
        for (veiculo in veiculos) {
            if(veiculo.identificador == identificador) {
                return veiculo
            }
        }
        return null
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        val veiculoParaVender = pesquisarVeiculo(identificador)

        if (veiculoParaVender != null) {
            comprador.comprarVeiculo(veiculoParaVender)
            veiculos.remove(veiculoParaVender)
            veiculoParaVender.dataDeAquisicao = LocalDate.now()
        }
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val veiculoParaMover = pesquisarVeiculo(identificador)
        if(veiculoParaMover == null) {
            return
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
        val hoje = LocalDate.now()
        val diferencaAnos = Period.between(dataDeNascimento, hoje).years

        if(diferencaAnos >= 18) {
            this.carta = Carta()
        }
    }

    override fun toString(): String {
        return "Pessoa(nome='$nome', dataDeNascimento=$dataDeNascimento, veiculos=$veiculos, carta=$carta, posicao=$posicao)"
    }
}