package myfirstscreen.com.myapplication.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import myfirstscreen.com.myapplication.CallbackReference;
import myfirstscreen.com.myapplication.FinalActivity;
import myfirstscreen.com.myapplication.Model.BlogModel;
import myfirstscreen.com.myapplication.R;


public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.MyViewHolder> {

    private ArrayList<BlogModel> blogArrayList;
//    private AdapterCallBack adapterCallBack;

    private Context context;
    private CallbackReference callbackReference;


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, shortDescription, author;
        CardView cardView;

        MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.blog_title);
            shortDescription = (TextView) view.findViewById(R.id.blog_short_description);
            author = (TextView) view.findViewById(R.id.blog_author);
            cardView = (CardView) view.findViewById(R.id.card_view);
            cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    callbackReference.onCallbackReceived(v);
                    return true;

                }
            });
        }
    }




    public BlogListAdapter(ArrayList<BlogModel> blogArrayList, Context context, CallbackReference callbackReference) {
        this.blogArrayList = blogArrayList;
        this.context = context;
        this.callbackReference = callbackReference;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.blog_list_view, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int pos) {
        final int positionAdapter = holder.getAdapterPosition();
        final BlogModel blogModel = blogArrayList.get(positionAdapter);

        holder.title.setText(blogModel.getTitle());
        holder.shortDescription.setText(blogModel.getDescription());
        holder.author.setText(blogModel.getAuthorName());

        holder.cardView.setTag(positionAdapter);

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String blogTitle = blogModel.getTitle();
//                String blogDescription = blogModel.getDescription();
//                String blogAuthorName = blogModel.getAuthorName();
//
//                Intent intent = new Intent(context, FinalActivity.class);
//                intent.putExtra("Title", blogTitle);
//                intent.putExtra("Description", blogDescription);
//                intent.putExtra("Authorname", blogAuthorName);
//                context.startActivity(intent);
//            }
//        });
//        String dateTime = GlobalConfig.convertRelativeTime(blogModel.getPostedDateTime());


//        holder.postedDataTime.setText(dateTime);

//
//        holder.postedImage.setImageBitmap(blogModel.getImage());
//        holder.ed.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BlogModel blogModel1 = blogArrayList.get(positionAdapter);
//                Intent n = new Intent(context, EditCheck.class);
//
//                n.putExtra("title", blogModel1.getTitle());
//                n.putExtra("Description", blogModel1.getDescription());
//                n.putExtra("Short Description", blogModel1.getShortDescription());
//                n.putExtra("author", blogModel1.getAuthor());
//                n.putExtra("id", blogModel1.getId());
//
//                context.startActivity(n);
//            }
//        });
//
//        holder.del.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
//                alertDialogBuilder.setTitle("ATTENTION");
//                alertDialogBuilder.setMessage("R U SURE ?");
//                alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        adapterCallBack.callbackReference(position, blogModel.getId());
//                    }
//                });
//                alertDialogBuilder.setNegativeButton("no", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        alertDialogBuilder.show();
//
//                    }
//                });
//
//
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return blogArrayList.size();
    }
//
//    public interface AdapterCallBack {
//        public void callbackReference(int position, int databaseId);
//    }

}
