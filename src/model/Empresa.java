package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;



import Aviones.Avion;
import Aviones.Bronce;
import Aviones.Gold;
import Aviones.Silver;
import enume.Lugares;
import enume.Motor;


public class Empresa {
	
	

	private String nombre;
    private TreeSet <Usuario> treeUsuarios;
    private ArrayList<Avion>listaAviones;
    private TreeMap<Integer, Reserva> mapReservas;
	
    Scanner reader = new Scanner(System.in);
    
    public Empresa(String nombre){
        this.nombre = nombre;
        this.treeUsuarios = new TreeSet<Usuario>();
        this.listaAviones = new ArrayList<Avion>();
        this.mapReservas = new TreeMap<Integer,Reserva>();
        
    }
    
    public String getNombre() {
		return nombre;
	}

	public TreeSet <Usuario> getTreeUsuarios() {
		return treeUsuarios ;
	}

	public ArrayList<Avion> getListaAviones() {
		return listaAviones;
	}

	public TreeMap<Integer, Reserva> getMapReservas() {
		return mapReservas;
	}

	public Scanner getReader() {
		return reader;
	}
    ///AGREGAR USUARIO | AVION | RESERVA

    public void agregarUsuario(Usuario u){////////////////////////////////////////////////////////////
    	
    	treeUsuarios.add(u); 
        
        
    }
    
	
    
    ///FALTA AGREGAR TRY CATCH PARA EVITAR ERRORES Y HACER BIEN LA VERIFICACION
    public void altaUsuario(){///verificar que no le den un dni repetido
        Usuario usuario = new Usuario();
    	System.out.println("Ingrese los datos correspondientes: ");
        int verificacion =0;

       
       	try {
       		
       		do {
       			
       			
       			 System.out.println("Ingrese el nombre:");
	    	         usuario.setNombre(reader.nextLine());
	    	      

	    	         System.out.println("Ingrese el apellido");
	    	        usuario.setApellido(reader.nextLine());
	    	       
	    	        
	    	         if(usuario.getNombre().equals(usuario.getApellido())){
	    	        	 System.out.println("Nombre y Apellido iguales, ingresar nuevamente los datos");
	    	             verificacion = 1;
	    	         }else {
	    	        	 verificacion=0;
	    	         }
	    	         
	    	        
	    	         
	    	         
       		}while(verificacion!=0);
       		
       		do {
       			System.out.println("Ingrese el DNI");
	    	         usuario.setDni(reader.nextInt());
	    	      
	    	         
	    	         if(buscaDni(usuario.getDni())!=null) {
	    	        	 verificacion=1;
	    	        	/// System.out.println("\n El DNI ingresado ya existe");
	    	        	 
	    	        	 
	    	         }
	    	         else {
	    	        	 verificacion=0;
	    	         }
	    	         if(usuario.getDni() <30000000 || usuario.getDni()> 70000000){
	    	        	 verificacion = 1;
	    	        	 System.out.println("\n Los valores ingresados del DNI, no son validos");
	    	        	 
	    	         }else {
	    	        	 verificacion=0;
	    	         }
	    	         
	    	         

       			
       		}while(verificacion!=0);
   	         
       		do {
       			System.out.println("Ingrese tu Edad");
	    	         usuario.setEdad(reader.nextInt());
	    	  
	    	         if(usuario.getEdad() <18){
	    	        	 verificacion = 1;
	    	        	 System.out.println("\n No pudimos registrarte, debes ser mayor de edad para hacerlo");
	    	        	 
	    	         }else {
	    	        	 verificacion=0;
	    	         }
	    	        
	    	         if(usuario.getEdad() >85){
	    	             
	    	             verificacion = 1;
	    	             System.out.println("\n Por seguridad las personas mayores de 85 años no pueden registrarse en nuestra empresa");
	    	             
	    	         }else {
	    	        	 verificacion=0;
	    	         }	
       		}while(verificacion!=0);
   	
       	}catch(Exception e) {
       		e.printStackTrace();
       	}
       	agregarUsuario(usuario);

    }

  

