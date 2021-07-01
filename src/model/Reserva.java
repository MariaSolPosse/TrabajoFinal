package model;


import java.util.ArrayList;

import java.util.Scanner;

import Aviones.Avion;
import enume.Lugares;



public class Reserva {
	
	 private String fecha;
	    private Lugares origen;
	    private Lugares destino;
	    private int cantAcompañantes;
	    private int selecAvion;
	    private float costoTotal;
	    private ArrayList<Usuario> listaUsuarios; ///
	    private int dni;
	    private ArrayList<String> fechasDisponibles; 
	    
	    
	    public Reserva(String fecha,Lugares origen,Lugares destino,int cantAcompañantes, int selecAvion, float costoTotal,int dni){
	        this.fecha = fecha;
	        this.origen = origen;
	        this.destino = destino;
	        this.cantAcompañantes = cantAcompañantes;
	        this.selecAvion = selecAvion;
	        this.costoTotal = costoTotal;
	        this.listaUsuarios = new ArrayList<>();
	        this.dni = dni;
	        this.fechasDisponibles= new ArrayList<>(); 

	    }
	    
	    public Reserva() {

	    }
	    
	    Scanner reader = new Scanner(System.in);
	    ///------------------------GETS AND SETS ------------------------------------

	    public Lugares getOrigen() {
	        return origen;
	    }

	    public Lugares getDestino() {
	        return destino;
	    }

	    public String getFecha() {
	        return fecha;
	    }

	    public int getCantAcompañantes() {
	        return cantAcompañantes;
	    }

	    public int getSelecAvion() {
	        return selecAvion;
	    }

	    public float getCostoTotal() {
	        return costoTotal;
	    }

	    public int getDni() {
	        return dni;
	    }

	    
	    
	   
	    
	    public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public void setOrigen(Lugares origen) {
			this.origen = origen;
		}

		public void setDestino(Lugares destino) {
			this.destino = destino;
		}

		public void setCantAcompañantes(int cantAcompañantes) {
			this.cantAcompañantes = cantAcompañantes;
		}

		public void setSelecAvion(int selecAvion) {
			this.selecAvion = selecAvion;
		}

		public void setCostoTotal(float costoTotal) {
			this.costoTotal = costoTotal;
		}

		

		public void setDni(int dni) {
			this.dni = dni;
		}

		

		
		///---------------------------------------------------------------------------
	    public void agregarUsuarios(Usuario u){
	        listaUsuarios.add(u);
	    }

	    public String mostrarListaUsuarios(){
	    	
	    	StringBuilder build= new StringBuilder(); 
	    	
	        for(int i=0;i<listaUsuarios.size();i++){
	            
	        	build.append(listaUsuarios.get(i).toString()); 
	        }
	        return build.toString(); 
	    }

	    public String mostrarLugares(){
	        String string= ("\n Lugares: \n Nº1 Buenos Aires \n Nº2 Cordoba \n Nº3 Santiago de Chile \n Nº4 Montevideo ");
	       return string ; 
	    		   
	    }
	    
	    public void AgregarFechasDisponibles(String fecha)
	    {
	    	fechasDisponibles.add(fecha); 
	  
	    }
	    
	    public String mostrarFechasDisponibles()
	    {
	    	StringBuilder build= new StringBuilder(); 
	    	for (int i = 0; i < fechasDisponibles.size(); i++) {
	    	    int index= i+1;
	    		build.append("\n "+ index + ".   ");
	    		build.append(fechasDisponibles.get(i)); 
	    	}
	    	return build.toString(); 
	    	
	    }
	    
	    //1) INDICAR LA FECHA PARA REALIZAR EL VUELO.
	    
	    ///--------------------------------------------------------------------------
	    /*
	     * @param la opcion de mostrar fecha 
	     * @ return la fecha indicada 
	     */
       public void indicarFecha (int op){
    	   
    		   if(op>0 && fechasDisponibles.isEmpty() != true)
    		   {
    			   this.fecha.replace(this.fecha, fechasDisponibles.get(op-1));
    			   
    		   } 
    		   else 
    		   {
    			   throw new RuntimeException("\n opcion no valida "); 
    		   }
    	   
    	   
       }

	    
	    
	    
       
	    //2) SELECCIONAR DESTINO Y ORIGEN.


	  

	    //3) CANTIDAD DE ACOMPAÑANTES QUE TENDRIA.
	 ///CAMBIAR LOS IF POR STWITCH
	    
	    
	    /*
	     * @param ingresa la cantidad de personas que lo acompañan 
	     * @return la cantidad, o -1 si hubo algun tipo de error 
	     */
	    
	    public int putAcompañantes(int cantidad ) {
	    	if (cantidad > -1)
	    	{
	    	
	    	if (cantidad < 5 )
	    	{
	    		
	    		this.cantAcompañantes= cantidad; 
	    	}else 
	    	{
	    		cantidad= -1;
	    		throw new RuntimeException("\n Tiene que ser menos de 5 acompañantes"); 
	    	}
	    	}else 
	    	{
	    		cantidad= -1; 
	    		throw new RuntimeException("\n Ingrese una cantidad positiva");
	    	}
	    	return cantidad; 
	    	
	    }
	    
	    

