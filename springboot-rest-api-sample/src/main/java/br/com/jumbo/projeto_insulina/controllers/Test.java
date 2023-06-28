/**
 * 
 */
package br.com.jumbo.projeto_insulina.controllers;
import java.util.Scanner;
/**
 * @author João Paulo
 *
 * 6 de mai. de 2023
 * 21:47:52
 */
public class Test {
	


	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        // solicita o peso e a altura do usuário
	        System.out.print("Digite o seu peso em kg: ");
	        double peso = input.nextDouble();

	        System.out.print("Digite a sua altura em metros: ");
	        double altura = input.nextDouble();

	        // calcula o IMC
	        double imc = peso / (altura * altura);

	        // exibe o resultado
	        System.out.printf("Seu IMC é %.2f\n", imc);

	        // classifica o resultado
	        if (imc < 18.5) {
	            System.out.println("Abaixo do peso");
	        } else if (imc >= 18.5 && imc < 25) {
	            System.out.println("Peso normal");
	        } else if (imc >= 25 && imc < 30) {
	            System.out.println("Sobrepeso");
	        } else if (imc >= 30 && imc < 35) {
	            System.out.println("Obesidade grau 1");
	        } else if (imc >= 35 && imc < 40) {
	            System.out.println("Obesidade grau 2");
	        } else {
	            System.out.println("Obesidade grau 3");
	        }
	    }
	}


