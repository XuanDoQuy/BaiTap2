package main;

import exceptions.DataNotInvalid;
import objects.LopHoc;
import objects.SinhVien;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Bai15 {
    private static ArrayList<SinhVien> listSV = new ArrayList<>();
    private static Scanner sc;
    private static FileWriter fr;


    public static void main(String[] args) {
        //1.......
        readFile();
        //2.......
        for (SinhVien sv : listSV) {
            System.out.println(sv);
        }
        //3......
        sortAndWriteFileSapXep();
        //4.......
        sortAndWriteFileXepLoai();
    }

    private static void sortAndWriteFileXepLoai() {
        ArrayList<SinhVien> listSvGioi = new ArrayList<>();
        ArrayList<SinhVien> listSvKha = new ArrayList<>();
        ArrayList<SinhVien> listSvTrungBinh = new ArrayList<>();
        ArrayList<SinhVien> listSvYeu = new ArrayList<>();
        for (SinhVien sv : listSV) {
            if (sv.getDtb() >= 8) listSvGioi.add(sv);
            if (sv.getDtb() >= 7 && sv.getDtb() < 8) listSvKha.add(sv);
            if (sv.getDtb() >= 5 && sv.getDtb() < 7) listSvTrungBinh.add(sv);
            if (sv.getDtb() < 5) listSvYeu.add(sv);
        }
        Comparator<SinhVien> comparator = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                StringTokenizer tokenizer1 = new StringTokenizer(o1.getHoTen());
                StringTokenizer tokenizer2 = new StringTokenizer(o2.getHoTen());
                ArrayList<String> token1 = new ArrayList<>(), token2 = new ArrayList<>();
                while (tokenizer1.hasMoreTokens()){
                    token1.add(tokenizer1.nextToken(" "));
                }
                while (tokenizer2.hasMoreTokens()){
                    token2.add(tokenizer2.nextToken(" "));
                }
                int i=token1.size()-1,j = token2.size()-1;
                while (i>0&&j>0){
                    if (token1.get(i).compareTo(token2.get(j))>0) return 1;
                    if (token1.get(i).compareTo(token2.get(j))<0) return -1;
                    i--;
                    j--;
                }
                return 0;
            }
        };
        Collections.sort(listSvGioi,comparator);
        Collections.sort(listSvKha,comparator);
        Collections.sort(listSvTrungBinh,comparator);
        Collections.sort(listSvYeu,comparator);

        try {
            fr = new FileWriter(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\xeploai.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (SinhVien sv : listSvGioi){
            try {
                fr.write(sv.toString()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (SinhVien sv : listSvKha){
            try {
                fr.write(sv.toString()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (SinhVien sv : listSvTrungBinh){
            try {
                fr.write(sv.toString()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (SinhVien sv : listSvYeu){
            try {
                fr.write(sv.toString()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFile() {
        try {
            sc = new Scanner(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            try {
                int msv = Integer.parseInt(sc.nextLine());
                String hoTen = sc.nextLine();
                String lop = sc.nextLine();
                double dtb = Double.parseDouble(sc.nextLine());
                SinhVien sv = new SinhVien(msv, hoTen, lop, dtb);
                listSV.add(sv);
            } catch (NumberFormatException e) {
                System.out.println("error");
            } catch (DataNotInvalid dataNotInvalid) {
                System.out.println("error");
            }
        }
    }

    public static void sortAndWriteFileSapXep() {
        ArrayList<LopHoc> listLopHoc = new ArrayList<>();
        for (SinhVien sv : listSV) {
            String lop = sv.getLop();
            int pos = findLop(lop, listLopHoc);
            if (pos >= 0) {
                listLopHoc.get(pos).getDssv().add(sv);
            } else {
                LopHoc lopNew = new LopHoc(lop);
                lopNew.getDssv().add(sv);
                listLopHoc.add(lopNew);
            }
        }
        for (LopHoc lh : listLopHoc) {
            Collections.sort(lh.getDssv(), new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    if (o1.getDtb() > o2.getDtb()) return -1;
                    if (o1.getDtb() < o2.getDtb()) return 1;
                    return 0;
                }
            });
        }
        try {
            fr = new FileWriter(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\sx.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (LopHoc lh : listLopHoc) {
            for (SinhVien sv : lh.getDssv()) {
//                System.out.println(sv);
                try {
                    fr.write(sv.toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findLop(String lop, ArrayList<LopHoc> listLopHoc) {
        for (int i = 0; i < listLopHoc.size(); i++) {
            if (lop.equals(listLopHoc.get(i).getTen())) return i;
        }
        return -1;
    }
}
