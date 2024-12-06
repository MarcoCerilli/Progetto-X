package com.example.demo;

public class Cesto {

	private String nome;
	private String marca;
	private double prezzo;
    private String luogo;
    private String url;
    
	public Cesto(String nome, String marca, double prezzo, String luogo, String url) {
		
		super();
		this.nome = nome;
		this.marca = marca;
		this.prezzo = prezzo;
		this.luogo = luogo;
		this.url = url;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    
    
	
	
}
