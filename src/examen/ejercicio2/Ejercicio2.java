package examen.ejercicio2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio2 {
	static int n;
	static int m;
	static int numero;
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce n y m: ");
		n = teclado.nextInt();
		m = teclado.nextInt();
		
		for(int i=0; i<n+m; i++) {
			System.out.println("Introduce un numero:");
			numero = teclado.nextInt();
			leerConjunto(i).add(numero);
		}
	}
	
	public static Set<Integer> leerConjunto (int i) {
		Set<Integer> primerConjunto = new HashSet<Integer>();
		Set<Integer> segundoConjunto = new HashSet<Integer>();	
		if (i<= n) {
			primerConjunto.add(numero);
		}
		else {
			segundoConjunto.add(numero);
		}
		
		return segundoConjunto;
	}
}