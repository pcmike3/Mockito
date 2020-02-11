package com.pc.mockito;

public class MockitoService {
    public int getI(){
        System.out.println("getI");
        return 1;
    }

    public String getS(){
        System.out.println("getS");
        throw new RuntimeException();
    }
}
