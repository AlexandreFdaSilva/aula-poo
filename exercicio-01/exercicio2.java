public class exercicio2{
	public static void main(String args[]){
		int d = Integer.parseInt(args[0]);
		String aux;
		switch(d){
			case 1:
				System.out.print("Domingo");
				break;
			case 2:
				System.out.print("Segunda");
				break;
			case 3:
				System.out.print("Terca");
				break;
			case 4:
				System.out.print("Quarta");
				break;
			case 5:
				System.out.print("Quinta");
				break;
			case 6:
				System.out.print("Sexta");
				break;
			case 7:
				System.out.print("Sabado");
				break;
			default:
				System.out.print("Erro");
				break;
		}
	}
}