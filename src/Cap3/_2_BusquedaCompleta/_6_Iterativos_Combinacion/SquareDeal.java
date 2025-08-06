package Cap3._2_BusquedaCompleta._6_Iterativos_Combinacion;

import java.util.*;

// Calcular todas las combinaciones

public class SquareDeal {

    // Clase para representar un rectángulo con sus lados ordenados (lado corto, lado largo)
    static class Rect {
        int a, b;

        Rect(int a, int b) {
            // Guardamos siempre el lado más pequeño en a, y el más grande en b
            this.a = Math.min(a, b);
            this.b = Math.max(a, b);
        }
    }

    static Rect[] rects = new Rect[3];  // Array para guardar los 3 rectángulos
    static boolean[] used = new boolean[3];  // Marca si ya hemos usado cada rectángulo en la búsqueda

    // Devuelve true si ya hemos utilizado los 3 rectángulos
    static boolean allUsed() {
        for (boolean u : used) {
            if (!u) return false;
        }
        return true;
    }

    /**
     * Función recursiva que intenta llenar un cuadrado de dimensiones a x b
     * usando los rectángulos disponibles aún no usados.
     * @param a ancho del área restante del cuadrado
     * @param b alto del área restante del cuadrado
     * @return true si se puede completar con los rectángulos que quedan
     */
    static boolean possible(int a, int b) {
        // Caso base inválido: dimensiones negativas
        if (a < 0 || b < 0) return false;

        // Caso base válido: hemos llenado completamente el cuadrado y usamos los 3 rectángulos
        if ((a == 0 || b == 0) && allUsed()) return true;

        // Probar colocar cada rectángulo aún no usado
        for (int i = 0; i < 3; i++) {
            if (used[i]) continue;

            Rect r = rects[i];
            used[i] = true;  // Marcamos este rectángulo como usado

            // Intentamos colocar el rectángulo de distintas maneras:

            // Colocar verticalmente si coincide el ancho
            if (a == r.a && possible(a, b - r.b)) return true;

            // Colocar verticalmente rotado
            if (a == r.b && possible(a, b - r.a)) return true;

            // Colocar horizontalmente si coincide el alto
            if (b == r.a && possible(a - r.b, b)) return true;

            // Colocar horizontalmente rotado
            if (b == r.b && possible(a - r.a, b)) return true;

            // Si no funcionó, desmarcamos el rectángulo y probamos con otros
            used[i] = false;
        }

        // Si ninguna combinación funciona
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int side = 0;  // Guardaremos aquí el lado mayor, posible lado del cuadrado final

        // Leer los 3 rectángulos y determinar el lado máximo
        for (int i = 0; i < 3; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            rects[i] = new Rect(a, b);
            // El lado del cuadrado debe ser al menos tan largo como el lado más largo de cualquier rectángulo
            side = Math.max(side, Math.max(a, b));
        }

        // Llamar a la función de búsqueda: ¿podemos formar un cuadrado de lado 'side'?
        System.out.println(possible(side, side) ? "YES" : "NO");
    }
}
