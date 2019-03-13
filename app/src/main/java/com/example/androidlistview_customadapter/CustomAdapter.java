package com.example.androidlistview_customadapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener {

    private Context mContext;
    private ArrayList<DataModel> dataSet;

    public CustomAdapter(ArrayList<DataModel> data, Context mContext) {
        super(mContext,R.layout.row_item , data);
        this.mContext = mContext;
        this.dataSet = data;
    }


    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        ImageView info;
    }

    @Override
    public void onClick(View v) {

        int position = (int) v.getTag();
        Object object = getItem(position);
        DataModel dataModel = (DataModel) object;

        switch (v.getId()){

            case R.id.item_info:
                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        ViewHolder viewHolder;
        final View result;

        // Get the data item for this position
        DataModel dataModel = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null){

            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item,parent,false );

            viewHolder.txtName = convertView.findViewById(R.id.name);
            viewHolder.txtType = convertView.findViewById(R.id.type);
            viewHolder.info = convertView.findViewById(R.id.item_info);
            viewHolder.txtVersion = convertView.findViewById(R.id.version_number);
            result = convertView;

            convertView.setTag(viewHolder);

        }
        else {
            //if the view is being reused
            viewHolder = (ViewHolder)convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());
        viewHolder.txtVersion.setText(dataModel.getVersionNumber());
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
        return result;
    }
}
