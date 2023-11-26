package Java;

import java.util.Scanner;

public class MainPuzzle {

    public static void main(String[] args) {
        // Crea estado inicial y objetivo
        String estadoInicial = "12345678 ";
        String estadoObjetivo = "12345678 ";

        String estadoInicial2 = "123 45678";
        String estadoObjetivo2 = "12345678 ";

        // Crea estados raíz
        Nodo raiz1 = new Nodo(estadoInicial);
        Nodo raiz2 = new Nodo(estadoInicial2);

        // Crea instancias de arbol de búsqueda con diferentes heurísticas
        ArbolDeBusqueda busqueda1 = new ArbolDeBusqueda(raiz1, estadoObjetivo);
        ArbolDeBusqueda busqueda2 = new ArbolDeBusqueda(raiz1, estadoObjetivo);
        ArbolDeBusqueda busqueda3 = new ArbolDeBusqueda(raiz1, estadoObjetivo);

        busqueda1.busquedaPorAnchuraConHeuristica(1);
        busqueda2.busquedaPorAnchuraConHeuristica(2);
        busqueda3.busquedaPorAnchuraConHeuristica(3);

        // Resultados
        System.out.println(" Algorithm  | Complejidad tiempo | Complejidad espacio");
        System.out.println("------------------------------------------------------");
        System.out.println("Heuristic 1 |       " + busqueda1.TiempoH1 + " ms         |        " + busqueda1.FinalH1.prof);
        System.out.println("Heuristic 2 |       " + busqueda2.TiempoH2 + " ms         |        " + busqueda2.FinalH2.prof);
        System.out.println("Heuristic 3 |       " + busqueda3.TiempoH3 + " ms         |        " + busqueda3.FinalH3.prof);
    }
}