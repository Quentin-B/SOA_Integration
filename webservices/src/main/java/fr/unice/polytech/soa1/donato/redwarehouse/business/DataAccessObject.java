package fr.unice.polytech.soa1.donato.redwarehouse.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.Singleton;

@Singleton(name = "RedWarehouse-DB-Mock")
public class DataAccessObject {

	private List<Warehouse> warehouses = new ArrayList<>();
	public List<Warehouse> getWarehouses() { return warehouses; }
	public void setWarehouses(List<Warehouse> warehouses) { this.warehouses = warehouses; }
	
	private List<Box> box = new ArrayList<>();
	public List<Box> getBoxs() { return box; }
	public void setBoxs(List<Box> box) { this.box = box; }
	
	private List<Product> products = new ArrayList<>();;
	public List<Product> getProducts() { return products; }
	public void setProducts(List<Product> products) { this.products = products; }

	public List<Employee> employees = new ArrayList<>();;
	public List<Employee> getEmployees() { return employees; }
	public void setEmployees(List<Employee> employees) { this.employees = employees; }
	
	public List<Planning> plannings = new ArrayList<>();
	public List<Planning> getPlannings() { return plannings; }
	public void setPlannings(List<Planning> plannings) { this.plannings = plannings; }
	
	public Employee getEmployeeById (String id) {		
		for (Employee employee : employees) {
			if (employee.id.equalsIgnoreCase(id)) {
				return employee;
			}
		}
		return null;
	}
	
	public Planning findPlanningById (String id) {
		for (Planning planning : plannings) {
			if (planning.id.equalsIgnoreCase(id)) {
				return planning;
			}
		}
		return null;
	}
	
	public Warehouse findWarehouseById (String id) {
		for (Warehouse warehouse : warehouses) {
			if (warehouse.id.equalsIgnoreCase(id)) {
				return warehouse;
			}
		}
		return null;
	}
	
	public Product findProducByRef (String ref) {
		for (Product product : products) {
			if (product.reference.equalsIgnoreCase(ref)) {
				return product;
			}
		}
		return null;
	}
	
	public DataAccessObject() { init(); INSTANCE = this; }
	
	private static DataAccessObject INSTANCE = null;
	public static DataAccessObject getInstance() {
		return INSTANCE;
	}


