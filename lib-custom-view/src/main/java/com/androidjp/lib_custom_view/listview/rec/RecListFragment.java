package com.androidjp.lib_custom_view.listview.rec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidjp.lib_custom_view.R;


/**
 * 用RecyclerView作为列表的Fragment
 * Created by androidjp on 16-7-7.
 */
public abstract class RecListFragment<V> extends Fragment implements OnItemClickListener<V>{

    View rootLayout;
    RecyclerView mRecView;
    BaseRecAdapter mListAdapter;

    View emptyView;//这里，放一个空的View



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootLayout == null) {
            rootLayout = inflater.inflate(R.layout.fragment_reclist, null);
            mRecView = (RecyclerView) rootLayout.findViewById(R.id.recview);
            emptyView = onSetEmptyView();
        }

        mRecView.setLayoutManager(onSetLayoutManager());

        return rootLayout;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListAdapter = onSetAdapter();
        mRecView.setAdapter(mListAdapter);


        initData();
    }


    public BaseRecAdapter getAdapter(){
        return this.mListAdapter;
    }

    //==========================================================================

    /**
     * 设置RecyclerView是整体列表布局形式
     *
     * @return LayoutManager对象（LinearLayoutManager、GridLayoutManager等）
     */
    protected abstract RecyclerView.LayoutManager onSetLayoutManager();


    /**
     * 设置RecyclerView的Adapter
     */
    protected abstract BaseRecAdapter<V> onSetAdapter();


    /**
     * @return RecyclerView的EmptyView
     */
    protected abstract View onSetEmptyView();


    /**
     * @return 初始化数据（同步或异步方式，加载数据给 getAdapter()）
     */
    protected abstract boolean initData();
}
