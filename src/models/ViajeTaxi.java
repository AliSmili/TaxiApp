package models;



public class ViajeTaxi {
	
	private int horaEntrada;
	private int minutosEntrada;
	private int segundosEntrada;
	private int horaSalida;
	private int minutosSalida;
	private int segundosSalida;
	private float tarifa;
	public ViajeTaxi(int horaEntrada, int minutosEntrada, int segundosEntrada, int horaSalida, int minutosSalida,
			int segundosSalida, float tarifa) {
		super();
		this.horaEntrada = horaEntrada;
		this.minutosEntrada = minutosEntrada;
		this.segundosEntrada = segundosEntrada;
		this.horaSalida = horaSalida;
		this.minutosSalida = minutosSalida;
		this.segundosSalida = segundosSalida;
		this.tarifa = tarifa;
	}
	public int getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(int horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public int getMinutosEntrada() {
		return minutosEntrada;
	}
	public void setMinutosEntrada(int minutosEntrada) {
		this.minutosEntrada = minutosEntrada;
	}
	public int getSegundosEntrada() {
		return segundosEntrada;
	}
	public void setSegundosEntrada(int segundosEntrada) {
		this.segundosEntrada = segundosEntrada;
	}
	public int getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(int horaSalida) {
		this.horaSalida = horaSalida;
	}
	public int getMinutosSalida() {
		return minutosSalida;
	}
	public void setMinutosSalida(int minutosSalida) {
		this.minutosSalida = minutosSalida;
	}
	public int getSegundosSalida() {
		return segundosSalida;
	}
	public void setSegundosSalida(int segundosSalida) {
		this.segundosSalida = segundosSalida;
	}
	public float getTarifa() {
		return tarifa;
	}
	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	
}
	
	
	