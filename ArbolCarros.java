// Clase para representar un nodo en el árbol
class Nodo {
    Carro data;
    Nodo izquierda, derecha;

    public Nodo(Carro carro) {
        data = carro;
        izquierda = derecha = null;
    }
}

// Clase para el árbol binario
class ArbolBinario {
    Nodo raiz;

    // 1. Añadir un carro al árbol binario
    public Nodo añadirCarro(Nodo nodo, Carro carro) {
        if (nodo == null) {
            return new Nodo(carro);
        }
        if (carro.placa < nodo.data.placa) {
            nodo.izquierda = añadirCarro(nodo.izquierda, carro);
        } else if (carro.placa > nodo.data.placa) {
            nodo.derecha = añadirCarro(nodo.derecha, carro);
        } else {
            System.out.println("Carro ya existe en el árbol");
        }
        return nodo;
    }

    // 2. Contar cuántos nodos (carros) hay en el árbol
    public int contarNodos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodos(nodo.izquierda) + contarNodos(nodo.derecha);
    }

    // 3. Calcular la altura del árbol
    public int calcularAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierda = calcularAltura(nodo.izquierda);
        int alturaDerecha = calcularAltura(nodo.derecha);
        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    // 4. Determinar si un nodo es hoja
    public boolean esHoja(Nodo nodo) {
        return nodo.izquierda == null && nodo.derecha == null;
    }

    // 5. Podar el árbol (eliminar todos los nodos hoja)
    public Nodo podarArbol(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        if (esHoja(nodo)) {
            return null;
        }
        nodo.izquierda = podarArbol(nodo.izquierda);
        nodo.derecha = podarArbol(nodo.derecha);
        return nodo;
    }
}

// Clase Carro para representar los datos de los carros
class Carro {
    int placa;

    public Carro(int placa) {
        this.placa = placa;
    }
}
