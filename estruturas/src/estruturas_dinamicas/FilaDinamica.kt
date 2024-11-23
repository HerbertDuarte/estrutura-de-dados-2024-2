package estruturas_dinamicas

import fila.Enfileiravel

abstract class FilaDinamica (val tamanho:Int): Enfileiravel {
    private var ponteiroFim: NoDuplo? = null
    private var ponteiroInicio: NoDuplo? = null
    private var quantidade: Int = 0

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {

        var aux = ponteiroFim
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

    override fun atualizar(dado: Any) {
        if(!estaVazia()){
            ponteiroFim?.dado = dado as Any
        }else{
            println("pilha vazia")
        }
    }


    override fun frente(): Any? {
        if(estaVazia()){
            throw NoSuchElementException("Lista vazia.")
        }
        return ponteiroInicio?.dado
    }

    override fun desenfileirar(): Any? {
        if(estaVazia()){
            throw NoSuchElementException("Lista vazia.")
        }

        var aux = ponteiroInicio?.dado
        ponteiroInicio = ponteiroInicio?.proximo
        if(ponteiroInicio != null){
            ponteiroInicio?.anterior = null
        }else{
            ponteiroFim = null
        }
        quantidade--

        return aux
    }

    override fun enfileirar(dado: Any){
        if(estaVazia())
            throw NoSuchElementException("Lista cheia.")

        var novoNoDuplo = NoDuplo(dado)
        if(ponteiroFim != null)
            ponteiroFim?.proximo = novoNoDuplo.proximo
        else
            ponteiroInicio = novoNoDuplo
        novoNoDuplo.anterior = ponteiroFim
        ponteiroFim = novoNoDuplo

        quantidade++
    }

}