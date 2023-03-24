class Posicao(var x: Int, var y: Int) {
    constructor(): this(0, 0)

    fun alterarPosicaoPara(x: Int, y: Int) {
        this.x = x
        this.y = y
    }
}