package sg.edu.rp.c346.id19036308.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holidays;
    private Context context;
    private TextView tvHolidayName, tvDate;
    private ImageView ivHoliday;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    //getView() is the method ListView will call to get
    // View object everytime ListView needs a row

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        // "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row1, parent, false);

        // Get the TextView object
        tvHolidayName = (TextView) rowView.findViewById(R.id.textViewHolidayTitle);
        tvDate = (TextView) rowView.findViewById(R.id.textViewDate);
        // Get the ImageView object
        ivHoliday = (ImageView) rowView.findViewById(R.id.imageViewHoliday);

        // The parameter "position" is the index of the
        // row ListView is requesting.
        // We get back the food at the same index.
        Holiday currentHoliday = holidays.get(position);
        // Set the TextView to show the food

        tvHolidayName.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());
//        ivHoliday.setImageResource();
        // Set the image to star or no star accordingly

        if(currentHoliday.getImg().equals("newYear")) {
            ivHoliday.setImageResource(R.drawable.newyear);
        } else if (currentHoliday.getImg().equals("labourDay")) {
            ivHoliday.setImageResource(R.drawable.labourday);
        } else if (currentHoliday.getImg().equals("cny")) {
            ivHoliday.setImageResource(R.drawable.cny);
        } else if (currentHoliday.getImg().equals("goodFriday")) {
            ivHoliday.setImageResource(R.drawable.goodfriday);
        }

        else {
//            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }
        return rowView;


    }
}
