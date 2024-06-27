package t.o.wrsd;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class Encoding {
    Hilfsklasse hilfsklasse = new Hilfsklasse();

    public void changingValueSpinner1TrueSpinner6(Context context, Spinner input, Spinner output, ImageView[] ringIV) {
        input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hilfsklasse.setValueOfSpinnerTrueChangeValueOtherSpinner(context, input, output);
                hilfsklasse.changeColorOfRing(input, ringIV);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void ChangingValueSpinner2TrueSpinner7(Context context, Spinner input, Spinner output, ImageView[] ringV) {
        input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hilfsklasse.setValueOfSpinnerTrueChangeValueOtherSpinner(context, input, output);
                hilfsklasse.changeColorOfRing(input, ringV);
            }
//hihi
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private int getValueForEditText(Spinner spinner3, Spinner spinner4, Spinner spinner5) {
        int number, r1, r2, r3;
        r1 = (spinner3.getSelectedItemPosition() + 1) * 100;
        r2 = spinner4.getSelectedItemPosition() * 10;
        r3 = spinner5.getSelectedItemPosition();
        number = r1 + r2 + r3;

        return number;
    }

    public void setValueInEditText(boolean itIsInput, Spinner spinner3, Spinner spinner4, Spinner spinner5, EditText editText) {
        MainActivity mainActivity = new MainActivity();
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (mainActivity.itIsInput) {
                    mainActivity.itIsInput = false;
                    String number = Integer.toString(getValueForEditText(spinner3, spinner4, spinner5));
                    editText.setText(number);
                    mainActivity.itIsInput = true;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mainActivity.itIsInput) {
                    mainActivity.itIsInput = false;
                    String number = Integer.toString(getValueForEditText(spinner3, spinner4, spinner5));
                    editText.setText(number);
                    mainActivity.itIsInput = true;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mainActivity.itIsInput) {
                    mainActivity.itIsInput = false;
                    String number = Integer.toString(getValueForEditText(spinner3, spinner4, spinner5));
                    editText.setText(number);
                    mainActivity.itIsInput = true;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
