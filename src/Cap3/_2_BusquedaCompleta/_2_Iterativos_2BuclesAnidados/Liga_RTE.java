package Cap3._2_BusquedaCompleta._2_Iterativos_2BuclesAnidados;

import java.util.Scanner;

// El objetivo es resolver un problema de una liga de fútbol donde se deben calcular los puntos y partidos jugados por un equipo.
// Hay dos reglas principales:
//  jugados = ganados + empatados + perdidos
//  puntos = 3 * ganados + empatados
// Si hay desconocidos, se deben deducir los valores a partir de los otros conocidos usando las fórmulas anteriores.
// O bien se pueden probar todas las combinaciones posibles de ganados y empatados (máximo 100 partidos jugados!).

// Da RTE en algún momento... revisar la traducción desde Python
//    ... y organizar el código para evitar repeticiones

public class Liga_RTE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Leer el número de equipos
        int numEquipos = Integer.parseInt(sc.nextLine());

        // Procesar cada caso de equipo. Se trata de casos independientes (lo dice el enunciado)
        for (int test = 0; test < numEquipos; test++) {
            //Leer las datos de la entrada
            String[] parts = sc.nextLine().trim().split("\\s+");
            String sJugados = parts[0];
            String sGanados = parts[1];
            String sEmpatados = parts[2];
            String sPerdidos = parts[3];
            String sPuntos = parts[4];
            int desconocidos = 5;

            Integer jugados = null, ganados = null, empatados = null, perdidos = null, puntos = null;

            //Revisar cada uno de los datos y convertirlos a enteros si no son desconocidos
            if (!sJugados.equals("?")) {
                jugados = Integer.parseInt(sJugados);
                desconocidos--;
            }
            if (!sGanados.equals("?")) {
                ganados = Integer.parseInt(sGanados);
                desconocidos--;
            }
            if (!sEmpatados.equals("?")) {
                empatados = Integer.parseInt(sEmpatados);
                desconocidos--;
            }
            if (!sPerdidos.equals("?")) {
                perdidos = Integer.parseInt(sPerdidos);
                desconocidos--;
            }
            if (!sPuntos.equals("?")) {
                puntos = Integer.parseInt(sPuntos);
                desconocidos--;
            }

            // Si no hay desconocidos, simplemente imprimimos los valores
            if (desconocidos == 0) {
                System.out.println(jugados + " " + ganados + " " + empatados + " " + perdidos + " " + puntos);
                continue;
            }

            // jugados == ? and perdidos == ?
            if (jugados == null && perdidos == null) {
                if (ganados == null && empatados != null && puntos != null) {
                    ganados = (puntos - empatados) / 3;
                } else if (ganados != null && empatados == null && puntos != null) {
                    empatados = puntos - 3 * ganados;
                } else if (ganados == null && empatados == null) {
                    // Pruebas todas las combinaciones de ganados y empatados (bb y cc)
                    // 10404 = 102 * 102 (límite máximo es 100, pero se ajusta a 102 por ser múltiplo de 3 (puntos de partido ganado))
                    for (int bc = 0; bc < 10404; bc++) {
                        int candidatoGanados = bc / 102;
                        int candidatoEmpatados = bc % 102;
                        if ((candidatoGanados + candidatoEmpatados < 101) && (puntos == null || puntos == 3 * candidatoGanados + candidatoEmpatados)) {
                            ganados = candidatoGanados;
                            empatados = candidatoEmpatados;
                            break;
                        }
                    }
                }
                System.out.println("100 " + ganados + " " + empatados + " 0 " + (3 * ganados + empatados));
            }

            // jugados == ?
            else if (jugados == null) {
                if (ganados == null && empatados != null && puntos != null) {
                    ganados = (puntos - empatados) / 3;
                } else if (ganados != null && empatados == null && puntos != null) {
                    empatados = puntos - 3 * ganados;
                } else if (ganados == null && empatados == null) {
                    // Pruebas todas las combinaciones de ganados y empatados (bb y cc)
                    // 10404 = 102 * 102 (límite máximo es 100, pero se ajusta a 102 por ser múltiplo de 3 (puntos de partido ganado))
                    for (int bc = 0; bc < 10404; bc++) {
                        int candidatoGanados = bc / 102;
                        int candidatoEmpatados = bc % 102;
                        if ((candidatoGanados + candidatoEmpatados < 101) && (puntos == null || puntos == 3 * candidatoGanados + candidatoEmpatados)) {
                            ganados = candidatoGanados;
                            empatados = candidatoEmpatados;
                            break;
                        }
                    }
                }
                jugados = ganados + empatados + perdidos;
                puntos = 3 * ganados + empatados;
                System.out.println(jugados + " " + ganados + " " + empatados + " " + perdidos + " " + puntos);
            }

            // perdidos == ?
            else if (perdidos == null) {
                if (ganados == null && empatados != null && puntos != null) {
                    ganados = (puntos - empatados) / 3;
                } else if (ganados != null && empatados == null && puntos != null) {
                    empatados = puntos - 3 * ganados;
                } else if (ganados == null && empatados == null) {
                    // Pruebas todas las combinaciones de ganados y empatados (bb y cc)
                    // 10404 = 102 * 102 (límite máximo es 100, pero se ajusta a 102 por ser múltiplo de 3 (puntos de partido ganado))
                    for (int bc = 0; bc < 10404; bc++) {
                        int candidatoGanados = bc / 102;
                        int candidatoEmpatados = bc % 102;
                        if ((candidatoGanados + candidatoEmpatados < 101) && (puntos == null || puntos == 3 * candidatoGanados + candidatoEmpatados)) {
                            ganados = candidatoGanados;
                            empatados = candidatoEmpatados;
                            break;
                        }
                    }
                }
                perdidos = jugados - ganados - empatados;
                puntos = 3 * ganados + empatados;
                System.out.println(jugados + " " + ganados + " " + empatados + " " + perdidos + " " + puntos);
            }

            // jugados and perdidos son conocidos
            else {
                if (ganados == null && empatados != null && puntos != null) {
                    ganados = (puntos - empatados) / 3;
                } else if (ganados != null && empatados == null && puntos != null) {
                    empatados = puntos - 3 * ganados;
                } else if (ganados == null && empatados == null) {
                    // Pruebas todas las combinaciones de ganados y empatados (bb y cc)
                    // 10404 = 102 * 102 (límite máximo es 100, pero se ajusta a 102 por ser múltiplo de 3 (puntos de partido ganado))
                    for (int bc = 0; bc < 10404; bc++) {
                        int candidatoGanados = bc / 102;
                        int candidatoEmpatados = bc % 102;
                        if ((candidatoGanados + candidatoEmpatados < 101) && (puntos == null || puntos == 3 * candidatoGanados + candidatoEmpatados)) {
                            ganados = candidatoGanados;
                            empatados = candidatoEmpatados;
                            break;
                        }
                    }
                } else if (puntos == null) {
                    puntos = 3 * ganados + empatados;
                }
                System.out.println(jugados + " " + ganados + " " + empatados + " " + perdidos + " " + puntos);
            }
        }
    }
}


