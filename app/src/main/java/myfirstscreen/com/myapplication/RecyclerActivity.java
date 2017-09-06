package myfirstscreen.com.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import myfirstscreen.com.myapplication.Adapter.BlogListAdapter;

public class RecyclerActivity extends AppCompatActivity implements CallbackReference {
    private BlogListAdapter blogListAdapter;

    //    private ArrayList<BlogModel> blogArrayList = new ArrayList<>();
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

//        configureListItem();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        blogListAdapter = new BlogListAdapter(GlobalClass.blogArrayList, this, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(blogListAdapter);
        FloatingActionButton floating1 = (FloatingActionButton) findViewById(R.id.fab);
        floating1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hub = new Intent(RecyclerActivity.this, ContentActivity.class);
                startActivity(hub);
            }
        });

    }

    @Override
    public void onCallbackReceived(View cardView) {
        registerForContextMenu(cardView);
        openContextMenu(cardView);
        position = (int)cardView.getTag();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.view:
                Toast.makeText(this, "Add: "+position, Toast.LENGTH_LONG).show();
                Intent view = new Intent(RecyclerActivity.this,FinalActivity.class);
                view.getIntExtra("pos", position);
                startActivity(view);
                return true;
            case R.id.edit:
                Toast.makeText(this, "Edit: ", Toast.LENGTH_LONG).show();
                Intent edit = new Intent(RecyclerActivity.this, EditActivity.class);
                edit.getIntExtra("pos", position);
                startActivity(edit);
                return true;
            case R.id.delete:
                Toast.makeText(this, "Delete:",Toast.LENGTH_LONG).show();
                GlobalClass.blogArrayList.remove(position);
                blogListAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }


    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Gaming Zone");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        blogListAdapter.notifyDataSetChanged();
    }


    //    private void configureListItem(){
//        for(int i = 0;i<10;i++){
//            BlogModel blogModel = new BlogModel();
////            blogModel.setTitle("Title: "+(i+1));
////            blogModel.setDescription("This is description: "+(i+1));
////            blogModel.setAuthorName("Author No: "+(i+1));
//            blogArrayList.add(blogModel);
//        }
//    }
}

