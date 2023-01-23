package org.example.first_class_citizen;

public class Main {
        public static void main(String[] args) {
        //higher order functions - przyjmują lub zwracają funkcje:
        
// aby wywołać funkcję należy przekazać implementację interfejsu
                //parametrem wejściowym jest tutaj funkcja
                // () jest puste bo metodaInterfejsu() nie przyjmuje w tym przypadku żadnych parametrów
                funkcja(()->"tekst");
                
                //wywołanie funkcji2 polega na przekazaniu typu który zwraca metoda interfejsu - implementacji
                // interfejsu, a wynikiem wywołania będzie wykonanie na tym typie metody która jest w ciele funkcji2
                // i zwrócenie typu zwracanego przez funkcję2
                String s = funkcja2(() -> 12);
                System.out.println(s);
        
                // ta funkcja zwróci inną funkcję
                Iinterfejs<String>stringIinterfejs = funkcja3();
                String s1 = stringIinterfejs.metodaInterfejsu();
                System.out.println(s1);
        }
        
        
        // ta funkcja zwróci inną funkcję, którą przekazuje jej interfejs, którego metodę implementujemy, nazwa
        // metody interfejsu potrzebna jest dopiero przy wywoływaniu
        private static Iinterfejs<String> funkcja3() {
        return () ->{
          return "napis";
        };
        }
        
        
        //                funkcja static zwraca String, a przyjmuje za argument instancję interfejsu, któremu należy
        //                wskazać jakieś T (tutaj jest to String)
        //              w ciele funkcji wywołujemy metodę interfejsu
        
        
        private static String funkcja(Iinterfejs<String> iinterfejs) {
               return iinterfejs.metodaInterfejsu();
        }
        private interface Iinterfejs<T> {
        
                T metodaInterfejsu();
        }
        
        
        //funkcja2 przyjmuje jakiś interfejs i w swoim ciele stosuje jego metodę dodając toString()
        private static String funkcja2(Interfejs2 i2) {
                return i2.method().toString();
        }
        
        private interface Interfejs2 {
                Integer method();
        }
        
        
        
        
        
        
        
        
}
