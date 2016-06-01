package com.example.pannam.context_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pannam on 6/1/2016.
 */
public class ItemSelectedAdapter extends BaseAdapter {

    private Context activity;
    private ArrayList data;

    public ItemSelectedAdapter(Context activity, ArrayList data) {
        this.activity = activity;
        this.data = data;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    private static LayoutInflater inflater = null;
    private View vi;
    private ViewHolder mViewHolder;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        vi = view;
        //populate listView;

        final int pos = position;
        Item items = (Item) data.get(pos);
        if (view == null) {
            vi = inflater.inflate(R.layout.listview_item, null);
            mViewHolder = new ViewHolder();
            mViewHolder.checkBox = (CheckBox) vi.findViewById(R.id.checkbox);
            mViewHolder.name = (TextView) vi.findViewById(R.id.name);
            vi.setTag(mViewHolder);

        } else {
            mViewHolder.checkBox.setChecked(false);
        }
        return vi;

    }

    public ArrayList<Item> getAllData(){
        return data;
    }

    public void setCheckBox(int position){
        //update the status of checkbox
        Item items = (Item) data.get(position);
        items.setCheckbox(!items.isCheckbox());
        notifyDataSetChanged();
    }

    public class ViewHolder {
        TextView name;
        CheckBox checkBox;
    }
}
