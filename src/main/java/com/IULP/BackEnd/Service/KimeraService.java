package com.IULP.BackEnd.Service;

import com.IULP.BackEnd.Kimera.Roscore;
import com.IULP.BackEnd.Kimera.Roslaunch;
import com.IULP.BackEnd.Kimera.Rosservice;
import org.springframework.stereotype.Service;

@Service
public class KimeraService {
    public void process(){
        Roscore roscore = new Roscore();
        Roslaunch roslaunch = new Roslaunch();
        Rosservice rosservice = new Rosservice();

        roscore.setPriority(Thread.MAX_PRIORITY);
        roslaunch.setPriority(Thread.NORM_PRIORITY);
        rosservice.setPriority(Thread.MIN_PRIORITY);

        System.out.println("roscore");
        roscore.start();
        System.out.println("roslaunch");
        roslaunch.start();;
        System.out.println("rosservice");
        rosservice.start();
    }
}
