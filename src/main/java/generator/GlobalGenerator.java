package generator;

import readers.MaterielReader;
import readers.StaffReader;

import java.util.List;

public class GlobalGenerator {
    private static StaffReader staffReader;
    private static MaterielReader materielReader;

    public static void main(String[] args) {
        List<String> staffList = staffReader.getStaffList();
        List<String> materielList = materielReader.getMaterielList();
        System.out.println(staffList);
        System.out.println(materielList);
    }
}
