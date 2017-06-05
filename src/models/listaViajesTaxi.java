package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;



public class listaViajesTaxi<T> extends ArrayList <T>{
	
	private Comparator<T> miComparador;

	
	public listaViajesTaxi(Comparator<T> comp){
		
		this.miComparador = comp;
		
	}
	
	
	
}
