package br.com.StartHair.view;

import java.util.Date;

import br.com.StartHair.model.Categoria;
import br.com.StartHair.model.Cliente;

public class Main {

	public static void main(String[] args) {
		
		Categoria hidratacao = new Categoria(1, "Hidratação");
		System.out.println(hidratacao.getNome());
		Cliente cliente = new Cliente(1,"Carlos","711.377.844-58", null, null, "carlos_camilo250@hotmail.com", "carlos300", "81995727182", "Rua coronel Kleber de andrade, 1403", "Recife", "Pernambuco" );
	
	}

}
