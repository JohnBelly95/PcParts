//skeutomai na ftiaksoume 9 antikeimena kai meta me tis set na tous dinoume tis times tous mia mia alla dn kserw pws h klassh 8a gurnaei to antikeimeno molis fiaxtei
import java.io.*;
import java.util.*;

public class TextReader{

	private List<Stock> stockList;
	private List<Order> orderList;
	private List<Sell> soldList;
	static BufferedReader input;

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
		catch(IOException e){
			System.err.println("An IOException was caught);
		}
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
	public void readRAM(){//RAM RAM RAM RAM RAM RAM RAM RAM RAM
		readITEM();
		if (!line.trim().equals("MODEL_TYPE: ")) {
			line = reader.readLine();
			if(line != null){
				RAM.setType(line);
				line = reader.readLine();
				if(line != null){
					if (line.trim().equals("SIZE: ")) {
						line = reader.readInt();
						if(line != null){
							RAM.setSize(line);
							line = reader.readLine();
							if (line != null){
								if (line.trim().equals("SPEED: ")){
									line = reader.readInt();
									if (line != null){
										RAM.setSpeed(line);

										
									}
								}
							}
						}
					}
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
