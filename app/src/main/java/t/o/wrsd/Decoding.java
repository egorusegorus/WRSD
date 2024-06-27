package t.o.wrsd;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Decoding {
    private final Hilfsklasse hilfsklasse = new Hilfsklasse();


    public void changingValueSpinner6TrueSpinner1(Context context, Spinner input, Spinner output, ImageView[] ringIV) {  // Methode, die setValueOfSpinnerTrueChangeValueOtherSpinner() von Hilfklasse auf ruft
        input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hilfsklasse.setValueOfSpinnerTrueChangeValueOtherSpinner(context, input, output);
                hilfsklasse.changeColorOfRing(input, ringIV);                                               //ändern Farbe auf Ring IV
                // Toast.makeText(context, "Spinner1 selection changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void changingValueSpinner7TrueSpinner(Context context, Spinner input, Spinner output, ImageView[] ringV) {
        input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hilfsklasse.setValueOfSpinnerTrueChangeValueOtherSpinner(context, input, output);          //ändern Wert auf Spinner7 Aufgrund änderungen in Spinner2
                hilfsklasse.changeColorOfRing(input, ringV);                                             //ändern Farbe auf Ring V
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void changinValuesOnSpinners1to3(Context context, EditText editText, boolean itIsInput,
                                            Spinner spinner3, Spinner spinner4, Spinner spinner5,
                                            Spinner spinner6, Spinner spinner7,
                                            ImageView[] ringI, ImageView[] ringII, ImageView[] ringIII,
                                            ImageView[] ringIV, ImageView[] ringV, View v) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {




            }

            @Override
            public void afterTextChanged(Editable s) {
                if (itIsInput) {
                    try {

                        int cursorPos=editText.getSelectionStart();
                        whatIsTheNumber(context, editText, itIsInput, spinner3, spinner4, spinner5);
                        hilfsklasse.changeColorOfRing(spinner3, ringI);

                        hilfsklasse.changeColorOfRing(spinner4, ringII);

                        hilfsklasse.changeColorOfRing(spinner5, ringIII);

                        hilfsklasse.changeColorOfRing(spinner6, ringIV);

                        hilfsklasse.changeColorOfRing(spinner7, ringV);
                        editText.setSelection(cursorPos);


                    } catch (Exception e) {
                        Log.e("Decoding", "Error processing text change: " + e.getMessage(), e);
                        Toast.makeText(context, "An error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });
    }


 private void waitForIt(int time){

     new Thread(new Runnable() {
         @Override
         public void run() {
             try {
                 Thread.sleep(time); // Wstrzymaj wykonanie na 0,5 sekundy
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }).start();

 }
    public void whatIsTheNumber(Context context, EditText editText, boolean inputOrOutput, Spinner spinner3, Spinner spinner4, Spinner spinner5) {
        try {
            int number = gettingValuefromEditText(context, editText);
            int number1 = 0, number2 = 0, number3 = 0;

            Log.d("MyApp", "Entered number: " + number);

            if (number >= 1 && number < 10) {
                number1 = number - 1;
                number2 = 0;
                number3 = 0;

            } else if (number >= 10 && number < 100) {
                number1 = (number / 10) - 1;
                number2 = number % 10;
                number3 = 0;

            }  else if (number >= 100 && number < 1000) {
                number1 = (number / 100) - 1;
                number2 = (number % 100) / 10;
                number3 = number % 10;

            } else {
                inputOrOutput = false;

            }


            changingValuesOf1To3Spinners(spinner3, number1);
            changingValuesOf1To3Spinners(spinner4, number2);
            changingValuesOf1To3Spinners(spinner5, number3);

        } catch (Exception e) {
            Log.e("Decoding", "Error in whatIsTheNumber: " + e.getMessage(), e);
            Toast.makeText(context, "An error occurred: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private int gettingValuefromEditText(Context context, EditText editText) {
        String textFromEditText = editText.getText().toString();

        try {
            return Integer.parseInt(textFromEditText);
        } catch (NumberFormatException e) {
            Log.e("Decoding", "Invalid number format: " + textFromEditText, e);
            Toast.makeText(context, "Invalid number format: " + textFromEditText, Toast.LENGTH_SHORT).show();
            return 1; // Return a default value
        }
    }


    private void changingValuesOf1To3Spinners(Spinner spinner, int position) {                            // setting values on Spinners 3,4,5
        spinner.setSelection(position);
    }
}