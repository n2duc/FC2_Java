/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package n2d;

/**
 *
 * @author N2DUC
 */
import java.util.*;
public class Matrix {
    int [][]a;
    int m, n;
    void randMatrix() {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        m = sc.nextInt();
        n = sc.nextInt();
        a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int)(Math.random() * 100);
            }
        }
    }
    void printMatrix() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
    Matrix multiMatrix(Matrix B) {
        if (this.m != B.n) {
            System.out.println("Can't multify this matrixs!");
            return new Matrix();
        } else {
            Matrix C = new Matrix();
            C.a = new int[m][B.n];
            C.m = m;
            C.n = B.n;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < B.n; j++) {
                    int t = 0;
                    for (int k = 0; k < n; k++) {
                        t += a[i][k] * B.a[k][j];
                    }
                    C.a[i][j] = t;
                }
            }
            return C;
        }
    }
    public static void main(String[] args) {
        Matrix A;
        Matrix B;
        A = new Matrix(); B = new Matrix();
        A.randMatrix(); B.randMatrix();
        A.printMatrix(); B.printMatrix();
        System.out.println(A.multiMatrix(B));
    }
}
