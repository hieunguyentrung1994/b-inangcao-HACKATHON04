package server;

import ra.model.Singer;

        public class SingerServer {
            public static Singer[] singerList = new Singer[100];
            private static int size = 0;
            public static Singer[] getAll(){
                return singerList;
            }
            public static int getSize(){
                return size;
            }
            public SingerServer() {

    }
    public static boolean save(Singer singer){
        // add
        if (findById(singer.getSingerId())==null){
            if (size==singerList.length){
                System.err.println("Danh sách người dùng quá số lương, vui lòng đăng kí sau");
                return false;
            }else {
                for (int i = 0; i < singerList.length; i++) {
                    if(singerList[i]==null){
                        singerList[i] = singer;
                        break;
                    }
                }
                System.out.println("Thêm mới thành công");
                size++;
                return true;
            }
        }else {
            // update
            for (int i = 0; i < singerList.length; i++) {
                if (singerList[i]!=null&& singerList[i].getSingerId()== singer.getSingerId()){
                    singerList[i] = singer;
                    break;
                }
            }
            System.out.println("Cập nhật thành công");
            return true;
        }
    }
    public static Singer findById(int id){
        for (Singer user:singerList) {
            if (user!=null) {
                if (user.getSingerId() == id) {
                    return user;
                }
            }
        }
        return null;
    }
    public static boolean delete(int id){
        if (findById(id) != null){
            for (int i = 0; i < singerList.length ; i++) {
                if (singerList[i]!=null&& singerList[i].getSingerId()== id){
                    singerList[i] = null;
                    break;
                }
            }
            size--;
            System.out.println("Xóa thành công");
            return true;
        }
        System.out.println("không tìm thấy id cần xóa");
        return false;

    }

    public static int getNewId(){
        int max = 0;
        for (Singer cat: singerList) {
            if(cat!= null ){
                if (cat.getSingerId()>= max){
                    max = cat.getSingerId();
                }
            }
        }
        return max+1;
    }
}
