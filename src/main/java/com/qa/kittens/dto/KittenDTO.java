package com.qa.kittens.dto;

public class KittenDTO {

	private int id;

	private String name;
	private String breed;

	private int age;
	private int cuteness;

	private OwnerDTO owner;

	public KittenDTO(int id, String name, String breed, int age, int cuteness, OwnerDTO owner) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.cuteness = cuteness;
		this.owner = owner;
	}

	public KittenDTO() {
		// TODO Auto-generated constructor stub
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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCuteness() {
		return cuteness;
	}

	public void setCuteness(int cuteness) {
		this.cuteness = cuteness;
	}

	public OwnerDTO getOwner() {
		return owner;
	}

	public void setOwner(OwnerDTO owner) {
		this.owner = owner;
	}

}
