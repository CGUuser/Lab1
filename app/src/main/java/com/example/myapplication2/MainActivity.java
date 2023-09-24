package com.example.myapplication2;

import static android.widget.Toast.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity  {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        TextView funcTable = (TextView) findViewById(R.id.functionTable);
        // LinearLayout funcTable = (LinearLayout) findViewById(R.id.linear);
        registerForContextMenu(funcTable);
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Lec 1 App");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitle("M1229014");
        toolbar.setSubtitleTextColor(Color.WHITE);
        toolbar.setContentInsetStartWithNavigation(0);
        toolbar.setNavigationOnClickListener(v-> {
            Toast.makeText(this, "結束", LENGTH_SHORT).show();
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflator = new MenuInflater(this);
        inflator.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("請選擇:");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void Button1_Click(View view) {
        makeText(this, "我是侯憲龍\n請多指教", LENGTH_SHORT).show();
    }

    public void Button2_Click(View view) {
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.getMenuInflater().inflate(R.menu.float_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(menuItem -> {
            final ConstraintLayout background = (ConstraintLayout)findViewById(R.id.activity_main);

            // Toast message on menu item clicked
            makeText(MainActivity.this, "You Clicked " + menuItem.getTitle(), LENGTH_SHORT).show();
            if (menuItem.getItemId() == R.id.dark) {
                background.setBackgroundColor(Color.BLACK);
            } else if (menuItem.getItemId() == R.id.white) {
                background.setBackgroundColor(Color.WHITE);
            }
            return true;
        });
        popup.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.counter) {
            // Toast.makeText(this, "溫度轉換", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.temperature_counter);
        }
        else if (item.getItemId() == R.id.main) {
            Toast.makeText(this, "此為主頁面", LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override

    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.bmi) {
            setContentView(R.layout.bmi_count);
        } else if (item.getItemId() == R.id.toExit) {
            finish();
            System.exit(0);
        }
        return super.onContextItemSelected(item);
    }

    public void to_main(View view) {
        setContentView(R.layout.activity_main);
        setToolbar();
        TextView funcTable = (TextView) findViewById(R.id.functionTable);
        registerForContextMenu(funcTable);
    }

    public void count_value(View view) {
        EditText countText = findViewById(R.id.CelsValue);
        TextView FalsView = findViewById(R.id.FahrValue);
        float Cels_num = Float.parseFloat(countText.getText().toString());
        float Fahr_num = (float) ((Cels_num*1.8) + 32);
        FalsView.setText(String.valueOf(Fahr_num));
    }

    public void bmi_to_main(View view) {
        setContentView(R.layout.activity_main);
        setToolbar();
        TextView funcTable = (TextView) findViewById(R.id.functionTable);
        registerForContextMenu(funcTable);
    }

    public void countBMI(View view) {
        EditText height = (EditText) findViewById(R.id.height);
        EditText weight = (EditText) findViewById(R.id.weight);
        float h = Float.parseFloat(height.getText().toString()) / 100;
        float w = Float.parseFloat(weight.getText().toString());
        float bmi = w / (h*h);
        TextView bmiValue = (TextView) findViewById(R.id.bmiValue);
        bmiValue.setText("BMI is " + String.valueOf(bmi));
    }

}