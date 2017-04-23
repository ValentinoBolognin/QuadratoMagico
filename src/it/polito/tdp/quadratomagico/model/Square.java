package it.polito.tdp.quadratomagico.model;

import java.util.ArrayList;
import java.util.List;

public class Square {

	//List come struttura dati per la mia griglia
	List<Integer> griglia = null;
	int N;
	int N2;
	int magicConst;
	
	public Square(int dimension) {
		this.griglia = new ArrayList<Integer>();
		this.N = dimension;
		this.N2 = N*N;
		this.magicConst = N * (N * N + 1) / 2;
	}

	public int getN2() {
		return N2;
	}
	
	public boolean contains(int number) {
		return griglia.contains(number);
	}

	public void add(int number) {
		griglia.add(number);
	}

	public void remove(int pos) {
		griglia.remove(pos);
	}

	public boolean checkMagicConstant() {
		if(griglia.size() != N2) {
			return false;
		}
		
		// Controllare le righe
		if(!checkRows())
			return false;
		
		// Controllare le colonne
		if(!checkColumns())
			return false;
		
		// Controllare le diagonali
		if(!checkDiagonals())
			return false;
		
		return true;
	}
	
	private boolean checkRows(){
//		matrice[i][j]
//		array[i*n + j]
			
//		0,0 0,1 0,2
//		1,0 1,1 1,2
//		2,0 2,1 2,2

//		0 1 2 3 = (1,0)......8

		for(int i = 0; i < N; i++){
			int temp = 0;
			for(int j = 0; j < N; j++) {
				temp += griglia.get(i*N + j);
			}
			if (temp != magicConst)
				return false;
		}
		
		return true;	
	}

	private boolean checkColumns(){

//		0,0 0,1 0,2
//		1,0 1,1 1,2
//		2,0 2,1 2,2
		
		for(int i = 0; i < N; i++){
			int temp = 0;
			for(int j = 0; j < N; j++) {
				temp += griglia.get(j*N + i);
			}
			if (temp != magicConst)
				return false;
		}
		return true;
	}
	
	private boolean checkDiagonals(){
//		0,0 0,1 0,2
//		1,0 1,1 1,2
//		2,0 2,1 2,2

		int tmp = 0;
		for(int i = 0; i < N; i++)
			tmp += griglia.get(i*N + i);

		if (tmp != magicConst)
			return false;
		
		tmp = 0;
		for(int i = N-1; i>=0; i--){
			tmp += griglia.get((N-1-i)*N + i);
		}
		
		return true;
	}

	public String toString() {
		return griglia.toString();
	}
	
	
}
