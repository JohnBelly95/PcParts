public class GPU extends Hardware{
    private String Chipset;
    private int Memory;
    public GPU(){
        super();
        Chipset = " ";
        Memory = 0;
    }
 
    public GPU(String Chipset, int Memory, String modelName, String Manufacturer, int modelYear, int Price ){
        super(modelName, Manufacturer, modelYear, Price );
        this.Chipset = Chipset;
        this.Memory = Memory;
    }
 
    public String getChipset(){
        return Chipset;
    }
    public void setChipset(String Chipset){
        this.Chipset = Chipset;
    }
 
    public int getMemory(){
        return Memory;
    }
    public void setMemory(int Memory){
        this.Memory = Memory;
    }
 
    public String toString(){
        return String.format("\n\t\tTYPE: GPU" +super.toString() + "\n\t\tCHIPSET: " + this.Chipset  + "\n\t\tMEMORY: " + this.Memory );
    }
}

