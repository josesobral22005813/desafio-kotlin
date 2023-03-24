abstract class Veiculo(identificador: String) : Movimentavel {
    var identificador: String = identificador
    var posicao: Posicao = Posicao()

    abstract fun requerCarta(): Boolean
}
