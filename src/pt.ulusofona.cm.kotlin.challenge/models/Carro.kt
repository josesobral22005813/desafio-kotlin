class Carro(identificador: String, motor: Motor): Veiculo(identificador) {
    val motor = motor
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {

    }
}