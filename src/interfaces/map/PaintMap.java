package interfaces.map;

import Abstracts.AbstractGameMap;
import Abstracts.AbstractGameObject;

import java.awt.*;

/**
 * Created by Admin on 03.02.2016.
 */
public interface PaintMap {

    boolean paintMap();

    Component getMap();

    AbstractGameMap getGameMap();
}
