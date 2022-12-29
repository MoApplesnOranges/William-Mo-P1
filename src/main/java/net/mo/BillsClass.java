//package net.mo;
//
//import java.util.Objects;
//
//public class BillsClass {
//    private int a = 5;
//    private String str = "Hello";
//
//    public BillsClass(int a, String str) {
//        this.a = a;
//        this.str = str;
//    }
//
//    public BillsClass() {
//    }
//
//    public int getA() {
//        return a;
//    }
//
//    public void setA(int a) {
//        this.a = a;
//    }
//
//    public String getStr() {
//        return str;
//    }
//
//    public void setStr(String str) {
//        this.str = str;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BillsClass that = (BillsClass) o;
//        return a == that.a && Objects.equals(str, that.str);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(a, str);
//    }
//}
