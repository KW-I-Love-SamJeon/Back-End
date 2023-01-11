package com.IULP.BackEnd.Service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BagService {
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
