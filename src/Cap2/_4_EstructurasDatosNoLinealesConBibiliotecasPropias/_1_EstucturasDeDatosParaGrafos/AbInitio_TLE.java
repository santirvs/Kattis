package Cap2._4_EstructurasDatosNoLinealesConBibiliotecasPropias._1_EstucturasDeDatosParaGrafos;

import Utils.Kattio;


// Test case #4: WA -> Error en el módulo 1_000_000_007
//               TLE -> Usar Fast I/O -> AC
// Test case #6: TLE -> Las operaciones transponer y complemento son O(V^2)
//                      mantener la matriz transpuesta, la matriz complemento y la matriz de transpuesta y complemento
// Test case #2: RTE -> ArrayIndexOutOfBoundsException -> MAX_V = 4 -> MAX_V = 4000 -> AC
// Test case #11: TLE -> Hay que optimizar aún más....
//                       No veo por donde optimizar más



public class AbInitio_TLE {

    static class Grafo {
        int _V;
        int MAX_V = 4000;  //Máximo número de vértices segun el enunciado + número de vértices agregados

        //Usaremos 4 matrices para agilizar las operaciones de transponer y complemento
        boolean[][][] matricesAdyacencia = new boolean[4][MAX_V][MAX_V];
        //1 -> Matriz de adyacencia original
        //2 -> Matriz de adyacencia original transpuesta
        //3 -> Matriz de adyacencia complemento
        //4 -> Matriz de adyacencia complemento transpuesta

        public Grafo(int V) {
            _V = V;
            //Inicializar las matrices de adyacencia complemento
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (i!=j) {
                        matricesAdyacencia[2][i][j] = true;
                        matricesAdyacencia[3][j][i] = true;
                    }
                }
            }
        }

        public void agregarVertice() {
            //Partimos de una matriz de adyacencia de VxV inicializada a false
            //En ningún momento se decrementa el número de vértices, por lo que ya está inicializada
            //Únicamente hay que establecer las aristas de las matrices 2 y 3
            for (int i = 0; i < _V; i++) {
                matricesAdyacencia[2][i][_V] = true;
                matricesAdyacencia[3][_V][i] = true;
                matricesAdyacencia[2][_V][i] = true;
                matricesAdyacencia[3][i][_V] = true;
            }
            _V++;

        }

        public void agregarArista(int origen, int destino) {
            matricesAdyacencia[0][origen][destino] = true;
            matricesAdyacencia[1][destino][origen] = true;
            matricesAdyacencia[2][origen][destino] = false;
            matricesAdyacencia[3][destino][origen] = false;

        }

        public void eliminarAristasVertice(int vertice) {
            for (int i = 0; i < _V; i++) {
                if (i != vertice) {
                    eliminarArista(vertice, i);
                    eliminarArista(i, vertice);
                }
            }
        }

        public void eliminarArista(int origen, int destino) {
            matricesAdyacencia[0][origen][destino] = false;
            matricesAdyacencia[1][destino][origen] = false;
            matricesAdyacencia[2][origen][destino] = true;
            matricesAdyacencia[3][destino][origen] = true;
        }

        public void transponer() {
            //Intercambiar las matrices 0 y 1
            boolean[][] aux = matricesAdyacencia[0];
            matricesAdyacencia[0] = matricesAdyacencia[1];
            matricesAdyacencia[1] = aux;
            //Intercambiar las matrices 2 y 3
            aux = matricesAdyacencia[2];
            matricesAdyacencia[2] = matricesAdyacencia[3];
            matricesAdyacencia[3] = aux;
        }

        public void complemento() {
            //Intercambiar las matrices 0 y 2
            boolean[][] aux = matricesAdyacencia[0];
            matricesAdyacencia[0] = matricesAdyacencia[2];
            matricesAdyacencia[2] = aux;
            //Intercambiar las matrices 1 y 3
            aux = matricesAdyacencia[1];
            matricesAdyacencia[1] = matricesAdyacencia[3];
            matricesAdyacencia[3] = aux;
        }

    }

    public static void main(String[] args) {

        //Scanner scan = new Scanner(System.in);
        Kattio scan = new Kattio(System.in, System.out);

        //Leer los datos iniciales (vertices, aristas y consultas)
        int numVertices = scan.getInt();
        int numAristas = scan.getInt();
        int numConsultas = scan.getInt();

        //Crear el grafo
        Grafo grafo = new Grafo(numVertices);

        //Leer las aristas
        for (int i = 0; i < numAristas; i++) {
            int origen = scan.getInt();
            int destino = scan.getInt();
            grafo.agregarArista(origen, destino);
        }

        //Leer las consultas
        while (numConsultas > 0) {
            numConsultas--;
            int opcion = scan.getInt();
            switch (opcion) {
                case 1:
                    grafo.agregarVertice();
                    break;
                case 2:
                    int origen2 = scan.getInt();
                    int destino2 = scan.getInt();
                    grafo.agregarArista(origen2, destino2);
                    break;
                case 3:
                    int vertice = scan.getInt();
                    grafo.eliminarAristasVertice(vertice);
                    break;
                case 4:
                    int origen4 = scan.getInt();
                    int destino4 = scan.getInt();
                    grafo.eliminarArista(origen4, destino4);
                    break;
                case 5:
                    grafo.transponer();
                    break;
                case 6:
                    grafo.complemento();
                default:
                    break;
            }
        }

        //Generar la salida
        //Primera línea: Número de vértices del grafo
        System.out.println(grafo._V);
        //Segunda línea: Para cada vértice: Número de aristas salientes del vértice y hash de la lista de adyacencias del vértice
        for (int i=0; i< grafo._V; i++) {
            long hash = 0;
            long base = 1;
            long numAristasSalientes = 0;
            for (int j=0; j< grafo._V; j++) {
                if (grafo.matricesAdyacencia[0][i][j]) {
                    hash += base * j;
                    hash = hash % 1_000_000_007;
                    base *= 7;
                    base = base % 1_000_000_007;
                    numAristasSalientes++;
                }
            }
            System.out.println(numAristasSalientes+ " " + hash);
        }

        scan.flush();
        scan.close();

    }
}
