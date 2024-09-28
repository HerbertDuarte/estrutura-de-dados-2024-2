package lista

class ListaEstatica (tamanho: Int): Listavel {

    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var posicao: Int = 0
    private var quantidade: Int = 0
    private var dados: Array<Any?> = arrayOfNulls<Any?>(tamanho)


    override fun inserir(dado: Any) {
        dados.set(ponteiroInicio, quantidade)
        ponteiroInicio++
        ponteiroFim++
    }
    override fun remover(indice: Int) {
        dados = dados.drop(indice).toTypedArray()
    }

    override fun listarTodos() {
        dados.forEach {
            dado ->
            println(dado)
        }
    }

    override fun sobrescrever(indice: Int, dado: Any) {
        dados[posicao] = dado
    }

    override fun tamanho(): Int {
        return quantidade
    }

    override fun estaCheio(): Boolean {
        return quantidade == 0;
    }

    override fun estaVazia(): Boolean {
        return posicao == -1;
    }

}