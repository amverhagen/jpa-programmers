package com.amverhagen.web.programmers.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "hex_code")
	private String hexCode;

	public void setHexCode(String hexCode) {
		this.hexCode = hexCode;
	}

	public String getHexCode() {
		return this.hexCode;
	}

}
