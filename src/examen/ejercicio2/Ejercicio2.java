package examen.ejercicio2;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio2 {
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner linea;
		System.out.print("> ");
		try {
			linea = new Scanner(teclado.nextLine());
			int n = linea.nextInt();
			int m = linea.nextInt();
			if (linea.hasNext()) {
				System.out.println("No se esperaban más números");
				System.exit(-1);
			}
			Set<Integer> primerConjunto = leerConjunto(n);
			Set<Integer> segundoConjunto = leerConjunto(m);
			segundoConjunto.removeAll(primerConjunto);
			System.out.println(segundoConjunto);
		}catch(InputMismatchException e) {
			System.out.println("Se esperaba un número entero");
			System.exit(-1);
		}
		catch(NoSuchElementException e) {
			System.out.println("Se esperaban dos números en esta linea");
			System.exit(-1);
		}


	}
	
	public static Set<Integer> leerConjunto (int n) {
		Set<Integer> s = new HashSet<>();
		try {
			for(int i=0; i<n; i++) {
				Scanner linea = new Scanner(teclado.nextLine());
				int num = linea.nextInt();
				if (linea.hasNext()) {
					System.out.println("No se esperaban más números");
					System.exit(-1);
				}
				s.add(num);
			}
		}catch(InputMismatchException e) {
			System.out.println("Se esperaba un número entero");
			System.exit(-1);
		}
		catch(NoSuchElementException e) {
			System.out.println("Se esperaban dos números en esta linea");
			System.exit(-1);
		}
		return s;
	}
}
