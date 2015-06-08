package com.thoughtworks.factorial;

public class Factorial {
    public Integer compute(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i < 2) {
            return 1;
        } else if(i>2){
            return i*2;
        } else {
            return compute(i-2)+compute(i-1);
        }
    }
}
