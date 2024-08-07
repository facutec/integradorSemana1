// Definir un data class de Producto
data class Producto(var nombre: String, var precio: Double)

// Definir la mutableList
var menu = mutableListOf<Producto>()

fun main() {
    var opcion: Int

    do {
        imprimirMenuPrincipal()
        opcion = leerOpcion()

        when (opcion) {
            1 -> agregarProducto(menu)
            2 -> mostrarMenu(menu)
            3 -> eliminarProducto(menu)
            4 -> actualizarProducto(menu)
            5 -> println("Saliendo de la aplicación...")
            else -> println("Opción inválida. Por favor, elija una opción válida.")
        }
    } while (opcion != 5)
}

// Imprimir el menú principal
fun imprimirMenuPrincipal() {
    println("Menú de la Cafetería")
    println("1. Agregar producto")
    println("2. Mostrar menú")
    println("3. Eliminar producto")
    println("4. Actualizar producto")
    println("5. Salir")
    println("Ingrese una opción:")
}

// Leer la opción del usuario
fun leerOpcion(): Int {
    return try {
        readLine()?.toInt() ?: 0
    } catch (e: Exception) {
        println("Entrada inválida. Por favor, ingrese un número.")
        0
    }
}

// Agregar producto al menú
fun agregarProducto(menu: MutableList<Producto>) {
    try {
        println("Ingrese el nombre del producto: ")
        val nombre = readLine() ?: ""
        println("Ingrese el precio del producto: ")
        val precio = readLine()!!.toDouble()
        menu.add(Producto(nombre, precio))
        println("Producto ingresado con éxito!")
        println("----------------".repeat(4))
    } catch (e: Exception) {
        println("Ha ocurrido un error: ${e.message}. Intente nuevamente.")
    }
}

// Mostrar el menú
fun mostrarMenu(menu: MutableList<Producto>) {
    if (menu.isEmpty()) {
        println("No hay productos en el menú...")
    } else {
        menu.forEachIndexed { index, producto ->
            println("${index + 1} - Nombre: ${producto.nombre} - Precio: \$${"%.2f".format(producto.precio)}")
        }
        println("----------------".repeat(4))
    }
}

// Actualizar un producto del menú
fun actualizarProducto(menu: MutableList<Producto>) {
    mostrarMenu(menu)
    try {
        println("¿Cuál es el índice del producto a actualizar?")
        val opcion = readLine()!!.toInt()
        val productoEncontrado = menu.getOrNull(opcion - 1)
        if (productoEncontrado != null) {
            println("Ingrese el nuevo nombre del producto:")
            productoEncontrado.nombre = readLine().toString()
            println("Ingrese el nuevo precio del producto:")
            productoEncontrado.precio = readLine()!!.toDouble()
            println("El producto se ha actualizado con éxito!")
            println("----------------".repeat(4))
        } else {
            println("El producto no fue encontrado en el menú...")
        }
    } catch (e: Exception) {
        println("Ha ocurrido un error: ${e.message}. Intente nuevamente.")
    }
}

// Eliminar un producto del menú
fun eliminarProducto(menu: MutableList<Producto>) {
    mostrarMenu(menu)
    try {
        println("¿Cuál es el índice del producto a eliminar?")
        val opcion = readLine()!!.toInt()
        val productoEncontrado = menu.getOrNull(opcion - 1)
        if (productoEncontrado != null) {
            menu.removeAt(opcion - 1)
            println("Producto eliminado!")
            println("----------------".repeat(4))
        } else {
            println("El producto no fue encontrado en el menú...")
        }
    } catch (e: Exception) {
        println("Ha ocurrido un error: ${e.message}. Intente nuevamente.")
    }
}