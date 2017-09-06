package myfirstscreen.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import myfirstscreen.com.myapplication.Model.TestModel1;

public class ShowActivity extends AppCompatActivity {
    private int pos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_actitvity);

        Intent builder = getIntent();
         pos = builder.getIntExtra("position", 0);

        final TestModel1 testModel1 = GlobalClass.arrayList1.get(pos);
        String name = testModel1.getMainText();
        String lastnmae = testModel1.getSubprimaryText();
        String dob = testModel1.getSubsecondoryText();
        String occpa = testModel1.getSubSubText();
        String edu = testModel1.getSubSubSubText();
        String mob = testModel1.getSubSubSubSubText();
        final EditText editView = (EditText) findViewById(R.id.Edit1);
        editView.setText(name);
        final EditText editView1 = (EditText) findViewById(R.id.Edit2);
        editView1.setText(lastnmae);
        final EditText editView2 = (EditText) findViewById(R.id.Edit3);
        editView2.setText(dob);
        final EditText editView3 = (EditText) findViewById(R.id.Edit4);
        editView3.setText(occpa);
        final EditText editView4 = (EditText) findViewById(R.id.Edit5);
        editView4.setText(edu);
        final EditText editView5 = (EditText) findViewById(R.id.Edit6);
        editView5.setText(mob);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = editView.getText().toString();
                String name2 = editView1.getText().toString();
                String name3 = editView2.getText().toString();
                String name4 = editView3.getText().toString();
                String name5 = editView4.getText().toString();
                String name6 = editView5.getText().toString();

                TestModel1 testMo= new TestModel1();
               testModel1.setMainText(name1);
                testModel1.setSubprimaryText(name2);
                testModel1.setSubsecondoryText(name3);
                testModel1.setSubSubText(name4);
                testModel1.setSubSubSubText(name5);
                testModel1.setSubSubSubSubText(name6);

                ArrayList<TestModel1> arrayLis= new ArrayList<TestModel1>();
                for(int i=0;i<GlobalClass.arrayList1.size();i++){
                    arrayLis.add(GlobalClass.arrayList1.get(i));
                }
                GlobalClass.arrayList1.clear();

                for(int i =0;i<arrayLis.size();i++){
                    if(i == pos){
                        GlobalClass.arrayList1.add(testModel1);
                    } else{
                        GlobalClass.arrayList1.add(arrayLis.get(i));
                    }
                }


                finish();
            }

        });
    }

}
