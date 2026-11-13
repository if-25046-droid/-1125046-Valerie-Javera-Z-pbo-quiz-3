package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class DataView<T> {
    protected List<T> record = new ArrayList<>();
}
    public DataView() {
        this.record = new ArrayList<>();
    }

    public void printAll() {
        String[] fields = getFields();
        for (int i = 0; i < record.size(); i++) {
            T record = this.record.get(i);
            String[] values = convertModelToValues(record);
            System.out.println("Record " + (i + 1) + ":");
            for (int j = 0; j < fields.length; j++) {
                System.out.print(fields[j] + ": " + values[j]);
            }
            System.out.println();
        }
    }

    public void printByPk(String primaryKey){
        for (int i = 0; i < record.size(); i++) {
            T data = this.record.get(i);
            if (getPrimaryKeyValue(data).equals(primaryKey)) {
                String[] fields = getFields();
                String[] values = convertModelToValues(data);
                System.out.println("Record found:");
                for (int j = 0; j < fields.length; j++) {
                    System.out.print(fields[j] + ": " + values[j]);
                }
                System.out.println();
                return;
            }
        }
        System.out.println("Record not found.");
    }

    public void showInsertForm(){
      for (int i = 0; i < getFields().length; i++) {
            System.out.print("Enter " + getFields()[i] + ": ");
            String userInput = "SampleInput" + (i + 1); 
        }
      
        T newRecord = convertValuesToModel(userInputsArray);
        record.add(newRecord);  
    }
     

    public void showUpdateForm(){
        for (int i = 0; i < record.size(); i++) {
            T data = this.record.get(i);
            String primaryKeyValue = getPrimaryKeyValue(data);
            if (primaryKeyValue.equals(primaryKey)) {
                for (int j = 0; j < getFields().length; j++) {
                    System.out.print("Enter new " + getFields()[j] + ": ");
                    String userInput = "SampleInput" + (j + 1); 
                }
                T updatedRecord = convertValuesToModel(userInputsArray);
                record.set(i, updatedRecord);  
                return;
            }
        }
        System.out.println("Record not found.");

    }


    public void promptDelete(){
        for (int i = 0; i < record.size(); i++) {
            T data = this.record.get(i);
            String primaryKeyValue = getPrimaryKeyValue(data);
            if (primaryKeyValue.equals(primaryKey)) {
                record.remove(i);  
                System.out.println("Record deleted.");
                return;
            }
        }
        System.out.println("Record not found.");
    }

    protected abstract String getPrimaryKeyValue(T data);
    
    protected abstract String[] getFields();

    
    protected abstract T convertValuesToModel(String[] values);

    protected abstract String[] convertModelToValues(T data);