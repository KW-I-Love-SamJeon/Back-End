package com.IULP.BackEnd.Kimera;

import java.io.IOException;

public class Rosservice extends Thread {
    public void run() {
        try{
            //String[] rosservice = new String[]{"rosservice","call", "/kimear_semantics_mode/generate_mesh"};
            String[] rosservice = new String[]{"time"};

            ProcessBuilder processBuilder = new ProcessBuilder(rosservice);
            java.lang.Process process = processBuilder.start();
        }catch(IOException e){
            e.printStackTrace();
        }
        //for(int i=0; i<100; i++) System.out.println(1);
    }
}
