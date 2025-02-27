package com.jspiders.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

}