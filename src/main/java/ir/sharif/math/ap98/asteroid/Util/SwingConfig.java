package ir.sharif.math.ap98.asteroid.Util;

public abstract class SwingConfig {

    protected Configs properties;
    protected String name;

    private int width, height;

    public SwingConfig(String name) {
        this.name = name;
        setProperties();

    }

    protected void initialize() {
        width = properties.readInteger("width");
        height = properties.readInteger("height");
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    protected abstract void setProperties();

}
