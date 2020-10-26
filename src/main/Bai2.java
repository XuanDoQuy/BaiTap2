package main;

import objects.SinhVien;

import java.util.*;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> listSv = new ArrayList<>();
        System.out.println("Nhap so luong sinh vien: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i=0;i<n;i++){
            System.out.println("Nhap sinh vien thu "+(i+1)+" : ");
            listSv.add(new SinhVien(Integer.parseInt(sc.nextLine()),sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }


        System.out.println("a. In toan bo danh sach sinh vien");
        System.out.println("---------------------------------");
        for (SinhVien sv : listSv){
            System.out.println(sv.getInfo());
        }
        System.out.println("\n\n");


        System.out.println("b. Sap xep danh sach theo ten sinh vien");
        System.out.println("---------------------------------");
        Collections.sort(listSv, new Comparator<SinhVien>() {
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
        });
        for (SinhVien sv : listSv){
            System.out.println(sv.getInfo());
        }
        System.out.println("\n\n");


        System.out.println("c. In danh sach sinh vien theo lop");
        System.out.println("---------------------------------");
        System.out.println("Nhap lop :");
        String lop = sc.next();
        for (SinhVien sv : listSv){
            if (sv.getLop().equals(lop)) System.out.println(sv.getInfo());
        }
    }
}
