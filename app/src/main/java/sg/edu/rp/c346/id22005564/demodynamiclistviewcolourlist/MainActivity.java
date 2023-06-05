package sg.edu.rp.c346.id22005564.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;
    EditText etIndexElement;
    ArrayList<String> alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextPosition);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter<String> aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = etElement.getText().toString();
                String positionText = etIndexElement.getText().toString();

                if (!newColour.isEmpty() && !positionText.isEmpty()) {
                    int pos = Integer.parseInt(positionText);
                    alColours.add(pos - 1, newColour);
                    aaColour.notifyDataSetChanged();
                    etElement.getText().clear();
                    etIndexElement.getText().clear();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a colour and position", Toast.LENGTH_SHORT).show();
                }
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }


        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String positionText = etIndexElement.getText().toString();

                if (!positionText.isEmpty()) {
                    int pos = Integer.parseInt(positionText);
                    if (pos >= 1 && pos <= alColours.size()) {
                        alColours.remove(pos - 1);
                        aaColour.notifyDataSetChanged();
                        etIndexElement.getText().clear();
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid position", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a position", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedColour = etElement.getText().toString();
                String positionText = etIndexElement.getText().toString();

                if (!updatedColour.isEmpty() && !positionText.isEmpty()) {
                    int pos = Integer.parseInt(positionText);
                    if (pos >= 1 && pos <= alColours.size()) {
                        alColours.set(pos - 1, updatedColour);
                        aaColour.notifyDataSetChanged();
                        etElement.getText().clear();
                        etIndexElement.getText().clear();
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid position", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a colour and position", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}
