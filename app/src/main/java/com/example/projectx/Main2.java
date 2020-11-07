package com.example.projectx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

 //public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public class Main2 extends AppCompatActivity {

    Button ButtonOTDIH;


   /* @SuppressLint("WrongViewCast") // ДЛЯ ПЕРЕХОДА НА НОВЫЕ ОКНА
    protected void Create(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonOTDIH = (Button) findViewById(R.id.ButtonOTDIH);
        ButtonOTDIH.setOnClickListener(this);
    } */



    /*@Override
    public void onClick(View X)
    {
       switch (X.getId()) {
           case R.id.ButtonOTDIH:
              Intent intent = new Intent(this, FirstFragment.class);
              startActivity(intent);
              break;
           default:
               break;
       }
    } */


    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = (PieChart) findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);


        ArrayList<PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(34f, "Тренировки"));
        yValues.add(new PieEntry(23f, "Ходьба"));
        yValues.add(new PieEntry(14f, "Питание"));
        yValues.add(new PieEntry(35, "Отдых"));
        yValues.add(new PieEntry(40, "Медитация"));

        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.WHITE);

        pieChart.setData(data);


    }
}