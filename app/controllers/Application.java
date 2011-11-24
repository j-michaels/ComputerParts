package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List builds = Build.find("order by name desc").fetch();
        List gpus = GPU.find("order by name desc").fetch();
        List cpus = CPU.find("order by name desc").fetch();
        List mobos = Motherboard.find("order by name desc").fetch();
        render(gpus, cpus, mobos, builds);
    }
    
    public static void admin() {
    	List builds = Build.find("order by name desc").fetch();
        List gpus = GPU.find("order by name desc").fetch();
        List cpus = CPU.find("order by name desc").fetch();
        List mobos = Motherboard.find("order by name desc").fetch();
        render(gpus, cpus, mobos, builds);
    }
    
    public static void createCPU(String name, String brand, int cores, double speed) {
    	CPU cpu = new CPU(name, brand, cores, speed);
    	renderJSON(cpu);
    }
    
    public static void createGPU(String name) {
    	GPU gpu = new GPU(name);
    	gpu.save();
    	System.out.println("Test");
    	renderJSON(gpu);
    }
    
}