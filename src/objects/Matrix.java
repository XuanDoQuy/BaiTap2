package objects;

import exceptions.RowsColumnNotInValid;

import java.util.Scanner;

public class Matrix {
    private float[][] a;

    public Matrix() {
        a = new float[3][3];
    }

    public Matrix(int rows, int cols) {
        a = new float[rows][cols];
    }

    public Matrix add(Matrix m) throws RowsColumnNotInValid {
        if (this.a.length == m.a.length && this.a[0].length == m.a[0].length) {
            Matrix kq = new Matrix(this.a.length, this.a[0].length);
            for (int i = 0; i < this.a.length; i++) {
                for (int j = 0; j < this.a[0].length; j++) {
                    kq.a[i][j] = this.a[i][j] + m.a[i][j];
                }
            }
            return kq;
        } else {
            throw new RowsColumnNotInValid();
        }
    }

    public Matrix sub(Matrix m) throws RowsColumnNotInValid {
        if (this.a.length == m.a.length && this.a[0].length == m.a[0].length) {
            Matrix kq = new Matrix(this.a.length, this.a[0].length);
            for (int i = 0; i < this.a.length; i++) {
                for (int j = 0; j < this.a[0].length; j++) {
                    kq.a[i][j] = this.a[i][j] - m.a[i][j];
                }
            }
            return kq;
        } else {
            throw new RowsColumnNotInValid();
        }
    }

    public Matrix mul(Matrix m) throws RowsColumnNotInValid {
        if (this.a[0].length == m.a.length){
            Matrix kq = new Matrix(this.a.length,m.a[0].length);
            int rows = kq.a.length;
            int cols = kq.a[0].length;
            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++){
                    kq.a[i][j] = 0;
                    for (int k=0;k<m.a.length;k++){
                        kq.a[i][j] = kq.a[i][j] + this.a[i][k] * m.a[k][j];
                    }
                }
            }
            return kq;
        }else {
            throw new RowsColumnNotInValid();
        }
    }

    public Matrix neg (){
        Matrix kq = new Matrix(this.a.length,this.a[0].length);
        for (int i = 0; i < this.a.length; i++) {
            for (int j = 0; j < this.a[0].length; j++) {
                kq.a[i][j] = 0 - this.a[i][j] ;
            }
        }
        return kq;
    }

    public Matrix transpose(){
        Matrix kq = new Matrix(this.a[0].length,this.a.length);
        for (int i = 0; i < this.a.length; i++) {
            for (int j = 0; j < this.a[0].length; j++) {
                kq.a[j][i] = this.a[i][j] ;
            }
        }

        return kq;
    }

    public void print(){
        for (int i = 0; i < this.a.length; i++) {
            for (int j = 0; j < this.a[0].length; j++) {
                System.out.print(this.a[i][j]+"\t");
            }
            System.out.println("");
        }
    }

    public void input(Scanner sc){
        for (int i = 0; i < this.a.length; i++) {
            for (int j = 0; j < this.a[0].length; j++) {
                this.a[i][j] = sc.nextInt();
            }
        }
    }
}
