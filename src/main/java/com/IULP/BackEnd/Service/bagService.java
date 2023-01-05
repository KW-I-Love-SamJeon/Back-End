package com.IULP.BackEnd.Service;

import java.io.IOException;

public class bagService {
    public void process(){
        String[] bag = new String[]{"rosbag record -a"};

        ProcessBuilder processBuilder = new ProcessBuilder(bag);
        try {
            Process process = processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
