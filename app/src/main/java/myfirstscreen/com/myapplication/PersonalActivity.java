package myfirstscreen.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import myfirstscreen.com.myapplication.Model.TestModel1;

public class PersonalActivity extends AppCompatActivity {

    private EditText editName,editLastname,editDob,editOccupation,editEducation,editMobileno;

    private String editName1,editLastname1,editDob1,editOccupation1,editEducation1,editMobileno1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        editName = (EditText) findViewById(R.id.name);
        editLastname = (EditText) findViewById(R.id.last_name);
        editDob = (EditText) findViewById(R.id.dob);
        editOccupation = (EditText) findViewById(R.id.occu_pation);
        editEducation = (EditText) findViewById(R.id.education);
        editMobileno = (EditText) findViewById(R.id.mob_no);

        Button registerbutton = (Button) findViewById(R.id.but_ton);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName1 = editName.getText().toString();
                editLastname1 = editLastname.getText().toString();
                editDob1 = editDob.getText().toString();
                editOccupation1 = editOccupation.getText().toString();
                editEducation1 = editOccupation.getText().toString();
                editMobileno1 = editMobileno.getText().toString();
                validateOptions();
            }
        });
    }
    private void validateOptions(){
        if(editName1.trim().equals("")||editLastname1.trim().equals("")||editDob1.trim().equals("")
                ||editOccupation1.trim().equals("") ||editEducation1.trim().equals("")
                ||editMobileno1.trim().equals("")){
            Toast.makeText(PersonalActivity.this, "Field is mandatory!", Toast.LENGTH_SHORT).show();}
        else
        {
            TestModel1 test = new TestModel1();
            test.setMainText(editName1);
            test.setSubprimaryText(editLastname1);
            test.setSubsecondoryText(editDob1);
            test.setSubSubText(editOccupation1);
            test.setSubSubSubText(editEducation1);
            test.setSubSubSubSubText(editMobileno1);



            GlobalClass.arrayList1.add(test);

            Intent intent1 = new Intent(PersonalActivity.this, ListViewActivity1.class);
//            intent1.putExtra("name",editName1);
//            intent1.putExtra("lastname",editLastname1);
//            intent1.putExtra("dob",editDob1);
//            intent1.putExtra("Occupation",editOccupation1);
//            intent1.putExtra("Education",editEducation1);
//            intent1.putExtra("Mobileno",editMobileno1);
            startActivity(intent1);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_register, menu);
        return true;}

    @Override
    protected void onResume() {
        super.onResume();
        editName.setText("");
        editLastname.setText("");
        editDob.setText("");
        editOccupation.setText("");
        editEducation.setText("");
        editMobileno.setText("");
    }
}
