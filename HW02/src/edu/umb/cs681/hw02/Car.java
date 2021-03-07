package edu.umb.cs681.hw02;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;


public class Car {

	private String make, model;
	private int mileage, year;
	private int price;
	private int dominationCount;

	public Car(String make, String model, int mileage, int year, int price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}
	
	public String getMake() {		return make;	}
	public String getModel() {		return model;	}
	public int getMileage() {		return mileage;	}
	public int getYear() {		return year;	}
	public int getPrice() {		return price;	}

	public void setDominationCount(ArrayList<Car> cars) {
		for (Car car : cars) {
			if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
					&& (car.getYear() <= this.getYear())) {
				this.dominationCount++;
			}
		}
		this.dominationCount--;
	}

	public int getDominationCount() {		return this.dominationCount;	}

	@Override
	public String toString() {		return this.make +" "+ this.model+" "+ this.mileage+" "+this.year+" "+this.price;	}

	public static void main(String[] args) {

		List<Car> carList = new ArrayList<Car>();
		carList.add(new Car("Maruti", "Swift", 9000, 2018, 30000));
		carList.add(new Car("Toyota", "RAV4", 100500, 2018, 35000));
		carList.add(new Car("Lexus", "RX350", 5000, 2017, 34000));
		carList.add(new Car("Honda", "CRV", 2000, 2020, 29000));
		carList.add(new Car("Honda", "CRV", 25000, 2019, 28000));

		System.out.println("Sorted Cars(by Year):");
		List<Car> sortedYearWise=carList.stream().sorted(Comparator.comparingInt(Car::getYear)).collect(Collectors.toList());
		sortedYearWise.forEach(System.out::println);

		System.out.println("");
		System.out.println("Sorted Cars(by Milage):");
		List<Car> sortedMileageWise=carList.stream().sorted(Comparator.comparingInt(Car::getMileage)).collect(Collectors.toList());
		sortedMileageWise.forEach(System.out::println);

		System.out.println("");
		System.out.println("Sorted Cars(by Price):");
		List<Car> sortedPriceWise=carList.stream().sorted(Comparator.comparingInt(Car::getPrice)).collect(Collectors.toList());
		sortedPriceWise.forEach(System.out::println);

		System.out.println("");
		System.out.println("Sorted Cars(by Domination):");
		List<Car> sortedDominationCountWise=carList.stream().sorted(Comparator.comparingInt(Car::getDominationCount)).collect(Collectors.toList());
		sortedDominationCountWise.forEach(System.out::println);
	}
}