package t.o.wrsd;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Hilfsklasse {

    public String[] einheiten = {"X1Ω", "X10Ω", "X100Ω", "X1.000Ω(kΩ)", "X10.000Ω(10kΩ)", "X100.000Ω(100kΩ)", "X1.000.000Ω(1MΩ)", "X10.000.000Ω(10MΩ)", "X0,1Ω", "X0,01Ω"};
    public String[] einheitenII = {"Schwarz", "Braun", "Rot", "Orange", "Gelb", "Grün", "Blau", "Lila", "Gold", "Silber"};

    public String[] toleranz = {"±1%", "±2%", "±0,5%", "±0,25%", "±0,1%", "±0,05%", "±5%", "±10%"};
    public String[] toleranzII = {"Braun", "Rot", "Grün", "Blau", "Lila", "Grau", "Gold", "Silber"};
    public String[] ring2and3 = {"Schwarz - 0", "Braun - 1", "Rot - 2", "Orange - 3", "Gelb - 4", "Grün - 5", "Blau - 6", "Lila - 7", "Grau - 8", "Weiß - 9"};
    public String[] ring1 = {"Braun - 1", "Rot - 2", "Orange - 3", "Gelb - 4 ", "Grün - 5 ", "Blau - 6", "Lila - 7", "Grau - 8", "Weiß - 9"};

    public void setAdapter(Context context, Spinner spinner, String[] data) {          // Lädt ArrayAdapter für Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        spinner.setAdapter(adapter);
    }

    public void setValueOfSpinnerTrueChangeValueOtherSpinner(Context context, Spinner input, Spinner output) { // Den Wert eines Spinners bei Änderung eines anderen ändern
        int selectedPosition = input.getSelectedItemPosition();
        output.setSelection(selectedPosition);

    }

    public void changeColorOfRing(Spinner spinner, ImageView[] imageView) {
        for (int a = 0; a < imageView.length; a++) {
            imageView[a].setVisibility(View.GONE);
        }
        int selecetdItem = spinner.getSelectedItemPosition();
        switch (selecetdItem) {
            case 0:
                imageView[0].setVisibility(View.VISIBLE);
                break;
            case 1:
                imageView[1].setVisibility(View.VISIBLE);
                break;
            case 2:
                imageView[2].setVisibility(View.VISIBLE);
                break;
            case 3:
                imageView[3].setVisibility(View.VISIBLE);
                break;
            case 4:
                imageView[4].setVisibility(View.VISIBLE);
                break;
            case 5:
                imageView[5].setVisibility(View.VISIBLE);
                break;
            case 6:
                imageView[6].setVisibility(View.VISIBLE);
                break;
            case 7:
                imageView[7].setVisibility(View.VISIBLE);
                break;
            case 8:
                imageView[8].setVisibility(View.VISIBLE);
                break;
            case 9:
                imageView[9].setVisibility(View.VISIBLE);
                break;

            default:

                break;
        }


    }

    /*
    public void changingRingColor(Spinner spinner, ImageView imageView0, ImageView imageView1,ImageView imageView2,
                                  ImageView imageView3,ImageView imageView4,ImageView imageView5,ImageView imageView6,
                                  ImageView imageView7,ImageView imageView8,ImageView imageView9){
        imageView0.setVisibility(View.GONE);
        imageView1.setVisibility(View.GONE);
        imageView2.setVisibility(View.GONE);
        imageView3.setVisibility(View.GONE);
        imageView4.setVisibility(View.GONE);
        imageView5.setVisibility(View.GONE);
        imageView6.setVisibility(View.GONE);
        imageView7.setVisibility(View.GONE);
        imageView8.setVisibility(View.GONE);
        imageView9.setVisibility(View.GONE);
        int selectedItem=spinner.getSelectedItemPosition();
        switch (selectedItem){
            case 0:
                imageView0.setVisibility(View.VISIBLE);
                break;
            case 1:
                imageView1.setVisibility(View.VISIBLE);
                break;
            case 2:
                imageView2.setVisibility(View.VISIBLE);
                break;
            case 3:
                imageView3.setVisibility(View.VISIBLE);
                break;
            case 4:
                imageView4.setVisibility(View.VISIBLE);
                break;
            case 5:
                imageView5.setVisibility(View.VISIBLE);
                break;
            case 6:
                imageView6.setVisibility(View.VISIBLE);
                break;
            case 7:
                imageView7.setVisibility(View.VISIBLE);
                break;
            case 8:
                imageView8.setVisibility(View.VISIBLE);
                break;
            case 9:
                imageView9.setVisibility(View.VISIBLE);
                break;
            default:
                imageView0.setVisibility(View.GONE);
                imageView1.setVisibility(View.GONE);
                imageView2.setVisibility(View.GONE);
                imageView3.setVisibility(View.GONE);
                imageView4.setVisibility(View.GONE);
                imageView5.setVisibility(View.GONE);
                imageView6.setVisibility(View.GONE);
                imageView7.setVisibility(View.GONE);
                imageView8.setVisibility(View.GONE);
                imageView9.setVisibility(View.GONE);
        }

    }*/


}
