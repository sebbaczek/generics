package org.example.comperable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
        public static void main(String[] args) {
        
                List<Cat>cats = new ArrayList<>(List.of(
                        new Cat("Burek",11),
                        new Cat("Murek",12),
                        new Cat("Kurek",16),
                        new Cat("Jurek",2),
                        new Cat("Turek",1),
                        new Cat("Burek",12)
                ));
                
                //sortowanie metodą Collections.sort() możliwe dzięki implementacji Comperable w klasie Cat
                
                //Comparable ma 1 metodę ale nie jest interfejsem funkcyjnym, i powinno się go implementować w klasie
        
                Collections.sort(cats);
                System.out.println(cats);
                
                
                
                
                
                
        
        }
        
        public static class Cat implements Comparable<Cat>{
                private final String name;
                private int age;
        
                public Cat(String name,int age) {
                        this.name = name;
                        this.age = age;
                }
        
                @Override
                public String toString() {
                        return "Cat{" +
                                       "name='" + name + '\'' +
                                       "age='" + age + '\'' +
                                       '}';
                }
        
                @Override
                public int compareTo(Cat o) {
                        //compsreTo możemy stosować też do Integer ale nie do int
                        //tutaj getter do name nie jest potrzebny
//                        rosnąco:
//                        return this.name.compareTo(o.name);
//                        malejąco:
//                        return o.name.compareTo(this.name);
                        
                        //można też wstawiać tutaj comperatory:
                        //reversed odwraca całą listę, żeby ztobić zwykłe odwrócenie trzeba napisać (o1,o2)->o1.name.compareTo(o2.name)
                        Comparator<Cat>comp1 =Comparator.<Cat,String>comparing(c->c.name).reversed();
                        Comparator<Cat>comp2 =comp1.thenComparingInt(c->c.age).reversed();
                        return comp2.compare(this, o);
                        
                }
        }
}
