package aninterface.ldgd.com.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import aninterface.ldgd.com.recyclerview.adapter.MyAdapter;
import aninterface.ldgd.com.recyclerview.decoration.MyItemDecoration;
import aninterface.ldgd.com.recyclerview.model.DataModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private List<DataModel> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initRecyclerView(recyclerView);
    }

    private void initView() {
        recyclerView = (RecyclerView) this.findViewById(R.id.recyclerview);
    }

    /**
     * 初始化RecyclerView
     *
     * @param recyclerView 主控件
     */
    private void initRecyclerView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true); // 设置固定大小
        initRecyclerLayoutManager(recyclerView); // 初始化布局
        initRecyclerAdapter(recyclerView); // 初始化适配器
        initItemDecoration(recyclerView); // 初始化装饰
        initItemAnimator(recyclerView); // 初始化动画效果
    }

    private void initRecyclerLayoutManager(RecyclerView recyclerView) {
        // 错列网格布局
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.VERTICAL));
    }

    private void initRecyclerAdapter(RecyclerView recyclerView) {
        mAdapter = new MyAdapter(getData());
        recyclerView.setAdapter(mAdapter);
    }



    /**
     * 模拟的数据
     *
     * @return 数据
     */
    private ArrayList<DataModel> getData() {
        int count = 57;
        ArrayList<DataModel> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            DataModel model = new DataModel();

            model.setDateTime(getBeforeDay(new Date(), i));
            model.setLabel("No. " + i);

            data.add(model);
        }

        return data;
    }

    /**
     * 获取日期的前一天
     *
     * @param date 日期
     * @param i    偏离
     * @return 新的日期
     */
    private static Date getBeforeDay(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, i * (-1));
        return calendar.getTime();
    }


    private void initItemDecoration(RecyclerView recyclerView) {
        recyclerView.addItemDecoration(new MyItemDecoration(this));
    }

    private void initItemAnimator(RecyclerView recyclerView) {
        recyclerView.setItemAnimator(new DefaultItemAnimator()); // 默认动画
    }
}
