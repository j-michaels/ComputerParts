var sections, current, lists, parts, selected;

function initialize()
{
	
    sections = new Array(5);
    current = new Array(5);
    lists = new Array(5);
    parts = new Array("CPU", "RAM", "GPU", "HD", "MB");
    selected = new Array(5);

    sections[0] = document.getElementById("cpu");
    sections[1] = document.getElementById("ram");
    sections[2] = document.getElementById("gpu");
    sections[3] = document.getElementById("hd");
    sections[4] = document.getElementById("mb");

    current[0] = document.getElementById("current_cpu");
    current[1] = document.getElementById("current_ram");
    current[2] = document.getElementById("current_gpu");
    current[3] = document.getElementById("current_hd");
    current[4] = document.getElementById("current_mb");
    
    lists[0] = document.getElementById("cpu_list");
    lists[1] = document.getElementById("ram_list");
    lists[2] = document.getElementById("gpu_list");
    lists[3] = document.getElementById("hd_list");
    lists[4] = document.getElementById("mb_list");
    
    for (var i = 0; i < 5; i++) {
        selected[i] = false;
    }
    
    showSection(0);
    
    resetList(0);
    resetList(1);
    resetList(2);
    resetList(3);
    resetList(4);
}

function showSection(s)
{
	
    for (var i = 0; i < sections.length; i++) {
    	if (sections[i] != null) {
        	sections[i].style.display = 'none';
        }
    }
	
	if (sections[s] != null) {
		sections[s].style.display = '';
	}
}

function updateList(u)
{
    var html = "<select size=\"7\" onchange=\"selectPart(" + u + ");\">";
    
    for (var i = 0; i < 4; i++) {
        html += "<option>" + parts[u] + " #" + (5+5*i) + "</option>";
    }
    
    html += "</select>";
    
    lists[u].innerHTML = html;
}

function resetList(r)
{
    var html = "<select size=\"7\" onchange=\"selectPart(" + r + ");\">"

    for (var i = 0; i < 20; i++) {
        html += "<option>" + parts[r] + " #" + i + "</option>";
    }
    
    html += "</select>";
	if (lists[r] != null) {
    	lists[r].innerHTML = html;
	}

    selected[r] = false;
    if (current[r] != null) {
    	current[r].innerHTML = "";
    }
    showAddButton();
}

function selectPart(s)
{
    selected[s] = true;
    current[s].innerHTML = parts[s] + " #X <br />";
    
    showAddButton();
}

function cheapest()
{
    for (var i = 0; i < selected.length; i++) {
        selected[i] = true;
    }
    
    document.getElementById("current_ram").innerHTML = "RAM #Y <br />";
    document.getElementById("current_cpu").innerHTML = "CPU #Y <br />";
    document.getElementById("current_gpu").innerHTML = "GPU #Y <br />";
    document.getElementById("current_hd").innerHTML  = "HD #Y <br />";
    document.getElementById("current_mb").innerHTML  = "MB #Y <br />";

    showAddButton();
}

function fastest()
{
    for (var i = 0; i < selected.length; i++) {
        selected[i] = true;
    }
    
    document.getElementById("current_ram").innerHTML = "RAM #Z <br />";
    document.getElementById("current_cpu").innerHTML = "CPU #Z <br />";
    document.getElementById("current_gpu").innerHTML = "GPU #Z <br />";
    document.getElementById("current_hd").innerHTML  = "HD #Z <br />";
    document.getElementById("current_mb").innerHTML  = "MB #Z <br />";

    showAddButton();
}

function showAddButton()
{
    var allSelected = true;
    
    for (var i = 0; i < selected.length; i++) {
        if (selected[i] == false) {
            allSelected = false;
        }
    }
    
    if (allSelected) {
        document.getElementById("add_section").style.display = '';
    } else {
        document.getElementById("add_section").style.display = 'none';
    }
}

function addToDB()
{
    document.getElementById("add_notification").innerHTML = "Current system added to Database! <strong>(redirect user to new page?)</strong>";
    
    document.getElementById("add_button").disabled = 'disabled';
}