package com.example.administrator.jianzhimao.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.example.administrator.jianzhimao.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.youth.banner.loader.ImageLoader;

public class banerImageLoader extends ImageLoader {
    private DisplayImageOptions baneroptions;
    protected com.nostra13.universalimageloader.core.ImageLoader uiloader =    com.nostra13.universalimageloader.core.ImageLoader.getInstance();
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        final DisplayImageOptions baneroptions;
        baneroptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.icon_no)// //默认图片
                .showImageForEmptyUri(R.mipmap.icon_nocollection)// url为空时展示的图片
                .showImageOnFail(R.mipmap.icon_network)// 图片加载失败时的图片
                .cacheInMemory(true)// 缓存到内存
                .cacheOnDisk(true)// 缓存到磁盘
                .considerExifParams(true)// Sets whether ImageLoader will
                // consider EXIF parameters of JPEG
                // image (rotate, flip)
                .displayer(new RoundedBitmapDisplayer(5))// 图片圆角显示
                .bitmapConfig(Bitmap.Config.RGB_565).build();
        String url = (String) path;
        String bb = "这是调试信息";
        Log.v("KKGG","我是调试信息");

        uiloader.getInstance().displayImage(url,imageView,baneroptions);

        Log.v("dddddd",url.toString());
    }
}
