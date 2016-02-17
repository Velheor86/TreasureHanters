package interfaces.object;

import Objects.Coordinate;
import enums.GameObjectType;

import javax.swing.*;

/**
 * Created by Admin on 25.01.2016.
 */
public interface StaticObject {

    GameObjectType getType();

    ImageIcon getIcon();

    Coordinate getCoordinate();



}
