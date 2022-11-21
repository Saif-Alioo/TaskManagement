package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;

//import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class Task {

	@Id
	private int taskid;
	@Column
	@NotBlank(message="Task name is mandatory")
	private String taskName;
	@Column
	private String taskdec;
	@ManyToOne
	@JoinColumn(name="proid")
	Profile profile;
	
	
}
