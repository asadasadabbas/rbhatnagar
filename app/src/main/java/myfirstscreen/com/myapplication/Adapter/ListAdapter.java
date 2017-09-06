package myfirstscreen.com.myapplication.Adapter;


import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.util.ArrayList;

import myfirstscreen.com.myapplication.ListViewActivity;
import myfirstscreen.com.myapplication.Model.TestModel;
import myfirstscreen.com.myapplication.R;

public class ListAdapter extends ArrayAdapter<TestModel> {

    private Context context;
    private ArrayList<TestModel> arrayList;

    public ListAdapter(Context context, ArrayList<TestModel> arrayList) {
        super(context, R.layout.item_row_view, arrayList);
        this.context = context;
        this.arrayList = arrayList;
    }

    private class MyViewHolder {
        TextView textView;
        TextView subTextView;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.item_row_view, parent, false);
            myViewHolder = new MyViewHolder();
            myViewHolder.textView = (TextView) convertView.findViewById(R.id.text_view_item);
            myViewHolder.subTextView = (TextView) convertView.findViewById(R.id.sub_text_view_item);

            convertView.setTag(myViewHolder);
        } else {

            myViewHolder = (MyViewHolder) convertView.getTag();

        }

        TestModel testModel = arrayList.get(position);
        myViewHolder.textView.setText(testModel.getPrimaryText());
        myViewHolder.subTextView.setText(testModel.getSubText());

//        myViewHolder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("Alert" + position);
//                builder.setMessage("Want to proceed");
//                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(context,"Yes",Toast.LENGTH_SHORT).show();
//
//
//                    }
//                });
//                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(context,"No",Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//            }
//        });


        return convertView;

    }
}
