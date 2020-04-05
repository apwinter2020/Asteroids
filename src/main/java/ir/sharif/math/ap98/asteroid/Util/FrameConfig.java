package main.java.ir.sharif.math.ap98.asteroid.Util;

public class FrameConfig  extends SwingConfig {
    private int closeOperation;
    private boolean resizable, undecorated;

    public FrameConfig(String name){
        super(name);

        initialize();
    }
    protected void initialize() {
        super.initialize();
        closeOperation = properties.readInteger("CloseOperation");
        resizable = properties.readBoolean("Resizable");
        undecorated = properties.readBoolean("undecorated");
    }

    public boolean isResizable() {
        return resizable;
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
