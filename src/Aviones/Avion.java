package Aviones;

import org.json.JSONException;
import org.json.JSONObject;

import enume.Motor;

public  class Avion {

	
	 private float capConbustible;
	    private float costoXkm;
	    private int sizePasajeros;
	    private float velMaxima;
	    private Motor motor;
	    private String tipoAvion;
	    private int id=0;
	    private int tarifa;
	    private String catering;
	    private int asientosDisponibles;

	 
	    /**
		 * 
		 */
		public Avion() {
		}

	    
	    /**
		 * @param capConbustible
		 * @param costoXkm
		 * @param sizePasajeros
		 * @param velMaxima
		 * @param motor
		 * @param tipoAvion
		 * @param id
		 * @param tarifa
		 * @param catering
		 * @param asientosDisponibles
		 */
		public Avion(float capConbustible, float costoXkm, int sizePasajeros, float velMaxima,
				String tipoAvion, int id, int tarifa, String catering, int asientosDisponibles) {
			this.capConbustible = capConbustible;
			this.costoXkm = costoXkm;
			this.sizePasajeros = sizePasajeros;
			this.velMaxima = velMaxima;
			
			this.tipoAvion = tipoAvion;
			this.id = id;
			this.tarifa = tarifa;
			this.catering = catering;
			this.asientosDisponibles = asientosDisponibles;
		}





		




		public Avion(float capConbustible,float costoXkm, int sizePasajeros, float velMaxima, Motor motor,String tipoAvion,  String catering){
	        this.capConbustible = capConbustible;
	        this.costoXkm = costoXkm;
	        this.sizePasajeros = sizePasajeros;
	        this.velMaxima = velMaxima;
	        this.motor = motor;
	        this.tipoAvion = tipoAvion;
	        this.id = id++;
	        this.tarifa = 15000;
	        
	        this.catering = catering;
	        this.asientosDisponibles=sizePasajeros;
	    }
	    
	    

	

		public int getAsientosDisponibles() {
			return asientosDisponibles;
		}

		public void setCatering(String catering) {
			this.catering = catering;
		}

		public void setAsientosDisponibles(int asientosDisponibles) {
			this.asientosDisponibles = asientosDisponibles;
		}

		/**
		 * 
		 */
		


		///-------------------------------- GETS AND SETS ---------------------------------------------
	/*
	    @Override
	    public String toString() {
	        return " Capacidad conbustible: " + capConbustible +
	                "| Costo por KM: " + costoXkm +
	                "| Cantidad maxima Pasajeros: " + sizePasajeros +
	                "| Velocidad Maxima: " + velMaxima +
	                "| Tipo de motor: " + motor;
	    }*/

	 public void ocuparAsientos(int asientosAUsar) {
		 if(asientosAUsar<=asientosDisponibles) {
			 asientosDisponibles = asientosDisponibles-asientosAUsar;
		 }
	 }

	

	    public String getCatering() {
	        return catering;
	    }

	    public int getTarifa() { return tarifa; }

	    public void setTarifa(int tarifa) { this.tarifa = tarifa; }

	    public int getId() { return id; }

	    

	    public String getTipoAvion() {
	        return tipoAvion;
	    }

	    public void setTipoAvion(String tipoAvion) {
	        this.tipoAvion = tipoAvion;
	    }

	    public float getCapConbustible() {
	        return capConbustible;
	    }

	    public void setCapConbustible(float capConbustible) {
	        this.capConbustible = capConbustible;
	    }

	    public float getCostoXkm() {
	        return costoXkm;
	    }

	    public void setCostoXkm(float costoXkm) {
	        this.costoXkm = costoXkm;
	    }

	    public int getSizePasajeros() {
	        return sizePasajeros;
	    }

	    public void setSizePasajeros(int sizePasajeros) {
	        this.sizePasajeros = sizePasajeros;
	    }

	    public float getVelMaxima() {
	        return velMaxima;
	    }

	    public void setVelMaxima(float velMaxima) {
	        this.velMaxima = velMaxima;
	    }

	    public Motor getMotor() {
	        return motor;
	    }

	    public void setMotor(Motor motor) {
	        this.motor = motor;
	    }

		public void servirComida() {
			// TODO Auto-generated method stub
			
		}

		public void darAuriculares() {
			// TODO Auto-generated method stub
			
		}
		
		public JSONObject toJson() {
	    	 JSONObject aux = new JSONObject();
	    	 JSONObject jmotor = new JSONObject();
	    	 
	    	 
	    	 try {
	    		 aux.put("capCombustible", capConbustible);
	    		 aux.put("costoXkm", costoXkm);
	    		 aux.put("sizePasajeros", sizePasajeros);
	    		 aux.put("velMaxima", velMaxima);
	    		jmotor.put("tipo", motor);
	    		 aux.put("motor", jmotor);
	    		 aux.put("tipoAvion", tipoAvion);
	    		 aux.put("id", id);
	    		 aux.put("tarifa", tarifa);
	    		 aux.put("catering", catering);
	    		 aux.put("asientosDisponibles", asientosDisponibles);
	    		 
	    		 
	    		 
	    		   
	    		    
	    	 }catch(JSONException e) {
	    		 e.printStackTrace();
	    	 }
	    	 return aux;
	     }
		

		@Override
		public String toString() {
			return "Avion [capConbustible=" + capConbustible + ", costoXkm=" + costoXkm + ", sizePasajeros="
					+ sizePasajeros + ", velMaxima=" + velMaxima + ", motor=" + motor + ", tipoAvion=" + tipoAvion
					+ ", tarifa=" + tarifa + ", catering=" + catering + "]";
		}
		
		

}
