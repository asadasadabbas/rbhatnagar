package myfirstscreen.com.myapplication;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import myfirstscreen.com.myapplication.Model.TestModel1;

public class ListViewActivity1 extends AppCompatActivity {


    private Adapter1 listAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        ListView listView1 = (ListView) findViewById(R.id.list_view1);
         listAdapter1 = new Adapter1(ListViewActivity1.this, GlobalClass.arrayList1);
        listView1.setAdapter(listAdapter1);
//        ListView listView = (ListView) findViewById(R.id.list_view1);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent n = new Intent(ListViewActivity1.this, DetailActivity.class);
//                TestModel1 testModel1 = GlobalClass.arrayList1.get(position);
//                String nme = testModel1.getMainText();
//                String lnme = testModel1.getSubprimaryText();
//                String dob = testModel1.getSubsecondoryText();
//                String occu = testModel1.getSubSubText();
//                String edu = testModel1.getSubSubSubText();
//                String mob = testModel1.getSubSubSubSubText();
//                n.putExtra("name", nme);
//                n.putExtra("lastname",lnme);
//                n.putExtra("DOB",dob);
//                n.putExtra("Occupation",occu);
//                n.putExtra("Educatiion",edu);
//                n.putExtra("Mobileno",mob);
                n.putExtra("position",position);
                startActivity(n);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        listAdapter1.notifyDataSetChanged();
    }
}
