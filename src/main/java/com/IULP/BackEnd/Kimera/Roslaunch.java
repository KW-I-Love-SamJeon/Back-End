package com.IULP.BackEnd.Kimera;

import java.io.IOException;

public class Roslaunch extends Thread{

    public void run() {
//        //String[] launch = new String[]{"roslaunch","kimera_semantics_res", "kimera_semantics.launch", "play_back:=true"};
//
//        ProcessBuilder processBuilder = new ProcessBuilder(launch);
//        try {
//            Process process = processBuilder.start();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        for(int i=0; i<100; i++) System.out.println(2);
    }
}