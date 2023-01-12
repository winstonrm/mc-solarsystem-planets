package com.punk.astronomy.solarsystem.dto;

public class Planet{
	public String id;
	public String name;
	public String type;
	public String resume;
	public String introduction;
	public String geography;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}


	public String getGeography() {
		return geography;
	}

	public void setGeography(String geography) {
		this.geography = geography;
	}

	@Override
	public String toString() {
		return "Planets [id=" + id + ", name=" + name + ", type=" + type + ", resume=" + resume + ", introduction="
				+ introduction + ", geography=" + geography + "]";
	}


}