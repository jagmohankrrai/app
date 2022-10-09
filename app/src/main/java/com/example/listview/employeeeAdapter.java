package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

public class employeeeAdapter extends RecyclerView.Adapter<employeeeAdapter.ViewHolder>  {
    private List<Data> mroundList;
    private Context mactivity;
    public employeeeAdapter(Context context, List<Data> roundList){
        mroundList=roundList;
        mactivity=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mactivity).inflate(R.layout.employee_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Data roundList = mroundList.get(position);
        String Name = mroundList.get(position).getName();
        holder.name.setText(Name);

    }

    @Override
    public int getItemCount() {
        return mroundList.size();
    }

    TextView name;
    CardView cd;
    public class ViewHolder extends RecyclerView.ViewHolder {

        public EditText name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            cd=itemView.findViewById(R.id.cd1);
        }
    }
}
