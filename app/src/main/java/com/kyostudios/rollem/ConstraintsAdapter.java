package com.kyostudios.rollem;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Drew on 1/21/2016.
 */
public class ConstraintsAdapter extends RecyclerView.Adapter<ConstraintsAdapter.ViewHolder> {
    private FragmentManager fm;
    public List<ConstraintsContainer> mConstraintsContainer;
    private Context context;

    public void ConstraintsAdapter(List<ConstraintsContainer> list){
        mConstraintsContainer = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView sizeText, repText, modText, answerText;
        public Button menuButton;

        public ViewHolder(View itemView) {
            super(itemView);

            sizeText = (TextView) itemView.findViewById(R.id.sizeText);
            repText = (TextView) itemView.findViewById(R.id.repText);
            modText = (TextView) itemView.findViewById(R.id.modText);
            answerText = (TextView) itemView.findViewById(R.id.answerText);

            menuButton = (Button) itemView.findViewById(R.id.menuButton);

        }
    }

    @Override
    public ConstraintsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View constraintsView = inflater.inflate(R.layout.simple_card_list_layout, parent, false);

        return new ViewHolder(constraintsView);
    }

    @Override
    public void onBindViewHolder(final ConstraintsAdapter.ViewHolder holder, int position) {
        final Button menuButton = (Button) holder.menuButton;

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Menu button clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return 0;
    }
}
