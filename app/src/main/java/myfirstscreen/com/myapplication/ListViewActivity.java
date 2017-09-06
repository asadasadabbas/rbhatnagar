package myfirstscreen.com.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import myfirstscreen.com.myapplication.Adapter.ListAdapter;
import myfirstscreen.com.myapplication.Model.TestModel;

public class ListViewActivity extends AppCompatActivity {

    private ArrayList<TestModel> arrayList = new ArrayList<TestModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        configureList();

        ListView listView = (ListView) findViewById(R.id.list_view);
        ListAdapter listAdapter = new ListAdapter(ListViewActivity.this,  arrayList);
        listView.setAdapter(listAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                final AlertDialog.Builder builder = new AlertDialog.Builder(ListViewActivity.this);
//                builder.setTitle("Alert" + position);
//                builder.setMessage("Want to proceed");
//                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(ListViewActivity.this,"Yes",Toast.LENGTH_SHORT).show();
//
//
//                    }
//                });
//                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(ListViewActivity.this,"No",Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//            }
//        });
    }

    private void configureList() {
        for (int i = 0; i < 15; i++) {

            TestModel testModel = new TestModel();
            testModel.setPrimaryText("PrimaryText "+(i+1));
            testModel.setSubText("Sub Text " + (i+1));
            arrayList.add(testModel);
        }
    }
}
