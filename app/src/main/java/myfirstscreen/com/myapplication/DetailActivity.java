package myfirstscreen.com.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import myfirstscreen.com.myapplication.Model.TestModel1;

public class DetailActivity extends AppCompatActivity {
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent n = getIntent();
//        String nm = n.getStringExtra("name");
//        String ln = n.getStringExtra("lastname");
//        String dob = n.getStringExtra("DOB");
//        String occpa = n.getStringExtra("Occupation");
//        String Edu = n.getStringExtra("Education");
//        String mob = n.getStringExtra("Mobile.no");
          pos = n.getIntExtra("position",0);

//        TestModel1 testModel1 = GlobalClass.arrayList1.get(pos);
//        String name = testModel1.getMainText();
//        String lastnmae = testModel1.getSubprimaryText();
//        String dob = testModel1.getSubsecondoryText();
//        String occpa = testModel1.getSubSubText();
//        String edu = testModel1.getSubSubSubText();
//        String mob = testModel1.getSubSubSubSubText();
//        TextView txtView = (TextView) findViewById(R.id.test_1);
//        txtView.setText(name);
//        TextView txtView1 = (TextView) findViewById(R.id.test_2);
//        txtView1.setText(lastnmae);
//        TextView txtView2 = (TextView) findViewById(R.id.test_3);
//        txtView2.setText(dob);
//        TextView txtView3 = (TextView) findViewById(R.id.test_4);
//        txtView3.setText(occpa);
//        TextView txtView4 = (TextView) findViewById(R.id.test_5);
//        txtView4.setText(edu);
//        TextView txtView5 = (TextView) findViewById(R.id.test_6);
//        txtView5.setText(mob);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_personal, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.edit_bar:
                final AlertDialog.Builder builder = new AlertDialog.Builder(DetailActivity.this);
                builder.setTitle("Editbar");
                builder.setMessage("now you are going in a new world");
                builder.setPositiveButton("True", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent builder = new Intent(DetailActivity.this,ShowActivity.class);
                        builder.putExtra("position",pos);
                        startActivity(builder);


                    }
                });
                builder.setNegativeButton("False", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog1 = builder.create();
                alertDialog1.show();
                return true;
            default:
            return super.onOptionsItemSelected(item);

        }







    }

    @Override
    protected void onResume() {
        super.onResume();

        TestModel1 testModel1 = GlobalClass.arrayList1.get(pos);
        String name = testModel1.getMainText();
        String lastnmae = testModel1.getSubprimaryText();
        String dob = testModel1.getSubsecondoryText();
        String occpa = testModel1.getSubSubText();
        String edu = testModel1.getSubSubSubText();
        String mob = testModel1.getSubSubSubSubText();
        TextView txtView = (TextView) findViewById(R.id.test_1);
        txtView.setText(name);
        TextView txtView1 = (TextView) findViewById(R.id.test_2);
        txtView1.setText(lastnmae);
        TextView txtView2 = (TextView) findViewById(R.id.test_3);
        txtView2.setText(dob);
        TextView txtView3 = (TextView) findViewById(R.id.test_4);
        txtView3.setText(occpa);
        TextView txtView4 = (TextView) findViewById(R.id.test_5);
        txtView4.setText(edu);
        TextView txtView5 = (TextView) findViewById(R.id.test_6);
        txtView5.setText(mob);
    }
}
