package t.o.wrsd;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class
MainActivity extends AppCompatActivity {
    public boolean itIsInput = true;
    public boolean isUpdating = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Spinner spinner1 = findViewById(R.id.spinner1);                                              //Erstellung Objekten für Spinner
            Spinner spinner2 = findViewById(R.id.spinner2);
            Spinner spinner3 = findViewById(R.id.spinner3);
            Spinner spinner4 = findViewById(R.id.spinner4);
            Spinner spinner5 = findViewById(R.id.spinner5);
            Spinner spinner6 = findViewById(R.id.spinner6);
            Spinner spinner7 = findViewById(R.id.spinner7);

            ImageView[] ringI;                                                                          //Deklation un initialisation array mit grafischen Datein RING 1
            ringI = new ImageView[9];
            ringI[0] = findViewById(R.id.v1);
            ringI[1] = findViewById(R.id.v2);
            ringI[2] = findViewById(R.id.v3);
            ringI[3] = findViewById(R.id.v4);
            ringI[4] = findViewById(R.id.v5);
            ringI[5] = findViewById(R.id.v6);
            ringI[6] = findViewById(R.id.v7);
            ringI[7] = findViewById(R.id.v8);
            ringI[8] = findViewById(R.id.v9);

            ImageView[] ringII;
            ringII = new ImageView[10];
            ringII[0] = findViewById(R.id.w0);
            ringII[1] = findViewById(R.id.w1);
            ringII[2] = findViewById(R.id.w2);
            ringII[3] = findViewById(R.id.w3);
            ringII[4] = findViewById(R.id.w4);
            ringII[5] = findViewById(R.id.w5);
            ringII[6] = findViewById(R.id.w6);
            ringII[7] = findViewById(R.id.w7);
            ringII[8] = findViewById(R.id.w8);
            ringII[9] = findViewById(R.id.w9);

            ImageView[] ringIII;
            ringIII = new ImageView[10];
            ringIII[0] = findViewById(R.id.x0);
            ringIII[1] = findViewById(R.id.x1);
            ringIII[2] = findViewById(R.id.x2);
            ringIII[3] = findViewById(R.id.x3);
            ringIII[4] = findViewById(R.id.x4);
            ringIII[5] = findViewById(R.id.x5);
            ringIII[6] = findViewById(R.id.x6);
            ringIII[7] = findViewById(R.id.x7);
            ringIII[8] = findViewById(R.id.x8);
            ringIII[9] = findViewById(R.id.x9);

            ImageView[] ringIV;
            ringIV = new ImageView[10];
            ringIV[0] = findViewById(R.id.y0);
            ringIV[1] = findViewById(R.id.y1);
            ringIV[2] = findViewById(R.id.y2);
            ringIV[3] = findViewById(R.id.y3);
            ringIV[4] = findViewById(R.id.y4);
            ringIV[5] = findViewById(R.id.y5);
            ringIV[6] = findViewById(R.id.y6);
            ringIV[7] = findViewById(R.id.y7);
            ringIV[8] = findViewById(R.id.y8);
            ringIV[9] = findViewById(R.id.y9);

            ImageView[] ringV;
            ringV = new ImageView[8];
            ringV[0] = findViewById(R.id.z0);
            ringV[1] = findViewById(R.id.z1);
            ringV[2] = findViewById(R.id.z2);
            ringV[3] = findViewById(R.id.z3);
            ringV[4] = findViewById(R.id.z4);
            ringV[5] = findViewById(R.id.z5);
            ringV[6] = findViewById(R.id.z6);
            ringV[7] = findViewById(R.id.z7);


            Hilfsklasse hilfsklasse = new Hilfsklasse();                                                    //Erstellung Objekt für Hilfklasse

            hilfsklasse.setAdapter(MainActivity.this, spinner1, hilfsklasse.einheiten);             //Auffüllung Spinners mit Arrays durch Mehode setAdapter aus Hilfklasse
            hilfsklasse.setAdapter(MainActivity.this, spinner2, hilfsklasse.toleranz);
            hilfsklasse.setAdapter(MainActivity.this, spinner3, hilfsklasse.ring1);
            hilfsklasse.setAdapter(MainActivity.this, spinner4, hilfsklasse.ring2and3);
            hilfsklasse.setAdapter(MainActivity.this, spinner5, hilfsklasse.ring2and3);
            hilfsklasse.setAdapter(MainActivity.this, spinner6, hilfsklasse.einheitenII);
            hilfsklasse.setAdapter(MainActivity.this, spinner7, hilfsklasse.toleranzII);


            Decoding decoding = new Decoding();                                                             // Erstellung Object decoding
            decoding.changingValueSpinner6TrueSpinner1(MainActivity.this, spinner1, spinner6, ringIV);       // ich rufe Methode decoding.chngingValueSpinner6TrueSpinner1() aus Decoding Klasse auf
            decoding.changingValueSpinner7TrueSpinner(MainActivity.this, spinner2, spinner7, ringV);      // genau was oben aber für spinner  un spinner
            EditText editText = findViewById(R.id.editTextNumber);                                         // neue Objekt editText
            decoding.changinValuesOnSpinners1to3(MainActivity.this, editText, itIsInput, spinner3, spinner4, spinner5, spinner6, spinner7, ringI, ringII, ringIII, ringIV, ringV, v); //aufrufen Methode changinValuesOnSpinners1to3


            Encoding encoding = new Encoding();
            encoding.changingValueSpinner1TrueSpinner6(MainActivity.this, spinner6, spinner1, ringIV);
            encoding.ChangingValueSpinner2TrueSpinner7(MainActivity.this, spinner7, spinner2, ringV);
            encoding.setValueInEditText(itIsInput, spinner3, spinner4, spinner5, editText);

            //setValueOfSpinnerTrueChangeValueOtherSpinner(MainActivity.this,spinner1,spinner6);


            return insets;
        });
    }
}