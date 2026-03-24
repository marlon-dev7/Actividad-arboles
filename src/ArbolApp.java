import java.util.Scanner; // Importa Scanner para leer datos por consola

// Clase que representa un nodo del árbol
class Nodo {
    int valor;       // Valor que almacena el nodo
    Nodo izq, der;   // Referencias a los hijos izquierdo y derecho

    // Constructor del nodo
    public Nodo(int valor) {
        this.valor = valor; // Asigna el valor al nodo
        izq = der = null;   // Inicialmente no tiene hijos
    }
}

// Clase del Árbol Binario de Búsqueda (BST)
class ArbolBinario {
    Nodo raiz; // Nodo raíz del árbol

    // Método para insertar un valor en el árbol
    Nodo insertar(Nodo nodo, int valor) {

        // Si el nodo actual es null, se crea uno nuevo
        if (nodo == null) {
            return new Nodo(valor);
        }

        // Si el valor es menor, se inserta en el subárbol izquierdo
        if (valor < nodo.valor) {
            nodo.izq = insertar(nodo.izq, valor);
        }
        // Si es mayor o igual, se inserta en el subárbol derecho
        else {
            nodo.der = insertar(nodo.der, valor);
        }

        return nodo; // Retorna el nodo actualizado
    }

    // Método para recorrer el árbol en inorden
    void inorden(Nodo nodo) {

        // Verifica que el nodo no sea null
        if (nodo != null) {

            inorden(nodo.izq); // Recorre el subárbol izquierdo

            System.out.print(nodo.valor + " "); // Imprime el valor del nodo

            inorden(nodo.der); // Recorre el subárbol derecho
        }
    }

    // Método para buscar un valor en el árbol
    boolean buscar(Nodo nodo, int valor) {

        // Si el nodo es null, el valor no existe
        if (nodo == null) return false;

        // Si el valor coincide, se encontró
        if (valor == nodo.valor) return true;

        // Si el valor es menor, buscar en el lado izquierdo
        if (valor < nodo.valor)
            return buscar(nodo.izq, valor);
        else
            // Si es mayor, buscar en el lado derecho
            return buscar(nodo.der, valor);
    }
}

// Clase principal con menú en consola
public class ArbolApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Objeto para leer datos
        ArbolBinario arbol = new ArbolBinario(); // Se crea el árbol

        int op;   // Variable para opción del menú
        int num;  // Variable para números ingresados

        do {
            // Menú de opciones
            System.out.println("\n1.Insertar  \n2.Inorden  \n3.Buscar  \n4.Salir");
            System.out.print("Opción: ");
            op = sc.nextInt(); // Lee la opción del usuario

            switch (op) {

                case 1:
                    // Insertar número en el árbol
                    System.out.print("Número a insertar: ");
                    num = sc.nextInt();

                    // Se actualiza la raíz al insertar
                    arbol.raiz = arbol.insertar(arbol.raiz, num);
                    break;

                case 2:
                    // Mostrar recorrido inorden
                    System.out.print("Recorrido inorden: ");
                    arbol.inorden(arbol.raiz);
                    System.out.println(); // Salto de línea
                    break;

                case 3:
                    // Buscar número en el árbol
                    System.out.print("Número a buscar: ");
                    num = sc.nextInt();

                    // Se evalúa si existe o no
                    if (arbol.buscar(arbol.raiz, num)) {
                        System.out.println("El número SI existe");
                    } else {
                        System.out.println("El número NO existe");
                    }
                    break;
            }

        } while (op != 4); // El programa se repite hasta que elija salir

        sc.close(); // Cierra el Scanner
    }
}
