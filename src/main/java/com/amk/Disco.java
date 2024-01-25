package com.amk;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Document
public class Disco {
	//@BsonId
	//@Id
	@MongoId(FieldType.INT32)
	private int id;
	private String titulo;
	private List<String> musicos;
	private double precio;
	private String discografica;

	public Disco() {
	}

	public Disco(int id, String titulo, List<String> musicos, double precio, String discografica) {
		this.id = id;
		this.titulo = titulo;
		this.musicos = musicos;
		this.precio = precio;
		this.discografica = discografica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getMusicos() {
		return musicos;
	}

	public void setMusicos(List<String> musicos) {
		this.musicos = musicos;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDiscografica() {
		return discografica;
	}

	public void setDiscografica(String discografica) {
		this.discografica = discografica;
	}

	@Override
	public String toString() {
		return "Disco{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", musicos=" + musicos +
				", precio=" + precio +
				", discografica='" + discografica + '\'' +
				'}';
	}
}
