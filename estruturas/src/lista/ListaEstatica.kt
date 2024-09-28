package lista

class ListaEstatica (tamanho: Int): Listavel {

    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var posicao: Int = 0
    private var quantidade: Int = 0
    private var dados: Array<Any?> = arrayOfNulls<Any?>(tamanho)


    override fun inserir(dado: Any) {
        if(!estaCheio()){
            ponteiroInicio++
            if(ponteiroFim == dados.size){
                ponteiroFim = 0
            }
            dados[ponteiroFim] = dado;
            quantidade++
        }else{
            println("lista cheia")
        }
    }
    override fun remover(posicao: Int): Any? {
        var dadoSobrecrito: Any? = null;
        if(!estaVazia() && posicaoValida(posicao) ){
            if(posicaoReal(posicao) < quantidade ){

                var ponteiroReal = posicaoReal(posicao)
                dadoSobrecrito = dados[posicaoReal(posicao)]
                for (i in posicao until (quantidade-1)) {
                    var atual = ponteiroReal
//                  aqui é feito o %dados.size para garantir que não ultrapasse o tamanho da lista
                    var proximo = (ponteiroReal+1)%dados.size

                    dados[atual] = dados[proximo]
                    ponteiroReal++
                }
                ponteiroFim--
                if (ponteiroFim == -1){
                    ponteiroFim = dados.size - 1
                }
                quantidade--
            }
            else {
                println("Indice Inválido!")
            }
        } else {
            println("Lista Vazia!")
        }
        return dadoSobrecrito;
    }

    override fun listarTodos() {
        dados.forEach {
            dado ->
            println(dado)
        }
    }

    override fun sobrescrever(indice: Int, dado: Any) {
        if (!estaCheio()) {
            //índice/posição é válido?
            if (posicaoValida(posicao)) {
                //mapeamento:
                //DE endereçamento lógico
                //(informado pelo usuário)
                //PARA endereçamento físico
                //(onde o dado está no array)

                var ponteiroAux = ponteiroFim+1
                for (i in posicao until quantidade) {
                    var anterior = ponteiroAux-1

                    if(ponteiroAux == dados.size) {
                        ponteiroAux = 0
                    }
                    var atual = ponteiroAux

                    dados[atual] = dados[anterior]
                    ponteiroAux--
                }

                dados[posicaoReal(posicao)] = dado
                ponteiroFim++
                if (ponteiroFim == dados.size) {
                    ponteiroFim = 0
                }
                quantidade++
            } else {
                println("Indice Inválido")
            }
        } else {
            println("Lista Cheia!")
        }
    }

    override fun tamanho(): Int {
        return quantidade
    }

    override fun estaCheio(): Boolean {
        return quantidade == dados.size;
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0;
    }

    private fun posicaoReal(posicao: Int): Int{
        return (ponteiroInicio + posicao) % quantidade

    }

    private fun posicaoValida(posicao: Int): Boolean {
        return posicao < 0 || posicao > dados.size
    }

}