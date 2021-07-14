package com.qa.kittens.data;

public class Kitten {

	private String name;
	private String breed;

	private int age;
	private int cuteness;

	public Kitten(String name, String breed, int age, int cuteness) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.cuteness = cuteness;
	}

	public Kitten() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Kitten [name=" + name + ", breed=" + breed + ", age=" + age + ", cuteness=" + cuteness + "]";
	}

}
