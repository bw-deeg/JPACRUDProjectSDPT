package com.skilldistillery.jpacandy.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Candy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private Integer calories;
	private String description;
	private Boolean available;
	
	@Column(name="average_price")
	private Double averagePrice; 
	
	//methods
	public Candy() {}
	
	public Candy(String name, Integer calories, String description, Boolean available, Double averagePrice) {
		super();
		this.name = name;
		this.calories = calories;
		this.description = description;
		this.available = available;
		this.averagePrice = averagePrice;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candy other = (Candy) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Candy [id=" + id + ", name=" + name + ", calories=" + calories + ", description=" + description
				+ ", available=" + available + ", averagePrice=" + averagePrice + "]";
	}
	
	

}
