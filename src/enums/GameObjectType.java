package enums;

import java.io.Serializable;

/**
 * Created by Admin on 25.01.2016.
 */
public enum GameObjectType implements Serializable {

    MONSTER(5),
    TREASURE(4),
    EXIT(3),
    HEROE(2),
    WALL(1),
    NOTHING(-1);

    GameObjectType(int priority) {
        this.priority = priority;
    }

    private int priority;

    public int getPriority() {
        return priority;
    }
}