	    //4) SELECCIONAR EL AVION (DEBE MOSTRAR LOS POSIBLES)
		/// no printear 
		///CAMBIAR IF POR SWITCH
	    
	    /*
	     * @param necesita el id de un avion para ser ingresado
	     * 
	     * @return retorna -1 sino es valido 
	     */
	    public int elegirAvion (int idAvion)
	    {
        
	    	if(idAvion< 0 )
	    	{
	    		if(idAvion <4)
	    		{
	    			this.selecAvion= idAvion;
	    			
	    		}
	    		else {
	    			
	    			idAvion= -1;
		    		
		    		throw new RuntimeException("\n Opcion no valida "); 
	    			
	    		}
	    	}
	    	else {
	    		idAvion= -1;
	    		
	    		throw new RuntimeException("\n numero negativo, ingrese uno valido"); 
	    	}
	    	
	    	return idAvion;
	    }





	    //5) MOSTRAR COSTO TOTAL.
	    
	    ///REVISAR PARA QUE NO HAYA TANTOS IF
	    public int obtenerDistancia(){
	        //-1 si no existe destino

	        int distancia = 0;
	        
	        if(origen.equals(Lugares.BuenoAires) && destino.equals(Lugares.Santiago)){
	            distancia = 1400;
	        }
	        
	        else if(origen.equals(Lugares.BuenoAires)){
	            if(destino.equals(Lugares.Cordoba))
	                distancia = 695;
	            else if(destino.equals(Lugares.Santiago))
	                distancia = 1400;
	            else if(destino.equals(Lugares.Montevideo))
	                distancia = 950;
	        }
	        
	        else if(origen.equals(Lugares.Cordoba)){
	            if(destino.equals(Lugares.BuenoAires)){
	                distancia = 695;
	            }
	            else if(destino.equals(Lugares.Santiago)){
	                distancia = 1050;
	            }
	            else if(destino.equals(Lugares.Montevideo)){
	                distancia =1190;
	            }
	        }

	        else if(origen.equals(Lugares.Santiago)){
	            if(destino.equals(Lugares.BuenoAires)){
	                distancia =1400;
	            }
	            else if(destino.equals(Lugares.Cordoba));
	            {
	                distancia =1050;
	            }
	             if(destino.equals(Lugares.Montevideo)){
	                distancia =2100;
	            }
	        }

	        else if (origen.equals(Lugares.Montevideo)){
	            if(destino.equals(Lugares.BuenoAires)){
	                distancia=950;
	            }
	            else if(destino.equals(Lugares.Cordoba)){
	                distancia=1190;
	            }
	            else if(destino.equals(Lugares.Santiago)){
	                distancia=2100;
	            }
	        }
	        return distancia;
	    }

	    public float calcularCosto(ArrayList<Avion> aviones){
	        /// UNA VARIABLE QUE INDIQUE EL AVION QUE SELECCIONÃ“ para luego poder atajar estos valores
	        float costoKm = 0;
	        int tarifa = 0 ;
	        float total= 0;
	        for(Avion a : aviones){
	            if(a.getId() == this.selecAvion) {
	                costoKm = a.getCostoXkm();
	                tarifa = a.getTarifa();
	                
	            }
	        }
	        total = ((obtenerDistancia() * costoKm) + (cantAcompañantes + 1 * 3500) + tarifa);
	        System.out.println("EL TOTAL ES : " + total);
	        this.costoTotal = total;
	        return total;
	    }

	    /// PRIMERO QUE MUESTRE LOS VALORES Y LOS CONFIRME
	    
	  
///QUITAR LOS PRINTS Y HACER QUE RETORNE UN BOOLEAN
	    public Reserva confirmarReserva(){
	    	Reserva aux=new Reserva();
	        int confirmar=0;
	        int check=0;

	        while (check == 0){
	            System.out.println("Los datos de la reserva son:");
	            toString();

	            System.out.println("¿Confirmar Reserva?");
	            System.out.println("1 - SI");
	            System.out.println("2 - NO");
	            confirmar = reader.nextInt();

	            if (confirmar == 1){

	                /// aca tiene que pasar toda la reserva al MAP RESERVAS

	                System.out.println("Su reserva a sido cargada");
	                check = 1;
	            }
	            if(confirmar == 2){
	                System.out.println("Acaba de cancelar la reserva");
	                this.fecha = null;
	    	        this.origen = null;
	    	        this.destino = null;
	    	        this.cantAcompañantes = -1;
	    	        this.selecAvion = -1;
	    	        this.costoTotal = -1;
	    	        this.listaUsuarios = null;
	    	        this.dni = -1;
	    	        this.fechasDisponibles= null; 

	                check = 1;
	            }

	            if (confirmar <1 || confirmar > 2){
	                check = 0;
	                System.out.println("Valor incorrecto, vuelva a ingresar el valor");
	            }

	        }

	        return aux;
	    }

	  
	    
	    @Override
		public String toString() {
			return "Reserva [fecha=" + fecha + ", origen=" + origen + ", destino=" + destino + ", cantAcompañantes="
					+ cantAcompañantes + ", selecAvion=" + selecAvion + ", costoTotal=" + costoTotal
					+ ", listaUsuarios=" + listaUsuarios + ", dni=" + dni + ", fechasDisponibles=" + fechasDisponibles
					+ ", reader=" + reader + "]";
		}

}
