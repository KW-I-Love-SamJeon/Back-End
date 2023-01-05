package com.IULP.BackEnd.Service;

import com.aspose.threed.Scene;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConvertService {
    private Scene scene;
    ClassPathResource resource = new ClassPathResource("input.ply");
    public void convert() throws IOException {
        //scene = Scene.fromFile("input.ply");
        System.out.println(resource.getPath());
        scene.open(resource.getPath());

        System.out.println(scene);
        scene.save("output.obj");
    }

}
