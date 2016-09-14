package com.amverhagen.web.programmers.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "programmer")
public class Programmer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "full_name")
	private String fullName;

	@ManyToOne
	@JoinColumn(name = "favorite_color")
	private Color favoriteColor;

	@ManyToOne
	@JoinColumn(name = "favorite_programming_language")
	private ProgrammingLanguage favoriteProgrammingLanguage;

	@ManyToOne
	@JoinColumn(name = "disliked_programming_language")
	private ProgrammingLanguage dislikedProgrammingLanguage;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public void setName(String name) {
		this.fullName = name;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFavoriteColor(Color favoriteColor) {
		this.favoriteColor = favoriteColor;
	}

	public Color getFavoriteColor() {
		return this.favoriteColor;
	}

	public void setFavoriteProgrammingLanguage(ProgrammingLanguage favoriteProgrammingLanguage) {
		this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
	}

	public ProgrammingLanguage getFavoriteProgrammingLangauge() {
		return this.favoriteProgrammingLanguage;
	}

	public void setDislikedProgrammingLanguage(ProgrammingLanguage dislikedProgrammingLanguage) {
		this.dislikedProgrammingLanguage = dislikedProgrammingLanguage;
	}

	public ProgrammingLanguage getDislikedProgrammingLangauge() {
		return this.dislikedProgrammingLanguage;
	}

}
