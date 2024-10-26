package heap

class AmontoavelMinima (private val tamanho:Int) : Amontoavel {

    private var ponteiroFim: Int = -1
    private val dados = LongArray(tamanho)

    override fun inserir(dado: Long) {

        if(!estaCheia()){
            ponteiroFim++
            dados[ponteiroFim] = dado
            ajustarAcima(ponteiroFim)
        }

    }

    override fun atualizar(novoDado: Long) {
        if(!estaVazia()){
            dados[0] = novoDado
            ajustarAbaixo(0)
        }else{
            print("Lista vazia")
        }
    }

    override fun extrair() : Long?{
        var aux :Long? = null
        if(!estaVazia()){
            aux =  dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim--
            ajustarAbaixo(0)

        }else{
            print("Lista vazia")
        }
        return aux
    }


    override fun obter() : Long? {
        var aux :Long? = null
        if(!estaVazia()){
            aux =  dados[0]
        }else{
            print("Lista vazia")
        }
        return aux
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == tamanho -1
    }

    override fun estaVazia(): Boolean {
        return ponteiroFim == -1
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in dados) {
            resultado += "$i} "
        }
        return "$resultado]"
    }

    fun trocar (index:Int, indexSubstituto: Int) {
        val temp = dados[index]
        dados[index] = dados[indexSubstituto]
        dados[indexSubstituto] = temp
    }

    fun indiceFilhoEsquerdo(indicePai: Int): Int {
        return (indicePai * 2 ) + 1
    }

    fun indiceFilhoDireito(indicePai: Int): Int {
        return (indicePai * 2 )+ 2
    }

    fun indicePai(indiceFilho:Int):Int{
        return Math.floorDiv(indiceFilho - 1, 2)
    }

    fun ajustarAcima(posicao:Int){

    }

    fun ajustarAbaixo(posicao: Int){

    }
}