package info.androidhive.instantapps.pregnency.model;

/**
 * Created by md.tanvirsaad on 7/20/17.
 */



public class Shop {

    public Shop(String title, String des) {
        this.title = title;
        this.description = des;

    }

    //private variables
    int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    String title;
    String description;
    String image;


}

