package controllers;

import play.*;
import play.db.jpa.Model;
import play.mvc.*;
import java.util.*;

import flexjson.JSONSerializer;
import models.*;
/*
enum Panel {
	CPU, GPU, RAM, HD, MB, PSU
}*/

public class Application extends Controller {
	public static enum Panel {
		CPU, GPU, RAM, HD, MB, PSU
	}
	
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
        renderTemplate("Application.html", gpus, cpus, mobos, builds);
    }
    
    public static void createCPU(String name, String brand, int cores, double speed) {
    	CPU cpu = new CPU(name, brand, cores, speed);
    	renderJSON(cpu);
    }
    
    public static void testAction() {
    	System.out.println("test");
    	GPU gpu = GPU.findById((long)2);
    	renderJSON(gpu);
    }
    
    public static void infoPanel(String name, long id) {
    	System.out.println("infoPanel");
    	String json = "";
    	JSONSerializer serializer = new JSONSerializer();
    	serializer.exclude("*.class", "id", "build", "entityId", "persistent", "requires");
    	Panel panelId = Panel.valueOf(name);
    	
    	switch (panelId) {
    	case CPU:
    		json = serializer.serialize(CPU.findById(id));
    		break;
    	case GPU:
    		json = serializer.serialize(GPU.findById(id));
    		System.out.println("GPU details requested.");
    		break;
    	case RAM:
    		json = serializer.serialize(RAM.findById(id));
    		break;
    	case HD:
    		json = serializer.serialize(HDD.findById(id));
    		break;
    	case MB:
    		json = serializer.serialize(Motherboard.findById(id));
    		break;
    	case PSU:
    		json = serializer.serialize(PSU.findById(id));
    		break;
    	}
    	renderJSON(json);
    }
    
    public static void infoForCPU(long id) {
    	System.out.println("infoForCPU: "+id);
    	CPU cpu = CPU.findById(id);
    	
    	render(cpu);
    }
    
    public static void infoForRAM(long id) {
    	System.out.println("infoForRAM: "+id);
    	RAM ram = RAM.findById(id);
    	
    	render(ram);
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