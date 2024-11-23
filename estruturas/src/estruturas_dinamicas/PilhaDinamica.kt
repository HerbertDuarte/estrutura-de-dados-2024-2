package estruturas_dinamicas

import pilha.Empilhavel

class PilhaDinamica (var tamanho:Int): Empilhavel {
    private var ponteiroTopo: NoDuplo? = null
    private var quantidade: Int = 0

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {

        var aux = ponteiroTopo
        var retorno = "["
        while (aux != null){
            retorno+= aux.dado
            retorno+= ","
            aux = aux.anterior
        }
        if(retorno.endsWith(",")){
            retorno = retorno.dropLast(1)
        }

        retorno+= "]"

        return retorno

    }

    override fun espiar(): Any? {
        var dadoAux:Any? = null

        if(!estaVazia()){
            dadoAux = ponteiroTopo?.dado
        }else{
            println("pilha vazia")
        }

        return dadoAux;
    }

    override fun atualizar(dado: Any) {
        if(!estaVazia()){
            ponteiroTopo?.dado = dado as Any
        }else{
            println("pilha vazia")
        }
    }

    override fun desempilhar(): Any? {
        var dadoAux:Any? = null
        if(!estaVazia()){
            dadoAux= ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior as NoDuplo
            ponteiroTopo?.proximo = null
            quantidade--
        }else{
            println("pilha vazia")
        }

        return dadoAux
    }

    override fun empilhar(dado: Any) {
        if(!estaCheia()){
            var novoNoDuplo = NoDuplo(dado)
            if(!estaVazia()){
                ponteiroTopo?.proximo = novoNoDuplo
            }
            novoNoDuplo.anterior = ponteiroTopo
            quantidade++
            ponteiroTopo = novoNoDuplo
        }else{
            println("pilha cheia")
        }
    }



}