package main;

import exceptions.DataNotInvalid;
import objects.LopHoc;
import objects.MatHang;
import objects.NhomHang;
import objects.SinhVien;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Bai16 {
    private static ArrayList<MatHang> listHang = new ArrayList<>();
    private static Scanner sc;
    private static FileWriter fr;

    public static void main(String[] args) {
        readFile();
        for (MatHang sp : listHang) {
            System.out.println(sp);
        }
        sortAndWriteSapXep();
        sortAndWriteFileNhom();
    }


    private static void sortAndWriteSapXep() {
        Collections.sort(listHang, new Comparator<MatHang>() {
            @Override
            public int compare(MatHang o1, MatHang o2) {
                if (o1.getGiaBan() > o2.getGiaBan()) return -1;
                if (o1.getGiaBan() < o2.getGiaBan()) return 1;
                return 0;
            }
        });
        try {
            fr = new FileWriter(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\sx16.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MatHang sp : listHang) {
            try {
                fr.write(sp.toString() + "\n");
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
            sc = new Scanner(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\test16.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            try {
                int ma = Integer.parseInt(sc.nextLine());
                String ten = sc.nextLine();
                String nhom = sc.nextLine();
                double gia = Double.parseDouble(sc.nextLine());
                MatHang sp = new MatHang(ma, ten, nhom, gia);
                listHang.add(sp);
            } catch (NumberFormatException e) {
                System.out.println("error");
            } catch (DataNotInvalid dataNotInvalid) {
                System.out.println("error");
            }
        }
    }

    public static void sortAndWriteFileNhom() {
        ArrayList<NhomHang> listNhomHang = new ArrayList<>();
        for (MatHang sp : listHang) {
            String tenNhom = sp.getNhom();
            int pos = findLop(tenNhom, listNhomHang);
            if (pos >= 0) {
                listNhomHang.get(pos).getDssp().add(sp);
            } else {
                NhomHang nhomHang = new NhomHang(tenNhom);
                nhomHang.getDssp().add(sp);
                listNhomHang.add(nhomHang);
            }
        }
        for (NhomHang nhomHang : listNhomHang) {
            Collections.sort(nhomHang.getDssp(), new Comparator<MatHang>() {
                @Override
                public int compare(MatHang o1, MatHang o2) {
                    if (o1.getTen().compareTo(o2.getTen()) > 0) return 1;
                    if (o1.getTen().compareTo(o2.getTen()) < 0) return -1;
                    return 0;
                }
            });
        }
        try {
            fr = new FileWriter(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\nhom16.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (NhomHang nhomHang : listNhomHang) {
            for (MatHang sp : nhomHang.getDssp()) {
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

    private static int findLop(String ten, ArrayList<NhomHang> listNhom) {
        for (int i = 0; i < listNhom.size(); i++) {
            if (ten.equals(listNhom.get(i).getTen())) return i;
        }
        return -1;
    }
}

