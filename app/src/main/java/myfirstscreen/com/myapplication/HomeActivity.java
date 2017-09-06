package myfirstscreen.com.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Intent g = getIntent();
//        String personalinformation = g.getStringExtra("personal_information");
//        String coursedetails = g.getStringExtra("course_details");
//        String feesdetails = g.getStringExtra("fees_details");
//        String documentdetails= g.getStringExtra("document_details");
//        String examdetails= g.getStringExtra("book_details");


//        TextView txt_view = (TextView)findViewById(R.id.personal_information);
//        txt_view.setText(personalinformation);
//        TextView txt_view1 = (TextView)findViewById(R.id.course_details);
//        txt_view1.setText(coursedetails);
//        TextView txt_View2 = (TextView)findViewById(R.id.fees_details);
//        txt_View2.setText(feesdetails);
//        TextView txt_View3 = (TextView)findViewById(R.id.document_details);
//        txt_View3.setText(documentdetails);
//        TextView txt_view4 = (TextView)findViewById(R.id.book_details);
//        txt_view4.setText(examdetails);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("first_name");
        String lastName = intent.getStringExtra("last_name");
        alertType();

    }

    private void alertType() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Alert");
        builder.setMessage("Its comes in that way");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this, "Yes", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(HomeActivity.this, "NO", Toast.LENGTH_SHORT).show();

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


}

