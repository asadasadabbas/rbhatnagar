package myfirstscreen.com.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import myfirstscreen.com.myapplication.Model.BlogModel;

public class EditActivity extends AppCompatActivity {
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editctivity);

        Intent edit = getIntent();
        position = edit.getIntExtra("pos",0);
        final BlogModel blogModel = GlobalClass.blogArrayList.get(position);
        String edit1 = blogModel.getTitle();
        String edit2 = blogModel.getDescription();
        String edit3 = blogModel.getAuthorName();

        ImageView imageView = (ImageView) findViewById(R.id.imageview);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        Glide.with(this).load("https://lh5.ggpht.com/YAU4DdvU_Tj40BtrB__z-ZaIpBMgRJI4An_TnbmAGshWWSQJmqF9BFpGWmKUx7jVIQ=w300")
                .listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        })
        .into(imageView);

        final EditText editText = (EditText) findViewById(R.id.hub1);
        editText.setText(edit1);
        final EditText editText1 = (EditText) findViewById(R.id.hub2);
        editText1.setText(edit2);
        final EditText editText2 = (EditText) findViewById(R.id.hub3);
        editText2.setText(edit3);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String var = editText.getText().toString();
                String var1 = editText1.getText().toString();
                String var2 = editText2.getText().toString();
                BlogModel blogModel1 = new BlogModel();
                blogModel1.setTitle(var);
                blogModel1.setDescription(var1);
                blogModel1.setAuthorName(var2);

                ArrayList<BlogModel> localarrayList = new ArrayList<BlogModel>();
                for(int i=0;i<GlobalClass.blogArrayList.size();i++){
                    localarrayList.add(GlobalClass.blogArrayList.get(i));
                }
                GlobalClass.blogArrayList.clear();
                for (int j=0;j<localarrayList.size();j++){
                    BlogModel blogModel = localarrayList.get(j);
                    if (j==position){
                        blogModel = blogModel1;
                    }
                    GlobalClass.blogArrayList.add(blogModel);
                }
                finish();

            }
        });
    }

}

