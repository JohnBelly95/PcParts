public class HardDrive extends Hardware{
    private String Type;
    private int Size;
    private double Width;
     
    public HardDrive(){
        super();
        Type = "HDD";
        Size = 1000;    //choritikotita (GB)
        Width= 3.5; //megethos (inches)
    }
    public HardDrive(String Type, int Size, double Width,  String modelName, String Manufacturer, int modelYear, int Price ){
        super(modelName, Manufacturer, modelYear, Price);
        this.Size = Size;
        this.Width=Width;
        this.Type = Type;
    }
    public String getType(){
        return Type;
    }
    public void setType(String Type){
        this.Type = Type;
    }
    public int getSize(){
        return Size;
    }
    public void setSize(int Size){
        this.Size = Size;
    }
    public double getWidth(){
        return Width;
    }
    public void setWidth(double Width){
        this.Width = Width;
    }
    public String toString(){
        return String.format("\n\t\tTYPE: HARDDRIVE" + super.toString() + "\n\t\tTYPE: " + this.Type + "\n\t\tWIDTH: " + this.Width  + "\n\t\tSIZE: " + this.Size );
    }
}