	public Avion altaAvionGold() {
    	Gold avionGold = new Gold();
    	int opcion=0,opcion2=0;
    	
    	
    	do {
    		try {
    			
    			System.out.println("Ingrese la capacidad de combustible");
        		avionGold.setCapConbustible(reader.nextFloat());
        		
        		System.out.println("Ingrese el costo por Km");
        		avionGold.setCostoXkm(reader.nextFloat());
        		
        		System.out.println("Ingrese la capacidad de pasajeros del avion");
        		avionGold.setSizePasajeros(reader.nextInt());
        		
        		System.out.println("Ingrese la velocidad maxima que alcanza el avion");
        		avionGold.setVelMaxima(reader.nextFloat());
        		
        		System.out.println("Ingrese el tipo de motor (reaccion, helice, pistones)");
        		opcion2 = reader.nextInt();
        		Motor motor1 = Motor.pistones;
        		Motor motor2 = Motor.helice;
        		Motor motor3 = Motor.reaccion;
        		
        		switch(opcion2) {
        		case 1:
        			avionGold.setMotor(motor3);
        			break;
        		case 2:
        			avionGold.setMotor(motor2);
        			break;
        			
        		case 3:
        			avionGold.setMotor(motor1);
        			break;
        			
        		}
        		
        		System.out.println("Ingrese el nombre del avion");
        		avionGold.setTipoAvion(reader.nextLine());
        		
        		System.out.println("Ingrese la clase del wifi");
        		avionGold.setWifi(reader.nextLine());
        	
        		
        		System.out.println("Ingrese el catering que incluye el avion");
        		avionGold.setCatering(reader.nextLine());
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    		System.out.println("0 para salir, cualquier otro numero para seguir cargando...");
    		opcion= reader.nextInt();
    		
    		
    	}while(opcion!=0);
    	
    	agregarAvion(avionGold);
    	return avionGold;
    }
    
    
    public Avion altaAvionSilver() {
    	
    	Avion avionSilver = new Silver();
    	
int opcion=0,opcion2=0;
    	
    	
    	do {
    		try {
    			
    			System.out.println("Ingrese la capacidad de combustible");
        		avionSilver.setCapConbustible(reader.nextFloat());
        		
        		System.out.println("Ingrese el costo por Km");
        		avionSilver.setCostoXkm(reader.nextFloat());
        		
        		System.out.println("Ingrese la capacidad de pasajeros del avion");
        		avionSilver.setSizePasajeros(reader.nextInt());
        		
        		System.out.println("Ingrese la velocidad maxima que alcanza el avion");
        		avionSilver.setVelMaxima(reader.nextFloat());
        		
        		System.out.println("Ingrese el tipo de motor (reaccion, helice, pistones)");
        		opcion2 = reader.nextInt();
        		Motor motor1 = Motor.pistones;
        		Motor motor2 = Motor.helice;
        		Motor motor3 = Motor.reaccion;
        		
        		switch(opcion2) {
        		case 1:
        			avionSilver.setMotor(motor3);
        			break;
        		case 2:
        			avionSilver.setMotor(motor2);
        			break;
        			
        		case 3:
        			avionSilver.setMotor(motor1);
        			break;
        			
        		}
        		
        		System.out.println("Ingrese el nombre del avion");
        		avionSilver.setTipoAvion(reader.nextLine());
        		
        		
        		System.out.println("Ingrese el catering que incluye el avion");
        		avionSilver.setCatering(reader.nextLine());
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    		
    		System.out.println("0 para salir, cualquier otro numero para seguir cargando...");
    		opcion= reader.nextInt();
    		
    	}while(opcion!=0);
    	
    	agregarAvion(avionSilver);
 
    	return avionSilver;
    }
    
    public Avion altaAvionBronce() {
    	
    	Avion avionBronce= new Bronce();
    	
int opcion=0,opcion2=0;
    	
    	
    	do {
    		try {
    			
    			System.out.println("Ingrese la capacidad de combustible");
        		avionBronce.setCapConbustible(reader.nextFloat());
        		
        		System.out.println("Ingrese el costo por Km");
        		avionBronce.setCostoXkm(reader.nextFloat());
        		
        		System.out.println("Ingrese la capacidad de pasajeros del avion");
        		avionBronce.setSizePasajeros(reader.nextInt());
        		
        		System.out.println("Ingrese la velocidad maxima que alcanza el avion");
        		avionBronce.setVelMaxima(reader.nextFloat());
        		
        		System.out.println("Ingrese el tipo de motor (reaccion, helice, pistones)");
        		opcion2 = reader.nextInt();
        		Motor motor1 = Motor.pistones;
        		Motor motor2 = Motor.helice;
        		Motor motor3 = Motor.reaccion;
        		
        		switch(opcion2) {
        		case 1:
        			avionBronce.setMotor(motor3);
        			break;
        		case 2:
        			avionBronce.setMotor(motor2);
        			break;
        			
        		case 3:
        			avionBronce.setMotor(motor1);
        			break;
        			
        		}
        		
        		System.out.println("Ingrese el nombre del avion");
        		avionBronce.setTipoAvion(reader.nextLine());
        	
        		System.out.println("Ingrese el catering que incluye el avion");
        		avionBronce.setCatering(reader.nextLine());
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
		
    		System.out.println("0 para salir, cualquier otro numero para seguir cargando...");
    		opcion= reader.nextInt();
    	}while(opcion!=0);
    	
    	agregarAvion(avionBronce);
    	return avionBronce;
    }
    
    public void modificaMotor(Avion avion) {
    	int opcion=0;
    	System.out.println("Ingrese el tipo de motor (reaccion, helice, pistones)");
		opcion = reader.nextInt();
		Motor motor1 = Motor.pistones;
		Motor motor2 = Motor.helice;
		Motor motor3 = Motor.reaccion;
		
		switch(opcion) {
		case 1:
			avion.setMotor(motor3);
			break;
		case 2:
			avion.setMotor(motor2);
			break;
			
		case 3:
			avion.setMotor(motor1);
			break;
			
		}
    	
    	
    	
    }
    

    public void agregarAvion(Avion t){
        listaAviones.add(t);
    }

    public void agregarReserva(Reserva r){  
        mapReservas.put(r.getDni(),r);
    }
    
    public void altaReserva() {
    	Reserva reserva = new Reserva();
    	
    	int opcion =0,opcion2=0;
    	
    	do {
    		System.out.println("Ingrese la fecha actual");
    		reserva.setFecha(reader.nextLine());
    		
    		System.out.println("");
    		Lugares lugar1= Lugares.BuenoAires;
    		Lugares lugar2= Lugares.Cordoba;
    		Lugares lugar3= Lugares.Montevideo;
    		Lugares lugar4= Lugares.Santiago;
    		
    		System.out.println("Ingrese el lugar de Origen(1.Buenos Aires/ 2.Cordoba / 3.Montevideo / 4.Santiago)");
    		
    		switch(opcion2) {
    		case 1:
    			reserva.setOrigen(lugar1);
    			
    			
    			break;
    		case 2:
    			reserva.setOrigen(lugar2);
    			
    			break;
    			
    		case 3:
    			reserva.setOrigen(lugar3);
    			
    			break;
    		case 4 : 
    			reserva.setOrigen(lugar4);
    			break;
    			
    		}
    		
    		
    		
    		System.out.println("0 para salir, cualquier otro numero para seguir cargando...");
    		opcion= reader.nextInt();
    		
    	}while(opcion!=0);
    	
    }
    
    
    ///HACER LOS JSON
    
    ///MOSTRAR USUARIOS | AVIONES | RESERVA
    public String mostrarReservas(){
       String palabras= mapReservas.toString();
        return palabras; 
    }

    public String mostrarAviones(){
        int contador=1;
        
        StringBuilder builder= new StringBuilder();
        
        for(int i=0;i<listaAviones.size();i++){
        
        	builder.append("\n Nº " + contador + " Avion: " + listaAviones.get(i).getTipoAvion()); 
        	builder.append("\n Cantidad maxima de pasajeros: " + listaAviones.get(i).getSizePasajeros());
        	builder.append("\n Velocidad maxima: " + listaAviones.get(i).getVelMaxima()); 
        	builder.append("\n Costo por kilometro: " + listaAviones.get(i).getCostoXkm());
        	builder.append("\n Catering:" + listaAviones.get(i).getCatering());
            contador++;
        }
        return builder.toString(); 
    }

    
    public String mostrarAvionesPro(){
      
        
        StringBuilder builder= new StringBuilder();
        
        for(int i=0;i<listaAviones.size();i++){
        	builder.append(listaAviones.get(i).toString());
        	
        }
        return builder.toString(); 
    }
    
    
    public String  mostrarUsuarios(){
    	StringBuilder builder= new StringBuilder();
    	
    	for(Usuario usuar : treeUsuarios) {
    		builder.append(usuar.toString());
    		}
    	
    	
    	
    	return builder.toString();
    	}
             
   
    

    /// GENERAR RESERVA
    public boolean generarReserva(Usuario usuario, Reserva reserva){
    	
    	boolean bool= mapReservas.containsKey(usuario.getDni()); 
    	boolean geneReserva = false;
    	
         if (!bool)///si no tiene reserva entra
         {
        	 mapReservas.put(usuario.getDni(), reserva);
        	 geneReserva = true;
        	 
         } 
         else {
        	 throw new RuntimeException ("\n El usuario ya tiene una reserva") ;
         }
		return geneReserva;
    } 
    
    
    public void eliminaReversa(Usuario usuario) {
    	boolean bool= mapReservas.containsKey(usuario.getDni()); 
    	
    	if(bool) {
    		mapReservas.remove(usuario.getDni());
    		
    	}else {
    		 throw new RuntimeException ("\n El usuario no tiene reserva") ;
    	}
    	
    }

  public void eliminarAvion(Avion avion) {
	  listaAviones.remove(avion);
  }
  
  public void eliminarUsuario(Usuario usuario) {
	
	  for(Usuario usuar : treeUsuarios) {
  		if(usuar.getDni()==usuario.getDni()) {
  			 treeUsuarios.remove(usuar);
  		}
	 
	  
  }
        
  }

    ///BUSCAR DNI

 
    public Usuario buscaDni(int dni) {
    	Usuario user=null;
    	
    	 
    	for(Usuario usuar : treeUsuarios) {
    		if(usuar.getDni()==dni) {
    			user=usuar;
    		}
    	}
 
		return user; 
    }
    
    public Reserva buscaReserva(int dni) {
    	Reserva reserva=new Reserva();
    	if(mapReservas.containsKey(dni)) {
    		reserva = mapReservas.get(dni);
    	}
    	
    	return reserva;
    }
    
    
    
    /// HACER FUNCION BUSCA AVION
    
    public Avion buscaAvion(Avion buscado) {
    	Avion avion = null;
    	for(int i=0; i<listaAviones.size();i++) {
    		if(listaAviones.get(i).equals(buscado)) {
    			avion = listaAviones.get(i);
    		}
    		
    	}
    	
    	return avion;
    }
    
    public Avion buscaAvion(String tipoAvion) {
    	Avion avion = null;
    	for(int i=0; i<listaAviones.size();i++) {
    		if(listaAviones.get(i).getTipoAvion().equals(tipoAvion)) {
    			avion = listaAviones.get(i);
    		}
    		
    	}
    	
    	return avion;
    }
    
    ///compara la reserva con la capacidad que tiene el avion
    public boolean compararPasajerosAvion(Reserva reserva,Avion avion){
        boolean permitido = false;
    	int pasajeros = reserva.getCantAcompañantes() + 1;

        
        
        for(Avion a : listaAviones){
            if(a.getId() == reserva.getSelecAvion() && pasajeros <= a.getSizePasajeros()){
            	permitido = true;
            }
        }
        
        return permitido;

    }
    

   
    ///REVISAR
    public boolean verificarFecha(int dni){

        /// Para poder obtener la fecha del dia actual.
        Calendar c1 = GregorianCalendar.getInstance();
        boolean flag = true;
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaActual = fecha.format(c1.getTime());

        //System.out.println("Fecha actual: " +fecha.format(c1.getTime()));

        for (Map.Entry<Integer, Reserva> r : mapReservas.entrySet()) {

          ///  System.out.println("Fecha del vuelo reservado: " + r.getValue().getFecha());

            if(dni == r.getKey() && fechaActual.equals(r.getValue().getFecha())){
                flag = false;
            }
        }
        return flag;
    }
    
    
    ///REVISAR
    public boolean verificarDisponibilidad(Reserva reserva){
        boolean flag = false;
        for (Map.Entry<Integer, Reserva> r : mapReservas.entrySet()) {

            ///System.out.println("Key: "+r.getKey() + " Value: " + r.getValue());
            if(reserva.getFecha().equals(r.getValue().getFecha()) && reserva.getSelecAvion() == r.getValue().getSelecAvion()){
                flag = true;
                break;
            }
        }
        return flag;
        }
    
    ///REVISAR PARSE NO IDENTIFICADO, REVISAR SI ESTA BIEN HECHA LA FUNCION
    public void listarVuelos(){
    	 
        boolean flag = false;
      
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Ingrese la fecha que quiere ver: ");
        String sDate1 = reader.next();
        try {
            Date date1 = fecha.parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("LA FECHA QUE QUIERE VER ES: " +sDate1);

        for (Map.Entry<Integer, Reserva> r : mapReservas.entrySet()) {

            if(sDate1.equals(r.getValue().getFecha())){

                System.out.println("El cliente con el dni: " + r.getKey() + " Tiene una reserva para: " + r.getValue().getCantAcompañantes() + " personas.");
                flag = true;
            }


        }
        if(!flag){
            System.out.println("No existen reservas para ese dia");
        }
       

    }

	
	

  
}
