package com.IULP.BackEnd.Service;

import java.io.IOException;

class Roscore extends Thread{
    public void run() {
        String[] roscore = new String[]{"roscore"};

        ProcessBuilder processBuilder = new ProcessBuilder(roscore);
        try {
            Process process = processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Roslaunch extends Thread{

    public void run() {
        String[] launch = new String[]{"roslaunch","kimera_semantics_res", "kimera_semantics.launch", "play_back:=true"};

        ProcessBuilder processBuilder = new ProcessBuilder(launch);
        try {
            Process process = processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Rosservice extends Thread{
    public void run() {
        try{
            String[] rosservice = new String[]{"rosservice","call", "/kimear_semantics_mode/generate_mesh"};

            ProcessBuilder processBuilder = new ProcessBuilder(rosservice);
            java.lang.Process process = processBuilder.start();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}

public class processService {
    public void process(){
        Roscore roscore = new Roscore();
        Roslaunch roslaunch = new Roslaunch();
        Rosservice rosservice = new Rosservice();

        roscore.setPriority(Thread.MAX_PRIORITY);
        roslaunch.setPriority(Thread.NORM_PRIORITY);
        rosservice.setPriority(Thread.MIN_PRIORITY);

        roscore.start();
        roslaunch.start();;
        rosservice.start();
    }
}
