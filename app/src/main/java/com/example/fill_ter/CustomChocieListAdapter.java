package com.example.fill_ter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomChocieListAdapter extends BaseAdapter {
    private ArrayList<disease_list_Activity> lst = new ArrayList<>();

    public CustomChocieListAdapter(){

    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.disease_list,parent,false);

        }
        //ImageView iconImageView = (Image)
        TextView txtview = (TextView) convertView.findViewById(R.id.combo_text);
        disease_list_Activity disease_list_view_item = lst.get(position);
        //icon
        txtview.setText(disease_list_view_item.getText());
        return convertView;
    }
    public void addItem(String text){
        disease_list_Activity item = new disease_list_Activity();
        item.setText(text);

        lst.add(item);
    }
    public ArrayList<disease_list_Activity> allItem(){
        ArrayList<disease_list_Activity> all_i = new ArrayList<>();
        all_i.addAll(lst);
        return all_i;
    }
    public void remove(int position){
        lst.remove(position);
    }
}
