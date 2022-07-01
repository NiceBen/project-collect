package com.niceben.projectjpa.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe =(Unsafe) unsafeField.get(null);


        long addr = unsafe.allocateMemory(4);
        unsafe.putInt(addr,1);
        int a=unsafe.getInt(addr);
        System.out.println(a);
        unsafe.freeMemory(addr);
    }


}
