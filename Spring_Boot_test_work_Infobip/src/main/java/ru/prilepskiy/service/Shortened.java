package ru.prilepskiy.service;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class Shortened {

    public static void main(String[] args) throws IOException {
        System.out.println(toBase36(Integer.MAX_VALUE));
    }

    static String toBase36(int i) {
        return new BigInteger(1, ByteBuffer.allocate(4).putInt(i).array()).toString(36);
    }


}
