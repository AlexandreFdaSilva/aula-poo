public class exercicio4{
	public static void main(String args[]){
		float peso = Float.parseFloat(args[0]);
		float altura = Float.parseFloat(args[1]);
		float IMC = peso / (altura * altura);
		System.out.print(IMC);
	}
}	