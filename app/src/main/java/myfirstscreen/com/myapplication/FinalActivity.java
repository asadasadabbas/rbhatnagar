package myfirstscreen.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import myfirstscreen.com.myapplication.Adapter.ListAdapter;
import myfirstscreen.com.myapplication.Model.BlogModel;

public class FinalActivity extends AppCompatActivity {
private int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
          Intent show = getIntent();
         BlogModel blogModel = GlobalClass.blogArrayList.get(position);
                String title1 = blogModel.getTitle();
                String description1 = blogModel.getDescription();
                String author1 = blogModel.getAuthorName();

        final TextView textView = (TextView) findViewById(R.id.joy1);
        textView.setText(title1);
        TextView textView1 = (TextView) findViewById(R.id.joy2);
        textView1.setText(description1);
        TextView textView2 = (TextView) findViewById(R.id.joy3);
        textView2.setText(author1);



        

    }
}
