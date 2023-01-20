package com.IULP.BackEnd.Kimera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Roscore extends Thread{
    public void run(){
//        String[] roscore = new String[]{"roscore"};
//        String[] roscore = new String[]{"pwd"};
//
//        ProcessBuilder processBuilder = new ProcessBuilder(roscore);
//        try {
//            Process process = processBuilder.start();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("ROSCORE");

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("roscore");
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
            System.out.println("roscore");
            System.out.println(output.toString());

        }catch(Exception e){
            e.printStackTrace();
        }


        //for(int i=0; i<100; i++) System.out.println(3);
    }
}
