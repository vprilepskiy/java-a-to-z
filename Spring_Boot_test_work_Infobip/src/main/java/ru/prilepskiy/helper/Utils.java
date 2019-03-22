package ru.prilepskiy.helper;

import org.apache.commons.text.RandomStringGenerator;

import java.math.BigInteger;
import java.nio.ByteBuffer;


public class Utils {

    public String toBase36(int i) {
        return new BigInteger(1, ByteBuffer.allocate(4).putInt(i).array()).toString(36);
    }

    public String generatePassword() {
         return new RandomStringGenerator.Builder().withinRange('a', 'z').build().generate(32);
    }

}
