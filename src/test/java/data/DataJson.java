package data;

import com.google.gson.Gson;
import dataModel.DataModel;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataJson {
    public DataModel readDataFromFileJson() throws FileNotFoundException {

        FileReader fileReader=new FileReader("data/data.json");
        DataModel dataModel= new Gson().fromJson(fileReader, DataModel.class);
        return dataModel;

    }
}
