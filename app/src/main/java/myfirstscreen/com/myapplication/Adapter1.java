package myfirstscreen.com.myapplication;


import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import myfirstscreen.com.myapplication.Model.TestModel1;

public class Adapter1 extends ArrayAdapter<TestModel1> {

    private Context context;
    private ArrayList<TestModel1> arrayList1;

    public Adapter1(Context context, ArrayList<TestModel1> arrayList1) {
        super(context, R.layout.item_row_view, arrayList1);
        this.context = context;
        this.arrayList1 = arrayList1;
    }
    private class MyViewHolder1{
        TextView textView;
        TextView subTextView;
        TextView subTextItem;
        ImageView imageView;
        TextView sub_text_item;
        TextView sub_text_items;
        TextView sub_text_views;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder1 myViewHolder1;
        if(convertView == null) {
            LayoutInflater layoutInflater1 = LayoutInflater.from(context);
            convertView = layoutInflater1.inflate(R.layout.item_row_view, parent, false);
            myViewHolder1 = new MyViewHolder1();
            myViewHolder1.textView = (TextView) convertView.findViewById(R.id.text_view_item);
            myViewHolder1.subTextView = (TextView) convertView.findViewById(R.id.sub_text_view_item);
            myViewHolder1.subTextItem = (TextView) convertView.findViewById(R.id.sub_text_item);
            myViewHolder1.imageView = (ImageView)convertView.findViewById(R.id.image_item);
            myViewHolder1.sub_text_item = (TextView)convertView.findViewById(R.id.sub_text_item1);
            myViewHolder1.sub_text_items = (TextView)convertView.findViewById(R.id.sub_text_item2);
            myViewHolder1.sub_text_views = (TextView) convertView.findViewById(R.id.sub_text_item3);
            convertView.setTag(myViewHolder1);
        }else{
            myViewHolder1 = (MyViewHolder1) convertView.getTag();
        }
        TestModel1 testModel1 =(arrayList1.get(position));
        myViewHolder1.textView.setText(testModel1.getMainText());
        myViewHolder1.subTextView.setText(testModel1.getSubprimaryText());
        myViewHolder1.subTextItem.setText(testModel1.getSubsecondoryText());
        myViewHolder1.imageView.setImageResource(testModel1.getImageResource());
        myViewHolder1.sub_text_item.setText(testModel1.getSubSubText());
        myViewHolder1.sub_text_items.setText(testModel1.getSubSubSubText());
        myViewHolder1.sub_text_views.setText(testModel1.getSubSubSubSubText());

        Log.e("test1", position+"");

//        Toast.makeText(context,"kk proceed",Toast.LENGTH_SHORT).show();
        return convertView;
    }
}
