package models;

import java.util.Comparator;
import java.util.Date;

public class comparaViajes<T> implements Comparator<T>{
	private ViajeTaxi v1, v2;

	public comparaViajes(){
		
	}
	  public int compare(Object v1, Object v2){
	      int instante1 = ((ViajeTaxi) v1).getHoraEntrada( );
	      int instante2 = ((ViajeTaxi) v2).getHoraEntrada( );
	      if(instante1 > instante2){//ordenamos de mayor a menor
	          return -1;
	       }else if(instante1 < instante2){
	          return 1;
	       }else{
	          return 0;
	       }
	    }
	 }

