package fila

interface Enfileiravel {

    fun estaCheia():Boolean
    fun estaVazia():Boolean

    fun imprimir(): String
    fun atualizar(dado:Any)

    fun frente():Any?
    fun desenfileirar():Any?
    fun enfileirar(dado: Any)
}