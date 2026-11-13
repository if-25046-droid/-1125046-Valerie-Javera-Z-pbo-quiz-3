package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class DataView<T> {
    private List<T> record;
}

    DataView(List<T> record) {
        this.record = record;
    }

    public void printAll() {
        for (int i = 0; i < record.size(); i++) {
            T data = record.get(i);
            String[] values = convertModelToValues(data);
            String[] fields = getFields();
            for (int j = 0; j < fields.length; j++) {
                System.out.print(fields[j] + ": " + values[j]);
            }
            System.out.println();
        }
    }

    //Mencari data berdasarkan primaryKey menggunakan getPrimaryKeyValue(T data), lalu mencetak satu data tersebut berdasarkan getFields() dan convertModelToValues(T data).
    public void printByPk(String primaryKey){
    }

    public void showInsertForm(){
    }
    
    public void showUpdateForm(){

    }

    public void promptDelete(){
    }

    protected abstract String getPrimaryKeyValue(T data){

    }
    
    protected abstract String[] getFields(){

    }

    protected abstract T convertValuesToModel(String[] values){
    }

    protected abstract String[] convertModelToValues(T data){

    }