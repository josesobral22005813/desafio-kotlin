import java.time.LocalDate

abstract class Veiculo(var identificador: String) : Movimentavel {
    var posicao: Posicao = Posicao()
    var dataDeAquisicao: LocalDate? = null

    init {
        dataDeAquisicao = LocalDate.now()
    }

    abstract fun requerCarta(): Boolean
    override fun toString(): String {
        return "Veiculo(identificador='$identificador', posicao=$posicao, dataDeAquisicao=$dataDeAquisicao)"
    }
}
