package com.IULP.BackEnd.Kimera;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SecondStep extends Thread {
    public void run() {

            //String[] rosservice = new String[]{"rosservice","call", "/kimear_semantics_mode/generate_mesh"};
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("roslaunch kimera_vio_ros kimera_vio_ros_euroc.launch run_stereo_dense:=true");
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
            System.out.println("Second Step");
            System.out.println(output.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
        //for(int i=0; i<100; i++) System.out.println(1);
    }
}
