package aninterface.ldgd.com.ldgdinterface.fragment;

import android.view.View;

import aninterface.ldgd.com.ldgdinterface.R;
import aninterface.ldgd.com.ldgdinterface.base.BaseFragment;


/**
 * Created by ldgd on 2017/7/25.
 * 调试Fragment
 */

public class DebugFragment extends BaseFragment {

    @Override
    public View initView() {

        View view = View.inflate(mContext, R.layout.fragment_debug, null);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
