package myfirstscreen.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class RegisterActivity extends AppCompatActivity {
    private EditText personalInformatioin, courseDetails, feesDetails, documentDetails, examDetails,hallTicketDetails,
            bookDetails;
    private CheckBox checkBox;

    private String personalinformation, coursedetails, feesdetails, documentdetails, examdetails, bookdetails,hallticketdetails;

    @Override
    protected void onCreate(Bundle savedInstanceSaved) {
        super.onCreate(savedInstanceSaved);
        setContentView(R.layout.activity_register);

        personalInformatioin = (EditText) findViewById(R.id.personal_information);
        courseDetails = (EditText) findViewById(R.id.course_details);
        feesDetails = (EditText) findViewById(R.id.fees_details);
        documentDetails = (EditText) findViewById(R.id.document_details);
        examDetails = (EditText) findViewById(R.id.exam_details);
        bookDetails = (EditText) findViewById(R.id.book_details);
        hallTicketDetails = (EditText) findViewById(R.id.hall_details1);
        checkBox = (CheckBox)findViewById(R.id.checkbox);


        Button registerButton1 = (Button) findViewById(R.id.button_register);
        registerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personalinformation = personalInformatioin.getText().toString();
                coursedetails = courseDetails.getText().toString();
                feesdetails = feesDetails.getText().toString();
                documentdetails = documentDetails.getText().toString();
                examdetails = examDetails.getText().toString();
                bookdetails = bookDetails.getText().toString();
                hallticketdetails = hallTicketDetails.getText().toString();
                validateOptions();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_register, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.add:
                Toast.makeText(RegisterActivity.this, "Clicked add", Toast.LENGTH_LONG).show();
                return true;


            case R.id.submit:
                Toast.makeText(RegisterActivity.this, "Clicked submit", Toast.LENGTH_LONG).show();
                return true;
            case R.id.login:
                Toast.makeText(RegisterActivity.this, "Clicked Login",Toast.LENGTH_LONG).show();
                return true;
            case R.id.random:
            Toast.makeText(RegisterActivity.this, "Clicked Random",Toast.LENGTH_LONG).show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void validateOptions() {
        //Validation check
        if(personalinformation.trim().equals("")|| coursedetails.trim().equals("")||!checkBox.isChecked()){
            Toast.makeText(RegisterActivity.this, "Field is mandatory!", Toast.LENGTH_SHORT).show();
        } else{
            Intent g = new Intent(RegisterActivity.this, StudentActivity.class);
            g.putExtra("personal_information", personalinformation);
            g.putExtra("course_details", coursedetails);
            g.putExtra("fees_details", feesdetails);
            g.putExtra("document_details", documentdetails);
            g.putExtra("exam_details", examdetails);
            g.putExtra("book_details", bookdetails);
            g.putExtra("hall_details",hallticketdetails);
            startActivity(g);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        personalInformatioin.setText("");
        courseDetails.setText("");
        feesDetails.setText("");
        documentDetails.setText("");
        examDetails.setText("");
        bookDetails.setText("");
        hallTicketDetails.setText("");

    }
}



