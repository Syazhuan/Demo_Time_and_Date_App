package sg.edu.rp.c346.id22043300.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewFinal);
        btnReset = findViewById(R.id.btnReset);

        tp.setIs24HourView(true);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int hour = tp.getCurrentHour();
                    int min = tp.getCurrentMinute();
                    tvDisplay.setText("Time is " + String.format("%02d:%02d", hour, min));
                }
        });
        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    tvDisplay.setText(String.format("Date is %02d/%02d/%02d", dp.getDayOfMonth(), dp.getMonth()+1, dp.getYear()));


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(12);
                tp.setCurrentMinute(0);

                dp.updateDate(2023, 0, 1);


            }
        });

    }
}
