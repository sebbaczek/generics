package org.example;

import java.util.function.Predicate;

public class Main {
        public static void main(String[] args) {
                
                //Worek
                Worek<String>worek = new Worek<>();
                
                worek.zapakuj("kot");
                System.out.println(worek);
                System.out.println(worek.wyciagzworka());
                
                //WorekZFiltrami
                
                //definiujemy dowolną klasę np. Car, aby jej desygnat włożyć do naszego worka z filtrami
                
                Car car = new Car("opel",24);
                
                WorekZFiltrami<Car, Predicate<Car>, Predicate<Car>> worekZFiltrami =
                        new WorekZFiltrami<Car, Predicate<Car>, Predicate<Car>>(
                     //tutaj należy zaimplementować oba filtry w postaci predykatów z klasy WorekZFiltrami, należy
                                // wymyśleć jakieś 2 filtry:
                                 car1 -> car1.getName().equals("opel"),
                     car1 -> car1.getAge() > 10
                );
                
                //teraz możemy użyć workazfiltrami i zobaczyć czy nasz samochód zostanie spakowany
                
                worekZFiltrami.zapakuj(car);
                System.out.println(worekZFiltrami);
                System.out.println(worekZFiltrami.wyciagzworka());
                
                
        }
        
        public static class Car {
                private String name;
                private int age;
        
                public Car(String name, int age) {
                        this.name = name;
                        this.age = age;
                }
        
                @Override
                public String toString() {
                        return "Car{" +
                                       "name='" + name + '\'' +
                                       ", age=" + age +
                                       '}';
                }
        
                public String getName() {
                        return name;
                }
        
                public int getAge() {
                        return age;
                }
        }
}