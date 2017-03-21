package com.xiaoqiang.fragment;

import android.view.View;
import android.widget.ListView;

import com.xiaoqiang.R;
import com.xiaoqiang.base.BaseFragment;
import com.xiaoqiang.data.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiaoqiang on 2017/3/8.
 */

public class FirstFragment extends BaseFragment {
    private static final String TAG = "FirstFragment";
    @BindView(R.id.lv_list)
    ListView listView;
    private ListViewAdapter adapter;
    private List<String> data = new ArrayList<String>();
    @Override
    protected int loadLayout() {
        return R.layout.list_view_fragment;
    }

    @Override
    protected void initView(View view) {
        adapter = new ListViewAdapter(getActivity(),data);
        listView.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        for(int i =0;i<90;i++){
            data.add("我的数据"+i);
        }
        adapter.notifyDataSetChanged();
    }
}