//Traducción desde el original en Python: https://github.com/RussellDash332/kattis/blob/main/src/Liga/liga.py
/*
for _ in range(int(input())):
    a, b, c, d, e = input().strip().split(); u = 5
    if a != '?': u -= 1; a = int(a)
    if b != '?': u -= 1; b = int(b)
    if c != '?': u -= 1; c = int(c)
    if d != '?': u -= 1; d = int(d)
    if e != '?': u -= 1; e = int(e)
    if not u: print(a, b, c, d, e)
    else:
        if a == '?' and d == '?':
            if b != '?' and c != '?': pass
            elif b != '?': c = e-3*b if e != '?' else 0
            elif c != '?': b = (e-c)//3 if e != '?' else 0
            else:
                for bc in range(10404):
                    b, c = bc//102, bc%102
                    if b+c<101 and e==3*b+c: break
            print(100, b, c, 0, 3*b+c)
        elif a == '?':
            if b != '?' and c != '?': pass
            elif b != '?': c = e-3*b if e != '?' else 0
            elif c != '?': b = (e-c)//3 if e != '?' else 0
            else:
                for bc in range(10404):
                    b, c = bc//102, bc%102
                    if b+c+d<101 and (e=='?' or e==3*b+c): break
            print(b+c+d, b, c, d, 3*b+c)
        elif d == '?':
            if b != '?' and c != '?': pass
            elif b != '?': c = e-3*b if e != '?' else 0
            elif c != '?': b = (e-c)//3 if e != '?' else 0
            else:
                for bc in range(10404):
                    b, c = bc//102, bc%102
                    if b+c<=min(a,100) and (e=='?' or e==3*b+c): break
            print(a, b, c, a-b-c, 3*b+c)
        else:
            if b != '?' and c != '?': pass
            elif b != '?': c = e-3*b if e != '?' else a-b-d
            elif c != '?': b = (e-c)//3 if e != '?' else a-c-d
            else:
                for bc in range(10404):
                    b, c = bc//102, bc%102
                    if b+c+d==a and (e=='?' or e==3*b+c): break
            print(a, b, c, d, 3*b+c)
 */
