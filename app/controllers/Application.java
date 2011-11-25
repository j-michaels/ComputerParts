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
    
    public static void infoForGPU(long id) {
    	System.out.println("infoForGPU: "+id);
    	GPU gpu = GPU.findById(id);
    	
    	render(gpu);
    }
    
    public static void deletegpu(long id) {
    	System.out.println("Deleting "+id);
    	GPU gpu = GPU.findById(id);
    	gpu.delete();
    	/*for (long i =0; i<6;i++) {
    		GPU g = GPU.findById(i);
    		if (g == null) {
    			System.out.println("Missing: "+i);
    		} else {
    			System.out.println("GPU id: "+g.id + "; name: "+g.name);
    		}
    	}*/
    }
    
    public static void createGPU(String name) {
    	System.out.println("foobar");
    	GPU gpu = new GPU(name);
    	gpu.save();
    	renderJSON(gpu);
    }
    
}