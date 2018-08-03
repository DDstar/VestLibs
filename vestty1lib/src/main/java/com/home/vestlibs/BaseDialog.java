package com.home.vestlibs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DDStar on 2018/2/2.
 */

public class BaseDialog extends Dialog {
    private OnClickersListener onClicksListener;
    private Context context;

    public BaseDialog(@NonNull Context context) {
        this(context, 0);
    }

    public BaseDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    protected void initView(Context context) {
        this.context = context;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public BaseDialog setRootView(int layoutId) {
        setContentView(layoutId);
        return this;
    }

    public BaseDialog setRootView(View view) {
        setContentView(view);
        return this;
    }

    public BaseDialog setText(int id, String text) {
        ((TextView) findViewById(id)).setText(text);
        return this;
    }

    public BaseDialog setViewClicker(int id, View.OnClickListener listener) {
        findViewById(id).setOnClickListener(listener);
        dismiss();
        return this;
    }

    public BaseDialog setCommonBtnsClicker(int okId, int cancleId, final OnClickersListener onClicksListener) {
        findViewById(okId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicksListener.onOkClick();
                dismiss();
            }
        });
        findViewById(cancleId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicksListener.onCalcleClick();
                dismiss();
            }
        });
        return this;
    }

    public BaseDialog setOnClicksListener(OnClickersListener onClicksListener) {
        this.onClicksListener = onClicksListener;
        return this;
    }

    public interface OnClickersListener {
        void onOkClick();

        void onCalcleClick();
    }

}
