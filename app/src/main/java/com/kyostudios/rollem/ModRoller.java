package com.kyostudios.rollem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Random;

/**
 * Created by Kyoma_000 on 3/23/2015.
 */
public class ModRoller extends Fragment{
    static String fragTitle = "Mod Roller";

    public ModRoller(){

    }

    public static ModRoller newInstance(){
        ModRoller fragment = new ModRoller();
        return fragment;
    }

    public static String getFragTitle(){
        return fragTitle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.mod_roller, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

            Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

            final EditText repsAmount = (EditText) view.findViewById(R.id.repsAmount);
            final EditText modAmount = (EditText) view.findViewById(R.id.modAmount);
            final Spinner diceSize = (Spinner) view.findViewById(R.id.sizeSpinner);
            final EditText output = (EditText) view.findViewById(R.id.output);


            ArrayAdapter<CharSequence> diceadapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.dice_list, R.layout.centered_spinner_item);
            diceadapter.setDropDownViewResource(R.layout.centered_spinner_item);
            diceSize.setAdapter(diceadapter);

            Button rollButton = (Button) view.findViewById(R.id.rollButton);
            rollButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (repsAmount.getText().toString().trim().length() > 0) {
                        if (modAmount.getText().toString().trim().length() > 0) {
                            rollMultiMod(Integer.parseInt(repsAmount.getText().toString().trim()), Integer.parseInt(diceSize.getSelectedItem().toString().trim()), Integer.parseInt(modAmount.getText().toString().trim()), view);
                        }
                        else {
                            rollMultiMod(Integer.parseInt(repsAmount.getText().toString().trim()), Integer.parseInt(diceSize.getSelectedItem().toString().trim()), 0, view);
                        }
                    }
                    else {
                        output.setText("");
                        output.append("You need to enter a number of times to roll the dice.");
                    }

                }
            });


    }

    @Override
    public void onResume(){
        super.onResume();
        MainActivity main = new MainActivity();
        main.currentFragmentPosition[0] = 2;
        Log.d("Testing", "Resuming activity with currentFragmentPosition of " + Integer.toString(main.currentFragmentPosition[0]));
    }

    public void rollMultiMod(int r, int m, int mod, View view){
        Random random = new Random();
        EditText output = (EditText) view.findViewById(R.id.output);
        int total = 0;
        output.setText("");

        for(int i = 1; i <= r; i++){
            int current = random.nextInt(m) + 1;
            total += current;
            output.append("Roll " + i + ": " + "\t" + current + "\n");
        }
        total += mod;
        output.append("Total plus Mod: \t" + total + "\n");


    }


}
