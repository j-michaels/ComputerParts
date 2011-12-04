package controllers;

import play.*;
import play.db.jpa.Model;
import play.mvc.*;
import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import flexjson.JSONSerializer;
import models.*;

public class Application extends Controller {
	public static enum Panel {
		CPU, GPU, RAM, HD, MB, PSU, BUILD
	}
	
	public static enum Comparer {
		EQUALS, GTR, LTN, GTRE, LTNE, SEQUALS
	}
	
    public static void index() {
    	List builds = Build.find("order by name desc").fetch();
        List gpus = GPU.find("order by name desc").fetch();
        List cpus = CPU.find("order by name desc").fetch();
        List mbs = Motherboard.find("order by name desc").fetch();
        List rams = RAM.find("order by name desc").fetch();
        List psus = PSU.find("order by name desc").fetch();
        List hds = HD.find("order by name desc").fetch();
        render(gpus, cpus, rams, psus, mbs, hds, builds);
    }
    
    public static void admin() {
    	List builds = Build.find("order by name desc").fetch();
        List gpus = GPU.find("order by name desc").fetch();
        List cpus = CPU.find("order by name desc").fetch();
        List mbs = Motherboard.find("order by name desc").fetch();
        List rams = RAM.find("order by name desc").fetch();
        List psus = PSU.find("order by name desc").fetch();
        List hds = HD.find("order by name desc").fetch();
        boolean admin = true;
        renderTemplate("Application/index.html", gpus, cpus, rams, mbs, psus, hds, builds, admin);
    }
    
    public static void createCPU(String name, String brand, int cores, double speed) {
    	CPU cpu = new CPU(name, brand, cores, speed);
    	renderJSON(cpu);
    }
    
