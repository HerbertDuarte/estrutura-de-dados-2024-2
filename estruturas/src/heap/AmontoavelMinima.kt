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

    fun trocar (item1:Int, item2: Int) {
        val temp = dados[item1]
        dados[item1] = dados[item2]
        dados[item2] = temp
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
        val indicePai = indicePai(posicao)
        val indiceFilho = posicao
        val pai = dados[indicePai]
        val filho = dados[posicao]
        if(filho < pai){
            trocar(indicePai, indiceFilho)
            if (indicePai > 0){
                ajustarAcima(indiceFilho)
            }
        }
    }

    fun ajustarAbaixo(posicao: Int){
        val indiceFilhoDireito = indiceFilhoDireito(posicao)
        val indiceFilhoEsquerdo = indiceFilhoEsquerdo(posicao)
        val indicePai = posicao

        val pai = dados[indicePai]
        val filhoEsquerdo = dados[indiceFilhoEsquerdo]
        val filhoDireito = dados[indiceFilhoDireito]

        if(filhoDireito < pai){
            trocar(indicePai, indiceFilhoDireito)
            if (indiceFilhoDireito < ponteiroFim){
                ajustarAbaixo(indicePai)
            }
        }

        if(filhoEsquerdo < pai){
            trocar(indicePai, indiceFilhoEsquerdo)
            if (indiceFilhoEsquerdo < ponteiroFim){
                ajustarAcima(indicePai)
            }
        }
    }
}