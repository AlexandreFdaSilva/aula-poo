public class exercicio5{
	public static void main(String args[]){
		int dias = Integer.parseInt(args[0]);
		int salarioIntegral = Integer.parseInt(args[1]);
		int salarioParcial = (salarioIntegral * dias) / 22;
		System.out.print(salarioParcial);
	}
}