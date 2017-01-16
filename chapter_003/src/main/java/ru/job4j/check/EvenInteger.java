package ru.job4j.check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by VLADIMIR on 16.01.2017.
 */
public class EvenInteger implements IEvenInteger {
    @Override
    public boolean isNumber(InputStream in) {
        boolean result = false;
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        try {
            line = br.readLine();
            int i = new Integer(line);
            int rest = i % 2;
            if (rest == 0) {
                result = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}