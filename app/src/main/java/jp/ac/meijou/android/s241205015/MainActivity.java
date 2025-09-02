package jp.ac.meijou.android.s241205015;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import jp.ac.meijou.android.s241205015.databinding.ActivityMainBinding;
import android.text.Editable;
import android.text.TextWatcher;





public class MainActivity extends AppCompatActivity {

  ;  private ActivityMainBinding binding;
     private PrefDataStore prefdataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        prefdataStore = PrefDataStore.getInstance(this);

        //チェンジボタン
        //TextView text = findViewById(R.id.text);
        //binding.text.setText(R.string.text1);
        binding.button.setOnClickListener(v -> {
            var text1 = binding.editTextText3.getText().toString();
            binding.text.setText(text1);
        });

        //セーブボタン
        binding.button3.setOnClickListener(v -> {
            var text1 = binding.editTextText3.getText().toString();
            prefdataStore.setString("name", text1);
        });

    }
    protected void onStart(){
        super.onStart();
        prefdataStore.getString("name").ifPresent(name -> binding.text.setText(name));
    }
}