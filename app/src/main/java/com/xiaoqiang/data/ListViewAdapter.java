package com.xiaoqiang.data;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xiaoqiang on 2017/3/21.
 */

public class ListViewAdapter extends BaseAdapter {
    public ListViewAdapter(Context context,List<String> names){
        this.names = names;
        this.mContext = context;
    }
    private List<String> names;
    private Context mContext;
    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = new TextView(mContext);
            convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200));
            ((TextView) convertView).setTextColor(0xff000000);
        }
        Log.d("wqq","这里getView:"+position);
        ((TextView) convertView).setText(names.get(position) + "对于的item:"+position);
        return convertView;
    }
}