    public static void infoPanel(String name, long id) {
    	//System.out.println("infoPanel");
    	String json = "";
    	JSONSerializer serializer = new JSONSerializer();
    	serializer.exclude("*.class", "id", "build", "entityId", "persistent");
    	Panel panelId = Panel.valueOf(name);
    	
    	switch (panelId) {
    	case CPU:
    		json = serializer.serialize(CPU.findById(id));
    		break;
    	case GPU:
    		json = serializer.serialize(GPU.findById(id));
    		break;
    	case RAM:
    		json = serializer.serialize(RAM.findById(id));
    		break;
    	case HD:
    		json = serializer.serialize(HD.findById(id));
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

    public static void currentBuild(long id) {
    	System.out.println("Looking at current build");
    	String json = "";
    	JSONSerializer serializer = new JSONSerializer();
    	serializer.exclude("*.class", "id", "entityId", "persistent");
    	Build build = Build.findById(id);
    	json = serializer.serialize(build);
    	renderJSON(json);
    }
    
    public static void delete(String part, long id) {
    	Panel panelId = Panel.valueOf(part);
    	System.out.println("Deleting item "+id+" from "+part);
    	switch (panelId) {
    	case CPU:
    		CPU cpu = CPU.findById(id);
    		cpu.delete();
    		renderJSON(cpu);
    		break;
    	case GPU:
    		GPU gpu = GPU.findById(id);
    		gpu.delete();
    		renderJSON(gpu);
    		break;
    	case RAM:
    		RAM ram = RAM.findById(id);
    		ram.delete();
    		renderJSON(ram);
    		break;
    	case HD:
    		HD hd = HD.findById(id);
    		hd.delete();
    		renderJSON(hd);
    		break;
    	case MB:
    		Motherboard mb = Motherboard.findById(id);
    		mb.delete();
    		renderJSON(mb);
    		break;
    	case PSU:
    		PSU psu = CPU.findById(id);
    		psu.delete();
    		renderJSON(psu);
    		break;
    	case BUILD:
    		Build build = Build.findById(id);
    		System.out.println(build.name+": "+build.id);
    		build.delete();
    		renderJSON(build);
    		break;
    	}
    }
    
    public static void create(String part, String name) {
    	System.out.println("Creating item '"+name+"' in "+part);
    	Panel panelId = Panel.valueOf(part);
    	switch (panelId) {
    	case CPU:
    		CPU cpu = new CPU(name, "foo", 1, 1);
    		cpu.save();
    		renderJSON(cpu);
    		break;
    	case GPU:
    		GPU gpu = new GPU(name);
    		gpu.save();
    		renderJSON(gpu);
    		break;
    	case RAM:
    		RAM ram = new RAM(name);
    		ram.save();
    		renderJSON(ram);
    		break;
    	case HD:
    		HD hd = new HD(name);
    		hd.save();
    		renderJSON(hd);
    		break;
    	case MB:
    		Motherboard mobo = new Motherboard(name);
    		mobo.save();
    		renderJSON(mobo);
    		break;
    	case PSU:
    		PSU psu = new PSU(name);
    		psu.save();
    		renderJSON(psu);
    		break;
    	case BUILD:
    		Build build = new Build(name);
    		build.save();
    		renderJSON(build);
    		break;
    	}
    }
    
    public static void changeBuild(String partName, long buildId, long partId) {
    	Build build = Build.findById(buildId);
    	System.out.println("Updating build '"+build.name+"' with "+partName+":"+partId);
    	Panel partKind = Panel.valueOf(partName);
    	switch (partKind) {
    	case CPU:
    		CPU cpu = CPU.findById(partId);
    		build.cpu = cpu;
    		break;
    	case GPU:
    		GPU gpu = GPU.findById(partId);
    		build.gpu = gpu;
    		break;
    	case RAM:
    		RAM ram = RAM.findById(partId);
    		build.ram = ram;
    		break;
    	case MB:
    		Motherboard mb = Motherboard.findById(partId);
    		build.mb = mb;
    		break;
    	case HD:
    		HD hd = HD.findById(partId);
    		build.hd = hd;
    		break;
    	case PSU:
    		PSU psu = PSU.findById(partId);
    		build.psu = psu;
    		break;
    	}
    	build.save();
    	renderJSON(build);
    }
    
    
    
    public static void changeFilter(String part, String something) {
    	//System.out.println(something);
    	ArrayList<String> endSqls = new ArrayList<String>();
    	HashMap<String, ArrayList<String>> hashsqls = new HashMap<String, ArrayList<String>>();
    	String[] predicates = something.split(",");
    	for (int i = 0; i<predicates.length; i++) {
    		String[] parts = predicates[i].split(":");
    		if (parts.length==3) {
    			ArrayList<String> sqls = hashsqls.get(parts[1]);
    			if (sqls == null) {
    				sqls = new ArrayList<String>();
    			}
    			Comparer comp = Comparer.valueOf(parts[0].toUpperCase());
    			switch (comp) {
    			case SEQUALS:
    				sqls.add(parts[1] + " like '" + parts[2]+"'");
    				break;
    			case EQUALS:
    				sqls.add(parts[1] + " = " + parts[2]);
    				break;
    			case GTR:
    				sqls.add(parts[1]+" > " + parts[2]);
    				break;
    			case LTN:
    				sqls.add(parts[1]+" < " + parts[2]);
    				break;
    			case GTRE:
    				sqls.add(parts[1]+ " >= " + parts[2]);
    				break;
    			case LTNE:
    				sqls.add(parts[1]+ " <= " + parts[2]);
    				break;
    			}
    			
    			hashsqls.put(parts[1], sqls);
    		}
    	}
    	Iterator<ArrayList<String>> itr = hashsqls.values().iterator();
    	while (itr.hasNext()) {
    		endSqls.add(StringUtils.join(itr.next().toArray(), " or "));
    	}
    	
    	String sqlStatement = "(" + StringUtils.join(endSqls.toArray(), ") and (") + ")";
    	if (sqlStatement.equals("()")) {
    		sqlStatement = "";
    	}
    	System.out.println(sqlStatement);
    	
    	List parts = HD.find(sqlStatement +" order by name desc").fetch();
    	/*Iterator<HD> it = hds.iterator();
    	while (it.hasNext()) {
    		HD hd = it.next();
    		System.out.println(hd.name);
    	}*/
    	
    	renderTemplate("Application/list.html", part, parts);
    }
}