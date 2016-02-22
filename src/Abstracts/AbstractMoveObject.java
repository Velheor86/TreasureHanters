package Abstracts;

import Objects.Coordinate;
import Objects.Heroe;
import Objects.Nothing;
import enums.GameObjectType;
import enums.MoveAction;
import enums.MovingDirect;
import interfaces.object.MoveObject;

import java.util.Random;

/**
 * Created by Admin on 26.01.2016.
 */
public abstract class AbstractMoveObject extends AbstractGameObject implements MoveObject {



    public void changeIcon(MovingDirect direct, GameObjectType type) {


        switch (direct) {
            case UP: {
                setIcon(getImageIcon("../res/" + type + "_up.png"));
                break;
            }
            case DOWN: {
                setIcon(getImageIcon("../res/" + type + "_down.png"));
                break;
            }
            case LEFT: {
                setIcon(getImageIcon("../res/" + type + "_left.png"));
                break;
            }
            case RIGHT: {
                setIcon(getImageIcon("../res/" + type + "_right.png"));
                break;
            }
        }
    }

    public MovingDirect randomDirect(){
        Random r = new Random();
        MovingDirect dir = null;
        switch (r.nextInt(4)){
            case 0:{
                dir = MovingDirect.UP;
                break;
            }
            case 1:{
                dir = MovingDirect.DOWN;
                break;
            }
            case 2:{
                dir = MovingDirect.LEFT;
                break;
            }
            case 3:{
                dir = MovingDirect.RIGHT;
                break;
            }
        }
        return dir;
    }

}

