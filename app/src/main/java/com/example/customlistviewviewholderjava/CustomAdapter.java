package com.example.customlistviewviewholderjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String ourAppsList[];
    int imagesList[];
    String description[];
    LayoutInflater inflater;

    public CustomAdapter(Context context,
                         String[] ourAppsList,
                         int[] imagesList,
                         String[] description) {
        this.context = context;
        this.ourAppsList = ourAppsList;
        this.imagesList = imagesList;
        this.description = description;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ourAppsList.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{

        TextView titleView;
        TextView descView;
        ImageView imgView;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();

        if (view == null) {

            /* There is no view at this point, we create a new one.
            In this case by inflating an xml layout */
            view = inflater.inflate(R.layout.list_item,
                    parent,
                    false);

            viewHolder.titleView = view.findViewById(R.id.appTitle);
            viewHolder.descView = view.findViewById(R.id.appDescription);
            viewHolder.imgView = view.findViewById(R.id.imgView);

            // Set a view tag so we can recycle/reuse the view.
            view.setTag(viewHolder);
        }else {
            /* We recycle/reuse a View that already exists
             and get the reference to the View */
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.titleView.setText(ourAppsList[position]);
        viewHolder.descView.setText(description[position]);
        viewHolder.imgView.setImageResource(imagesList[position]);

        /*
        When you create anonymous inner-class inside a method,
        you need to make the parameter as final in order to use
         it inside that anonymous class. E.g. the position parameter.
         So, you can't modify the reference of the parameter.
         */

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked on item:\n"
                                + ourAppsList[position],
                        Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
