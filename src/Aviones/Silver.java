package Aviones;

import Interface.IDasFrazadas;
import Interface.IServirComida;
import enume.Motor;

public class Silver extends Avion implements IServirComida,IDasFrazadas{

	

	
	/**
	 * 
	 */
	


	


	/**
	 * @param capConbustible
	 * @param costoXkm
	 * @param sizePasajeros
	 * @param velMaxima
	 * @param motor
	 * @param tipoAvion
	 * @param catering
	 */
	public Silver(float capConbustible, float costoXkm, int sizePasajeros, float velMaxima, Motor motor,
			String tipoAvion, String catering) {
		super(capConbustible, costoXkm, sizePasajeros, velMaxima, motor, tipoAvion, catering);
		// TODO Auto-generated constructor stub
	}
	





	/**
	 * 
	 */
	public Silver() {
		super();
		// TODO Auto-generated constructor stub
	}






	/**
	 * @param capConbustible
	 * @param costoXkm
	 * @param sizePasajeros
	 * @param velMaxima
	 * @param tipoAvion
	 * @param id
	 * @param tarifa
	 * @param catering
	 * @param asientosDisponibles
	 */
	public Silver(float capConbustible, float costoXkm, int sizePasajeros, float velMaxima, String tipoAvion, int id,
			int tarifa, String catering, int asientosDisponibles) {
		super(capConbustible, costoXkm, sizePasajeros, velMaxima, tipoAvion, id, tarifa, catering, asientosDisponibles);
		// TODO Auto-generated constructor stub
	}





	@Override
	public String toString() {
		return super.toString()+"Silver []";
	}

	
	@Override
	public void darFrazadas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void servirComida() {
		// TODO Auto-generated method stub
		
	}

	
	
}
