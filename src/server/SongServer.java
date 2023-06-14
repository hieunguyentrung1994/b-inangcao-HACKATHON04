package server;

import ra.model.Singer;
import ra.model.Song;

import java.util.HashSet;
import java.util.Set;

public class SongServer {
    private static Song[] songList = new Song[100];
    private static int size = 0;

    public static Song[] getAll() {
        return songList;
    }

    public static int getSize() {
        return size;
    }

    public SongServer() {

    }

    public static boolean save(Song song) {
        // add
        if (findById(song.getSongId()) == null) {
            if (size == songList.length) {
                System.err.println("Danh sách người dùng quá số lượng, vui lòng đăng kí sau");
                return false;
            } else {
                for (int i = 0; i < songList.length; i++) {
                    if (songList[i] == null) {
                        songList[i] = song;
                        break;
                    }
                }
                System.out.println("Thêm mới thành công");
                size++;
                return true;
            }
        } else {
            // update
            for (int i = 0; i < songList.length; i++) {
                if (songList[i] != null && songList[i].getSongId().equals(song.getSongId())) {
                    songList[i] = song;
                    break;
                }
            }
            System.out.println("Cập nhật thành công");
            return true;
        }
    }

    public static Song findById(String id) {
        for (Song song : songList) {
            if (song != null && song.getSongId().equals(id)) {
                return song;
            }
        }
        return null;
    }

    public static boolean delete(String id) {
        if (findById(id) != null) {
            for (int i = 0; i < songList.length; i++) {
                if (songList[i] != null && songList[i].getSongId().equals(id)) {
                    songList[i] = null;
                    break;
                }
            }
            size--;
            System.out.println("Xóa thành công");
            return true;
        }
        System.out.println("Không tìm thấy ID cần xóa");
        return false;
    }

    public static String getNewId(){
        int max = 0;
        Set<String> existingIds = new HashSet<>();
        for (Song song : songList) {
            if (song != null) {
                String songId = song.getSongId().toString();
                if (songId.startsWith("S") && songId.length() == 4 && !existingIds.contains(songId)) {
                    existingIds.add(songId);
                    int numericId = Integer.parseInt(songId.substring(1));
                    if (numericId >= max) {
                        max = numericId;
                    }
                }
            }
        }
        int newNumericId = max + 1;
        String newId = "S" + newNumericId;
        return newId;
    }
}
