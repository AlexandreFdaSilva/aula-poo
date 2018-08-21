import java.util.Scanner;
public class exercicio7{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		String nome = scan.nextLine();
		float[] vet = new float[3];
		for(int i=1; i<4; i++){
			System.out.println("Digite a note da M"+i+": ");
			vet[i-1] = Float.parseFloat(scan.nextLine());
		}
		
		float media = 0;
		for(int i=0; i<3; i++)
			media += vet[i];
		media/=3;
		
		System.out.println(nome);
		System.out.println(media);
		if(media>=6)
			System.out.println("Aprovado");
		else
			System.out.println("Reprovado");
	}
}