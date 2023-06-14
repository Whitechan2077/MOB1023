/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Customs;
/**
 *
 * @author buidu
 */
public class Service {
    private List<Customs> listCustom = new ArrayList<>();

    public List<Customs> getListCustom() {
        return listCustom;
    }
    public void add(Customs c){
        this.listCustom.add(c);
    }
    public void write(String path) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(path);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this.listCustom);
            fos.flush();
        }
    }
    public void read(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream  ois;
        try (FileInputStream fis = new FileInputStream(path)) {
            ois = new ObjectInputStream(fis);
            this.listCustom = (List<Customs>) ois.readObject();
        }
        ois.close();
    }
}
