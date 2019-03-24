package ru.prilepskiy.helper;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    public String toBase36(int i) {
        return Integer.toString(i, 36);
    }

    public String generatePassword() {
        return new RandomStringGenerator.Builder().withinRange('0', 'z').build().generate(8);
    }
}
