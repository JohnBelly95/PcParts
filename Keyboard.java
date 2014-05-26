public class Keyboard extends Peripherals{
    private String Connection;
    public Keyboard(){
        super();
        Connection = "Wired" ;
    }
     
    public Keyboard(String Connection, String modelName, String Manufacturer, int modelYear, int Price){
        super(modelName, Manufacturer, modelYear, Price);
        this.Connection = Connection;
    }
     
    public String getConnection(){
        return Connection;
    }
     
    public void setConnection(String Connection){
        this.Connection = Connection;
    }
     
    public String toString(){
        return String.format("\n\t\tTYPE: KEYBOARD" + super.toString() + "\n\t\tCONNECTION: " + this.Connection );
    }
     
}

