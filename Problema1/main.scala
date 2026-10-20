def crearTransformacion(factor: Double, desplazamiento: Double): Double => Double = {
    (x) => factor * x + desplazamiento
}

object main{
    def main(args: Array[String]): Unit = {
        val corregirError: Double => Double = crearTransformacion(1, -1.5)
        val calibrarSensor: Double => Double = crearTransformacion(1.04, 0)
        val convertirFahrnheit: Double => Double = crearTransformacion(1.8, 32)
        val procesarTemperatura: Double => Double = corregirError.andThen(calibrarSensor).andThen(convertirFahrnheit)
        println(procesarTemperatura(20))
        println(procesarTemperatura(30))
        println(procesarTemperatura(10))
    }
}