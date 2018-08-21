import java.util.Scanner;
public class exercicio6{
	public static void main(String args[]){
		int[] vet = new int[10];
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<10; i++){
			System.out.println("Digite um numero["+i+"]: ");
			vet[i] = scan.nextInt();
			//scan.nextLine();
		}
		
		int soma = 0;
		for(int i=0; i<10; i++)
			soma+= vet[i];
		
		int media = soma/10;
		
		int maior = vet[0], menor = vet[0];
		for(int i=1; i<10; i++){
			if(vet[i]>maior)
				maior = vet[i];
			if(vet[i]<menor)
				menor = vet[i];
		}
		
		System.out.println("Soma: "+soma);
		System.out.println("Media: "+media);
		System.out.println("Maior: "+maior);
		System.out.println("Menor: "+menor);
	}
}