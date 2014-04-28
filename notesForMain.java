public static Keyboard Keyboard(String modelName, String Manufacturer, int modelYear, int Price){
	System.out.println("What connection type is the customer ordering ?");
	Connection = input.nextLine();
	x1 = modelName;
	x2 = Manufacturer;
	z1 = modelYear;
	z2 = Price;
	Keyboard KB = new Keyboard (Connection, x1, x2, z1, z2);
	return KB;
}

public static Mouse Mouse (String modelName, String Manufacturer, int modelYear, int Price){
	System.out.println("What connection type is the customer ordering ?");
	Connection = input.nextLine();
	System.out.println("What mouse technology is the customer ordering ?");
	Technology = input.nextLine();
	x1 = modelName;
	x2 = Manufacturer;
	z1 = modelYear;
	z2 = Price;
	Mouse MS = new Mouse (Connection, Technology, x1, x2, z1, z2);
	return MS;
}

public static Printer Printer(String modelName, String Manufacturer, int modelYear, int Price){
	System.out.println("What printing type is the customer ordering ?");
	PrintingType = input.nextLine();
	System.out.println("What technology is the customer ordering ?");
	Technology = input.nextLine();
	x1 = modelName;
	x2 = Manufacturer;
	z1 = modelYear;
	z2 = Price;
	Printer PR = new Printer (PrintingType, Technology, x1, x2, z1, z2);
	return PR;
}

public static Screen Screen(String modelName, String Manufacturer, int modelYear, int Price){
	System.out.println("What screen type is the customer ordering ?");
	Type = input.nextLine();
	System.out.println("What size is the customer ordering ?");
	Size = input.nextDouble();
	System.out.println("What resolution is the customer ordering ?");
	Resolution = input.nextLine();
	System.out.println("How many HDMI ports is the customer ordering ?");
	HDMIport = input.nextInt();
	System.out.println("How many DVI ports is the customer ordering ?");
	DVIport = input.nextInt();
	System.out.println("How many Composite ports is the customer ordering ?");
	COMPOSITEport = input.nextInt();	
	x1 = modelName;
	x2 = Manufacturer;
	z1 = modelYear;
	z2 = Price;
	Screen SCR = new Screen (Type, Size, Resolution, HDMIport, DVIport, COMPOSITEport, x1, x2, z1, z2);
	return SCR;
}
