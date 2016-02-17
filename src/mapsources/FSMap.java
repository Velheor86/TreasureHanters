package mapsources;

import Abstracts.AbstractGameMap;
import Objects.Coordinate;
import Abstracts.AbstractGameObject;
import creator.GameObjectCreator;
import enums.GameObjectType;
import interfaces.map.GameCollection;

import java.io.*;


public class FSMap extends AbstractGameMap {

    public FSMap(GameCollection gameCollection) {
        super(gameCollection);
    }

    @Override
    public boolean loadMap(Object source){
        File file = new File(source.toString());

        if (!file.exists()) throw new IllegalArgumentException("Файл не существует");
        try {
            setExit(false);
            setHeroe(false);
            setHeight(getLineCount(file));


            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine().trim();

            setName(line.split(",")[0]);
            setLimit(Integer.valueOf(line.split(",")[1]).intValue());
            setWight(Integer.valueOf(line.split(",")[2]).intValue());

            int x ;
            int y = 0;

            while ((line = br.readLine()) != null){
                x = 0;
                for(String str : line.split(",")){
                    createGameObject(str, new Coordinate(x,y));
                    x++;
                }
                y++;
            }

            if(!isValidMap()) {
                throw new Exception("нет элементов");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    private void createGameObject(String str, Coordinate coordinate) {

        GameObjectType type = GameObjectType.valueOf(str.toUpperCase());
        AbstractGameObject newObject = GameObjectCreator.getInst().createObject(type,coordinate);
        getGameCollection().addGameObject(newObject);

        if(newObject.getType() == GameObjectType.EXIT)
            setExit(true);
        else if (newObject.getType()== GameObjectType.HEROE)
            setHeroe(true);
    }

    private int getLineCount(File file) {
        BufferedReader reader = null;

        int count = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            while (reader.readLine()!=null){
             count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        count -= 1;

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }



    @Override
    public boolean saveMap(Object source) {
        return false;
    }

}
