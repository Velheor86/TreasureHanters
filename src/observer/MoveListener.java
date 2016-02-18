package observer;

import Objects.Heroe;
import enums.MoveAction;

/**
 * Created by Admin on 18.02.2016.
 */
public interface MoveListener {
    void notifyAction(MoveAction action, Heroe heroe);
}
