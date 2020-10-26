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

public class Bai18 {
    private static ArrayList<MonHoc> listMonHoc = new ArrayList<>();
    private static Scanner sc;
    private static FileWriter fr;

    public static void main(String[] args) {
        readFile();
        for (MonHoc m : listMonHoc) {
            System.out.println(m);
        }
        sortAndWriteSapXep();
        sortAndWriteFileNhom();
    }


    private static void sortAndWriteSapXep() {
        Collections.sort(listMonHoc, new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                if (o1.getSoTinChi() > o2.getSoTinChi()) return -1;
                if (o1.getSoTinChi() < o2.getSoTinChi()) return 1;
                return 0;
            }
        });
        try {
            fr = new FileWriter(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\sx18.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MonHoc m : listMonHoc) {
            try {
                fr.write(m.toString() + "\n");
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
            sc = new Scanner(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\test18.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            try {
                int ma = Integer.parseInt(sc.nextLine());
                String ten = sc.nextLine();
                String nhom = sc.nextLine();
                int soTin = Integer.parseInt(sc.nextLine());
                MonHoc m = new MonHoc(ma, ten, nhom, soTin);
                listMonHoc.add(m);
            } catch (NumberFormatException e) {
                System.out.println("error");
            } catch (DataNotInvalid dataNotInvalid) {
                System.out.println("error");
            }
        }
    }

    public static void sortAndWriteFileNhom() {
        ArrayList<NhomMonHoc> listNhom = new ArrayList<>();
        for (MonHoc m : listMonHoc) {
            String tenNhom = m.getNhomMh();
            int pos = findLop(tenNhom, listNhom);
            if (pos >= 0) {
                listNhom.get(pos).getDsMonHoc().add(m);
            } else {
                NhomMonHoc nhomMonHoc = new NhomMonHoc(tenNhom);
                nhomMonHoc.getDsMonHoc().add(m);
                listNhom.add(nhomMonHoc);
            }
        }
        for (NhomMonHoc nhomMonHoc : listNhom) {
            Collections.sort(nhomMonHoc.getDsMonHoc(), new Comparator<MonHoc>() {
                @Override
                public int compare(MonHoc o1, MonHoc o2) {
                    if (o1.getTen().compareTo(o2.getTen()) > 0) return 1;
                    if (o1.getTen().compareTo(o2.getTen()) < 0) return -1;
                    return 0;
                }
            });
        }
        try {
            fr = new FileWriter(new File("D:\\JavaOOP\\BaiTap2\\src\\main\\nhom18.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (NhomMonHoc nhomMonHoc : listNhom) {
            for (MonHoc m : nhomMonHoc.getDsMonHoc()) {
//                System.out.println(sv);
                try {
                    fr.write(m.toString() + "\n");
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

    private static int findLop(String ten, ArrayList<NhomMonHoc> listNhom) {
        for (int i = 0; i < listNhom.size(); i++) {
            if (ten.equals(listNhom.get(i).getTen())) return i;
        }
        return -1;
    }
}

