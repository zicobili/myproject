package com.example.administrator.jianzhimao;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class myScrollView extends ScrollView {
    public myScrollView(Context context) {  
        super(context);  
    }  
  
    public myScrollView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
    }  
  
    public myScrollView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
    }  
    
    /**
     * �����ӿڣ�ScrollView��������
     */
    public interface OnScrollChangedListener {  
        void onScrollChanged(ScrollView who, int x, int y, int oldx, int oldy);  
    }  
  
    private OnScrollChangedListener mOnScrollChangedListener;  
  
    @Override  
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {  
        super.onScrollChanged(x, y, oldx, oldy);  
        if (mOnScrollChangedListener != null) {  
        	//ʹ�ù����ӿڴ���������Ϣ��onScrollChanged������������λ����Ϣ��¶���ⲿ
            mOnScrollChangedListener.onScrollChanged(this, x, y, oldx, oldy);  
        }  
    }  
  
    /**
     * ��¶���ⲿ�ķ��������ù�������
     * @param listener
     */
    public void setOnScrollChangedListener(OnScrollChangedListener listener) {  
        mOnScrollChangedListener = listener;  
    }  
}
