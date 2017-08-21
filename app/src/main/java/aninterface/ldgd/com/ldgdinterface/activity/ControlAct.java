package aninterface.ldgd.com.ldgdinterface.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aninterface.ldgd.com.ldgdinterface.R;
import aninterface.ldgd.com.ldgdinterface.base.BaseFragment;
import aninterface.ldgd.com.ldgdinterface.fragment.DebugFragment;
import aninterface.ldgd.com.ldgdinterface.fragment.ParameterFragment;
import aninterface.ldgd.com.ldgdinterface.fragment.TimingFragment;

/**
 * Created by ldgd on 2017/8/19.
 * 控制页面
 */

public class ControlAct extends FragmentActivity implements View.OnClickListener {

    private TextView tvTiming;
    private TextView tvParameter;
    private TextView tvDebug;


    private List<BaseFragment> fragments;
    private int position = 0;
    private BaseFragment mContext; // 记录当前显示的Fragment

    private ImageView iv_break;

    private List<TextView> textViewsList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contro);


        findViews();
        initFragment();
        initListener();
    }

    private void initListener() {
        // 得到传递过来的参数
        String positionStr = getIntent().getStringExtra("position");
        position = Integer.parseInt(positionStr);

        BaseFragment baseFragment = getFragment(position);
        switchFragment(mContext, baseFragment,textViewsList.get(position));

        tvTiming.setOnClickListener(this);
        tvParameter.setOnClickListener(this);
        tvDebug.setOnClickListener(this);
        iv_break.setOnClickListener(new ClickListener());
    }


    private void initFragment() {
        fragments = new ArrayList<BaseFragment>();
        fragments.add(new TimingFragment());
        fragments.add(new ParameterFragment());
        fragments.add(new DebugFragment());


    }

    private void findViews() {
        tvTiming = (TextView) findViewById(R.id.tv_timing);
        tvParameter = (TextView) findViewById(R.id.tv_parameter);
        tvDebug = (TextView) findViewById(R.id.tv_debug);
        iv_break = (ImageView) this.findViewById(R.id.iv_break);

        textViewsList = new ArrayList<>();
        textViewsList.add((TextView) findViewById(R.id.tv_save));
        textViewsList.add((TextView) findViewById(R.id.tv_query));
        textViewsList.add((TextView) findViewById(R.id.tv_send));
    }


    @Override
    public void onClick(View v) {

        if (v == tvTiming) {
            position = 0;
        } else if (v == tvParameter) {
            position = 1;
        } else if (v == tvDebug) {
            position = 2;
        } else {
            position = 0;
        }

        BaseFragment baseFragment = getFragment(position);
        switchFragment(mContext, baseFragment,textViewsList.get(position));
    }


    private BaseFragment getFragment(int position) {

        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment,TextView textView) {

        if (mContext != nextFragment) {

            mContext = nextFragment;
            if (nextFragment != null) {

                FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();

                //判断 nextFragment 是否添加
                if (!nextFragment.isAdded()) {

                    //隐藏当前 Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();

                } else {

                    //隐藏当前 Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }

                    transaction.show(nextFragment).commit();
                }

                // 显示对应的操作
                for (int i = 0; i < textViewsList.size(); i++) {
                   if(textView == textViewsList.get(i)){
                       textViewsList.get(i).setVisibility(View.VISIBLE);
                   }else {
                       textViewsList.get(i).setVisibility(View.GONE);
                   }
                }
            }
        }
    }

    class ClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v == iv_break) {
                finish();
            }

        }
    }

}
