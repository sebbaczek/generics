package org.example.comparator;

import org.example.Main.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
        public static void main(String[] args) {
 //nayural order: 1, A, a
        
                List<String>list = Arrays.asList("a","aa","A1a","1aa","Aa","a1","1A");
                
                Comparator<String> compNatural = Comparator.naturalOrder();
                list.sort(compNatural);
                System.out.println(list);
                
                Comparator<String> compNaturalRev = compNatural.reversed();
                list.sort(compNaturalRev);
                System.out.println(list);
        
                //2. metoda na reversed
                Comparator<String> compNaturalRev2 = Comparator.<String>naturalOrder().reversed();
                list.sort(compNaturalRev2);
                System.out.println(list);
                
   //interfejs Comparator można zaimplementować na 3 sposoby: osobną klasą, klasą anonimową, lambdą
   
   //klasa anonimowa implementująca Comparator
                
                //jeśli porównujemy daną klasę to trzeba dodać <typ>
                Comparator<Car> comparator1 = new Comparator<>() {
                
                        @Override
                        // jeśli o1-o2  -kolejność rosnąca
                        // jeśli o2-o1  -kolejność malejąca
                        public int compare(Car o1, Car o2) {
                                return o1.getAge()-o2.getAge();
                        }
                };
        
                List<Car>cars = new ArrayList<>(
                        List.of(
                                new Car("opel" ,2),
                                new Car("opel" ,4),
                                new Car("toyota" ,55),
                                new Car("audi" ,21),
                                new Car("opel" ,12),
                                new Car("opel" ,23),
                                new Car("audi" ,4),
                                new Car("fiat" ,2)
                        )
                );
                
                cars.sort(comparator1);
                System.out.println(cars);
        
        
                Comparator<Car> comparator2 = new Comparator<>() {
                
                        @Override
                        // jeśli o1-o2  -kolejność rosnąca
                        // jeśli o2-o1  -kolejność malejąca
                        public int compare(Car o1, Car o2) {
                                return o1.getName().compareTo(o2.getName());
                        }
                };
        
                cars.sort(comparator2);
                cars.sort(comparator2.reversed());
                System.out.println(cars);
        
                
                //jeśli dodajemy .thenComparing, to trzeba umieścić typ generyczny we frazie new Comparator<Car>()
                Comparator<Car> comparator3 = new Comparator<Car>() {
                
                        @Override

                        public int compare(Car o1, Car o2) {
                                return o1.getName().compareTo(o2.getName());
                        }
                }.thenComparing( new Comparator<Car>() {
        
                        @Override
           
                        public int compare(Car o1, Car o2) {
                                return o1.getAge()-o2.getAge();
                        }
                });
        
                cars.sort(comparator3);
                System.out.println(cars);
        
        
                
 //zamiast thenComparing, możemy zrobić to krócej:
                Comparator<Car> comparator4 = new Comparator<>() {
                        @Override
                        public int compare(Car o1, Car o2) {
                                //trzeba dodać jeszcze zachowanie na wypadek nulla
                                int result = o1.getName().compareTo(o2.getName());
                                //jeśli Name są równe to zrób porównanie Age, jeśli Name są różne to nie rób już porównania Age
                                if (result != 0){
                                        return result;
                                }
                                return o2.getAge()-o1.getAge();
                        }
                };
                cars.sort(comparator4);
                System.out.println(cars);
        
 //komparator za pomocą lambdy:
 
Comparator<Car>lambdacomp =(o1,o2)->o1.getAge()- o2.getAge();
Comparator<Car>lambdacomp2 = Comparator.comparingInt(Car::getAge);
Comparator<Car>lambdacomp5 = Comparator.comparingInt(car -> car.getAge());



Comparator<Car>lambdacomp3 =(o1,o2)->o1.getName().compareTo(o2.getName());
 Comparator<Car>lambdacomp4 = Comparator.comparing(Car::getName);
 Comparator<Car>lambdacomp6 = Comparator.comparing(car -> car.getName());
 
 //reversed - trzeba dodać typ Car car
Comparator<Car>lambdacomp6rev = Comparator.comparing((Car car) -> car.getName()).reversed();

lambdacomp6rev = lambdacomp6rev.thenComparingInt(car -> car.getAge())  ;

//skrócenie zapisu ctrl alt N
Comparator<Car>lambdacomp6rev2;
lambdacomp6rev2 = Comparator.<Car, String>comparing(car1 -> car1.getName()).thenComparingInt(car -> car.getAge())  ;
        
                
                
                
                
        }
}
