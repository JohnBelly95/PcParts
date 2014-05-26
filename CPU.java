public class CPU extends Hardware{
    private double Speed;
    private int CoreCount;
    public CPU(){
        super();
        Speed = 2.9;
        CoreCount = 2;
    }
    public CPU(double Speed, int CoreCount, String modelName, String Manufacturer, int modelYear, int Price){
        super(modelName, Manufacturer, modelYear, Price);
        this.Speed = Speed;
        this.CoreCount = CoreCount;
    }
    public double getSpeed(){
        return Speed;
    }
    public void setSpeed(double Speed){
        this.Speed = Speed;
    }
    public int getCoreCount(){
        return CoreCount;
    }
    public void setCoreCount(int CoreCount){
        this.CoreCount = CoreCount;
    }
    public String toString(){
        return String.format("\n\t\tTYPE: CPU" +super.toString() + "\n\t\tSPEED: " + this.Speed  + "\n\t\tCORES: " + this.CoreCount );
    }
}

