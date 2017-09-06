package myfirstscreen.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import myfirstscreen.com.myapplication.Model.BlogModel;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        final EditText editText = (EditText) findViewById(R.id.game1);
//      editText.setText("name");
        final EditText editText1 = (EditText) findViewById(R.id.game2);
//        editText1.setText("lastname");
        final EditText editText2 = (EditText) findViewById(R.id.game3);
//        editText2.setText("variable");

        Button button  = (Button) findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                BlogModel blogModel = new BlogModel();
                blogModel.setTitle(text);
                blogModel.setDescription(text1);
                blogModel.setAuthorName(text2);
                GlobalClass.blogArrayList.add(blogModel);
                finish();

            }
        });
    }
}
