import estruturas_dinamicas.PilhaDinamica
import pilha.Empilhavel

fun main() {
    val pilha: Empilhavel = PilhaDinamica(10)

    pilha.empilhar("1")
    pilha.empilhar("2")
    pilha.empilhar("3")
    pilha.empilhar("4")
    pilha.empilhar("5")
    pilha.empilhar("6")
    print(pilha.imprimir())
}