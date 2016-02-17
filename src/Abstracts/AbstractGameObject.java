package Abstracts;

import Objects.Coordinate;
import enums.GameObjectType;
import interfaces.map.GameCollection;
import interfaces.object.StaticObject;

import javax.swing.*;

public abstract class AbstractGameObject implements StaticObject {

    private GameObjectType type;
    private Coordinate coordinate;
    private ImageIcon icon = getImageIcon("");


    public AbstractGameObject() {
    }


    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    protected ImageIcon getImageIcon(String path) {
        return new ImageIcon(getClass().getResource(path));
    }

    @Override
    public GameObjectType getType() {
        return type;
    }

    public void setType(GameObjectType type) {
        this.type = type;

    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractGameObject that = (AbstractGameObject) o;

        if (type != that.type) return false;
        return coordinate.equals(that.coordinate);

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + coordinate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AbstractGameObjct{" +
                "type=" + type +
                ", coordinate=" + coordinate +
                '}';
    }
}