	private void init() {

		// WareHouse
		Warehouse WH1 = new Warehouse("WH1", "P.O. Box 216, 6557 Integer St.", "0576JW", "Vaux-sur-Sure");
		Warehouse WH2 = new Warehouse("WH2", "P.O. Box 430, 7013 Commodo St.", "9239", "Norderstedt");
		Warehouse WH3 = new Warehouse("WH3", "8184 Erat Ave", "1624", "Sellano");
		Warehouse WH4 = new Warehouse("WH4", "Ap #545-5349 Aliquet Road", "98758", "Sargodha");
		Warehouse WH5 = new Warehouse("WH5", "352-4460 Nunc St.", "22714", "Valda");
		Warehouse WH6 = new Warehouse("WH6", "356-3090 Sociis St.", "47617", "Feldkirchen in K�rnten");
		Warehouse WH7 = new Warehouse("WH7", "Ap #569-158 Neque Rd.", "1089", "Henderson");
		Warehouse WH8 = new Warehouse("WH8", "Ap #188-948 Donec St.", "7442", "Bosa");
		Warehouse WH9 = new Warehouse("WH9", "719-9027 Dui Avenue", "843798", "Lossiemouth");
		Warehouse WH10 = new Warehouse("WH10", "4613 Ligula Rd.", "141693", "Armstrong");
		Warehouse WH11 = new Warehouse("WH11", "598-2533 Lorem Road", "652548", "Bayreuth");
		Warehouse WH12 = new Warehouse("WH12", "6752 Interdum. Rd.", "A1V 5V4", "Zelem");
		Warehouse WH13 = new Warehouse("WH13", "P.O. Box 606, 394 Sapien. St.", "48842", "Gambol�");
		Warehouse WH14 = new Warehouse("WH14", "P.O. Box 664, 8927 Ornare St.", "75336-112", "Courbevoie");
		Warehouse WH15 = new Warehouse("WH15", "670-9456 Duis St.", "6687", "Bhiwandi");
		Warehouse WH16 = new Warehouse("WH16", "735-158 Nec, Rd.", "5809", "Goes");
		Warehouse WH17 = new Warehouse("WH17", "584 Morbi Rd.", "49226", "Vergemoli");
		Warehouse WH18 = new Warehouse("WH18", "1978 Turpis. St.", "65650", "Erode");
		Warehouse WH19 = new Warehouse("WH19", "787-4846 Tellus. Street", "10802", "Waalwijk");
		Warehouse WH20 = new Warehouse("WH20", "P.O. Box 124, 1719 Nisl. St.", "62100", "Sassocorvaro");
		Warehouse WH21 = new Warehouse("WH21", "Ap #282-3041 Nunc Avenue", "HZ3O 3WF", "Lissewege");
		Warehouse WH22 = new Warehouse("WH22", "P.O. Box 346, 5202 Imperdiet Rd.", "4836WK", "Sousa");
		Warehouse WH23 = new Warehouse("WH23", "243-5372 Suspendisse St.", "125911", "Albury");
		Warehouse WH24 = new Warehouse("WH24", "P.O. Box 552, 4997 Est St.", "63475-577", "Neufeld an der Leitha");
		Warehouse WH25 = new Warehouse("WH25", "6209 Proin Rd.", "54250-238", "Oklahoma City");
		Warehouse WH26 = new Warehouse("WH26", "P.O. Box 805, 5245 Interdum Rd.", "5606", "Nothomb");
		Warehouse WH27 = new Warehouse("WH27", "P.O. Box 722, 7713 Nullam Road", "38166", "Ingelheim");
		Warehouse WH28 = new Warehouse("WH28", "Ap #971-4596 Ante. Rd.", "V9R 9E6", "Perth");
		Warehouse WH29 = new Warehouse("WH29", "Ap #356-7528 Lorem Road", "3229", "Cape Breton Island");
		Warehouse WH30 = new Warehouse("WH30", "3128 Fusce Rd.", "5761", "Mornimont");
		Warehouse WH31 = new Warehouse("WH31", "P.O. Box 750, 1693 Magnis Street", "Y8J 3H0", "Spormaggiore");
		Warehouse WH32 = new Warehouse("WH32", "902-8046 Mi. Rd.", "6311HL", "Dover");
		Warehouse WH33 = new Warehouse("WH33", "Ap #114-4633 Non, Rd.", "88942", "Westmalle");
		Warehouse WH34 = new Warehouse("WH34", "P.O. Box 739, 8905 Facilisis Av.", "88504", "Pastena");
		Warehouse WH35 = new Warehouse("WH35", "2083 Fringilla St.", "3686", "Amsterdam");
		Warehouse WH36 = new Warehouse("WH36", "Ap #808-8768 Adipiscing Street", "L5K 5B0", "Baltimore");
		Warehouse WH37 = new Warehouse("WH37", "Ap #973-9314 Magna. Rd.", "822597", "Fahler");
		Warehouse WH38 = new Warehouse("WH38", "733-1385 Felis Rd.", "88491", "Nandyal");
		Warehouse WH39 = new Warehouse("WH39", "5995 Quisque Av.", "22158", "Rhemes-Saint-Georges");
		Warehouse WH40 = new Warehouse("WH40", "753-4219 Euismod Rd.", "534499", "Cerreto di Spoleto");
		Warehouse WH41 = new Warehouse("WH41", "4260 Sed, Ave", "00606-086", "Frederick");
		Warehouse WH42 = new Warehouse("WH42", "Ap #385-5762 Quis St.", "11470", "Messancy");
		Warehouse WH43 = new Warehouse("WH43", "Ap #493-4257 Massa. Ave", "1340", "Varanasi");
		Warehouse WH44 = new Warehouse("WH44", "P.O. Box 275, 1955 Facilisis, Rd.", "562574", "Juneau");
		Warehouse WH45 = new Warehouse("WH45", "Ap #129-6003 Erat Ave", "25432", "Dorval");
		Warehouse WH46 = new Warehouse("WH46", "P.O. Box 966, 7049 Tempor, Road", "2598", "Ottawa");
		Warehouse WH47 = new Warehouse("WH47", "Ap #673-3020 Velit Street", "964151", "Gie?en");
		Warehouse WH48 = new Warehouse("WH48", "610-1532 Nunc Avenue", "01439", "Beaumont");
		Warehouse WH49 = new Warehouse("WH49", "Ap #632-1251 Duis St.", "77-671", "Sainte-Marie-sur-Semois");
		Warehouse WH50 = new Warehouse("WH50", "Ap #654-4904 Dapibus Road", "6104TX", "Attimis");
		Warehouse WH51 = new Warehouse("WH51", "4744 Duis St.", "70220", "Laon");
		Warehouse WH52 = new Warehouse("WH52", "P.O. Box 990, 8080 Euismod Street", "4774", "Neustrelitz");
		Warehouse WH53 = new Warehouse("WH53", "8729 Et Rd.", "0407", "Moricone");
		Warehouse WH54 = new Warehouse("WH54", "749-6328 Lorem. Avenue", "6389VY", "Rockville");
		Warehouse WH55 = new Warehouse("WH55", "339-9170 Porttitor Ave", "5752", "Grand-Rosi?re-Hottomont");
		Warehouse WH56 = new Warehouse("WH56", "1002 Nullam Rd.", "758391", "Sambuca Pistoiese");
		Warehouse WH57 = new Warehouse("WH57", "4781 Lacus. St.", "56902-240", "Helensburgh");
		Warehouse WH58 = new Warehouse("WH58", "Ap #651-5717 Mauris Av.", "L9 1UZ", "Affligem");
		Warehouse WH59 = new Warehouse("WH59", "558-2400 Lobortis Avenue", "374857", "Grande Prairie");
		Warehouse WH60 = new Warehouse("WH60", "Ap #639-2435 In St.", "R6R 5T7", "Tewkesbury");
		Warehouse WH61 = new Warehouse("WH61", "777-974 A Ave", "59393", "San Clemente");
		Warehouse WH62 = new Warehouse("WH62", "6627 Auctor Rd.", "44-962", "Neum?nster");
		Warehouse WH63 = new Warehouse("WH63", "533-4724 Rutrum Av.", "765668", "Glovertown");
		Warehouse WH64 = new Warehouse("WH64", "1034 Nec, Rd.", "41113", "Patan");
		Warehouse WH65 = new Warehouse("WH65", "7517 Blandit Rd.", "P0G 8W6", "Boise");
		Warehouse WH66 = new Warehouse("WH66", "P.O. Box 657, 8449 Sem. Road", "4005", "Melton Mowbray");
		Warehouse WH67 = new Warehouse("WH67", "Ap #155-5619 Iaculis Avenue", "1504", "Konin");
		Warehouse WH68 = new Warehouse("WH68", "2179 Congue Ave", "873816", "Couthuin");
		Warehouse WH69 = new Warehouse("WH69", "P.O. Box 923, 355 Sapien. St.", "N1A 0Z4", "Mobile");
		Warehouse WH70 = new Warehouse("WH70", "354-7085 Lacus. Av.", "12048", "Witney");
		Warehouse WH71 = new Warehouse("WH71", "Ap #272-5295 Ut, Ave", "60326-316", "Bijapur");
		Warehouse WH72 = new Warehouse("WH72", "P.O. Box 324, 8862 Massa. St.", "56028", "Bastogne");
		Warehouse WH73 = new Warehouse("WH73", "583-5846 Luctus Road", "93409", "Hatfield");
		Warehouse WH74 = new Warehouse("WH74", "P.O. Box 971, 7973 Consectetuer Avenue", "1288", "Burlington");
		Warehouse WH75 = new Warehouse("WH75", "Ap #239-1774 Sit Road", "3251", "Asso");
		Warehouse WH76 = new Warehouse("WH76", "2394 Purus Rd.", "25073", "Waardamme");
		Warehouse WH77 = new Warehouse("WH77", "6406 Quis, Av.", "25747", "Sainte-Marie-sur-Semois");
		Warehouse WH78 = new Warehouse("WH78", "8064 Eu Road", "70111", "Bayswater");
		Warehouse WH79 = new Warehouse("WH79", "P.O. Box 861, 2141 Rutrum, Av.", "5536", "Ashburton");
		Warehouse WH80 = new Warehouse("WH80", "309-4882 Metus. Rd.", "6168", "G?rouville");
		Warehouse WH81 = new Warehouse("WH81", "799-1019 Feugiat. Rd.", "39798", "Gonnosfanadiga");
		Warehouse WH82 = new Warehouse("WH82", "P.O. Box 433, 7541 A, Street", "36040", "Bras");
		Warehouse WH83 = new Warehouse("WH83", "Ap #369-6415 Tempor Rd.", "R9C 6G3", "Shillong");
		Warehouse WH84 = new Warehouse("WH84", "6715 Molestie Rd.", "401909", "Rochester");
		Warehouse WH85 = new Warehouse("WH85", "Ap #471-6634 Turpis Ave", "9803", "Portici");
		Warehouse WH86 = new Warehouse("WH86", "1681 Lorem, Street", "B2T 8EX", "Minervino di Lecce");
		Warehouse WH87 = new Warehouse("WH87", "Ap #202-414 Magnis Ave", "570578", "Kansas City");
		Warehouse WH88 = new Warehouse("WH88", "318-1771 Sagittis. St.", "2911", "San Rafael Abajo");
		Warehouse WH89 = new Warehouse("WH89", "6360 Et Ave", "X5P 4E7", "Buzenol");
		Warehouse WH90 = new Warehouse("WH90", "8570 Ullamcorper, Avenue", "11213", "Frankston");
		Warehouse WH91 = new Warehouse("WH91", "Ap #267-5278 Nulla. St.", "20189", "Wernigerode");
		Warehouse WH92 = new Warehouse("WH92", "Ap #458-4170 Montes, Street", "87030", "Zwevegem");
		Warehouse WH93 = new Warehouse("WH93", "Ap #733-4698 Dui, Road", "4386", "Lafayette");
		Warehouse WH94 = new Warehouse("WH94", "2779 Tellus Rd.", "15189", "Tsiigehtchic");
		Warehouse WH95 = new Warehouse("WH95", "644-6260 Vitae, St.", "9510OH", "Tulita");
		Warehouse WH96 = new Warehouse("WH96", "Ap #379-4068 Mauris Rd.", "35034", "Acciano");
		Warehouse WH97 = new Warehouse("WH97", "P.O. Box 255, 9420 Sollicitudin Road", "9722", "Tampa");
		Warehouse WH98 = new Warehouse("WH98", "P.O. Box 134, 7371 Magnis St.", "1654", "Bossuit");
		Warehouse WH99 = new Warehouse("WH99", "5169 Mus. Avenue", "130507", "Columbia");
		Warehouse WH100 = new Warehouse("WH100", "Ap #765-7781 Lacus. Ave", "11118", "Kanchipuram");
		warehouses.add(WH1);
		warehouses.add(WH2);
		warehouses.add(WH3);
		warehouses.add(WH4);
		warehouses.add(WH5);
		warehouses.add(WH6);
		warehouses.add(WH7);
		warehouses.add(WH8);
		warehouses.add(WH9);
		warehouses.add(WH10);
		warehouses.add(WH11);
		warehouses.add(WH12);
		warehouses.add(WH13);
		warehouses.add(WH14);
		warehouses.add(WH15);
		warehouses.add(WH16);
		warehouses.add(WH17);
		warehouses.add(WH18);
		warehouses.add(WH19);
		warehouses.add(WH20);
		warehouses.add(WH21);
		warehouses.add(WH22);
		warehouses.add(WH23);
		warehouses.add(WH24);
		warehouses.add(WH25);
		warehouses.add(WH26);
		warehouses.add(WH27);
		warehouses.add(WH28);
		warehouses.add(WH29);
		warehouses.add(WH30);
		warehouses.add(WH31);
		warehouses.add(WH32);
		warehouses.add(WH33);
		warehouses.add(WH34);
		warehouses.add(WH35);
		warehouses.add(WH36);
		warehouses.add(WH37);
		warehouses.add(WH38);
		warehouses.add(WH39);
		warehouses.add(WH40);
		warehouses.add(WH41);
		warehouses.add(WH42);
		warehouses.add(WH43);
		warehouses.add(WH44);
		warehouses.add(WH45);
		warehouses.add(WH46);
		warehouses.add(WH47);
		warehouses.add(WH48);
		warehouses.add(WH49);
		warehouses.add(WH50);
		warehouses.add(WH51);
		warehouses.add(WH52);
		warehouses.add(WH53);
		warehouses.add(WH54);
		warehouses.add(WH55);
		warehouses.add(WH56);
		warehouses.add(WH57);
		warehouses.add(WH58);
		warehouses.add(WH59);
		warehouses.add(WH60);
		warehouses.add(WH61);
		warehouses.add(WH62);
		warehouses.add(WH63);
		warehouses.add(WH64);
		warehouses.add(WH65);
		warehouses.add(WH66);
		warehouses.add(WH67);
		warehouses.add(WH68);
		warehouses.add(WH69);
		warehouses.add(WH70);
		warehouses.add(WH71);
		warehouses.add(WH72);
		warehouses.add(WH73);
		warehouses.add(WH74);
		warehouses.add(WH75);
		warehouses.add(WH76);
		warehouses.add(WH77);
		warehouses.add(WH78);
		warehouses.add(WH79);
		warehouses.add(WH80);
		warehouses.add(WH81);
		warehouses.add(WH82);
		warehouses.add(WH83);
		warehouses.add(WH84);
		warehouses.add(WH85);
		warehouses.add(WH86);
		warehouses.add(WH87);
		warehouses.add(WH88);
		warehouses.add(WH89);
		warehouses.add(WH90);
		warehouses.add(WH91);
		warehouses.add(WH92);
		warehouses.add(WH93);
		warehouses.add(WH94);
		warehouses.add(WH95);
		warehouses.add(WH96);
		warehouses.add(WH97);
		warehouses.add(WH98);
		warehouses.add(WH99);
		warehouses.add(WH100);
		
		// employees
		Employee EP1 = new Employee("EP1", "Lesley", "Bond");
		Employee EP2 = new Employee("EP2", "Cameron", "Abbott");
		Employee EP3 = new Employee("EP3", "Daquan", "Mcintosh");
		Employee EP4 = new Employee("EP4", "Barclay", "Castillo");
		Employee EP5 = new Employee("EP5", "Sopoline", "Compton");
		Employee EP6 = new Employee("EP6", "Lacy", "Gardner");
		Employee EP7 = new Employee("EP7", "Bree", "Colon");
		Employee EP8 = new Employee("EP8", "Belle", "Wells");
		Employee EP9 = new Employee("EP9", "Cullen", "Cruz");
		Employee EP10 = new Employee("EP10", "Len", "Neal");
		Employee EP11 = new Employee("EP11", "Patricia", "Craft");
		Employee EP12 = new Employee("EP12", "Susan", "Crawford");
		Employee EP13 = new Employee("EP13", "Igor", "Douglas");
		Employee EP14 = new Employee("EP14", "Carter", "Jones");
		Employee EP15 = new Employee("EP15", "Patience", "Wolfe");
		Employee EP16 = new Employee("EP16", "Hilda", "Richards");
		Employee EP17 = new Employee("EP17", "Danielle", "Holden");
		Employee EP18 = new Employee("EP18", "Kaye", "Saunders");
		Employee EP19 = new Employee("EP19", "Tasha", "Joyce");
		Employee EP20 = new Employee("EP20", "Kibo", "Sosa");
		Employee EP21 = new Employee("EP21", "Urielle", "Howard");
		Employee EP22 = new Employee("EP22", "Doris", "Gallagher");
		Employee EP23 = new Employee("EP23", "Samantha", "Brooks");
		Employee EP24 = new Employee("EP24", "Guinevere", "Hurley");
		Employee EP25 = new Employee("EP25", "Karyn", "Moore");
		Employee EP26 = new Employee("EP26", "Justin", "Aguilar");
		Employee EP27 = new Employee("EP27", "Zelda", "Dennis");
		Employee EP28 = new Employee("EP28", "Veda", "Jimenez");
		Employee EP29 = new Employee("EP29", "Fletcher", "Duke");
		Employee EP30 = new Employee("EP30", "Lawrence", "Walker");
		Employee EP31 = new Employee("EP31", "Jared", "Mullins");
		Employee EP32 = new Employee("EP32", "Callie", "Tillman");
		Employee EP33 = new Employee("EP33", "Lacota", "Guzman");
		Employee EP34 = new Employee("EP34", "Neville", "Miranda");
		Employee EP35 = new Employee("EP35", "Fletcher", "Marshall");
		Employee EP36 = new Employee("EP36", "Lois", "Fleming");
		Employee EP37 = new Employee("EP37", "Vaughan", "Greer");
		Employee EP38 = new Employee("EP38", "August", "Beasley");
		Employee EP39 = new Employee("EP39", "Cally", "Pittman");
		Employee EP40 = new Employee("EP40", "Jarrod", "Tyler");
		Employee EP41 = new Employee("EP41", "Leslie", "Holder");
		Employee EP42 = new Employee("EP42", "Laura", "Andrews");
		Employee EP43 = new Employee("EP43", "Tobias", "Conley");
		Employee EP44 = new Employee("EP44", "Benedict", "Luna");
		Employee EP45 = new Employee("EP45", "Buckminster", "Fitzpatrick");
		Employee EP46 = new Employee("EP46", "Ivy", "Nichols");
		Employee EP47 = new Employee("EP47", "Victoria", "Duke");
		Employee EP48 = new Employee("EP48", "Sonia", "Osborn");
		Employee EP49 = new Employee("EP49", "Lacy", "Stanley");
		Employee EP50 = new Employee("EP50", "Oliver", "Hebert");
		Employee EP51 = new Employee("EP51", "Daniel", "Jefferson");
		Employee EP52 = new Employee("EP52", "Holly", "Wall");
		Employee EP53 = new Employee("EP53", "Joshua", "Hanson");
		Employee EP54 = new Employee("EP54", "Chadwick", "Pope");
		Employee EP55 = new Employee("EP55", "Winter", "Gaines");
		Employee EP56 = new Employee("EP56", "Michelle", "Bernard");
		Employee EP57 = new Employee("EP57", "Kristen", "Cleveland");
		Employee EP58 = new Employee("EP58", "Alexis", "Schultz");
		Employee EP59 = new Employee("EP59", "Charlotte", "Wooten");
		Employee EP60 = new Employee("EP60", "Zahir", "Graham");
		Employee EP61 = new Employee("EP61", "Hayes", "Blackburn");
		Employee EP62 = new Employee("EP62", "Quon", "Macdonald");
		Employee EP63 = new Employee("EP63", "Gretchen", "Sandoval");
		Employee EP64 = new Employee("EP64", "Erin", "May");
		Employee EP65 = new Employee("EP65", "Blossom", "Riggs");
		Employee EP66 = new Employee("EP66", "Basil", "Pitts");
		Employee EP67 = new Employee("EP67", "Jamal", "Lee");
		Employee EP68 = new Employee("EP68", "Serina", "Bentley");
		Employee EP69 = new Employee("EP69", "Luke", "Lane");
		Employee EP70 = new Employee("EP70", "Nasim", "Terry");
		Employee EP71 = new Employee("EP71", "Gemma", "Mcpherson");
		Employee EP72 = new Employee("EP72", "Vance", "Chandler");
		Employee EP73 = new Employee("EP73", "Cameran", "Carey");
		Employee EP74 = new Employee("EP74", "Forrest", "Greene");
		Employee EP75 = new Employee("EP75", "Cailin", "Alford");
		Employee EP76 = new Employee("EP76", "Quentin", "Manning");
		Employee EP77 = new Employee("EP77", "Tara", "Wright");
		Employee EP78 = new Employee("EP78", "Laura", "Guerrero");
		Employee EP79 = new Employee("EP79", "Jael", "Burgess");
		Employee EP80 = new Employee("EP80", "Stacy", "Davenport");
		Employee EP81 = new Employee("EP81", "Dustin", "Hunt");
		Employee EP82 = new Employee("EP82", "Ishmael", "Cox");
		Employee EP83 = new Employee("EP83", "Galena", "Mccarty");
		Employee EP84 = new Employee("EP84", "Keiko", "Watts");
		Employee EP85 = new Employee("EP85", "Wesley", "Mendez");
		Employee EP86 = new Employee("EP86", "Marcia", "Hartman");
		Employee EP87 = new Employee("EP87", "Orli", "Snider");
		Employee EP88 = new Employee("EP88", "Barbara", "Chase");
		Employee EP89 = new Employee("EP89", "David", "Fitzgerald");
		Employee EP90 = new Employee("EP90", "Chandler", "Barrera");
		Employee EP91 = new Employee("EP91", "Keith", "Bauer");
		Employee EP92 = new Employee("EP92", "Darius", "Hines");
		Employee EP93 = new Employee("EP93", "Demetrius", "Sloan");
		Employee EP94 = new Employee("EP94", "Amena", "Hawkins");
		Employee EP95 = new Employee("EP95", "Xenos", "Nielsen");
		Employee EP96 = new Employee("EP96", "Liberty", "Hyde");
		Employee EP97 = new Employee("EP97", "Carl", "Burns");
		Employee EP98 = new Employee("EP98", "Ella", "Clayton");
		Employee EP99 = new Employee("EP99", "Irma", "Casey");
		Employee EP100 = new Employee("EP100", "Ina", "Harrington");
		
		employees.add(EP1);
		employees.add(EP2);
		employees.add(EP3);
		employees.add(EP4);
		employees.add(EP5);
		employees.add(EP6);
		employees.add(EP7);
		employees.add(EP8);
		employees.add(EP9);
		employees.add(EP10);
		employees.add(EP11);
		employees.add(EP12);
		employees.add(EP13);
		employees.add(EP14);
		employees.add(EP15);
		employees.add(EP16);
		employees.add(EP17);
		employees.add(EP18);
		employees.add(EP19);
		employees.add(EP20);
		employees.add(EP21);
		employees.add(EP22);
		employees.add(EP23);
		employees.add(EP24);
		employees.add(EP25);
		employees.add(EP26);
		employees.add(EP27);
		employees.add(EP28);
		employees.add(EP29);
		employees.add(EP30);
		employees.add(EP31);
		employees.add(EP32);
		employees.add(EP33);
		employees.add(EP34);
		employees.add(EP35);
		employees.add(EP36);
		employees.add(EP37);
		employees.add(EP38);
		employees.add(EP39);
		employees.add(EP40);
		employees.add(EP41);
		employees.add(EP42);
		employees.add(EP43);
		employees.add(EP44);
		employees.add(EP45);
		employees.add(EP46);
		employees.add(EP47);
		employees.add(EP48);
		employees.add(EP49);
		employees.add(EP50);
		employees.add(EP51);
		employees.add(EP52);
		employees.add(EP53);
		employees.add(EP54);
		employees.add(EP55);
		employees.add(EP56);
		employees.add(EP57);
		employees.add(EP58);
		employees.add(EP59);
		employees.add(EP60);
		employees.add(EP61);
		employees.add(EP62);
		employees.add(EP63);
		employees.add(EP64);
		employees.add(EP65);
		employees.add(EP66);
		employees.add(EP67);
		employees.add(EP68);
		employees.add(EP69);
		employees.add(EP70);
		employees.add(EP71);
		employees.add(EP72);
		employees.add(EP73);
		employees.add(EP74);
		employees.add(EP75);
		employees.add(EP76);
		employees.add(EP77);
		employees.add(EP78);
		employees.add(EP79);
		employees.add(EP80);
		employees.add(EP81);
		employees.add(EP82);
		employees.add(EP83);
		employees.add(EP84);
		employees.add(EP85);
		employees.add(EP86);
		employees.add(EP87);
		employees.add(EP88);
		employees.add(EP89);
		employees.add(EP90);
		employees.add(EP91);
		employees.add(EP92);
		employees.add(EP93);
		employees.add(EP94);
		employees.add(EP95);
		employees.add(EP96);
		employees.add(EP97);
		employees.add(EP98);
		employees.add(EP99);
		employees.add(EP100);
		
		for (Warehouse warehouse : warehouses) {
			warehouse.employees = new HashSet<>(employees);
		}
		
		createProduct("F9T7FN4TG33WC5F", "0", "5", "3", "74", "43", "22", "86");
		createProduct("W3P3NV5OZ24BD1K", "0", "2", "4", "61", "11", "92", "42");
		createProduct("H5J4CP8ZY18SO6R", "1", "5", "5", "2", "2", "73", "4");
		createProduct("X9M7UD2NL47SB2W", "3", "1", "3", "79", "24", "96", "60");
		createProduct("H4O1ZU7DU23ZR9V", "3", "10", "4", "79", "18", "5", "15");
		createProduct("B4Z7QN1IB81OT5J", "0", "7", "1", "83", "56", "88", "48");
		createProduct("T1M7UW4AQ18KM6V", "2", "9", "1", "91", "16", "2", "19");
		createProduct("P3L5YD5GB59LN5G", "1", "1", "3", "60", "64", "30", "1");
		createProduct("E5T2VO1WB17UG7V", "2", "8", "4", "22", "48", "84", "8");
		createProduct("L5C1TR4OO94MD2D", "2", "1", "3", "82", "71", "35", "93");
		createProduct("I8D7TY9PU73UO6G", "3", "3", "2", "11", "32", "47", "24");
		createProduct("D7I1ZY8PZ28HZ5G", "3", "7", "4", "71", "18", "72", "70");
		createProduct("E6Y2OB1DQ45VQ7E", "2", "8", "2", "5", "47", "85", "96");
		createProduct("H9X5TL5LW53HI2M", "3", "10", "4", "60", "13", "17", "17");
		createProduct("M9H5AP9UB56GZ6U", "3", "6", "4", "56", "8", "2", "18");
		createProduct("U3E9BQ8AJ88KI2Y", "3", "6", "1", "68", "59", "16", "52");
		createProduct("V8X6ID5OY52GU8A", "3", "5", "3", "62", "20", "46", "22");
		createProduct("O5T2PR6JM18QK2T", "2", "6", "4", "71", "59", "76", "67");
		createProduct("J2Q4CM4PA37CR9H", "0", "5", "4", "21", "62", "43", "65");
		createProduct("L8G4YY1BK75TU4D", "1", "7", "1", "53", "84", "9", "92");
		createProduct("G2C7RA6HE49OM3R", "0", "3", "1", "53", "97", "95", "73");
		createProduct("N5X2ZA1TS18VO6K", "2", "10", "3", "38", "72", "12", "89");
		createProduct("K5C4EB9FL61TQ6F", "2", "9", "3", "37", "31", "11", "74");
		createProduct("C1B5KG5DU77ZL1X", "3", "8", "2", "52", "74", "70", "85");
		createProduct("Z3T3RB4JK56TV1R", "3", "6", "2", "13", "3", "36", "4");
		createProduct("A5D1IU3CK74MO6P", "0", "8", "3", "6", "4", "28", "6");
		createProduct("X9A6MS3GH48JQ7K", "2", "5", "1", "11", "37", "37", "57");
		createProduct("F3J7HK8OO47RH1B", "0", "6", "1", "12", "92", "73", "48");
		createProduct("N6S2KX8CT13UJ3C", "2", "6", "5", "15", "46", "20", "96");
		createProduct("A3R2TE7IL62ZP3D", "2", "9", "4", "2", "62", "30", "83");
		createProduct("A4N5TM4IR82VN7V", "0", "4", "4", "32", "59", "24", "85");
		createProduct("O1A8PZ4RQ73GS3X", "3", "8", "4", "79", "99", "41", "51");
		createProduct("G2T7BE4YL83ID4A", "3", "9", "5", "73", "20", "28", "11");
		createProduct("M6Q9HR9ZQ92PU5H", "2", "4", "2", "43", "78", "84", "58");
		createProduct("C1Q5IS4MA96TD1Y", "0", "5", "4", "65", "68", "18", "11");
		createProduct("T4X6EQ1KH49SI3T", "2", "2", "4", "70", "22", "99", "42");
		createProduct("S9H3BG1CE46MS8Z", "2", "10", "4", "15", "47", "65", "65");
		createProduct("R4D5RV8BQ31KB6K", "2", "7", "1", "88", "75", "75", "49");
		createProduct("N6N3PJ3KF67BX9X", "0", "9", "5", "70", "59", "99", "16");
		createProduct("D1F1IF6EL47FN1B", "1", "5", "4", "40", "7", "80", "99");
		createProduct("F1F1SX8UI43CZ4L", "3", "10", "2", "48", "10", "17", "16");
		createProduct("X3R4AA5TG41DK9C", "1", "4", "4", "48", "29", "90", "32");
		createProduct("B2U2YZ4SF33HY2A", "0", "7", "3", "78", "93", "54", "8");
		createProduct("F6U6RJ1NS12GB4Z", "0", "10", "1", "23", "93", "89", "87");
		createProduct("R6A3ET8OY12ZW4H", "3", "4", "1", "75", "16", "26", "1");
		createProduct("U7R7OK2TT98KO2I", "0", "7", "2", "63", "75", "90", "65");
		createProduct("V1E8SQ1EU76LK3W", "3", "3", "1", "65", "27", "56", "15");
		createProduct("J3V9FM4CU49ME6C", "1", "2", "5", "60", "87", "39", "66");
		createProduct("N4H9WJ2JQ73DJ6M", "1", "9", "3", "38", "77", "18", "51");
		createProduct("I3A9AO2ZB61TT3P", "0", "2", "5", "59", "15", "49", "47");
		createProduct("F2B4SN4LV12ZG2A", "1", "5", "2", "50", "30", "52", "2");
		createProduct("T8C5HR4VN56EQ7K", "1", "5", "2", "67", "78", "39", "11");
		createProduct("W4T1YL5QS96LV8H", "2", "1", "3", "13", "4", "40", "32");
		createProduct("L7S4PZ1KW94CQ8W", "1", "9", "1", "57", "14", "60", "90");
		createProduct("F7N9HT8KX79KY5W", "1", "7", "4", "7", "65", "91", "77");
		createProduct("C7F8OX4QD65GI3J", "3", "2", "5", "85", "99", "17", "76");
		createProduct("P6A2XZ4XE15HQ1Y", "1", "5", "3", "17", "73", "42", "14");
		createProduct("Z2P8AV3EV72GH7W", "2", "2", "3", "64", "94", "2", "36");
		createProduct("L6E1AZ2EY66GC4Z", "3", "9", "2", "58", "73", "28", "42");
		createProduct("F4H3BF2TE61NJ1X", "1", "4", "1", "39", "17", "97", "45");
		createProduct("X7F3TM3HI32SE1T", "3", "10", "2", "56", "100", "70", "33");
		createProduct("G4S4AI2QR32WZ3H", "3", "1", "4", "97", "56", "56", "38");
		createProduct("D4X9PY9PT46YZ1I", "0", "4", "5", "52", "25", "11", "58");
		createProduct("P1O8TE1TX98MN6P", "0", "4", "4", "24", "85", "40", "90");
		createProduct("N1R5FE9TV84XP3B", "1", "9", "5", "59", "92", "53", "69");
		createProduct("G6Q8RR6XH82MU5C", "1", "7", "4", "40", "28", "69", "62");
		createProduct("D3P3ML2UH24MF7F", "3", "1", "2", "39", "93", "39", "48");
		createProduct("P5B4ZK7BU47UI2Y", "1", "1", "3", "100", "68", "48", "18");
		createProduct("F7H7OS8LN17CX2K", "1", "4", "5", "95", "65", "99", "26");
		createProduct("Q6Q5DZ3BC15CZ9O", "2", "4", "3", "92", "35", "7", "43");
		createProduct("F6N3JE8RA13UZ4W", "2", "1", "1", "84", "34", "49", "4");
		createProduct("O7P9QD8EU56UN6E", "0", "8", "2", "96", "50", "58", "67");
		createProduct("L2Q3WM1ZH24FM1M", "3", "5", "2", "84", "91", "66", "89");
		createProduct("F3T2ZS2DX89MQ9Z", "0", "8", "2", "75", "18", "34", "87");
		createProduct("D8U4TH1YH83KO7W", "2", "6", "2", "5", "66", "83", "83");
		createProduct("H7W7EB8ZI95JA7T", "2", "8", "2", "58", "95", "52", "70");
		createProduct("A7V2QG6WY98KX7N", "1", "4", "4", "14", "68", "96", "87");
		createProduct("Z6L7XQ7CR16RO5J", "3", "7", "2", "23", "11", "25", "35");
		createProduct("S4G2XK6TQ81MJ6C", "2", "5", "1", "73", "79", "98", "35");
		createProduct("A8U7BM5RA91DO3H", "0", "7", "2", "81", "69", "14", "100");
		createProduct("S1H3FJ2AZ51YI6Q", "1", "10", "4", "8", "85", "79", "14");
		createProduct("P9F7WU4LJ15QQ7N", "1", "9", "4", "32", "2", "75", "93");
		createProduct("S7Z8RH1ZK19UI1N", "0", "2", "5", "88", "11", "63", "100");
		createProduct("V3V5ME4KI19CP5Y", "3", "3", "1", "47", "25", "93", "58");
		createProduct("S7G1JG4PM15PC7W", "3", "6", "5", "98", "40", "54", "39");
		createProduct("O5X5UA5EZ13FM7M", "2", "10", "4", "23", "20", "43", "64");
		createProduct("E8F8MX6AF41UM6L", "1", "7", "4", "20", "61", "7", "30");
		createProduct("V9S2TT9OU44IP8E", "3", "3", "2", "21", "96", "84", "7");
		createProduct("O8C6QB9AY36MW5S", "0", "8", "4", "87", "37", "47", "93");
		createProduct("K1T2UO4EF88JX5L", "1", "1", "5", "10", "56", "4", "59");
		createProduct("F4N6LD7QW44ZK9E", "2", "6", "2", "59", "16", "11", "95");
		createProduct("J8T5ED1UV21CB5L", "0", "8", "5", "17", "40", "14", "32");
		createProduct("A6H3WF8IG83AO4V", "0", "8", "4", "69", "85", "19", "96");
		createProduct("X8K8RN7SC25HL3G", "3", "3", "2", "80", "61", "66", "33");
		createProduct("G8F2ZW4JN68SO6X", "0", "10", "4", "91", "59", "83", "22");
		createProduct("L6Y2TH2NG56KX2C", "1", "9", "1", "84", "49", "80", "55");
		createProduct("V1W1RY1YL53BU4N", "3", "1", "1", "61", "95", "23", "60");
		createProduct("Q7S8OA5KF81JB8E", "0", "9", "5", "22", "27", "35", "9");
		createProduct("S6X2PX2TA81DR9K", "3", "1", "2", "90", "10", "19", "24");
		createProduct("D8I3JU7PV11EQ1U", "1", "9", "3", "11", "31", "80", "64");
		
		createPlanning("1316387260", "delivery", "15", "15", "Q2P4ZW8FJ21NG1Q", "22", "82", "47", "34");
		createPlanning("4695671566", "delivery", "15", "00", "H8C7JA1OE73NU4P", "9", "11", "32", "30");
		createPlanning("6828765938", "pickup", "8", "30", "N4E4MT9ZV46FD3S", "42", "72", "87", "38");
		createPlanning("9736601553", "pickup", "11", "30", "D4K4UB7FJ34DB9Z", "68", "21", "5", "48");
		createPlanning("9008727099", "pickup", "16", "45", "J9G5FR8UC16WU2Q", "13", "88", "90", "38");
		createPlanning("6389693407", "pickup", "14", "00", "T3O7II9UP74GT5X", "69", "9", "98", "16");
		createPlanning("8021571331", "pickup", "12", "30", "O2U1CQ5WQ96EI4I", "23", "46", "50", "8");
		createPlanning("6424730133", "delivery", "14", "30", "H7S2VS2VS36JW7H", "83", "71", "91", "33");
		createPlanning("4237732723", "pickup", "15", "15", "G1N2ZL2JG82HA7U", "30", "8", "72", "19");
		createPlanning("4339427917", "pickup", "12", "30", "K2O6UM1EV77EL8J", "72", "16", "37", "11");
		createPlanning("9744950056", "pickup", "15", "45", "M2Y5HL7TK13XN6M", "49", "60", "56", "28");
		createPlanning("7032344449", "pickup", "13", "15", "I6W3VZ7WD41RE8V", "89", "37", "1", "49");
		createPlanning("3154412402", "pickup", "14", "15", "C4L8OI2NB39ZG5A", "86", "77", "9", "27");
		createPlanning("7650781211", "delivery", "16", "30", "C5Y1ZJ1GU24QQ2O", "87", "76", "90", "27");
		createPlanning("3824419973", "delivery", "16", "30", "P1B9EQ8GT86KP3U", "41", "7", "59", "4");
		createPlanning("8000509310", "pickup", "9", "00", "V4O1LC9HR21ZZ3E", "80", "33", "55", "26");
		createPlanning("9551415594", "delivery", "8", "15", "V7U3AJ5TH51RH2W", "59", "65", "90", "8");
		createPlanning("8020408651", "pickup", "15", "15", "S5Y5LP5WZ97OP5W", "46", "27", "57", "40");
		createPlanning("2927344192", "pickup", "17", "15", "S2J6NO9ZR53BF4M", "19", "60", "71", "42");
		createPlanning("4485033317", "delivery", "13", "30", "X5G3VX4ZX13WR6S", "17", "73", "90", "12");
		createPlanning("1402625871", "delivery", "14", "45", "A2A2BP7ZA13TB9F", "85", "71", "88", "24");
		createPlanning("9549445604", "pickup", "13", "00", "N1U4RC6CX25PE9A", "15", "27", "19", "38");
		createPlanning("1291479563", "pickup", "17", "30", "Q9G2PV1NW49MJ1J", "83", "28", "96", "6");
		createPlanning("7544906543", "delivery", "10", "30", "F9J8BH8NH13PZ7U", "40", "54", "45", "22");
		createPlanning("3557584291", "pickup", "8", "45", "P4V9BE9BJ36AW7T", "94", "29", "13", "28");
		createPlanning("9119272695", "pickup", "11", "45", "U7E9AT2MW96GZ5W", "29", "71", "65", "8");
		createPlanning("8457127530", "delivery", "15", "00", "C3Z3PF5ZF53WF6S", "53", "13", "28", "6");
		createPlanning("9802462568", "pickup", "16", "00", "Q3D4UQ7MT66CB9G", "86", "31", "71", "22");
		createPlanning("1748542925", "pickup", "9", "15", "G2K4ZY6KF73BF1Q", "38", "37", "51", "38");
		createPlanning("4447671702", "pickup", "13", "15", "Z7W9NS1FI15BK4A", "57", "8", "63", "16");
		createPlanning("6509464279", "delivery", "13", "45", "Q7Y8MJ5VB75ZZ9Q", "83", "81", "56", "17");
		createPlanning("4410183276", "pickup", "12", "30", "S6B5LB8AY16UE3W", "48", "44", "13", "36");
		createPlanning("4146754249", "delivery", "13", "15", "E3O2MD2LS71HN5S", "8", "23", "92", "14");
		createPlanning("3675907524", "delivery", "14", "30", "F9Y7SV5QF38RL4J", "46", "70", "75", "49");
		createPlanning("6561110035", "pickup", "15", "45", "A8U6LS4ZL47DC1X", "34", "24", "41", "6");
		createPlanning("7603139035", "pickup", "10", "30", "J2C4EH2ES54SR8M", "21", "84", "85", "47");
		createPlanning("1765277701", "delivery", "9", "15", "V7F8XN3OG88LH4T", "75", "28", "26", "8");
		createPlanning("5771996582", "delivery", "16", "30", "N5Y7KB7VJ42WR2A", "12", "34", "95", "48");
		createPlanning("4681990243", "delivery", "16", "30", "J2P1FP8ZQ38UT1S", "41", "66", "5", "38");
		createPlanning("3393529253", "delivery", "13", "30", "N3Y2AH5SJ82FC3O", "57", "56", "70", "37");
		createPlanning("9197368945", "delivery", "9", "00", "C2I4XS3LN28XI8H", "64", "78", "20", "44");
		createPlanning("4093588456", "delivery", "15", "45", "E8J3ME9RR88QO5E", "67", "33", "36", "14");
		createPlanning("2347369151", "delivery", "9", "15", "Q5V4NT9UG16PG6M", "44", "93", "7", "2");
		createPlanning("8521807173", "delivery", "11", "00", "J8C5AB6HE68KK4F", "17", "37", "67", "36");
		createPlanning("9906494895", "delivery", "17", "00", "X2B6LP6CV67LP8N", "68", "7", "94", "40");
		createPlanning("3160066278", "delivery", "11", "15", "I2U4BG2LU47SL3G", "5", "35", "57", "4");
		createPlanning("8279141750", "pickup", "10", "30", "A7X5MK6LR75PD5H", "76", "77", "34", "39");
		createPlanning("7839421345", "pickup", "16", "00", "D4A9RT6PR42WI4J", "87", "27", "19", "32");
		createPlanning("2683753033", "pickup", "14", "30", "O7F4KQ5AC88XL9T", "13", "25", "81", "36");
		createPlanning("2926044655", "pickup", "8", "15", "F1T8FN2PP49IL9V", "77", "58", "17", "50");
		createPlanning("4265056019", "delivery", "14", "15", "T4S1PD3NE82GT2O", "2", "25", "97", "3");
		createPlanning("3144477441", "pickup", "9", "30", "M5P5HL3OV75KJ2T", "16", "28", "26", "25");
		createPlanning("1891026024", "delivery", "14", "45", "O6Z5OE4OF71OF2E", "1", "29", "4", "40");
		createPlanning("7470373042", "pickup", "10", "45", "Q9R1CF9JX45GP7M", "15", "47", "76", "22");
		createPlanning("5521204436", "delivery", "11", "00", "Q1Z6TA5IT57JC4E", "12", "23", "72", "12");
		createPlanning("1167190405", "pickup", "13", "00", "G5W7JO9VY19NS7D", "36", "59", "35", "24");
		createPlanning("2385155434", "pickup", "10", "15", "A9R1OF2YN52KB7W", "29", "11", "95", "2");
		createPlanning("4870164994", "pickup", "11", "30", "P7U2AO8HR16NP7D", "17", "3", "69", "12");
		createPlanning("6625724062", "pickup", "14", "00", "X9K9VT4YH18KS5K", "54", "34", "72", "18");
		createPlanning("4616764552", "delivery", "13", "30", "H7Q3BN9UX27ZH3H", "55", "62", "99", "26");
		createPlanning("6954448054", "delivery", "12", "00", "C8S1BR7XQ87EG5K", "29", "91", "90", "10");
		createPlanning("7425591094", "delivery", "8", "15", "L9V9NJ2PB86PB1G", "29", "83", "18", "28");
		createPlanning("6938635529", "delivery", "12", "15", "M5U3PE7UJ39NW2A", "38", "83", "27", "19");
		createPlanning("6467539512", "delivery", "15", "15", "C4Z6MF7SF27NN9M", "34", "86", "54", "33");
		createPlanning("5427085971", "pickup", "13", "30", "Z5N4WA4TW85CC9M", "36", "2", "58", "46");
		createPlanning("3602748104", "pickup", "10", "45", "K9I3RQ6JU73NU1N", "54", "30", "35", "50");
		createPlanning("4169286767", "delivery", "8", "00", "J9M2YU6TW83HF5G", "36", "99", "61", "41");
		createPlanning("3328876367", "delivery", "17", "15", "O8P6ZI5LP29ID4F", "29", "25", "26", "6");
		createPlanning("8091126566", "pickup", "8", "15", "G9Z3NO7BZ22IC9K", "33", "32", "18", "49");
		createPlanning("1903881950", "pickup", "12", "00", "U3W4TK3EJ27XA3E", "73", "15", "34", "28");
		createPlanning("1447262433", "delivery", "14", "00", "V8O8SW9UQ62DI9I", "78", "8", "26", "28");
		createPlanning("2642121930", "pickup", "10", "00", "U3V1TS8BS14WT8G", "35", "25", "10", "32");
		createPlanning("9535870620", "pickup", "10", "45", "V1Y7NU5OY45JQ5Q", "58", "49", "2", "1");
		createPlanning("7116885004", "pickup", "10", "30", "M3W8UC9UR94GW3P", "66", "91", "92", "26");
		createPlanning("1638451841", "pickup", "10", "30", "C5F3EE3VT56KU8B", "76", "49", "94", "31");
		createPlanning("8174247957", "delivery", "13", "00", "T3G7ZU1SM98SB7R", "44", "35", "87", "7");
		createPlanning("9314156712", "delivery", "11", "45", "X2Y6QE1WV11LW8J", "48", "44", "42", "19");
		createPlanning("5346984038", "delivery", "12", "15", "U8E1RT3PK71AF2H", "94", "98", "76", "2");
		createPlanning("7051916876", "pickup", "16", "45", "L5T2OH4OJ17JY9S", "51", "53", "98", "36");
		createPlanning("3612479327", "pickup", "10", "45", "R3C4XC7VN65EQ6V", "53", "15", "29", "34");
		createPlanning("4455328214", "delivery", "8", "15", "M7I2GU2VY28EP9X", "19", "3", "75", "23");
		createPlanning("7205460269", "delivery", "9", "15", "T4D7SZ8SN74PJ4D", "79", "96", "57", "28");
		createPlanning("8592792449", "pickup", "15", "30", "N9R2KX5AN65LT3W", "9", "82", "33", "6");
		createPlanning("4200060683", "pickup", "15", "00", "A9Y6IA9IP63JO7A", "58", "11", "63", "10");
		createPlanning("5282337945", "delivery", "11", "00", "S7F1VR3KV23AJ7L", "80", "95", "44", "24");
		createPlanning("2783116531", "delivery", "17", "15", "K9H9GR6TR22WB8U", "28", "71", "80", "1");
		createPlanning("1782525612", "pickup", "17", "00", "E2Q6OY5GR48BY8D", "78", "72", "21", "29");
		createPlanning("2925032978", "delivery", "17", "30", "A1W7OR1UX29HF6V", "60", "26", "66", "18");
		createPlanning("4997043003", "pickup", "14", "15", "E5Q5ZH5HJ52WA9L", "56", "62", "31", "4");
		createPlanning("3815756276", "pickup", "10", "15", "M2U7TY1BN33IN3Z", "82", "28", "96", "30");
		createPlanning("4161801186", "delivery", "16", "45", "L7J6WB6SY37YN7T", "41", "73", "29", "35");
		createPlanning("8133899569", "pickup", "9", "15", "E2Q7CL4IP78EH6P", "36", "20", "13", "49");
		createPlanning("4858564792", "pickup", "12", "45", "H8O4EE6VW41RI9K", "15", "95", "85", "1");
		createPlanning("3980529344", "delivery", "9", "00", "K9Z5BX7AP27FJ2P", "15", "49", "30", "11");
		createPlanning("2188091297", "delivery", "9", "30", "I4P1IZ1FJ99HY4N", "70", "82", "91", "44");
		createPlanning("2938292000", "delivery", "11", "15", "H9Y2NH1HB79LJ5O", "89", "78", "40", "16");
		createPlanning("4162829502", "pickup", "13", "30", "Y3E6FH9BJ27AU7P", "87", "2", "49", "12");
		createPlanning("4098875580", "pickup", "10", "45", "Z2Q7HN2XQ39LC1R", "58", "7", "69", "27");
		createPlanning("2825740066", "delivery", "11", "30", "J6A2MV2LN25TZ4U", "89", "28", "12", "29");
		createPlanning("9535291466", "pickup", "13", "30", "M3V1NS5ZL31MH5U", "68", "41", "35", "20");
		
		
		// assign plannings to one employee
		EP24.plannings.add(this.plannings.get(6));
		EP24.plannings.add(this.plannings.get(45));
		
		Command command = new Command();
		command.setQuantity(30);
		command.setProduct(this.products.get(34));
		command.setPlanning(this.plannings.get(6));
		this.plannings.get(6).commands.add(command);
		command.setProduct(this.products.get(67));
		command.setPlanning(this.plannings.get(34));
		this.plannings.get(34).commands.add(command);
		command.setProduct(this.products.get(34));
		command.setPlanning(this.plannings.get(49));
		this.plannings.get(49).commands.add(command);
		command.setProduct(this.products.get(67));
		command.setPlanning(this.plannings.get(67));
		this.plannings.get(67).commands.add(command);
	}
	
