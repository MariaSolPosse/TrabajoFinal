package Aviones;

import Interface.IServirComida;
import enume.Motor;

public class Bronce extends Avion implements IServirComida{

	

	
	



	/**
	 * @param capConbustible
	 * @param costoXkm
	 * @param sizePasajeros
	 * @param velMaxima
	 * @param motor
	 * @param tipoAvion
	 * @param catering
	 */
	public Bronce(float capConbustible, float costoXkm, int sizePasajeros, float velMaxima, Motor motor,
			String tipoAvion, String catering) {
		super(capConbustible, costoXkm, sizePasajeros, velMaxima, motor, tipoAvion, catering);
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 */
	public Bronce() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return super.toString()+"Bronce []";
	}


	
	@Override
	public void servirComida() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
