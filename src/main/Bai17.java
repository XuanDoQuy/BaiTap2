package main;

import exceptions.DataNotInvalid;
import objects.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Bai17 {
    private static ArrayList<Sach> listSach = new ArrayList<>();
    private static Scanner sc;
    private static FileWriter fr;

    public static void main(String[] args) {
        readFile();
        for (Sach s : listSach) {
            System.out.println(s);
        }
        sortAndWriteSapXep();
        sortAndWriteFileNhom();
    }


    private static void sortAndWriteSapXep() {
        Collections.sort(listSach, new Comparator<Sach>() {
            @Override
            public int compare(Sach o1, Sach o2) {
                if (o1.getGiaBan() > o2.getGiaBan()) return -1;
                if (o1.getGiaBan() < o2.getGiaBan()) return 1;
                return 0;
            }
        });
        try {
            fr = new FileWriter(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\sx17.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Sach s : listSach) {
            try {
                fr.write(s.toString() + "\n");
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

    private static void readFile() {
        try {
            sc = new Scanner(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\test17.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            try {
                int ma = Integer.parseInt(sc.nextLine());
                String ten = sc.nextLine();
                String chuyenNganh = sc.nextLine();
                double gia = Double.parseDouble(sc.nextLine());
                Sach s = new Sach(ma, ten, chuyenNganh, gia);
                listSach.add(s);
            } catch (NumberFormatException e) {
                System.out.println("error");
            } catch (DataNotInvalid dataNotInvalid) {
                System.out.println("error");
            }
        }
    }

    public static void sortAndWriteFileNhom() {
        ArrayList<NhomSach> listNhomSach = new ArrayList<>();
        for (Sach sp : listSach) {
            String tenNhom = sp.getChuyenNganh();
            int pos = findLop(tenNhom, listNhomSach);
            if (pos >= 0) {
                listNhomSach.get(pos).getDsSach().add(sp);
            } else {
                NhomSach nhomSach = new NhomSach(tenNhom);
                nhomSach.getDsSach().add(sp);
                listNhomSach.add(nhomSach);
            }
        }
        for (NhomSach nhomSach : listNhomSach) {
            Collections.sort(nhomSach.getDsSach(), new Comparator<Sach>() {
                @Override
                public int compare(Sach o1, Sach o2) {
                    if (o1.getTen().compareTo(o2.getTen()) > 0) return 1;
                    if (o1.getTen().compareTo(o2.getTen()) < 0) return -1;
                    return 0;
                }
            });
        }
        try {
            fr = new FileWriter(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\nhom17.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (NhomSach nhomSach : listNhomSach) {
            for (Sach sp : nhomSach.getDsSach()) {
//                System.out.println(sv);
                try {
                    fr.write(sp.toString() + "\n");
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

    private static int findLop(String ten, ArrayList<NhomSach> listNhom) {
        for (int i = 0; i < listNhom.size(); i++) {
            if (ten.equals(listNhom.get(i).getTen())) return i;
        }
        return -1;
    }
}

