class Motor(var cavalos: Int, var cilindrada: Int) : Ligavel {
    private var ligado = false

    override fun ligar() {
        ligado = true
    }

    override fun desligar() {
        ligado = false
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

}