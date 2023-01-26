package com.IULP.BackEnd.Kimera;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FourthStep extends Thread{

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

        ProcessBuilder processBuilder1 = new ProcessBuilder();
        processBuilder1.command("rosbag play /home/rhee/dataset/* --clock");
        ProcessBuilder processBuilder2 = new ProcessBuilder();
        processBuilder2.command("rosservice call /kimera_semantics_node/generate_mesh");
        try{
            // Run script
            Process process1 = processBuilder1.start();
            Process process2 = processBuilder1.start();

            // Read output
            StringBuilder output = new StringBuilder();
            BufferedReader reader1 = new BufferedReader(
                    new InputStreamReader(process1.getInputStream()));
            BufferedReader reader2 = new BufferedReader(
                    new InputStreamReader(process2.getInputStream()));

            String line;
            while ((line = reader1.readLine()) != null) {
                output.append(line);
            }
            while ((line = reader2.readLine()) != null) {
                output.append(line);
            }
            System.out.println("Fourth Step");
            System.out.println(output.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
        //for(int i=0; i<100; i++) System.out.println(2);
    }
}