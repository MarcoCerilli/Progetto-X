package com.example.demo;

public class CestiA {

	private String nome;
	
	private double prezzo;
  
    private int quantita;
    
	public CestiA(String nome, double prezzo, int quantita) {
		super();
		this.nome = nome;
		
		this.prezzo = prezzo;
		
		this.quantita = quantita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
    
}