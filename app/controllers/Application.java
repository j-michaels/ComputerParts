package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        List gpus = GPU.find("order by name desc").fetch();
        render(gpus);
    }
    
    public static void createGPU(String name) {
    	GPU gpu = new GPU(name);
    	gpu.save();
    	System.out.println("Test");
    	renderJSON(gpu);
    }

}