package com.citiustech.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.citiustech.enums.ERole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ERole getRole() {
		return role;
	}

	public Role(long id, ERole role) {
		super();
		this.id = id;
		this.role = role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private ERole role;
	
}