	private void createProduct(String pRef, String floorStr, String corridor, String rack, String quantityStr, String widthStr, String heightStr, String depthStr) {
		int floor = Integer.valueOf(floorStr);
		int quantity = Integer.valueOf(quantityStr);
		int width = Integer.valueOf(widthStr);
		int height = Integer.valueOf(heightStr);
		int depth = Integer.valueOf(depthStr);
		
		// search box
		Box box = null;
		for (Box boxTmp : this.box) {
			if (boxTmp.floor == floor
					&& boxTmp.corridor.equalsIgnoreCase(corridor)
					&& boxTmp.rackNumber.equalsIgnoreCase(rack)) {
				box = boxTmp;
				break;
			}
		}
		if (box == null) {
			box = new Box(floor, corridor, rack);
			this.box.add(box);
			
			for(Warehouse warehouse : this.warehouses) {
				warehouse.box.add(box);
			}
		}
		
		// create product
		Product product = new Product(pRef, width, height, depth, quantity, box);
		products.add(product);
		box.products.add(product);
	}
	
	private void createPlanning(String eventId, String kind, String hour, String minutes, String productId, String widthStr, String heightStr, String depthStr, String quantityStr) {
		int quantity = Integer.valueOf(quantityStr);
		int width = Integer.valueOf(widthStr);
		int height = Integer.valueOf(heightStr);
		int depth = Integer.valueOf(depthStr);
		
		// search product
		Product product = null;
		for (Product productTmp : this.products) {
			if (productTmp.reference.equalsIgnoreCase(productId)) {
				product = productTmp;
			}
		}
		if (product == null) {
			product = new Product(productId, width, height, depth, quantity);
			//products.add(product);
		}
		
		// create planning
		Planning planning = new Planning();
		planning.id = eventId;
		
		Command command = new Command();
		command.setQuantity(30);
		command.setProduct(product);
		command.setPlanning(planning);
		planning.commands.add(command);
		
		for (Event event : Event.values()) {
			if (event.name.toUpperCase().contains(kind.toUpperCase())) {
				planning.status = event;
				break;
			}
		}
		try {
			planning.setDate(new SimpleDateFormat("hh:mm").parse(hour + ":" + minutes));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.plannings.add(planning);
		
		for(Warehouse warehouse : this.warehouses) {
			warehouse.plannings.add(planning);
		}
	}
}
