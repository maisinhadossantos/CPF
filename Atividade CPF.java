import java.util.Scanner;

public class Cpf {

	public static void main(String[] args) {
		int pridv = 0, segd = 0;
		String numCPF;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o número do CPF");
		numCPF = sc.nextLine();
		
		int[]cpf = new int[11];
		
		int j = 10;
		int cont = 0;
		
		if(numCPF.length() < 11 || numCPF.length() > 11 ) {
			System.out.println("Quantidade de caracteres inválida, por favor execute o programa novamente!");
			sc.close();
		}
		else {
			for(int n = 0; n < 9; n++) {
				cpf[n] = Character.getNumericValue(numCPF.charAt(n));
				cont += cpf[n] * j;
				j--;
			}
		}
		
		int resto1 = cont % 11;
		System.out.println("resto 1: "+ resto1);
		resto1 = 11 - resto1;
		pridv =  resto1 < 10 ? resto1 : 0;
		
		j = 11;
		cont = 0;
		for(int b = 0; b < 10; b++) {
			cpf[b] = Character.getNumericValue(numCPF.charAt(b));
			cpf[9] = pridv;
			cont += cpf[b] * j;
			j--;
		}
		
		resto1 = cont % 11;
		System.out.println("resto 2: "+resto1);
		resto1 = 11 - resto1;
		segd = resto1 < 10 ? resto1:0;
		
		int c1, c2;
		c1 = (int) Character.getNumericValue(numCPF.charAt(9));
		c2 = (int) Character.getNumericValue(numCPF.charAt(10));
		if (c1 != pridv || c2 != segd) {
			System.out.println("O CPF Inserido: "+ numCPF +". foi invalidado!");
		} else {
			System.out.println("O CPF Inserido: "+ numCPF +". foi validado!");
		}
		
		sc.close();
	}

}