package com.ademir.todoapp.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String description;

	private ZonedDateTime startDate;
	
	private boolean done;
	
	private boolean favorite;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	@JsonIgnore
	private Category category;

}
