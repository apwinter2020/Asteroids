package main.java.Util;

public class FrameConfig  extends SwingConfig{
    private int closeOperation;
    private boolean resizaable , undecorated;

    public FrameConfig(String name){
        super(name);

        initialize();
    }
    protected void initialize() {
        super.initialize();
        closeOperation = properties.readInteger("CloseOperation");
        resizaable = properties.readBoolean("Resizable");
        undecorated = properties.readBoolean("undecorated");
    }

    public boolean isResizaable() {
        return resizaable;
    }

    public boolean isUndecorated() {
        return undecorated;
    }

    public int getCloseOperation() {
        return closeOperation;
    }


    @Override
    protected void setProperties() {
        this.properties = ConfigLoader.getInstance().getFrameProperties(name);
    }
}
