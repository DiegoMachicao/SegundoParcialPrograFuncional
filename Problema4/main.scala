trait ambiental{ //servicios enfocados en cambiar algo del ambiente en vez de interactuar con personas
    def alterarAmbiente(): String
}

abstract class Servicio (
    val precio: Double,
    val encargado: String
) {
    def descripcion(): String
    def alterarPrecio(nuevoPrecio: Double): Servicio
}

class Fotografia(
    val lugar: String, //En donde se sacara la foto
    precio: Double,
    encargado: String
) extends Servicio(precio, encargado) {
    def descripcion(): String = s"La fotografia tiene un coste de $precio y está bajo la supervision de $encargado"
    def alterarPrecio(nuevoPrecio: Double): Servicio = Fotografia.crear(lugar, nuevoPrecio, encargado)
    def sacarFoto(): String = "Sonrian para la foto"
    def ubicacion(): String = s"La foto se sacara en $lugar"
}

object Fotografia{
    def crear(lugar: String, precio: Double, encargado: String): Fotografia = {
        if precio < 1000 then new Fotografia(lugar, 1000, encargado) //El servicio tiene un precio minimo
        else new Fotografia(lugar, precio, encargado)
    }
}

class Sonido(
    val dispositivo: String,
    precio: Double,
    encargado: String
) extends Servicio(precio, encargado) with ambiental{
    def descripcion(): String = s"El servicio de sonido tiene un precio de $precio, esta bajo la supervision de $encargado y se utiliza el dispositivo $dispositivo"
    def alterarPrecio(nuevoPrecio: Double): Servicio = Sonido.crear(dispositivo, nuevoPrecio, encargado)
    def alterarAmbiente(): String = s"Se esta empezando a reproducir canciones" 
}

object Sonido{
    def crear(dispositivo: String, precio: Double, encargado: String): Sonido = {
        if precio < 1300 then new Sonido(dispositivo, 1300, encargado)
        else new Sonido(dispositivo, precio, encargado)
    }
}

object main{
    def main(args: Array[String]): Unit = {
        val fotos = new Fotografia("Salon de eventos", 900, "Juan Mamani")
        val dj = new Sonido("Parlante", 1400, "Cristian Aguilar")
        println(fotos.descripcion())
        val fotos2 = fotos.alterarPrecio(1400)
        println(fotos2.descripcion())
        println(dj.alterarAmbiente())
    }
}