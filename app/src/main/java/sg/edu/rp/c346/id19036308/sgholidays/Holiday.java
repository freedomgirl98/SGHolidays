package sg.edu.rp.c346.id19036308.sgholidays;

import android.widget.ImageView;

public class Holiday {

    private String name;
    private String date;
    private String img;

    public Holiday(String name, String date, String img){
        this.name = name;
        this.date = date;
        this.img = img;
    }
    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }

    public String getImg(){
        return img;
    }
}
