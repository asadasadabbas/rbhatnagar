package myfirstscreen.com.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_activity);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textName = (TextView)findViewById(R.id.personal_information);
        TextView textName1 = (TextView)findViewById(R.id.course_details);
        TextView textNaem2 = (TextView)findViewById(R.id.fees_details);
        TextView textName3 = (TextView)findViewById(R.id.document_details);
        TextView textName4 = (TextView)findViewById(R.id.exam_details);
        TextView textName5 = (TextView)findViewById(R.id.book_details);
        TextView textName6 = (TextView)findViewById(R.id.hall_details);

        CheckBox checkBox = (CheckBox) findViewById(R.id.check_box1);

        Intent g = getIntent();
        String personalinformation = g.getStringExtra("personal_information");
        String coursedetails = g.getStringExtra("course_details");
        String feesdetails = g.getStringExtra("fees_details");
        String documentDetails = g.getStringExtra("document_details");
        String examdetails = g.getStringExtra("exam_details");
        String bookdetails = g.getStringExtra("book_details");
        String hallticketdetails = g.getStringExtra("hall_details");

        textName.setText(personalinformation);
        textName1.setText(coursedetails);
        textNaem2.setText(feesdetails);
        textName3.setText(documentDetails);
        textName4.setText(examdetails);
        textName5.setText(bookdetails);
        textName6.setText(hallticketdetails);

        final AlertDialog.Builder builder = new AlertDialog.Builder(StudentActivity.this);
        builder.setTitle("Alert");
        builder.setMessage("Do you want to proceed!");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onPositiveClicked();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        Button button = (Button) findViewById(R.id.button_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


    }

    private void onPositiveClicked(){

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_register, menu);
        return true;}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.add:
                final AlertDialog.Builder builder = new AlertDialog.Builder(StudentActivity.this);
                builder.setTitle("add");
                builder.setMessage("now you are going in a new world");
                builder.setPositiveButton("True", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent builder = new Intent(StudentActivity.this,ShowActivity.class);


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
            case R.id.submit:
                Toast.makeText(StudentActivity.this, "Clicked submit", Toast.LENGTH_LONG).show();
                return true;
            case R.id.login:
                Toast.makeText(StudentActivity.this, "Clicked Login",Toast.LENGTH_LONG).show();
                return true;
            case R.id.random:
                Toast.makeText(StudentActivity.this, "Clicked Random",Toast.LENGTH_LONG).show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}

