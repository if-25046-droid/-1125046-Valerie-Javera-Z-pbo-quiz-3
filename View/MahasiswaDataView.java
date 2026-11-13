package View;

import java.util.Scanner;
import Model.*;


public class MahasiswaDataView extends DataView<Mahasiswa> {
    private final Scanner scanner = new Scanner(System.in);
    
        @Override
        protected String getPrimaryKeyValue(Mahasiswa data) {
            return data.getNim();
        }   

    @Override
    protected String[] getFields() {
        return new String[]{"NIM", "nama", "Email", "Umur"};
    }


    @Override
    protected String[] convertValuesToModel(String[] values) {
        return new String[]{ new Mahasiswa(values[0], values[1], values[2], Integer.parseInt(values[3])).getNim(), values[1], values[2], String.valueOf(Integer.parseInt(values[3]))};
    }
    

    @Override
    protected Mahasiswa convertValuesToModel(String[] values) {
        String nim = values[0];
        String nama = values[1];
        String email = values[2];
        int umur = Integer.parseInt(values[3]);
        return null;
    }

}

