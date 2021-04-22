package sg.edu.rp.c346.id19036308.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvHoliday;
    TextView tvHoli;
    //    ImageView ivModule;
    ArrayList<Holiday> holidays;
    ArrayAdapter aa;
    String holiday = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lvHoliday = (ListView) this.findViewById(R.id.lvHoli);
        tvHoli = (TextView) findViewById(R.id.textViewHoli);
//        ivModule = (ImageView) findViewById(R.id.imageViewModule);

        lvHoliday = (ListView) this.findViewById(R.id.lvHoli);
        holidays = new ArrayList<>();

        Intent i = getIntent();
        holiday = i.getStringExtra("holiday");
        tvHoli.setText(holiday);
//        Toast.makeText(this, holiday, Toast.LENGTH_SHORT).show();


        if (holiday.equals("Secular")) {
            holidays.add(new Holiday("New Year's Day", "1 Jan 2017", "newYear"));
            holidays.add(new Holiday("Labour Day", "1 May 2017", "labourDay"));

        } else if (holiday.equals("Ethnic & Religion")) {
            holidays.add(new Holiday("Chinese New Year", "28-29 Jan 2017", "cny"));
            holidays.add(new Holiday("Good Friday", "14 April 2017", "goodFriday"));

        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        }

        aa = new HolidayAdapter(this, R.layout.row1, holidays);
        lvHoliday.setAdapter(aa);


        lvHoliday.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


//                String listItem = lvHoliday.getItemAtPosition(position);

                Holiday selectedHoliday = holidays.get(position);
                Holiday selectedDate = holidays.get(position);
                String holidayTitle = selectedHoliday.getName();
                String holidayDate = selectedDate.getDate();
                Toast.makeText(SecondActivity.this, holidayTitle + " Date: " + holidayDate , Toast.LENGTH_SHORT).show();


            }
        });

    }
}