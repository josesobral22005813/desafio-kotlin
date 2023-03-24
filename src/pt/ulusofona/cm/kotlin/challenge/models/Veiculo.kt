abstract class Veiculo(var identificador: String) : Movimentavel {
    var posicao: Posicao = Posicao()

    abstract fun requerCarta(): Boolean
}
