package com.IULP.BackEnd.Kimera;

import java.io.IOException;

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

        ProcessBuilder builder = new ProcessBuilder();
        builder.command("pwd");
        try{
            Process process = builder.start();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


        //for(int i=0; i<100; i++) System.out.println(3);
    }
}
