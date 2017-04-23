package it.polito.tdp.quadratomagico.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		List<Square> solutions = model.findMagicSquares(3);
		if(solutions != null) {
			System.out.println("Trovata almeno una soluzione");
			for (Square s: solutions){
				System.out.println(s.toString());
			}
		} else {
			System.out.println("Nessuna soluzione trovata");
		}
	}
}
