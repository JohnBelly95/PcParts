
public class Screen extends Peripherals{
 
    private String Type, Resolution;
    private double Size;
    private int HDMIport, DVIport, COMPOSITEport;
    public Screen(){
        super();
        Type = " ";
        Size = 0;
        Resolution = " ";
        HDMIport = 0;
        DVIport = 0;
        COMPOSITEport = 0;
    }
    public Screen(String Type, double Size, String Resolution, int HDMIport, int DVIport, int COMPOSITEport, String modelName, String Manufacturer, int modelYear, int Price){
        super(modelName, Manufacturer, modelYear, Price);
        this.Type = Type;
        this.Size = Size;
        this.Resolution = Resolution;
        this.HDMIport = HDMIport;
        this.DVIport = DVIport;
        this.COMPOSITEport = COMPOSITEport;
    }
     
    public String getType(){
        return Type;
    }
    public void setType(String Type){
        this.Type = Type;
    }
     
    public double getSize(){
        return Size;
    }
    public void setSize(double Size){
        this.Size = Size;
    }
     
    public String getResolution(){
        return Resolution;
    }
    public void setResolution(String Resolution){
        this.Resolution = Resolution;
    }
     
    public int getHDMIport(){
        return HDMIport;
    }
    public void setHDMIport(int HDMIport){
        this.HDMIport = HDMIport;
    }
     
    public int getDVIport(){
        return DVIport;
    }
    public void setDVIport(int DVIport){
        this.DVIport = DVIport;
    }
     
    public int getCOMPOSITEport(){
        return COMPOSITEport;
    }
    public void setCOMPOSITEport(int COMPOSITEport){
        this.COMPOSITEport = COMPOSITEport;
    }
	

	public String Ports(){
		String str = null;
		if(COMPOSITEport > 0){
			str = str + "\n\t\tCOMPOSITE_PORTS :"+COMPOSITEport;
			
		}
		if(DVIport > 0){
			str = str+"\n\t\tDVI_PORTS :"+DVIport;
		}
		if(HDMIport > 0){
			str = str + "\n\t\tHDMI_PORTS :" + HDMIport;
		}
		return  str;
		//na checkaroume ti ektupwnei
	}
	
    public String toString(){
        return String.format("\n\t\tTYPE: MONITOR" +super.toString() + "\n\t\tTECHNOLOGY: " + this.Type  + "\n\t\tSIZE: " + this.Size  + "\n\t\tPORTS: " + Ports() + "\n\t\tRESOLUSION: " + this.Resolution);
    }
     
}