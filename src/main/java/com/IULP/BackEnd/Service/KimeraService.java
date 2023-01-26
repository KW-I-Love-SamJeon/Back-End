package com.IULP.BackEnd.Service;

import com.IULP.BackEnd.Kimera.FirstStep;
import com.IULP.BackEnd.Kimera.FourthStep;
import com.IULP.BackEnd.Kimera.ThirdStep;
import com.IULP.BackEnd.Kimera.SecondStep;
import org.springframework.stereotype.Service;

@Service
public class KimeraService {
    public void process(){
        FirstStep firstStep = new FirstStep();
        ThirdStep thirdStep = new ThirdStep();
        SecondStep secondStep = new SecondStep();
        FourthStep fourthStep = new FourthStep();

        firstStep.setPriority(Thread.MAX_PRIORITY);
        thirdStep.setPriority(Thread.MIN_PRIORITY);
        secondStep.setPriority(Thread.NORM_PRIORITY);
        fourthStep.setPriority(Thread.MIN_PRIORITY);
        System.out.println("First");
        firstStep.start();

        System.out.println("Second");
        secondStep.start();

        System.out.println("Third");
        thirdStep.start();;

        System.out.println("Fourth");
        fourthStep.start();
    }
}
