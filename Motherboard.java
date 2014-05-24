public class Motherboard extends Hardware{
    private String Chip;
    private int RAMSize, ExpansionSlots;
     
    public Motherboard(){
        super();
        Chip = "Intel";
        RAMSize = 64;
        ExpansionSlots = 6;
    }
    public Motherboard(String Chip, int RAMSize, int ExpansionSlots, String modelName, String Manufacturer, int modelYear, int Price){
        super(modelName, Manufacturer, modelYear, Price);
        this.Chip = Chip;
        this.RAMSize = RAMSize;
        this.ExpansionSlots = ExpansionSlots;
    }
    public String getChip(){
        return Chip;
    }
    public void setChip(String Chip){
        this.Chip = Chip;
    }
    public int getRAMSize(){
        return RAMSize;
    }
    public void setRAMSize(int RAMSize){
        this.RAMSize = RAMSize;
    }
    public int getExpansionSlots(){
        return ExpansionSlots;
    }
    public void setExpansionSlots(int ExpansionSlots){
        this.ExpansionSlots = ExpansionSlots;
    }
    public String toString(){
        return String.format("\n\t\tTYPE: MOTHERBOARD" + super.toString() + "\n\t\tCHIP: " + this.Chip  + "\n\t\tSIZE: " + this.RAMSize  + "\n\t\tGATES: " + this.ExpansionSlots );
    }
}

