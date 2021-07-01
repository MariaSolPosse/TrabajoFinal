package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Usuario implements Comparable<Usuario> {

	 private String nombre;
	    private String apellido;
	    private int edad;
	    private int dni;
	    
	    
	    public Usuario(String nombre, String apellido, int edad, int dni){
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.edad = edad;
	        this.dni = dni;

	     }
	     public Usuario(){

	     }
	     
	     public JSONObject toJson() {
	    	 JSONObject aux = new JSONObject();
	    	 
	    	 try {
	    		 aux.put("nombre", nombre);
	    		 aux.put("apellido", apellido);
	    		 aux.put("edad", edad);
	    		 aux.put("dni", dni);
	    		 
	    	 }catch(JSONException e) {
	    		 e.printStackTrace();
	    	 }
	    	 return aux;
	     }
	     
	    

	     

	   ///------------------------- GETS AND SETS -----------------------------------------
	       public String getNombre() {
	           return nombre;
	       }

	       public void setNombre(String nombre) {
	           this.nombre = nombre;
	       }

	       public String getApellido() {
	           return apellido;
	       }

	       public void setApellido(String apellido) {
	           this.apellido = apellido;
	       }

	       public int getDni() {
	           return dni;
	       }

	       public void setDni(int dni) {
	           this.dni = dni;
	       }

	       public int getEdad() {
	           return edad;
	       }

	       public void setEdad(int edad) {
	           this.edad = edad;
	       }

	       
	       
	       @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
			result = prime * result + dni;
			result = prime * result + edad;
			result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Usuario other = (Usuario) obj;
			if (apellido == null) {
				if (other.apellido != null)
					return false;
			} else if (!apellido.equals(other.apellido))
				return false;
			if (dni != other.dni)
				return false;
			if (edad != other.edad)
				return false;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			return true;
		}
		@Override
	       public String toString() {
	           return " Nombre: " + nombre +
	                   " Apellido: " + apellido +
	                   " Dni:" + dni +
	                   " Edad:" + edad;
	       }
		@Override
		public int compareTo(Usuario o) {
			// TODO Auto-generated method stub
			return this.getDni() - o.getDni();
		}
		

}
