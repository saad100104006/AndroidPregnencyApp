package info.androidhive.instantapps.pregnency.model;

/**
 * Created by Saad on 7/18/17.
 */


public class Calendar {

    //private variables
    int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCal_date() {
        return cal_date;
    }

    public void setCal_date(String cal_date) {
        this.cal_date = cal_date;
    }

    public String getCal_note() {
        return cal_note;
    }

    public void setCal_note(String cal_note) {
        this.cal_note = cal_note;
    }

    String cal_date;
    String cal_note;


}

