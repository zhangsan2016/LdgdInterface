package aninterface.ldgd.com.ldgdinterface.fragment;

import android.view.View;

import aninterface.ldgd.com.ldgdinterface.R;
import aninterface.ldgd.com.ldgdinterface.base.BaseFragment;


/**
 * Created by ldgd on 2017/7/25.
 * 定时Fragment
 */

public class TimingFragment extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragmet_timing, null);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
