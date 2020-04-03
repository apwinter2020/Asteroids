package ir.sharif.math.ap98.asteroid.Util;

public class PanelConfig extends SwingConfig{
    private String bgImage;
    private int bgImageX, bgImageY, bgImageSpeedX, bgImageSpeedY, coefficient , timeCounter;
    public PanelConfig(String name){
        super(name);
        initialize();
    }

    protected void initialize() {
        super.initialize();
        bgImage = properties.getProperty("bgImage");
        bgImageX = properties.readInteger("bgImageX");
        bgImageY = properties.readInteger("bgImageX");
        bgImageSpeedX = properties.readInteger("bgImageX");
        bgImageSpeedY = properties.readInteger("bgImageX");
        coefficient = properties.readInteger("bgImageX");
        timeCounter = properties.readInteger("bgImageX");
    }

    @Override
    protected void setProperties() {

        this.properties = ConfigLoader.getInstance("default").getPanelProperties(name);
    }

    public int getTimeCounter() {
        return timeCounter;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getBgImageY() {
        return bgImageY;
    }

    public int getBgImageX() {
        return bgImageX;
    }

    public int getBgImageSpeedY() {
        return bgImageSpeedY;
    }

    public int getBgImageSpeedX() {
        return bgImageSpeedX;
    }

    public String getBgImage() {
        return bgImage;
    }
}
