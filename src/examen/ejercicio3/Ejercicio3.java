package examen.ejercicio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio3 {
	static Map<String, Map<String, Integer>> mensajes = new HashMap<>();
	
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		int totalMensajes = 0;
		int mensajeIp;
		int numIp = 0;
		String ip;
		String mensaje;
		String usuario;
			
		do {
			System.out.print("IP= ");
			ip = teclado.nextLine();
			System.out.print("mensaje= ");
			mensaje = teclado.nextLine();
			System.out.print("usuario= ");
			usuario = teclado.nextLine();
			
			mensajeIp = 0;
			mensajes.put(usuario, mensajes.put(ip, mensajes.get(mensajeIp)));
				
			if (mensajes.containsKey(usuario)) {
				if (mensajes.containsKey(ip)) {			
					mensajeIp = mensajeIp + 1;
				}
				numIp = numIp +1;
				totalMensajes = totalMensajes + mensajeIp;
			}
			
			System.out.println("nombre de usuario: " + usuario);
			System.out.println(ip + "=> " + mensajeIp);
			System.out.println("Número de Ips: " + numIp);
			System.out.println("Total de mensajes: " + totalMensajes);
				
		}while(!ip.equals("terminar"));
	}
}


