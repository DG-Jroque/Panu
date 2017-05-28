package com.mycaker.panu;

import android.app.Service;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Roque on 27/05/2017.
 */

public abstract class MiAdaptador extends BaseAdapter {
    private Context context;
    private ArrayList<PetsAvailable> list;
    private int layout;

    public MiAdaptador(Context context, ArrayList<PetsAvailable> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return -1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
        }

        onDisplayRow(view, i);

        return view;
    }

    public abstract void onDisplayRow(View view, int pos);

}
