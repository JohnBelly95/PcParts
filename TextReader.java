//skeutomai na ftiaksoume 9 antikeimena kai meta me tis set na tous dinoume tis times tous mia mia alla dn kserw pws h klassh 8a gurnaei to antikeimeno molis fiaxtei
import java.io.*;
import java.util.*;

public class TextReader{

	private List<Stock> stockList;
	private List<Order> orderList;
	private List<Sell> soldList;
	static BufferedReader input;
	static PcParts product = null;
	String line;
	BufferReader reader = null;

	public void StockTextReader(List<Stock> stockList){
		try{
			line = reader.readLine();
			while (line !=null){
				if (!line.trim().equals(" ")) {
					if (line.trim().equals("STOCK_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								if (line != null){
									if (line.trim().equals("ITEM")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													if(line.trim().equals("TYPE:"){
														line = reader.readLine();
														if(line != null){
															if(line.trim().equals("RAM"){
																readRAM();
															}else if(line.trim().equals("CPU"){
																readCPU();
															}else if(line.trim().equals("GPU"){
																readGPU();
															}else if(line.trim().equals("HARDDRIVE"){
																readHARDDRIVE();
															}else if(line.trim().equals("MOTHERBOARD"){
																readMOTHERBOARD();
															}else if(line.trim().equals("KEYBOARD"){
																readRKEYBOARD();
															}else if(line.trim().equals("MOUSE"){
																readMOUSE();
															}else if(line.trim().equals("MONITOR"){
																readMONITOR();
															}else if(line.trim().equals("PRINTER"){
																readPRINTER();
															}
														}
													}//TYPE KLEINEI
												}
											}//{ KLEINEI
										}
									}//ITEM KLEINEI
								}
							}//{ KLEINEI
						}
					}//STOCK_LIST KLEINEI
				}
			}
		}
			
	}

	public void OrderTextReader(List<Order> orderList){
		/*try{
			elegxos an oi paraggelies perilamvanontai sta diathesima proionta
		}
		catch(){
			eidopoihsh
		}*/

		try{
			line = reader.readLine();
			while (line !=null){
				if (!line.trim().equals(" ")) {
					if (line.trim().equals("ORDER_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								if (line != null){
									if (line.trim().equals("ORDER")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												//anagnorisi metavlitwn
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void SoldTextReader(List<Sell> soldList){
		this.soldList = soldList;
		try{
			line = reader.readLine();
			while (line !=null){
				if (!line.trim().equals(" ")) {
					if (line.trim().equals("SOLD_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								if (line != null){
									if (line.trim().equals("SOLD")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													if(line.trim().equals("TYPE: "){
														line = reader.readLine();
														if(line != null){
															if(line.trim().substring(6).trim().equals("RAM"){
																product = new RAM();
																readRAM(3);
															}else if(line.trim().substring(6).trim().equals("CPU"){
																product = new CPU();
																readCPU(3);
															}else if(line.trim().substring(6).trim().equals("GPU"){
																product = new GPU();
																readGPU(3);
															}else if(line.trim().substring(6).trim().equals("HARDDRIVE"){
																product = new HardDrive();
																readHARDDRIVE(3);
															}else if(line.trim().substring(6).trim().equals("MOTHERBOARD"){
																product = new Motherboard();
																readMOTHERBOARD(3);
															}else if(line.trim().substring(6).trim().equals("KEYBOARD"){
																product = new Keyboard();
																readKEYBOARD(3);
															}else if(line.trim().substring(6).trim().equals("MOUSE"){
																product = new Mouse();
																readMOUSE(3);
															}else if(line.trim().substring(6).trim().equals("MONITOR"){
																product = new Screen();
																readMONITOR(3);
															}else if(line.trim().substring(6).trim().equals("PRINTER"){
																product =  new Printer();
																readPRINTER(3);
															}
														}
													}//TYPE KLEINEI
												}
											}//{ KLEINEI
										}
									}//ITEM KLEINEI
								}
							}//{ KLEINEI
						}
					}//STOCK_LIST KLEINEI
					if(line.trim().equals("}"){
						line = reader.readLine();
					}
				}
			}
		}
		catch(IOException e){
			System.err.println("An IOException was caught);
		}
		return
	}
	public void readITEM(){//ITEM
		if (!line.trim().equals("MODEL_NAME: ")) {
			line = reader.readLine();
			if(line != null){
				PcParts.setmodelName(line);
				line = reader.readLine();
				if(line != null){
					if (line.trim().equals("YEAR: ")) {
						line = reader.readInt();
						if(line != null){
							PcParts.setmodelYear(line);
							line = reader.readLine();
							if (line != null){
								if (line.trim().equals("MANUFACTURER: ")){
									line = reader.readLine();
									if (line != null){
										PcParts.setManufacturer(line)
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("PRICE: ")) {
												line = reader.readInt();
												if(line != null){
													PcParts.setPrice(line);

												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public void readRAM(num){ // RAM RAM RAM RAM RAM RAM RAM
		stk = new Stock(product);
		ord = new Order(product);
		sl = new Sell(product);
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((RAM)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((RAM)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((RAM)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: "){
					((RAM)product).setPrice(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("MODEL_TYPE: ")) {
					((RAM)product).setmodelType(line.substring(12).trim());
				}else if(line.trim().equals("SIZE: ")) {
					((RAM)product).setSize(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("SPEED: ")){
					((RAM)product).setSpeed(Integer.parseInt(line.substring(7).trim()));
				}else if(num == 1){
					stk.setsavailableStock(line.substring(8).trim());
				}else if(num == 2 && line.trim().equals("")){
					ord.setStatus(line.substring().trim());
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("")){
					ord.setPhone(Long.parseLong(line.substring().trim()));
				}else if(num == 2 && line.trim().equals("")){
					ord.setFP(Double.parseDouble(line.substring().trim()));
				}else if(num == 3 && line.trim().equals(""){
				}else if(num == 3 && line.trim().equals(""){
				}else if(num == 3 && line.trim().equals(""){
				
				}
			}
		}
	}
	public void readCPU(){// CPU CPU CPU
		readITEM();
		if (!line.trim().equals("SPEED: ")) {
			line = reader.readInt();
			if(line != null){
				CPU.setSpeed(line);
				line = reader.readLine();
				if(line != null){
					if (line.trim().equals("CORES: ")) {
						line = reader.readInt();
						if(line != null){
							CPU.setCoreCount(line);
						}
					}
				}
			}
		}
	}
	public void readGPU(){// G P U
		readITEM();
		if (!line.trim().equals("CHIPSET: ")) {
			line = reader.readLine();
			if(line != null){
				GPU.setChipset(line);
				line = reader.readLine();
				if(line != null){
					if (line.trim().equals("MEMORY: ")) {
						line = reader.readInt();
						if(line != null){
							GPU.setMemory(line);

						}
					}
				}
			}
		}
	}
	public void readHARDDRIVE(){  	// H   A    R   D    D   R   I   V   E
		readITEM();
		if (!line.trim().equals("TYPE: ")) {
			line = reader.readLine();
			if(line != null){
				Harddrive.setType(line);
				line = reader.readLine();
				if(line != null){
					if (line.trim().equals("WIDTH: ")){
						line = reader.readDouble();
						if(line != null){
							Harddrive.setWidth(line);
							line = reader.readLine();
							if (line != null){
								if (line.trim().equals("SIZE: ")){
									line = reader.readInt();
									if (line != null){
										Harddrive.setSize(line);
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public void readMOTHERBOARD(){                                //  M  O  T  H   E   R   B   O   A   R   D
		readITEM();
		if (!line.trim().equals("CHIP: ")) {
			line = reader.readLine();
			if(line != null){
				Motherboard.setChip(line);
				line = reader.readLine();
				if(line != null){
					if (line.trim().equals("SIZE: ")) {
						line = reader.readInt();
						if(line != null){
							Motherboard.setRAMSize(line)
							line = reader.readLine();
							if (line != null){
								if (line.trim().equals("GATES: ")){
									line = reader.readInt();
									if (line != null){
										Motherboard.setExpansionSlots(line);										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public void readMONITOR(){           //     M   O  N  I   T  O  R
		readITEM();
		if (!line.trim().equals("TYPE: ")) {   // EXW KANEI ENA LATHOS STHN SCREEN ANTI GIA TYPE TECHNOLOGY
			line = reader.readLine();
			if(line != null){
				Screen.setType(line);
				line = reader.readLine();
				if(line != null){
					if (line.trim().equals("SIZE: ")) {
						line = reader.readDouble();
						if(line != null){
							Screen.setSize(line);
							line = reader.readLine();
							if (line != null){
								if (line.trim().equals("PORTS: ")){
									line = reader.readLine();
									if (line != null){
										//setPORTS                      kollaw sto ports dn kserw pws to xeirizeste na to doume
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("RESOLUSION: ")){
												line = reader.readLine();
												if (line != null){
													Screen.setResolution(line);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public void readKEYBOARD(){                        //      K   E  Y   B   O   A   R   D
		readITEM();
		if (!line.trim().equals("CONNECTION: ")) {
			line = reader.readLine();
			if(line != null){
				Keyboard.setConnection(line);
			}
		}
	}
	public void readMOUSE(){                          //       M   O   U   S   E
		readITEM();
		if (!line.trim().equals("TECHNOLOGY: ")) {
			line = reader.readLine();
			if(line != null){
				Mouse.setTechnology(line);
				line = reader.readLine();
				if(line != null){
					if (line.trim().equals("CONNECTION: ")) {
						line = reader.readLine();
						if(line != null){
							Mouse.setConnection(line);
						}
					}
				}
			}
		}
	}
	public void readPRINTER(){                       //        P   R   I   N   T   E   R
		readITEM();
		if (!line.trim().equals("TECHNOLOGY: ")) {
			line = reader.readLine();
			if(line != null){
				Printer.setTechnology(line);
				line = reader.readLine();
				if(line != null){
					if (line.trim().equals("PRINTER_TYPE: ")) {
						line = reader.readLine();
						if(line != null){
							Printer.setPrintingType(line);
						}
					}
				}
			}
		}
	}
	
}
