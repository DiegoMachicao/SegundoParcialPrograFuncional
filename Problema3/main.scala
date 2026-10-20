def procesarRango(desde: Int, hasta: Int, transformar: Int => Int, combinar: (Int, Int) => Int, valorInicial: Int): Int = {
    if desde == hasta then combinar(valorInicial, transformar(desde))
    else procesarRango(desde + 1, hasta, transformar, combinar, combinar(transformar(desde), valorInicial))
}

def buscar(desde: Int, hasta: Int, condicion: Int => Boolean): Int = {
    if condicion(desde) then desde
    else if desde == hasta then -1
    else buscar(desde + 1, hasta, condicion)
}

def contarDivisores(numero: Int): Int = {
    def aux(numero: Int, divisores: Int = 0, acc: Int = 1): Int = {
        if acc > numero then divisores
        else if numero%acc == 0 then aux(numero, divisores + 1, acc + 1)
        else aux(numero, divisores, acc + 1)
    }
    aux(numero)
}

def maximo(a: Int, b: Int): Int = 
    if a > b then a else b

def esPrimo(numero: Int): Boolean = {
    def aux(numero: Int, divisores: Int = 0, acc: Int = 1): Boolean = {
        if acc > numero then divisores == 2
        else if numero%acc == 0 then aux(numero, divisores + 1, acc + 1)
        else aux(numero, divisores, acc + 1)
    }
    aux(numero)
}

object main{
    def main(args: Array[String]): Unit = {
        println(procesarRango(5, 10, contarDivisores, maximo, 0))
        println(procesarRango(22, 26, contarDivisores, maximo, 0))
        println(buscar(6, 11, esPrimo))
        println(buscar(24, 28, esPrimo))
    }
}