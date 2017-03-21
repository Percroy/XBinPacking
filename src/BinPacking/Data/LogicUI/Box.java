package BinPacking.Data.LogicUI;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

import java.util.Random;

/**
 * Created by Xsignati on 24.01.2017.
 */
public class Box extends Cuboid implements Comparable<Box>{
    /**
     * Box parameters
     */
    //Dimensions and size
    public final double ORIGINAL_LENGTH;
    public final double ORIGINAL_WIDTH;
    public final double ORIGINAL_HEIGHT;
    public static final int ROTATIONS_NUM = Box.Rotations.values().length;

    //Appearance
    private final PhongMaterial material = new PhongMaterial();
    private javafx.scene.shape.Box box;
    private final static double SHIFT_RATIO = 0.5;

    //Id and others
    private int weight;

    public Box(double length, double width, double height){
        this(length, width, height, new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat(), 1));
    }

    public Box(double length, double width, double height, Color color){
        super(0, 0, 0, length, width, height);
        //measurements
        this.ORIGINAL_LENGTH = length;
        this.ORIGINAL_WIDTH = width;
        this.ORIGINAL_HEIGHT = height;

        //appearance
        box = new javafx.scene.shape.Box(length, width, height);
        material.setDiffuseColor(color);
        material.setSpecularColor(Color.DARKGREY);
        box.setMaterial(material);
        getChildren().add(box);
    }

    public void scale(double scale){
        box.setWidth(getLength() * scale);
        box.setHeight(getWidth() * scale);
        box.setDepth(getHeight() * scale);
        box.setTranslateX(scale * (getX()  + SHIFT_RATIO * getLength()));
        box.setTranslateY(scale * (getY()  + SHIFT_RATIO * getWidth()));
        box.setTranslateZ(scale * (getZ()  + SHIFT_RATIO * getHeight()));
    }

    public void setBoxes(){
        box.setTranslateX(getX()  + SHIFT_RATIO * getLength());
        box.setTranslateY(getY()  + SHIFT_RATIO * getWidth());
        box.setTranslateZ(getZ()  + SHIFT_RATIO * getHeight());
    }

    @Override
    public int compareTo(Box o){
        return (int)(o.getVolume() - getVolume());
    }

    public enum Rotations {WLH, LHW, HLW, WHL, HWL, LWH }

    public void rotate(Rotations rotation) {
        switch (rotation) {
            case WLH:
                setSize(ORIGINAL_WIDTH, ORIGINAL_LENGTH, ORIGINAL_HEIGHT);
                break;
            case LHW:
                setSize(ORIGINAL_LENGTH, ORIGINAL_HEIGHT, ORIGINAL_WIDTH);
                break;
            case HLW:
                setSize(ORIGINAL_HEIGHT, ORIGINAL_LENGTH, ORIGINAL_WIDTH);
                break;
            case WHL:
                setSize(ORIGINAL_WIDTH, ORIGINAL_HEIGHT, ORIGINAL_LENGTH);
                break;
            case HWL:
                setSize(ORIGINAL_HEIGHT, ORIGINAL_WIDTH, ORIGINAL_LENGTH);
                break;
            case LWH:
                setSize(ORIGINAL_LENGTH, ORIGINAL_WIDTH, ORIGINAL_HEIGHT);
                break;
            default:
                setSize(ORIGINAL_LENGTH, ORIGINAL_WIDTH, ORIGINAL_HEIGHT);
                break;
        }
    }

    //Setters and getters

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length.get();
    }

    public SimpleDoubleProperty lengthProperty() {
        return length;
    }

    public void setLength(double length) {
        this.length.set(length);
    }

    public double getWidth() {
        return width.get();
    }

    public SimpleDoubleProperty widthProperty() {
        return width;
    }

    public void setWidth(double width) {
        this.width.set(width);
    }

    public double getHeight() {
        return height.get();
    }

    public SimpleDoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public double getX() {
        return x.get();
    }

    public SimpleDoubleProperty xProperty() {
        return x;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public SimpleDoubleProperty yProperty() {
        return y;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public double getZ() {
        return z.get();
    }

    public SimpleDoubleProperty zProperty() {
        return z;
    }

    public void setZ(double z) {
        this.z.set(z);
    }

    public double getVolume() {
        return volume;
    }
}