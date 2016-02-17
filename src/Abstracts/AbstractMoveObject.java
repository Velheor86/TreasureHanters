package Abstracts;

import enums.GameObjectType;
import enums.MovingDirect;
import interfaces.object.MoveObject;

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



}

