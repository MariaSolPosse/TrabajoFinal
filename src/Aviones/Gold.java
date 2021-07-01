package Aviones;

import Interface.IDasFrazadas;
import Interface.IServicioPremium;
import Interface.IServirComida;
import enume.Motor;

public class Gold extends Avion implements IServirComida,IDasFrazadas,IServicioPremium{

	 private String wifi;


	/**
	 * 
	 */
	public Gold() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param capConbustible
	 * @param costoXkm
	 * @param sizePasajeros
	 * @param velMaxima
	 * @param motor
	 * @param tipoAvion
	 * @param catering
	 */
	public Gold(float capConbustible, float costoXkm, int sizePasajeros, float velMaxima, Motor motor, String tipoAvion,
			String catering,String wifi) {
		super(capConbustible, costoXkm, sizePasajeros, velMaxima, motor, tipoAvion, catering);
		this.wifi=wifi;
		// TODO Auto-generated constructor stub
	}


	
	public String getWifi() {
		return wifi;
	}



	public void setWifi(String wifi) {
		this.wifi = wifi;
	}



	@Override
	public String toString() {
		return "Gold [wifi=" + wifi + "]";
	}



	@Override
	public void darAuriculares() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darShow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darFrazadas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void servirComida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void conexionWifi() {
		// TODO Auto-generated method stub
		
	}

	
	
}
