package cocholor;

import ra.model.Song;
import server.SongServer;
import server.SongSever;

public class SongCocholor {
    private SongServer server = new SongServer();
    public Song[] getAll(){
        return SongServer.getAll();
    }
    public static void save(Song cat){
        SongServer.save(cat);
    }
    public Song findById(String id){
        return SongServer.findById(id);
    }
    public void delete(String id){
        SongServer.delete(id);
    }
    public  int getSize(){
        return SongServer.getSize();
    }

    public String getNewId(){
        return SongServer.getNewId();
    }
}
