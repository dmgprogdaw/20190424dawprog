package examen.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException{
		Map<String, Map<String, Integer>> usuariosIp = new HashMap<>();
		Map<String, Integer> mensajeIp = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalMensajes = 0; //contador para el total de los mensajes
		int numIp = 0; //contador para el total de ips
		String ip = null , mensaje = null, usuario = null, linea;
		boolean fin = false;	
		do {
			System.out.print("> ");
			Scanner teclado = new Scanner(br.readLine());
			int estado = 0;
			String token = null;
			while(estado != 8) {
				switch(estado) {
					case 0:
						try {
							token = teclado.skip("terminar|Ip").match().group();
							if (token.equals("terminar")) {
								estado = 8;
								fin = true;
							}
							else if (token.equals("Ip")) {
								estado = 1;
							}
						} catch (NoSuchElementException e) {
							System.out.println("Se esperaba terminar o Ip");
							estado = 8;
						}
						break;
					case 1:
						try {				
							if(token == "Ip") {
								teclado.skip("=");	
								estado = 2;
							}
							else if (token == "mensaje") {
								teclado.skip("=");	
								estado = 4;
							}
							else if (token == "usuario") {
								teclado.skip("=");	
								estado = 6;
							}
						} catch (NoSuchElementException e) {
							System.out.println("Se esperaba el simbolo '='");
							estado = 8;
						}
						break;
					case 2:
						try {
							ip = teclado.skip("((\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5]).){3}(?:\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])").match().group();
							estado = 3;
							//(?:(?:\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5]).){3}(?:\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])A
						} catch (NoSuchElementException e) {
								System.out.println("Se esperaba una dirección ip válida");
							estado = 8;
						}
						break;
					case 3:
						try {
							token = teclado.skip("\\s*mensaje").match().group();					
							estado = 1;
						} catch (NoSuchElementException e) {
							System.out.println("Se esperaba 'mensaje'");
							estado = 8;
						}
						break;
					case 4:
						try {
							mensaje = teclado.skip("\\p{L}+").match().group();					
							estado = 5;
						} catch (NoSuchElementException e) {
							System.out.println("Se esperaba un mensaje");
							estado = 8;
						}
						break;
					case 5:
						try {
							token = teclado.skip("\\s*usuario").match().group();					
							estado = 1;
						} catch (NoSuchElementException e) {
							System.out.println("Se esperaba 'usuario'");
							estado = 8;
						}
						break;
					case 6:
						try {
							usuario = teclado.skip("\\p{L}+").match().group();
						} catch (NoSuchElementException e) {
							System.out.println("Se esperaba un usuario");
							estado = 8;
						}
						break;
				}
			}
		}while (!fin);
	}
}

/*
 case 3:
						try {
							token = teclado.skip("mensaje").match().group();
							estado = 1;
						} catch (NoSuchElementException e) {
								System.out.println("Se esperaba mensaje");
							estado = 8;
						}
					case 4:
						try {
							mensaje = teclado.skip("\\p{L}+").match().group();
							estado = 5;
						} catch (NoSuchElementException e) {
								System.out.println("Se esperaba un mensaje");
							estado = 8;
						}
					case 5:
						try {
							mensaje = teclado.skip("usuario").match().group();
							estado = 1;
						} catch (NoSuchElementException e) {
								System.out.println("Se esperaba usuario");
							estado = 8;
						}
					case 6:
						try {
							usuario = teclado.skip("\\p{L}+").match().group();
							
						} catch (NoSuchElementException e) {
								System.out.println("Se esperaba un usuario");
							estado = 8;
						}
					case 7:
						try {
							usuario = teclado.skip("\\p{L}+").match().group();
							
						} catch (NoSuchElementException e) {
								System.out.println("Se esperaba un usuario");
							estado = 8;
						}
*/
