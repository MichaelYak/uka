package Entity;

import java.util.Random;

/**
 * Created by kim.flaethe on 20.03.2015.
 */
public class DummyData {

    private String data;
    private String name;

    private String _id;
    private String _rev;

    private Random random;

    public DummyData() {
        data = "This is some data";
        name = "This is a name";
    }

    public String getData() {
        return data;
    }
    public void setData(String data){
        this.data = data;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_rev() {
        return _rev;
    }
    public void set_rev(String _rev) {
        this._rev = _rev;
    }
}
