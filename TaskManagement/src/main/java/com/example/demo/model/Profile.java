package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Profile {

	
	@Id
    private int proid;
	@Column
	@NotBlank(message="Name is mandatory")
	private String name;
	@Lob
	@Column
//	private int age;
	private byte[] image;
	
}
