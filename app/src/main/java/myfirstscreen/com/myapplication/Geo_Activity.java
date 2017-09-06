package myfirstscreen.com.myapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Geo_Activity extends AppCompatActivity {

    private String random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_);

        Intent g = getIntent();
        String personalinformation = g.getStringExtra("personal_information");
        String coursedetails = g.getStringExtra("course_details");
        String feesdetails = g.getStringExtra("fees_details");
        String documentDetails = g.getStringExtra("document_details");
        String examdetails = g.getStringExtra("exam_details");
        String bookdetails = g.getStringExtra("book_details");




        TextView txtView = (TextView) findViewById(R.id.personal_information);
        txtView.setText(personalinformation);
        TextView txtView1 = (TextView) findViewById(R.id.course_details);
        txtView1.setText(coursedetails);
        TextView txtView2 = (TextView) findViewById(R.id.fees_details);
        txtView2.setText(feesdetails);
        TextView txtView3 = (TextView) findViewById(R.id.document_details);
        txtView3.setText(documentDetails);
        TextView txtView4 = (TextView) findViewById(R.id.exam_details);
        txtView4.setText(examdetails);
        TextView txtView5 = (TextView) findViewById(R.id.book_details);
        txtView5.setText(bookdetails);
        test();
    }

    private void test(){
        Intent intent = new Intent(Geo_Activity.this,HomeActivity.class);
        intent.putExtra("first_name","rahul");
        intent.putExtra("last_name","test");
        startActivity(intent);



//        random
    }

    private void test1(){

    }
}
