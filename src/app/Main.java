package app;


import java.io.IOException;
import java.util.Scanner;

import org.json.JSONException;

import Aviones.Avion;
import Registros.RegistroAviones;
import Registros.RegistroUsuarios;
import model.Empresa;
import model.Reserva;
import model.Usuario;



public class Main {

	@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args)  {
		// FALTA TRABAJAR CON JSON
		//FALTA INCLUIR ARCHIVOS PARA LA PERSISTENCIA DE DATOS
		
		///REVISAR MAIN , NO COMPROBADO EL FUNCIONAMIENTO
	
		Scanner scan = new Scanner(System.in);
	    Empresa empresa = new Empresa("AeroJESO "); /// CREACION DE EMPRESA
	 
	    
	    int dniBuscado=0;
	    int dniReserva=0;
	    Usuario user = new Usuario();
	    Reserva reserva=new Reserva();
	    String nombreAvionBuscado;
	    Avion buscado=new Avion();
	    

	    RegistroAviones registroAviones= new RegistroAviones();
	    RegistroUsuarios registroUsuarios = new RegistroUsuarios();
	        /// CREANDO MENU INTERACTIVO
	        int opcion=0, opcion2=0,opcionReserva = 0,opcionAviones=0,opcionUsuarios=0;

	       
	        
	    
	        do {
	        
	        	 menu();
	        	  opcion = scan.nextInt();
	        	   clearScreen();
	        	   
	        	  
	        	  switch(opcion){
                  case 1:
                	  do {
                		  menuAviones();
                		  opcionAviones=scan.nextInt();
                		  
                		  switch(opcionAviones) {
                		  case 1:
                			  System.out.println("Ingrese la clase del avion que desea crear(1.Bronce/2.Silver/3.Gold)");
                        	  opcion2 = scan.nextInt();
                        	  switch(opcion2){
                        		  case 1:
                        			  empresa.altaAvionBronce();
                        			  break;
                        		  case 2:
                        			  empresa.altaAvionSilver();
                        			  break;
                        		  case 3:
                        			  empresa.altaAvionGold();
                        			  break;
                        	  }
                			  break;
                		  case 2:
                			  System.out.println("Ingrese el nombre del avion a buscar");
                			  nombreAvionBuscado= scan.nextLine();
                			  buscado = empresa.buscaAvion(nombreAvionBuscado);
                			  System.out.println(buscado.toString());
                			  break;
                		  case 3:
                			  System.out.println("Ingrese el nombre del avion a buscar");
                			  nombreAvionBuscado= scan.nextLine();
                			  buscado = empresa.buscaAvion(nombreAvionBuscado);
                			  empresa.modificaMotor(buscado);
                			  
                			  break;
                		  case 4:
                			  System.out.println(empresa.mostrarAvionesPro());
                			  break;
                		  case 5:
                			  System.out.println("Ingrese el nombre del avion a buscar");
                			  nombreAvionBuscado= scan.nextLine();
                			  buscado = empresa.buscaAvion(nombreAvionBuscado);
                			  empresa.eliminarAvion(buscado);
                			  break;
                			 
                		  }
                		 
                    	  
                	  }while(opcionAviones!=0);
                	 
                	  
                	  break;
                  case 2:
                	  do {
                		  menuUsuarios();
                		  opcionUsuarios=scan.nextInt();
                		  
                		  switch(opcionUsuarios) {
                		  case 1:
                			  empresa.altaUsuario();
                        	  
                			  break;
                		  case 2:
                			  System.out.println("Ingrese el dni que desea buscar");
                          	  dniBuscado = scan.nextInt();
                          	  
                          	 user =  empresa.buscaDni(dniBuscado);
                          	 System.out.println(user.toString());
                			  break;
                		  case 3:
                			 System.out.println( empresa.mostrarUsuarios());
                			  
                			  break;
                		  case 4:
                			  System.out.println("Ingrese el dni del usuario que desea eliminar");
                          	  dniBuscado = scan.nextInt();
                          	  
                          	 user =  empresa.buscaDni(dniBuscado);
                			  empresa.eliminarUsuario(user);
                			  break;
                		  
                			 
                		  }
                		 
                    	  
                	  }while(opcionUsuarios!=0);
                	 
                	 
                	 
                	  break;
                  case 3:
                	  do {
                		  menuReservas();
                		  opcionReserva=scan.nextInt();
                		  
                		  switch(opcionReserva) {
                		  case 1:
                			  empresa.altaReserva();
                        	  
                			  break;
                		  case 2:
                			  System.out.println("Ingrese el dni del usuario a nombre de la reserva");
                          	  dniBuscado = scan.nextInt();
                          	  
                         
                          	 reserva = empresa.buscaReserva(dniReserva);
                          	 System.out.println(reserva.toString());
                          	 
                			  break;
                		  case 3:
                			  System.out.println(empresa.mostrarReservas());
                			  
                			  break;
                		  case 4:
                			  System.out.println("Ingrese el dni del usuario a nombre de la reserva");
                          	  dniBuscado = scan.nextInt();
                          	  
                          	 user =  empresa.buscaDni(dniReserva);
                			  empresa.eliminaReversa(user);
                			  
                			  break;
                		  
                			 
                		  }
                		 
                    	  
                	  }while(opcionReserva!=0);
                	  
                	  break;
                
                	 
	        	  }
	        	  
	        	  
    	       
	        	 
	        	 
	        	  
	        	  
	        	
	        	 
	        	 
	        	 
	        }while(opcion!=0);
	        
	        try {
				registroAviones.guardarRegistroAviones(empresa.getListaAviones());
				registroUsuarios.guardarRegistroUsuarios(empresa.getTreeUsuarios());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	  
    	  try {
			registroAviones.guardarRegistroAviones2(empresa.getListaAviones());
			  registroUsuarios.guardarRegistroUsuarios2(empresa.getTreeUsuarios());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    	  registroAviones.levantarRegistroObj(empresa);
	        registroUsuarios.levantarRegistro(empresa);
	        
	      registroAviones.grabarJson(empresa.getListaAviones());
	  registroUsuarios.grabarJson(empresa.getTreeUsuarios());
	   
        try {
			registroAviones.levantarJson(empresa);
			 registroUsuarios.levantarJson(empresa);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
	        
	        
	        
	        


	}
	
	public static void menu() {
		
		System.out.println("\t\t<<< AEROJESOGO >>>\n\n\n");
		
        System.out.println("1 | Menu aviones");
        System.out.println("2 | Menu usuaios") ;
        System.out.println("3 | Menu Reservas");
   
        
        System.out.println("\n\n0 | Para salir");
	}
	
	
	public static void menuAviones() {
        System.out.println("1 | Alta Avion");
        System.out.println("2 | Busca un avion(por nombre del avion)") ;
        System.out.println("3 | Modifica motor de avion");
        System.out.println("4 | Muestra Aviones");
        System.out.println("5 | Eliminar avion");
        
        System.out.println("\n\n0 | Para salir");
	}
	
	public static void menuUsuarios() {
        System.out.println("1 | Alta Usuario");
        System.out.println("2 | Busca un usuario(por dni)") ;
        System.out.println("3 | Muestra usuarios");
        System.out.println("4 | Eliminar usuario");
        
        System.out.println("\n\n0 | Para salir");
	}
	
	public static void menuReservas() {
        System.out.println("1 | Alta reserva");
        System.out.println("2 | Busca un reserva(por dni del reservante)") ;
        System.out.println("3 | Muestra reservas");
        System.out.println("4 | Eliminar reserva");
        
        System.out.println("\n\n0 | Para salir");
	}
	
	 public static void clearScreen(){
	        for(int i=0; i < 80 * 300;i++){
	            System.out.println("\n");
	        }
	    }
}
