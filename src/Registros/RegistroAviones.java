package Registros;



import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Aviones.Avion;

import model.Empresa;
import model.JsonUtiles;


public class RegistroAviones implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	public void guardarRegistroAviones(ArrayList<Avion>listaAviones)throws IOException{
		FileOutputStream inData = null;
		ObjectOutputStream data = null;
		try {
			inData =  new FileOutputStream("Aviones.dat");
			data = new ObjectOutputStream(inData);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("asd");
		}
		
		
		
		for(int i=0;i<listaAviones.size();i++) {
			data.writeFloat(listaAviones.get(i).getCapConbustible());
			data.write(listaAviones.get(i).getSizePasajeros());
			data.writeUTF(listaAviones.get(i).getTipoAvion());
			data.write(listaAviones.get(i).getId());
			data.write(listaAviones.get(i).getTarifa());
			data.writeUTF(listaAviones.get(i).getCatering());
			data.write(listaAviones.get(i).getAsientosDisponibles());
		
		}
		try {
			data.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	
	}
	
	public void guardarRegistroAviones2(ArrayList<Avion>listaAviones)throws IOException {
		
DataOutputStream  data = new DataOutputStream(new FileOutputStream("Aviones.dat"));
		
for(int i=0;i<listaAviones.size();i++) {
	data.writeFloat(listaAviones.get(i).getCapConbustible());
	data.write(listaAviones.get(i).getSizePasajeros());
	data.writeUTF(listaAviones.get(i).getTipoAvion());
	data.write(listaAviones.get(i).getId());
	data.write(listaAviones.get(i).getTarifa());
	data.writeUTF(listaAviones.get(i).getCatering());
	data.write(listaAviones.get(i).getAsientosDisponibles());

}
try {
	data.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		data.close();
		
	}
	

	
	
	public void levantarRegistroObj(Empresa empresa) {
		ObjectInputStream objIngreso = null;
		FileInputStream fileIngreso;
		
	
		
		
			try {
				fileIngreso = new FileInputStream("Aviones.dat");
				objIngreso = new ObjectInputStream(fileIngreso);
				
				
					Avion aux = (Avion) objIngreso.readObject();
					empresa.agregarAvion(aux);
					
		
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch(EOFException e) {
				//System.out.println("Termino el archivo");
			} catch(IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
				
	
	}
	
	
	

	
	
	///----------------JSON------------------------------
	
public void grabarJson(ArrayList<Avion>listaAviones) {
	JSONArray json = new JSONArray();
	
	for(int i=0;i<listaAviones.size();i++) {
		json.put(listaAviones.get(i).toJson());
	
	}
	
	JsonUtiles.grabar(json, "Aviones.json");
	
}


public void levantarJson(Empresa empresa) throws JSONException {
	
	JSONArray aux = new JSONArray(JsonUtiles.leer("Aviones.json"));
	
	for(int i = 0; i < aux.length(); i++) {
		
		JSONObject auxObj = aux.getJSONObject(i);
	Avion avion=new Avion((float)auxObj.getDouble("capCombustible"),(float)auxObj.getDouble("costoXkm"),auxObj.getInt("sizePasajeros"),(float)auxObj.getDouble("velMaxima"),auxObj.getString("tipoAvion"),auxObj.getInt("id"),auxObj.getInt("tarifa"),auxObj.getString("catering"),auxObj.getInt("asientosDisponibles"));

		empresa.agregarAvion(avion);
		
	
   

	}
	
}
	

	
	
}

