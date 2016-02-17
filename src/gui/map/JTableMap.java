package gui.map;

import Abstracts.AbstractGameMap;
import Abstracts.AbstractGameObject;
import Objects.Coordinate;
import collection.MapCollection;
import Objects.Nothing;
import Objects.Wall;
import creator.MapCreator;
import enums.GameObjectType;
import enums.MapSource;
import interfaces.map.PaintMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class JTableMap implements PaintMap {

    private JTable table = new JTable();



    private AbstractGameMap gamemap;
    private String[] columnName;
    private AbstractGameObject[][] mapObjects;

    public JTableMap(MapSource type, Object source, MapCollection collection){

        table.setEnabled(false);
        table.setSize(400,400);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setTableHeader(null);
        table.setRowHeight(26);
        table.setRowSelectionAllowed(false);

        gamemap = MapCreator.getJmap().createMap(type,collection);
        gamemap.loadMap(source);
    }



    public void addMapObject(){
        mapObjects = new AbstractGameObject[gamemap.getHeight()][gamemap.getWight()];

        for (int y = 0; y < gamemap.getHeight() ; y++) {
            for (int x = 0; x < gamemap.getWight() ; x++) {
                mapObjects[y][x] = new Nothing(new Coordinate(x,y));
            }
        }

        for(AbstractGameObject gameObj:gamemap.getGameCollection().getGameObject().values()) {
            if (!gameObj.getType().equals(GameObjectType.NOTHING)) {
                int x = gameObj.getCoordinate().getX();
                int y = gameObj.getCoordinate().getY();
                if (!(mapObjects[y][x] instanceof Nothing) & !(mapObjects[y][x] instanceof Wall)) {
                    AbstractGameObject temp = mapObjects[y][x];
                    mapObjects[y][x] = gamemap.getObjectPriority(temp, gameObj);
                } else{
                    mapObjects[y][x] = gameObj;
                }
            }
        }

    }


    @Override
    public boolean paintMap() {
        addMapObject();

        columnName = new String[gamemap.getWight()];

        for (int i = 0; i < columnName.length ; i++) {
            columnName[i] = "";
        }

        table.setModel(new DefaultTableModel(mapObjects,columnName));
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
            TableColumn a = table.getColumnModel().getColumn(i);
            a.setPreferredWidth(26);
        }

        return true;
    }

    @Override
    public Component getMap() {
        return table;
    }

    @Override
    public AbstractGameMap getGameMap() {
        return gamemap;
    }
}
