package com.example.animals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Application {
	public static void main(String[] args) {
		Dog d1 = new Dog("Finn", "Mutt", "Hooper", "MALE", 80.0);
		Dog d2 = new Dog("Fido", "Mutt", "World", "MALE", 160.0);
		Dog d3 = new Dog("Toto", "Terrier", "Dorthy", "MALE", 5.0);
		Dog d4 = new Dog("Cain", "Lab", "Quinn", "MALE", 120.0);
		
		Cat c1 = new Cat("Garfield", "Tabby", "John", "MALE", 50.0);
		Cat c2 = new Cat("Dot", "Tabby", "World", "FEMALE", 10.0);
		
		d1.performTask((Interact)(Animal a) -> {
			try {				
				if (a instanceof Dog) {
					System.out.println("Walking " + ((Dog) a).getName());
				} else {
					System.out.println("Walking " + ((Cat) a).getName());
				}
			} catch (ClassCastException e) {
				throw new IllegalArgumentException();
			}				if (a instanceof Dog) {
				System.out.println("Walking " + ((Dog) a).getName());
			} else {
				System.out.println("Walking " + ((Cat) a).getName());
			}

		});
		
		ArrayList<Animal> list = new ArrayList<Animal>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		list.add(c1);
		list.add(c2);
		
		System.out.println(list);
		
		Collections.sort(list, (Comparator<Animal>)(Animal a1, Animal a2) -> {
			Double a1Weight;
			Double a2Weight;
			
			try {
				if (a1 instanceof Dog) {
					a1Weight = ((Dog) a1).getWeight();
				} else {
					a1Weight = ((Cat) a1).getWeight();
				}
				
				if (a2 instanceof Dog) {
					a2Weight = ((Dog) a2).getWeight();
				} else {
					a2Weight = ((Cat) a2).getWeight();
				}				
			} catch (ClassCastException e) {
				throw new IllegalArgumentException("Non Dog / Cat given");
			}
			
			Double delta = a1Weight - a2Weight;
			
			
			if (delta > 0.1) {
				return 1;
			} else if (delta < -0.1) {
				return -1;
			} else {
				return 0;
			}
		});
		
		System.out.println(list);
		
		try {			
			Double worth = findNetWorth("Bezos").get();
			System.out.println(worth);
		} catch (NoSuchElementException e) {
			System.out.println("Unable to find net worth of Bezos");
		}
		
		try {			
			Double worth = findNetWorth("Quinn").get();
		} catch (NoSuchElementException e) {
			System.out.println("Unable to find net worth of Quinn");
		}
		
	}
	
	
	static Optional<Double> findNetWorth(String name) {
		if (name == "Bezos") {
			return Optional.of(1_000_000_000.00);
		}
		
		if (name == "Kylie Jenner") {
			return Optional.of(1_000_000.00);
		}
		
		return Optional.empty();
	}
}
