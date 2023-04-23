import java.io.*;
import java.util.Scanner;

public class TallerProgra {

	public static int leerIAS(String[] IAS, int[] AÑOS, int[] VEL_APRENDIZAJES, String[] TIPOS_IAS, String[] CREADORES, int[] CANT_MEJORAS ) {
		int n = 0;
		try {
			Scanner scan = new Scanner(new File("datos_ia.txt"));
			n = Integer.parseInt(scan.nextLine());//Representa la cantidad de archivos a leer
			int cantIAS = 0;
			
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				String nombreIA = partes[0];
				int añoCreacion = Integer.parseInt(partes[1]);
				int velAprendizaje = Integer.parseInt(partes[2]);
				String tipoIA = partes[3];
				String creador = partes[4];
				int cantMejoras = Integer.parseInt(partes[5]);
				
				IAS[cantIAS] = nombreIA;
				AÑOS[cantIAS] = añoCreacion;
				VEL_APRENDIZAJES[cantIAS] = velAprendizaje;
				TIPOS_IAS[cantIAS] = tipoIA;
				CREADORES[cantIAS] = creador;
				CANT_MEJORAS[cantIAS] = cantMejoras;
				cantIAS++;
			}
			scan.close();
			
			
		} 
		catch(IOException e) {
			System.err.println("Error al leer el archivo 'datos_ia.txt': " + e.getMessage());
			
		}
		return n;
	}
	
	public static int buscarElemento(String[] lista, String elemento) {
		   for (int i = 0; i < lista.length; i++) {
		       if (lista[i].equals(elemento)) {
		           return i;
		       }
		   }
		   return -1;
		}
	
	public static int verificarUsuario(String[] Usuarios, String[] Passwords, String[] categoriaUsuarios, String[] creadorUsuario, String nombreLogin, String contraLogin ) {
		int usuario = 0;
		try {
			Scanner scan = new Scanner(new File("datos_usuarios.txt"));
			int cantUsuarios = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				String nombreUsuario = partes[0];
				String password = partes[1];
				String catUsuario = partes[2];
				String nombreCreador = partes[3];
				
				Usuarios[cantUsuarios] = nombreUsuario;
				Passwords[cantUsuarios] = password;
				categoriaUsuarios[cantUsuarios] = catUsuario;
				creadorUsuario[cantUsuarios] = nombreCreador;
				cantUsuarios++;
			}
			scan.close();
				
			int posUsuario = buscarElemento(Usuarios, nombreLogin);
				
			if(posUsuario != -1 && Passwords[posUsuario].equals(contraLogin)) {
					usuario = 1;
			} else {
					usuario = 0;
				}
			
		} 
		catch(IOException e){
			System.out.println(e.getMessage());
			
		}
		return usuario;
		
	}
	
	public static String comprobarCategoria(String[] Usuarios, String[] Categorias, int posUsuario) {
		String categoriaa = "";
		try {
			Scanner scan = new Scanner(new File("datos_usuarios.txt"));
			int cantUsuarios = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				String categoria = partes[2];
				
				Categorias[cantUsuarios] = categoria;
				cantUsuarios++;
				
			}
			categoriaa = Categorias[posUsuario];
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			
		}
		return categoriaa;
	}
	
	public static String comprobarEspecialidad(String [] creadorUsuarios, String[] CREADORES, String[] ESPECIALIDADES, int posUsuario) {
		String especialidadd = "";
		try {
			Scanner scan = new Scanner(new File("datos_usuarios.txt"));
			int cantUsuarios = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(","); 
				String nombreCreador = partes[3];
				
				creadorUsuarios[cantUsuarios] = nombreCreador;
				cantUsuarios++;
				
			}
			scan.close();
			
			Scanner scanner = new Scanner(new File("datos_creadores.txt"));
			int cantCreadores = 0;
			
			while(scanner.hasNextLine()) {
				String[] partes = scanner.nextLine().split(",");
				String creador = partes[0];
				String especialidad = partes[2];
				
				CREADORES[cantCreadores] = creador;
				ESPECIALIDADES[cantCreadores] = especialidad;
				cantCreadores++;
				
				
				} 
				
				
			scanner.close();
			
			for (int i = 0; i < cantUsuarios; i++) {
	            if (creadorUsuarios[posUsuario].equals(CREADORES[i])) {
	                especialidadd = ESPECIALIDADES[i].toLowerCase();
	                break;
				}
			}
			
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			
		}
		return especialidadd;
	}
	
	public static String[] leerDatosIA(String[] IAS, String[] AÑOS, String[] VEL_APRENDIZAJE, String[] TIPOS_IAS, String[] CREADORES, String[] CANT_MEJORAS, String retorno) {
		String[] retornooString = new String[100];
		try {
			Scanner scan = new Scanner(new File("datos_ia.txt"));
			int cantIAS = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				String nombreIA = partes[0];
				String añoCreacionIA = partes[1];
				String velAprendizajeIA = partes[2];
				String tipoIA = partes[3];
				String creadorIA = partes[4];
				String cantMejorasIA = partes[5];
				
				IAS[cantIAS] = nombreIA;
				AÑOS[cantIAS] = añoCreacionIA;
				VEL_APRENDIZAJE[cantIAS] = velAprendizajeIA;
				TIPOS_IAS[cantIAS] = tipoIA;
				CREADORES[cantIAS] = creadorIA;
				CANT_MEJORAS[cantIAS] = cantMejorasIA;
				cantIAS++;
				
			}
			scan.close();
			String[] retornoString = new String[cantIAS];
			
			if(retorno.equals("ias")) {
				for(int i = 0; i < cantIAS; i++) {
					retornoString[i] = IAS[i];
				}
				return retornoString;
			} else if(retorno.equals("años")) {
				for(int i = 0; i < cantIAS; i++) {
					retornoString[i] = AÑOS[i];
				}
				return retornoString;
			} else if(retorno.equals("vel_aprendizaje")) {
				for(int i = 0; i < cantIAS; i++) {
					retornoString[i] = VEL_APRENDIZAJE[i];
				}
				return retornoString;
			} else if(retorno.equals("tipos_ias")) {
				for(int i = 0; i < cantIAS; i++) {
					retornoString[i] = TIPOS_IAS[i];
				}
				return retornoString;
			} else if(retorno.equals("creador_ia")) {
				for(int i = 0; i < cantIAS; i++) {
					retornoString[i] = CREADORES[i];
				}
				return retornoString;
			} else if(retorno.equals("cant_mejoras")) {
				for(int i = 0; i < cantIAS; i++) {
					retornoString[i] = CANT_MEJORAS[i];
				}
				return retornoString;
			}
			

			
			
			
			
		for(int i = 0; i < cantIAS; i++) {
			retornooString[i] = retornoString[i];
		}
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		return retornooString;

	}
	
	
	
	
	
	
	
	public static void desplegarMenuNormal(String Especialidad, int posUsuario) {
			Scanner scan = new Scanner(System.in);
			
			//Vectores para el texto datos_ias.txt
			String[] IAS = new String[100];
			String[] AÑOS = new String[100];
			String[] VEL_APRENDIZAJES = new String[100];
			String[] TIPOS_IAS = new String[100];
			String[] CREADORES = new String[100];
			String[] CANT_MEJORAS = new String[100];
			
			
			
			
			if(Especialidad.equals("mejora de ia")) {
				String retorno = "ias";
				leerDatosIA(IAS, AÑOS, VEL_APRENDIZAJES, TIPOS_IAS, CREADORES, CANT_MEJORAS, retorno);
				int cantDatos =  leerDatosIA(IAS, AÑOS, VEL_APRENDIZAJES, TIPOS_IAS, CREADORES, CANT_MEJORAS, retorno).length;
				System.out.println("¿Que IA deseas mejoras?: ");
				for(int i = 0; i < cantDatos; i++) {
					System.out.println(i + "." + IAS[i]);
					
				}
				
			}
			scan.close();
			
				
				
					

			
			
			
		
	
	}
	
	public static void desplegarMenu(String[] IAS, int[] AÑOS, int[] VEL_APRENDIZAJES, 
			String[] TIPOS_IAS, String[] CREADORES, int[] CANT_MEJORAS, String[] categoriaUsuarios, 
			String[] creadorUsuario, String[] NOMBRE_CREADORES, int[] EXPERIENCIA, String[] ESPECIALIDADES, 
			int[] EDADES , int posUsuario) {
		
		try {
			Scanner scan = new Scanner(System.in);
			Scanner datosIA = new Scanner(new File("datos_ia.txt"));
			Scanner datosUsuarios = new Scanner(new File("datos_usuarios.txt"));
			Scanner datosCreadores = new Scanner(new File("datos_creadores.txt"));
			
			
			
			int cantIAS = 0;
			int cantUsuarios = 0;
			int cantCreadores = 0;
			int posiUsuario = posUsuario;
			
			
			//Leer archivo de IAS
			while(datosIA.hasNextLine()) {
				String[] partes = datosIA.nextLine().split(",");
				String nombreIA = partes[0];
				int añoCreacion = Integer.parseInt(partes[1]);
				int velAprendizaje = Integer.parseInt(partes[2]);
				String tipoIA = partes[3];
				String creador = partes[4];
				int cantMejoras = Integer.parseInt(partes[5]);
				
				IAS[cantIAS] = nombreIA;
				AÑOS[cantIAS] = añoCreacion;
				VEL_APRENDIZAJES[cantIAS] = velAprendizaje;
				TIPOS_IAS[cantIAS] = tipoIA;
				CREADORES[cantIAS] = creador;
				CANT_MEJORAS[cantIAS] = cantMejoras;
				cantIAS++;
			}
			datosIA.close();
			
			//Leer archivo de usuarios
			while(datosUsuarios.hasNextLine()) {
				String[] partes = datosUsuarios.nextLine().split(","); 
				String catUsuario = partes[2].toLowerCase();
				String nombreCreador = partes[3].toLowerCase();
				
				categoriaUsuarios[cantUsuarios] = catUsuario;
				creadorUsuario[cantUsuarios] = nombreCreador;
				cantUsuarios++;
			}
			datosUsuarios.close();
			
			//Leer archivo de creadores
			while(datosCreadores.hasNextLine()) {
				String[] partes = datosCreadores.nextLine().split(",");
				String creador = partes[0];
				int experiencia = Integer.parseInt(partes[1]);
				String especialidad= partes[2];
				int edad = Integer.parseInt(partes[3]);
				
				NOMBRE_CREADORES[cantCreadores] = creador;
				EXPERIENCIA[cantCreadores] = experiencia;
				ESPECIALIDADES[cantCreadores] = especialidad;
				EDADES[cantCreadores] = edad;	
				cantCreadores++;
			}
			datosCreadores.close();
			
			
			
			
			if(categoriaUsuarios[posiUsuario].equals("administrador")) {
				System.out.println("--------------------------------------");
				System.out.println("¿Que IA Desea Editar?: ");
				for(int i = 0; i < cantIAS; i++) {
					System.out.println(i + "." + IAS[i] + ".");
				}
				System.out.println(cantIAS+1 + "." + " Salir.");
				int seleccionIA = scan.nextInt();
				
			}else if(categoriaUsuarios[posiUsuario].equals("normal")) {
				if(comprobarEspecialidad(creadorUsuario, NOMBRE_CREADORES, ESPECIALIDADES, posiUsuario).equals("mejora de ia")) {
					System.out.println("¿Cuántas mejoras quieres hacer?: ");
					String cantMejoras = "";
					while(!scan.hasNextInt()) {
						System.out.println("Ingresa un número válido: ");
						scan.nextLine();
					}
					cantMejoras = scan.nextLine();
					System.out.println("¿A que IA le vas a agregar las mejoras?: ");
					for(int i = 0; i < cantIAS; i++) {
						System.out.println(i + "." + IAS[i] + ".");
					}
					int iaMejorar = 0;
					while(!scan.hasNextInt()) {
						System.out.println("Ingresa un número válido: ");
						scan.nextLine();
					}
					iaMejorar = scan.nextInt();
					System.out.println("Vas a upgradear en " + cantMejoras + " mejoras a la IA " + IAS[iaMejorar]);
					
				}
			}
			
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			
		}
			
		
	}
	
	
	
	
	public static double edadMediaCreadores(int[] EDADES) {
		double edadMedia = 0;
		try {
			Scanner scan = new Scanner(new File("datos_creadores.txt"));
			int cantCreadores = 0;
			int sumaEdades = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				int edad = Integer.parseInt(partes[3]);
				
				EDADES[cantCreadores] = edad;
				sumaEdades = sumaEdades + edad;
				cantCreadores++;
				
			}
			
			edadMedia = sumaEdades/cantCreadores;
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			
		}
		return edadMedia;
	}
	
	public static double edadMediaIA(int[] Años) {
		double edadMedia = 0;
		try {
			Scanner scan = new Scanner(new File("datos_ia.txt"));
			int cantIAS = 0;
			int sumaAñosCreacion = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				int añoCreacion = Integer.parseInt(partes[1]);
				
				Años[cantIAS] = añoCreacion;
				sumaAñosCreacion += añoCreacion;
				cantIAS++;
				
			}
			
			edadMedia = ((2023*cantIAS) - sumaAñosCreacion)/cantIAS;
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		return edadMedia;
	}
	
	public static double promedioVelIAS(int[] VEL_APRENDIZAJES) {
		double promedioVelocidad = 0;
		try {
			Scanner scan = new Scanner(new File("datos_ia.txt"));
			int cantIAS = 0;
			int sumaVelocidades = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				int velAprendizaje = Integer.parseInt(partes[2]);
				
				VEL_APRENDIZAJES[cantIAS] = velAprendizaje;
				sumaVelocidades += velAprendizaje;
				cantIAS++;
			}
			
			promedioVelocidad = sumaVelocidades/cantIAS;
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		return promedioVelocidad;
	}
	
	/*public static void creadoresDecrecientes(String[] NOMBRECREADOR, int[] EXPERIENCIA) {
		try {
			Scanner scan = new Scanner(new File("datos_creadores.txt"));
			int creador[];
			int cantCreadores = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				String nombreCreador = partes[0];
				int experiencia = Integer.parseInt(partes[1])/365;
				
				NOMBRECREADOR[cantCreadores] = nombreCreador;
				EXPERIENCIA[cantCreadores] = experiencia;
				
				
			}
			
			for(int i = 0; i < cantCreadores; i++) {
				int experienciaDias = EXPERIENCIA[i];
				double experienciaAnos = experienciaDias/365;
				creador[i] = experienciaAnos;
				
			}
			
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	} */

	public static void cantidadIASTipo(String[] TIPOS_IAS) {
		try {
			Scanner scan = new Scanner(new File("datos_ia.txt"));
			int cantIAS = 0;
			int cantIasSimple = 0;
			int cantIasMedia = 0;
			int cantIasAvanzada = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				String tipoIA = partes[3].toLowerCase();
				
				TIPOS_IAS[cantIAS] = tipoIA;
				cantIAS++;
			}
			
			for(int i = 0; i < cantIAS; i++) {
				if(TIPOS_IAS[i].equals("simple")) {
					cantIasSimple += 1;
				} else if(TIPOS_IAS[i].equals("media")) {
					cantIasMedia += 1;
				} else if(TIPOS_IAS[i].equals("avanzada")) {
					cantIasAvanzada += 1;
				}
			}
			
			System.out.println("Cantidad de IA's por tipo: ");
			System.out.println("Simples: " + cantIasSimple);
			System.out.println("Medias: " + cantIasMedia);
			System.out.println("Avanzadas: " + cantIasAvanzada);
			
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void cantidadCreadoresEspecialidad(String[] ESPECIALIDAD) {
		try {
			Scanner scan = new Scanner(new File("datos_creadores.txt"));
			int cantCreadores = 0;
			int cantCreadoresMejoraIa = 0;
			int cantCreadoresProgramador = 0;
			int cantCreadoresIaMaster = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				String especialidad = partes[2].toLowerCase();
				
				ESPECIALIDAD[cantCreadores] = especialidad;
				cantCreadores++;
			}
			
			for(int i = 0; i < cantCreadores; i++) {
				if(ESPECIALIDAD[i].equals("mejora de ia")) {
					cantCreadoresMejoraIa += 1;
				} else if(ESPECIALIDAD[i].equals("programador")) {
					cantCreadoresProgramador += 1;
				} else if(ESPECIALIDAD[i].equals("ia master")) {
					cantCreadoresIaMaster += 1;
				}
			}
			
			System.out.println("Cantidad de creadores por especialidad: ");
			System.out.println("Mejoradores de IA: " + cantCreadoresMejoraIa);
			System.out.println("Programadores: " + cantCreadoresProgramador);
			System.out.println("IA Master's: " + cantCreadoresIaMaster);
			
			
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void IARevelarse(String[] IAS, int[] AÑO, int[] EXPERIENCIA, int[] VEL_APRENDIZAJE, String[] TIPOS_IAS,  String[] CREADORES, String[] NOMBRECREADOR, int posUsuario) {
		try {
			Scanner scan = new Scanner(new File("datos_ia.txt"));
			int cantIAS = 0;
			int iaRevelarse =0;
			String nombreIaRevelarse = "";
			int calculoIA = 0;
			
			while(scan.hasNextLine()) {
				String[] partes = scan.nextLine().split(",");
				String nombre = partes[0];
				int año = Integer.parseInt(partes[1]);
				int velocidad = Integer.parseInt(partes[2]);
				String tipo = partes[3].toLowerCase();
				String creador = partes[4].toLowerCase();
				
				IAS[cantIAS] = nombre;
				AÑO[cantIAS] = año;
				VEL_APRENDIZAJE[cantIAS] = velocidad;
				TIPOS_IAS[cantIAS] = tipo;
				CREADORES[cantIAS] = creador;
				cantIAS++;
			}
			scan.close();
			
			Scanner scanner = new Scanner(new File("datos_creadores.txt"));
			int cantCreadores = 0;
			
			while(scanner.hasNextLine()) {
				String[] partes = scanner.nextLine().split(",");
				
				String nombre = partes[0].toLowerCase();
				int experiencia = Integer.parseInt(partes[1])/12;
				
				NOMBRECREADOR[cantCreadores] = nombre;
				EXPERIENCIA[cantCreadores] = experiencia;
				cantCreadores++;
			}
			
				for(int i = 0; i < cantIAS; i++) {
					if(TIPOS_IAS[i].equals("simple")) {
						calculoIA = ((AÑO[i] * 5 * EXPERIENCIA[i]) / VEL_APRENDIZAJE[i]);
						if(iaRevelarse < calculoIA) {
							nombreIaRevelarse = IAS[i];
						}
					} else if(TIPOS_IAS[i].equals("media")) {
						calculoIA = ((AÑO[i] * 10 * EXPERIENCIA[i]) / VEL_APRENDIZAJE[i]);
						if(iaRevelarse < calculoIA) {
							nombreIaRevelarse = IAS[i];
						}
					} else if(TIPOS_IAS[i].equals("avanzada")) {
						calculoIA = ((AÑO[i] * 15 * EXPERIENCIA[i]) / VEL_APRENDIZAJE[i]);
						if(iaRevelarse < calculoIA) {
							nombreIaRevelarse = IAS[i];
						}
					}
					
			
				}
				System.out.println("La IA mas probable a revelarse es: " + nombreIaRevelarse);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//Vectores para el texto datos_ias.txt
		String[] IAS = new String[100];
		int[] AÑOS = new int[100];
		int[] VEL_APRENDIZAJES = new int[100];
		String[] TIPOS_IAS = new String[100];
		String[] CREADORES = new String[100];
		int[] CANT_MEJORAS = new int[100];
		
		//Vectores para el texto datos_usuarios.txt
		String[] USUARIOS = new String[100];
		String[] PASSWORDS = new String[100];
		String[] CATEUSUARIOS = new String[100];
		String[] CREADORUSUARIO = new String[100];
		
		//Vectores para el texto datos_creadores.txt
		String[] NOMBRECREADOR = new String[100];
		int[] EXPERIENCIA = new int[100];
		String[] ESPECIALIDAD = new String[100];
		int[] EDAD = new int[100];
				
		
		Scanner scan = new Scanner(System.in);
		System.out.println("--------------------------------------");
		System.out.println("Ingrese su nombre de usuario: ");
		String usuario = scan.nextLine();
		System.out.println("Ingrese su contraseña: ");
		String contra = scan.nextLine();
		System.out.println("--------------------------------------");
		scan.close();
		
		
		int verificador = verificarUsuario(USUARIOS, PASSWORDS, CATEUSUARIOS, CREADORUSUARIO, usuario, contra);
		
		if(verificador < 0) {
			System.out.println("No estás registrado en la base de datos del sistema :(.");
		} else if(verificador > -1){
			System.out.println("Bienvenido de vuelta " + usuario + ".");
		}
		
		String veriCategoria = comprobarCategoria(USUARIOS, CATEUSUARIOS, verificador);
		String veriEspecialidad = comprobarEspecialidad(CREADORUSUARIO, NOMBRECREADOR, ESPECIALIDAD, verificador);
		
		System.out.println("Tipo de usuario: " + veriCategoria);
		System.out.println("Especialidad: " + veriEspecialidad);
		System.out.println("--------------------------------------");
		
		
		desplegarMenuNormal(veriEspecialidad, verificador);
		System.out.println("--------------------------------------");
		System.out.println("Edad media de creadores: " + edadMediaCreadores(EDAD));
		System.out.println("Edad media de las IA's: " + edadMediaIA(AÑOS));
		System.out.println("Promedio de velocidad de aprendizaje de las IA's: " + promedioVelIAS(VEL_APRENDIZAJES));
		//Acá agregar Creadores según años de experiencia de forma decreciente
		System.out.println("--------------------------------------");
		cantidadIASTipo(TIPOS_IAS);
		System.out.println("--------------------------------------");
		cantidadCreadoresEspecialidad(ESPECIALIDAD);
		System.out.println("--------------------------------------");
		IARevelarse(IAS, AÑOS, EXPERIENCIA, VEL_APRENDIZAJES, TIPOS_IAS, CREADORES, NOMBRECREADOR, verificador);
		/*desplegarMenu(IAS, AÑOS, VEL_APRENDIZAJES, TIPOS_IAS, CREADORES, CANT_MEJORAS, 
				CATEUSUARIOS, CREADORUSUARIO, NOMBRECREADOR, EXPERIENCIA, ESPECIALIDAD, EDAD, verificador);*/
		
	}

}
