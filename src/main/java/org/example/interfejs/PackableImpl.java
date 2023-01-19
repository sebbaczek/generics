package org.example.interfejs;

public class PackableImpl<T> implements Packable<T>{
        private T elem;
//
//        @Override
//        public String toString() {
//                return "PackableImpl{" +
//                               "elem=" + elem +
//                               '}';
//        }
//
//        public PackableImpl(T elem) {
//                this.elem = elem;
//        }
        
        @Override
        public void pack(T elem) {
                this.elem = elem;
        }
        
        @Override
        public T empty() {
                T elem = this.elem;
                this.elem = null;
                return elem;
        }
        
        @Override
        public String toString() {
                return "PackableImpl{" +
                               "elem=" + elem +
                               '}';
        }
}
