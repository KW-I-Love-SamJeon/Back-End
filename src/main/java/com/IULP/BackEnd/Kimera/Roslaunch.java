package com.IULP.BackEnd.Kimera;

import org.apache.tomcat.jni.Proc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Roslaunch extends Thread{

    public void run() {
        //String[] launch = new String[]{"roslaunch","kimera_semantics_res", "kimera_semantics.launch", "play_back:=true"};
//        String[] launch = new String[]{"date"};
//
//        ProcessBuilder processBuilder = new ProcessBuilder(launch);
//        try {
//            Process process = processBuilder.start();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("date");
        try{
            // Run script
            Process process = processBuilder.start();

            // Read output
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            System.out.println(output.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
        //for(int i=0; i<100; i++) System.out.println(2);
    }
}