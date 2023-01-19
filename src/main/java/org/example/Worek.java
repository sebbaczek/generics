package org.example;

public class Worek<T> {
        
        private T element;
        
       public void zapakuj(T element){
                this.element = element;
        }
        
        public T wyciagzworka(){
                T element = this.element;
                this.element = null;
                return element;
        }
        
        @Override
        public String toString() {
                return "Worek{" +
                               "element=" + element +
                               '}';
        }
}
