package com.example.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.example.animals.Dog;

public class Container {
	
	static private Container instance;
	
	private Container() {
		
	}
	
	public static Container getContainer() {
		if (Container.instance == null) {
			instance = new Container();
		}
		
		return instance;
	}
	
	
	private List<Dog> list = new ArrayList<Dog>();
	
	public void add(Dog d) {
		list.add(d);
	}
	
	public Optional<Dog> find(Predicate<Dog> searchTerm) {
		for(Dog d: list) {
			if(searchTerm.test(d)) {
				return Optional.of(d);
			}
		}
		
		return Optional.empty();
	}
}
