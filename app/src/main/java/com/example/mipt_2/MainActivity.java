package com.example.mipt_2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mipt_2.utils.TextCounter;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvCountResult;
    EditText etUserInput;

    Spinner spSelectionOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });
        this.tvCountResult =findViewById(R.id.tvCountResult);
        this.etUserInput =findViewById(R.id.etUserInput);

        this.spSelectionOptions = findViewById(R.id.spSelectionOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSelectionOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        if(this.etUserInput.getText().toString().matches("")){
            Toast.makeText(this, "Text field empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(this.spSelectionOptions.getSelectedItem().toString().equalsIgnoreCase("Chars")) {
            String userPhrase = this.etUserInput.getText().toString();
            int charsCount = TextCounter.getCharsCount(userPhrase);
            this.tvCountResult.setText(String.valueOf(charsCount));
        }
        else{
            String userPhrase = this.etUserInput.getText().toString();
            int wordCount = TextCounter.getWordCount(userPhrase);
            this.tvCountResult.setText(String.valueOf(wordCount));

        }
    }
}