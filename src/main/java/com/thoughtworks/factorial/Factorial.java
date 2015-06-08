package com.thoughtworks.factorial;

public class Factorial {
    public Integer compute(int i) {
        if(i>2){
            return i*2;
        } else if (i>0){
            return i;
        } else if (i==0){
            return 1;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
