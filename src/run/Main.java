package run;

import cocholor.SingerCocholor;
import cocholor.SongCocholor;
import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;

public class Main {
    private static SingerCocholor singerCocholor = new SingerCocholor();
    private static SongCocholor songCocholor = new SongCocholor();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1.************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menuSinger();
                    break;
                case 2:
                    menuSong();
                    break;
                case 3:
                    menuSearch();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 4");
            }
        }
    }

    public static void menuSinger() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("----------------SINGER-MANAGEMENT--------------");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới ");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4. Xóa ca sĩ theo mã id ");
            System.out.println("5. Quay lại");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới
                    addNewSinger();
                    break;
                case 2:
                    //Hiển thị danh sách tất cả ca sĩ đã lưu trữ
                    showSinger();
                    break;
                case 3:
                    //Thay đổi thông tin ca sĩ theo mã id
                    updateSinger();
                    break;
                case 4:
                    //4. Xóa ca sĩ theo mã id
                    deleteSinger();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }
    }

    public static void addNewSinger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số lượng ca sỹ cần thêm mới");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhập thông tin danh mục thứ " + (i + 1));
            Singer newSinger = new Singer();
            int id = singerCocholor.getNewId();
            System.out.println("Id : " + id);
            newSinger.setSingerId(id);
            while (true) {
                System.out.println("nhập tên ca sỹ");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    newSinger.setSingerName(name);
                    break;
                }
            }
            while (true) {
                System.out.println("nhập tuổi ca sỹ");
                int age = scanner.nextInt();
                if (age > 0) {
                    newSinger.setAge(age);
                    break;
                }
            }
            while (true) {
                System.out.println("nhập Quốc tịch ca sỹ");
                String nationality = scanner.nextLine();
                if (!nationality.equals("")) {
                    newSinger.setNationality(nationality);
                    break;
                }
            }
            System.out.println("nhập giới tính ca sỹ\n" + "true:nam \n" + "false: nữ");

            while (true) {
                System.out.println("nhập thể loại nhạc của ca sỹ");
                String genre = scanner.nextLine();
                if (!genre.equals("")) {
                    newSinger.setNationality(genre);
                    break;
                }
            }
            // lưu nó vào listcategory
            SingerCocholor.save(newSinger);
        }
    }

    public static void showSinger() {
        Singer[] listSinger = singerCocholor.getAll();
        if (singerCocholor.getSize() == 0) {
            System.err.println("danh sách trống");
        } else {
            for (Singer cat : listSinger) {
                if (cat != null) {
                    System.out.println(cat);
                }
            }
        }
    }

    public static void updateSinger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" hãy nhập vào id của danh mục muốnn sửa");
        int idEdit = scanner.nextInt();
        Singer SingerEdit = singerCocholor.findById(idEdit);
        if (SingerEdit != null) {
            // có ton tại , cho phép chỉnh sửa
            System.out.println("nhập tên danh mục mới");
            while (true) {
                System.out.println("nhập tên ca sỹ");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    SingerEdit.setSingerName(name);
                    break;
                }
            }
            while (true) {
                System.out.println("nhập tuổi ca sỹ");
                int age = scanner.nextInt();
                if (age > 0) {
                    SingerEdit.setAge(age);
                    break;
                }
            }
            while (true) {
                System.out.println("nhập Quốc tịch ca sỹ");
                String nationality = scanner.nextLine();
                if (!nationality.equals("")) {
                    SingerEdit.setNationality(nationality);
                    break;
                }
            }
            System.out.println("nhập giới tính ca sỹ\n" + "true:nam \n" + "false: nữ");

            while (true) {
                System.out.println("nhập thể loại nhạc của ca sỹ");
                String genre = scanner.nextLine();
                if (!genre.equals("")) {
                    SingerEdit.setNationality(genre);
                    break;
                }
            }
            // lưu nó vào listcategory
            SingerCocholor.save(SingerEdit);

        } else {
            System.err.println("Id không tồn tại");
        }
    }

    public static void deleteSinger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" hãy nhập vào id của danh mục muốn xóa");
        int idDel = scanner.nextInt();
        // cho phép xóa
        singerCocholor.delete(idDel);
    }

    public static void menuSong() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("----------------SONG-MANAGEMENT--------------");
            System.out.println("1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới ");
            System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4. Xóa bài hát theo mã id ");
            System.out.println("5. Quay lại");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới
                    addNewSong();
                    break;
                case 2:
                    //Hiển thị danh sách tất cả bài hát đã lưu trữ
                    showSong();
                    break;
                case 3:
                    updateSong();
                    break;
                case 4:
                    //Xóa bài hát theo mã id
                    deleteSong();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }

    }

    public static void addNewSong() {
        if (SingerCocholor.getSize() == 0) {
            System.err.println("Bạn phải thêm Ca sỹ trước");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số lượng bài hát cần thêm mới");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhập thông tin danh mục thứ " + (i + 1));
            Song newSong = new Song();
            String id = String.valueOf(Integer.parseInt(songCocholor.getNewId()));
            System.out.println("Id : " + id);
            newSong.setSongId(id);
            while (true) {
                System.out.println("nhập tên bài hát");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    newSong.setSongName(name);
                    break;
                }
            }

            while (true) {
                System.out.println("nhập mô tả bài hát ");
                String descriptions = scanner.nextLine();
                if (!descriptions.equals("")) {
                    newSong.setDescriptions(descriptions);
                    break;
                }
            }
            while (true) {
                System.out.println("Nhập id cua của ca sỹ");
                int singerId = scanner.nextInt();
                Singer cat = singerCocholor.findById(singerId);
                if (cat == null) {
                    System.err.println("Id không tôn tại, vui lòng nhập lại");
                } else {
                    newSong.setSinger(cat);
                    break;
                }
            }
            while (true) {
                System.out.println("nhập người sáng tác");
                String songWriter = scanner.nextLine();
                if (!songWriter.equals("")) {
                    newSong.setSongWriter(songWriter);
                    break;
                }
            }
            // lưu nó vào listcategory
            SongCocholor.save(newSong);
        }
    }

    public static void showSong() {
        Song[] listSong = songCocholor.getAll();
        if (singerCocholor.getSize() == 0) {
            System.err.println("danh sách trống");
        } else {
            for (Song cat : listSong) {
                if (cat != null) {
                    System.out.println(cat);
                }
            }
        }
    }

    public static void deleteSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" hãy nhập vào id của danh mục muốn xóa");
        String idDel = scanner.nextLine();
        // cho phép xóa
        songCocholor.delete(idDel);
    }

    public static void updateSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" hãy nhập vào id của danh mục muốnn sửa");
        String idEdit = scanner.nextLine();
        Song SongEdit = songCocholor.findById(idEdit);
        if (SongEdit != null) {
            // có ton tại , cho phép chỉnh sửa
            while (true) {
                System.out.println("nhập tên bài hát");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    SongEdit.setSongName(name);
                    break;
                }
            }

            while (true) {
                System.out.println("nhập mô tả bài hát ");
                String descriptions = scanner.nextLine();
                if (!descriptions.equals("")) {
                    SongEdit.setDescriptions(descriptions);
                    break;
                }
            }
            while (true) {
                System.out.println("Nhập id cua của ca sỹ");
                int singerId = scanner.nextInt();
                Singer cat = singerCocholor.findById(singerId);
                if (cat == null) {
                    System.err.println("Id không tôn tại, vui lòng nhập lại");
                } else {
                    SongEdit.setSinger(cat);
                    break;
                }
            }
            while (true) {
                System.out.println("nhập người sáng tác");
                String songWriter = scanner.nextLine();
                if (!songWriter.equals("")) {
                    SongEdit.setSongWriter(songWriter);
                    break;
                }
            }
            // lưu nó vào listcategory
            SongCocholor.save(SongEdit);


        } else {
            System.err.println("Id không tồn tại");
        }
    }


    public static void menuSearch() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("----------------SONG-MANAGEMENT--------------");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại .");
            System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại ");
            System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4. .Hiển thị 10 bài hát được đăng mới nhất ");
            System.out.println("5. Quay lại");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }

    }
}
