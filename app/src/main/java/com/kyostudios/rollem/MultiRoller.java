package com.kyostudios.rollem;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;
import java.util.ArrayList;

/**
 * Created by Kyoma_000 on 3/8/2015.
 *
 *
 * FloatingActionButton fabButton = new FloatingActionButton.Builder(this)
     .withDrawable(getResources().getDrawable(R.drawable.ic_action_add))
     .withButtonColor(getResources().getColor(R.color.primary))
     .withGravity(Gravity.BOTTOM | Gravity.RIGHT)
     .withMargins(0, 0, 16, 16)
     .create();
 */
public class MultiRoller extends Fragment implements ConstraintDialog.ConstraintDialogListener{
    ListView cardList;
    final ArrayList<ConstraintsContainer> arrayList = new ArrayList<>();
    int rp = 0;
    int gs = 0;
    int md = 0;
    String tt;
    static String fragTitle = "Multi Roller";

    public MultiRoller(){

    }

    public static MultiRoller newInstance(){
        MultiRoller fragment = new MultiRoller();
        return fragment;
    }

    public static String getFragTitle(){
        return fragTitle;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.multi_roller, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(Bundle SavedInstanceState, View view){
        super.onCreate(SavedInstanceState);
        setHasOptionsMenu(true);
        Log.d("Testing", "Version code is " + Integer.toString(Build.VERSION_CODES.LOLLIPOP));
        cardList = (ListView) view.findViewById(R.id.list);
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onFABClicked();
                }
            });

        }

        ArrayAdapter<ConstraintsContainer> arrayAdapter = new ArrayAdapter<ConstraintsContainer>(getActivity().getApplicationContext(), R.layout.simple_card_list_layout);
        cardList.setAdapter(arrayAdapter);

    }

    @Override
    public void onDialogPositiveClick(ConstraintDialog dialog, int repeatVariable, int greatestSide, int modifier) {


        rp = repeatVariable;
        gs = greatestSide;
        md = modifier;

        ConstraintsContainer cs = new ConstraintsContainer(rp, gs, md, getActivity().getApplicationContext());

        arrayList.add(cs);

    }

    @Override
    public void onDialogPositiveClick(ConstraintDialog dialog, int repeatVariable, int greatestSide, int modifier, String title){

        rp = repeatVariable;
        gs = greatestSide;
        md = modifier;
        tt = title;

        ConstraintsContainer cs = new ConstraintsContainer(rp, gs, md, title, getActivity().getApplicationContext());

        arrayList.add(cs);
    }

    @Override
    public void onDialogNegativeClick(ConstraintDialog dialog) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu items for use in the action bar
        inflater.inflate(R.menu.multi_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        MainActivity main = new MainActivity();
        main.currentFragmentPosition[0] = 4;
        Log.d("Testing", "Resuming activity with currentFragmentPosition of " + Integer.toString(main.currentFragmentPosition[0]));
    }

    public void onFABClicked(){
        DialogFragment dialog = new ConstraintDialog();
        dialog.show(getActivity().getSupportFragmentManager(), "Constraints");
    }
}
