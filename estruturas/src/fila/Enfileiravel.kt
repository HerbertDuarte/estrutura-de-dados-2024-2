package fila

interface Enfileiravel {

    fun estaCheia():Boolean
    fun estaVazia():Boolean

    fun imprimir(): String
    fun espiar():Any?

    fun atualizar(dado:Any)
    fun desempilhar():Any?
    fun empilhar(dado:Any)
}