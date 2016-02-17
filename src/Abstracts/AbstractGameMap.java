package Abstracts;

import interfaces.map.GameCollection;
import interfaces.map.GameMap;

import java.io.Serializable;

/**
 * Created by Admin on 02.02.2016.
 */
public abstract class AbstractGameMap implements GameMap, Serializable {

    private static final long serialVersionUID = 1L;

    public AbstractGameMap(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }

    private GameCollection gameCollection;
    private String Name;
    private int Height;
    private int Wight;
    private int Limit;
    private boolean isExit;
    private boolean isHeroe;

    public GameCollection getGameCollection() {
        return gameCollection;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    @Override
    public int getWight() {
        return Wight;
    }

    public void setWight(int wight) {
        Wight = wight;
    }

    @Override
    public int getLimit() {
        return Limit;
    }

    public void setLimit(int limit) {
        Limit = limit;
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean exit) {
        isExit = exit;
    }

    public boolean isHeroe() {
        return isHeroe;
    }

    public void setHeroe(boolean heroe) {
        isHeroe = heroe;
    }


    public AbstractGameObject getObjectPriority(AbstractGameObject a, AbstractGameObject b) {
        return (a.getType().getPriority() > b.getType().getPriority()) ? a : b;
    }

    public boolean isValidMap() {
        return isExit && isHeroe;
    }
}
