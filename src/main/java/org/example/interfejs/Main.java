package org.example.interfejs;

import java.util.Map;

public class Main<T> {
        
        private static  Map<org.example.Main.Car,String>someMap2 = Map.of(
                new org.example.Main.Car("opel",21),"car1",
                new org.example.Main.Car("opel2",11),"car2");
        
        public static void main(String[] args) {
                //klasa implementująca interfejs z dowolnym typem generycznym;
                //przy typach generycznych występuje typ erasure - podmiana typów na Object:
                //nie można: stworzyć instancji new T(); stworzyć tablicy new T[6]; wywołać instanceof T; użyć
                // prymitywów jako T; używać T jako staticów
                
                // można też stworzyć klasę
                // implementującą interfejs już z konkretnym obiektem i wtedy używać jej PackableImpl packableImpl =
                // new PackableImpl();
                PackableImpl<org.example.Main.Car> carPackable = new PackableImpl<>();
                        org.example.Main.Car car = new org.example.Main.Car("opel",24);
                                carPackable.pack(car);
                                  System.out.println(carPackable);
                               System.out.println(carPackable.empty());
                
                PackableImpl<String>stringPackable = new PackableImpl<>();
                        stringPackable.pack("kot");
                        System.out.println(stringPackable);
        
                        
              //wywołanie metody statycznej z generykiem
                call(car);
                call("mysz");
                
                call2(car);
                //nie zadziała bo mysz nie extend Car:
//                call2("mysz");
                
                
                //metoda static zwracająca generyk
                System.out.println(call3("jakiśelem"));
        
                
                //metoda statyczna wyjmująca jakieś T z mapy
                System.out.println((String) call4());
//                Object o = call4();
        
        
                //użycie metody statycznej wywołanej na tablicy statycznej wymaga podania klasy w której jest ta
                // metoda oraz <T> typu którym jest obiekt na którym tę metodę wywołujemy : Main.<org.example.Main
                // .Car>methodx().somemethod() - bo java nie wie jaki typ przekazaliśmy do tej metody i z jakim typem
                // ma być call5 wywołane
                int o = Main.<org.example.Main.Car>call5().getAge();
                System.out.println(o);
        
        
        }
        
        //metoda static musi mieć <U> po static
        public static <U> void call (U elem){
                System.out.println(elem);
        };
        
//        statyczna metoda generyczna, w której mamy doprecyzowany generyk
        //extends stosujemy tutaj do klas i też do interfejsów
        public static <U extends org.example.Main.Car> void call2 (U elem){
                System.out.println(elem);
        };
        
        //metoda static zwracająca generyk
        public static <U> U call3 (U elem){
                return elem;
        };
        
        //metoda statyczna wyjmująca jakieś T z mapy
        private static Map<Integer,String>someMap = Map.of(1,"elem1",2,"elem2");
 
        public static <U> U call4 (){
                return (U) someMap.get(2);
        };
        
        public static <U> U call5 (){
                return (U) someMap2.keySet().toArray()[0];
        };
}
