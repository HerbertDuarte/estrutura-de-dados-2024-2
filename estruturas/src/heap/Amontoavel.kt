package heap

interface Amontoavel {
    fun inserir(dado: Long) // insere no final mas vai comparando para caso seja heap minima ou maxima
    fun atualizar(novoDado: Long) // atualiza na raiz
    fun extrair()  : Long?// pega o dado da raiz e insere o ultimo no lugar dele
    fun obter() : Long? // pega da raiz

    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}