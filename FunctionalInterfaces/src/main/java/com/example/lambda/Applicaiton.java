package com.example.lambda;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

import com.example.animals.Dog;

public class Applicaiton {
	public static void main(String[] args) {
		Container c = Container.getContainer();
		Dog d1 = new Dog("Finn", "Mutt", "Hooper", "MALE", 80.0);
		Dog d2 = new Dog("Fido", "Mutt", "World", "MALE", 160.0);
		Dog d3 = new Dog("Toto", "Terrier", "Dorthy", "MALE", 5.0);
		Dog d4 = new Dog("Cain", "Lab", "Quinn", "MALE", 120.0);
		
		c.add(d1);
		c.add(d2);
		c.add(d3);
		//c.add(d4);
		
		
		try {			
			// Find dog where breed is LAB
			Dog result = c.find((Predicate<Dog>)(Dog d) -> {
				if (d.getBreed().toUpperCase().equals("LAB")) {
					return true;
				}
				
				return false;
			}).get();
			
			System.out.println("Found Lab");
			System.out.println(result);
		} catch (NoSuchElementException e) {
			System.out.println("Unable to find a lab");
		}
		
		
	}
}
