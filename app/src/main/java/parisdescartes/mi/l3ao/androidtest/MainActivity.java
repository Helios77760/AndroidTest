package parisdescartes.mi.l3ao.androidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Button> buttons;
    private CustomAutoComplete actv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons = new ArrayList<>();
        buttons.add((Button)findViewById(R.id.button));
        buttons.add((Button)findViewById(R.id.button2));
        buttons.add((Button)findViewById(R.id.button3));
        buttons.add((Button)findViewById(R.id.button4));
        for(Button b : buttons)
        {
            b.setText("");
        }
        final AutoCompleteTextView ac = findViewById(R.id.autoCompleteTextView);
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        List<String> list = new ArrayList<String>();
        List<Double>  occurences = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("liste_mots.txt")));
            for(String line; (line = reader.readLine()) != null;)
            {
                String[] split = line.split("\t");
                list.add(split[0]);
                occurences.add(Double.valueOf(split[1]));
            }
        }catch(Exception e)
        {

        }
        Log.v("AUTOCOMPLETE INIT", String.valueOf(list.size()));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list);
        ac.setAdapter(adapter);
        ac.setThreshold(3);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                Log.v("MainAct",ac.getAdapter() != null ? String.valueOf(ac.getAdapter().getCount()) : "null");
            }
        });

    }
}
