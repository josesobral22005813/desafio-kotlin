class Posicao(x: Int, y: Int) {
    var x: Int = x
    var y: Int = y

    constructor(): this(0, 0)

    fun alterarPosicaoPara(x: Int, y: Int) {
        this.x = x
        this.y = y
    }
}