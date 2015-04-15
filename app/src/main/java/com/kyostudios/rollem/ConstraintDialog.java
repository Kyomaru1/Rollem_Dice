package com.kyostudios.rollem;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Kyoma_000 on 4/9/2015.
 */
public class ConstraintDialog extends DialogFragment {

    ConstraintDialogListener clistener;

    public interface ConstraintDialogListener{
        void onViewCreated(Bundle SavedInstanceState, View view);

        public void onDialogPositiveClick(ConstraintDialog dialog, int repeatVariable, int greatestSide, int modifier);
        public void onDialogPositiveClick(ConstraintDialog dialog, int repeatVariable, int greatestSide, int modifier, String title);
        public void onDialogNegativeClick(ConstraintDialog dialog);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.constraints_dialog, null))
                .setMessage("Create a new Die")
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int repeatVariable, greatestSide, modifier;
                        String title;
                        EditText rvText = (EditText) getActivity().findViewById(R.id.repeatVariable_text);
                        EditText gsText = (EditText) getActivity().findViewById(R.id.greatestSide_text);
                        EditText mdText = (EditText) getActivity().findViewById(R.id.modifier_text);
                        EditText ttText = (EditText) getActivity().findViewById(R.id.title_text);

                        repeatVariable = Integer.parseInt(rvText.getText().toString().trim());
                        greatestSide = Integer.parseInt(gsText.getText().toString().trim());
                        modifier = Integer.parseInt(mdText.getText().toString().trim());

                        title = ttText.toString().trim();

                        if (title.trim().length() != 0) {
                            clistener.onDialogPositiveClick(ConstraintDialog.this, repeatVariable, greatestSide, modifier, title);
                        } else {
                            clistener.onDialogPositiveClick(ConstraintDialog.this, repeatVariable, greatestSide, modifier);
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clistener.onDialogNegativeClick(ConstraintDialog.this);
                    }
                });

        return builder.create();
    }


    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            clistener = (ConstraintDialogListener) activity;
        }
        catch(ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement ConstraintDialogListener");
        }
    }
}
