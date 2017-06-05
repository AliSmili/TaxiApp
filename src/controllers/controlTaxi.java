package controllers;

import models.listaViajesTaxi;
import models.ViajeTaxi;
import models.comparaViajes;

public class controlTaxi {
	
private static comparaViajes<ViajeTaxi> comp;
private static listaViajesTaxi<ViajeTaxi> listaViajes = new listaViajesTaxi<ViajeTaxi>(comp );
	
	
	public static boolean Buscar(int horaEntrada){
		ViajeTaxi via = Obtener(horaEntrada);
		
		if(via == null){
			return false;
		}else{
			return true;
		}
	}
	
	
	public static ViajeTaxi Obtener(int horaEntrada){
		ViajeTaxi via = null;
		
		for(ViajeTaxi i: listaViajes){
			if(i.getHoraEntrada()==(horaEntrada)){
				via = i;
			}
		}
		
		return via;
	}
	
	//Muy raro que coincidan los segundos de entrada --> como un ID del viaje
	public static void Aniadir(int horaEntrada,int minutosEntrada,int segundosEntrada, int horaSalida, int minutosSalida, int segundosSalida, float tarifa){
		if(Buscar(segundosEntrada)) throw new RuntimeException("No se puede añadir el cliente porque ya hay uno con la misma hora de entrada");
		
		listaViajes.add(new ViajeTaxi(horaEntrada,minutosEntrada,segundosEntrada, horaSalida, minutosSalida, segundosSalida, tarifa));
	}

}
