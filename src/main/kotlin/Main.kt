var marcador = mutableListOf<Int>()
fun main() {
    val prueba1 = listOf(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8,6)
    val prueba2 = listOf(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 1,7)
    val prueba3 = listOf(7, 0, 8, 2, 0, 0, 10, 9, 0, 5, 5, 4, 4, 4, 4, 3, 6, 3, 1, 1)
    val prueba4 = listOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    try {
        println("Prueba 1: "+ calcular(prueba1))
        println("Prueba 2: "+ calcular(prueba2))
        println( "Prueba 3: "+ calcular(prueba3))
        println("Prueba 4: "+ calcular(prueba4))
    } catch (e: Exception) {
        println("Hubo un error")
    }
}
fun calcular(tiros: List<Int>): List<Int> {
    limpiar()
    var auxMarcador = 0
    var tiradas = 0
    while (tiradas < tiros.size && auxMarcador < marcador.size) {

        if (tiros[tiradas] == 10) {
            strike(marcador, tiros[tiradas], tiros[tiradas + 1], tiros[tiradas + 2], auxMarcador)
            tiradas++
        } else if (tiros[tiradas] + tiros[tiradas + 1] < 10) {
            open(marcador, tiros[tiradas], tiros[tiradas + 1], auxMarcador)
            if (tiradas + 2 >= tiros.size) {
                tiradas++
            } else {
                tiradas += 2
            }
        } else if (tiros[tiradas] + tiros[tiradas + 1] == 10) {
            spare(marcador, tiros[tiradas], tiros[tiradas + 1], tiros[tiradas + 2], auxMarcador)
            if (tiradas + 2 >= tiros.size) {
                tiradas++
            } else {
                tiradas += 2
            }
        }
        auxMarcador++
    }
    return marcador
}
 fun spare(marcador: MutableList<Int>, actual: Int, siguiente: Int, postsiguiente: Int, posicion: Int) {
    marcador[posicion] = marcador[posicion] + actual + siguiente + postsiguiente
    if (posicion < 9) {
        marcador[posicion + 1] = marcador[posicion]
    }
}
fun limpiar() {
    marcador = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
}
fun strike(marcador: MutableList<Int>, actual: Int, siguiente: Int, postsiguiente: Int, posicion: Int) {
    marcador[posicion] = marcador[posicion] + actual + siguiente + postsiguiente
    if (posicion < 9) {
        marcador[posicion + 1] = marcador[posicion]
    }

}
fun open(marcador: MutableList<Int>, actual: Int, siguiente: Int, posicion: Int) {

    marcador[posicion] = marcador[posicion] + actual + siguiente
    if (posicion < 9) {
        marcador[posicion + 1] = marcador[posicion]
    }
}
