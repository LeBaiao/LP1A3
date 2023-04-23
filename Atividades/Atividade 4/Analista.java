package Generics;

public class Analista extends Funcionario implements Ponto{

	public Analista(String nome, int id, double salario){
		super(nome, id, salario);
	}
	
	public void horaEntrada(int horaEntrada) {
		setHoraEntrada(horaEntrada);
	}
	
	public void horaSaida(int horaSaida) {
		setHoraSaida(horaSaida);
	}
}
