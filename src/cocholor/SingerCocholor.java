package cocholor;

import ra.model.Singer;
import server.SingerServer;

public class SingerCocholor {
    private SingerServer server = new SingerServer();

    public Singer[] getAll(){
        return SingerServer.getAll();
    }
    public static void save(Singer cat){
        SingerServer.save(cat);
    }
    public Singer findById(int id){
        return SingerServer.findById(id);
    }
    public void delete(int id){
        SingerServer.delete(id);
    }
    public static int getSize(){
        return SingerServer.getSize();
    }

    public int getNewId(){
        return SingerServer.getNewId();
    }
}
