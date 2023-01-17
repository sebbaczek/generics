package org.example;

import java.util.function.Predicate;

//Predicate jest interfejsem z metodą test(T)
public class SortowanieWorka<T, U extends Predicate<T>, V extends Predicate<T>> {

private T elem;

//final musi być zainicjowany w konstruktorze
private final U filter1;
private final V filter2;
        
        public SortowanieWorka(U filter1, V filter2) {
                this.filter1 = filter1;
                this.filter2 = filter2;
        }
        
        public void zapakuj(T elem){
                //dodajemy sprawdzenie pakowanego elementu, implementacja tefo sprawdzenia nastąpi wraz z wywołaniem
                // metody
                if (filter1.test(elem) && (filter2.test(elem))) {
                        this.elem = elem;
                }
               
        }
        
        public T wyciagzworka(){
                T elem = this.elem;
                this.elem = null;
                return elem;
        }
        
        
        
        
        
        
        
}
