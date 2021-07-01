package Registros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.TreeSet;

import model.Empresa;
import model.JsonUtiles;
import model.Usuario;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;







public class RegistroUsuarios implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void guardarRegistroUsuarios(TreeSet <Usuario> treeUsuarios)throws IOException{
		
		FileOutputStream inData = null;
		ObjectOutputStream data = null;
		
		try {
			inData =  new FileOutputStream("Usuarios.dat");
			data = new ObjectOutputStream(inData);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("asd");
		}
		
		
		for(Usuario usuar : treeUsuarios) {
				data.writeUTF(usuar.getNombre());
				data.writeUTF(usuar.getApellido());
				data.writeInt(usuar.getDni());
				data.writeInt(usuar.getEdad());
				
    		
    		}
    	
		try {
			data.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void guardarRegistroUsuarios2(TreeSet <Usuario> treeUsuarios)throws IOException {
		
		DataOutputStream  data = new DataOutputStream(new FileOutputStream("Usuarios.dat"));
				
		for(Usuario usuar : treeUsuarios) {
			data.writeUTF(usuar.getNombre());
			data.writeUTF(usuar.getApellido());
			data.writeInt(usuar.getDni());
			data.writeInt(usuar.getEdad());
			
		
		}
		try {
			data.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				data.close();
				
			}
			
	
	

	/**
	 * @deprecated Se utilizaba para leer dato por dato.
	 */
	public void levantarRegistro(Empresa empresa) {
		
		DataInputStream dataIngreso = null;
		FileInputStream fileIngreso;
		
		try {
			fileIngreso = new FileInputStream("Usuarios.dat");
			dataIngreso = new DataInputStream(fileIngreso);

			while(true) {
				
				
				Usuario aux = new Usuario();
				aux.setNombre(dataIngreso.readUTF());
				aux.setApellido(dataIngreso.readUTF());
				aux.setDni(dataIngreso.readInt());
				aux.setEdad(dataIngreso.readInt());
				
				
			
				
			
				empresa.agregarUsuario(aux);
			
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch(EOFException e) {
			System.out.println("Termino el archivo");
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dataIngreso.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

	
	///----------------JSON------------------------------
	
public void grabarJson(TreeSet <Usuario> treeUsuarios) {
	JSONArray json = new JSONArray();
	for(Usuario usuar : treeUsuarios) {
		
		
		json.put(usuar.toJson());
		
	}
	JsonUtiles.grabar(json, "usuarios.json");
	
}


public void levantarJson(Empresa empresa) throws JSONException {
	
	JSONArray aux = new JSONArray(JsonUtiles.leer("Usuarios.json"));
	
	for(int i = 0; i < aux.length(); i++) {
		
		JSONObject auxObj = aux.getJSONObject(i);
	Usuario usu= new Usuario (auxObj.getString("nombre"),auxObj.getString("apellido"),auxObj.getInt("edad"),auxObj.getInt("dni"));
	
		empresa.agregarUsuario(usu);
		
		

	}
	
}
	

	
	
}
