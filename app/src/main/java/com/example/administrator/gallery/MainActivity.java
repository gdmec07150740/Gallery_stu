package com.example.administrator.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends Activity {

    private Gallery myGallery;
    private String[] myImageURL = new String[]
            {
                    "http://b43.photo.store.qq.com/http_imgload.cgi?/"
                            + "rurl4_b=17a39f8fd6536fa1e8752d5874fdd24aef3c61fd94bc9063b81dccb1dd93900f3dbe3a22a3396bc02595cdf8c82c4dd74274b59a9a3e34f2ffad62467626e06f1b84e0e548cb8e7539d1dc0d541dbb085f1105d0&a=43&b=43",
                    "http://b27.photo.store.qq.com/http_imgload.cgi?/"
                            + "rurl4_b=086a67cbd6a8cfb4389ea2b48efab6f3ea78f5797abbbaa617259f2d2a980a5468f2801897cfcc2b78af92fbb87565ed7a3a08041daff2dd9ccd26d3cc6198e41f2d205c8a0c445325771e8a179215999afaf9f3&a=27&b=27",
                    "http://b27.photo.store.qq.com/http_imgload.cgi?/"
                            + "rurl4_b=2a9dcf1fd909a7ed3ce8951f738608982f26d812b3a5fc96e221b85fc085e7cc3264ee20730f0fd3a1f7aca06740db7a6153d9357467ca39f82b866b6fbe3cd94bbdd10ed01841e67c95d8e4af8890b7ced40869&a=30&b=27",
                    "http://b27.photo.store.qq.com/http_imgload.cgi?/"
                            + "rurl4_b=2a9dcf1fd909a7ed3ce8951f73860898bb7ff57a8cb7747c9f0eb6a02124850b709c0b86f086a4ba5653eeb71dd4b01e4a58f407e2eec9433cd8d4bc0b88fda56260c2c8beb34ebab77b610c7131393f82e774ef&a=27&b=27",
                    "http://b27.photo.store.qq.com/http_imgload.cgi?/"
                            + "rurl4_b=2a9dcf1fd909a7ed3ce8951f73860898158d252489f84e7d2a83d44c01b7bb12b2c19ca0efdd555dba788407fd01e9de45524b11a9793f532624197bc8d14c84ae78ddebafe4357e4eedc60e9e510224367490bf&a=27&b=27" };
    private int[] image = new int[] { R.drawable.wallpaper_0, R.drawable.wallpaper_1,
            R.drawable.wallpaper_2, R.drawable.wallpaper_3, R.drawable.wallpaper_4 };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myGallery = (Gallery) findViewById(R.id.myGallery);
        myGallery.setAdapter(new ImageGalleryAdapter(this));
        myGallery.setOnItemClickListener(new OnItemClickListenerImpl());
    }

    private class OnItemClickListenerImpl implements OnItemClickListener {

        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            Toast.makeText(MainActivity.this, String.valueOf(position),
                    Toast.LENGTH_SHORT).show();
        }

    }

    public class ImageGalleryAdapter extends BaseAdapter {
        private Context context;
        // 里面所有的方法表示的是可以根据指定的显示图片的数量,进行每个图片的处理



        public ImageGalleryAdapter(Context context) {
            this.context = context;
        }

        public int getCount() { // 取得要显示内容的数量
            return image.length;
        }

        public Object getItem(int position) { // 每个资源的位置
            return image[position];
        }

        public long getItemId(int position) { // 取得每个项的ID
            return image[position];
        }

        // 将资源设置到一个组件之中，很明显这个组件是ImageView
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv = new ImageView(this.context);
            iv.setBackgroundColor(0xFFFFFFFF);
            iv.setImageResource(image[position]);// 给ImageView设置资源



            iv.setLayoutParams(new Gallery.LayoutParams(200, 150));

            iv.setScaleType(ImageView.ScaleType.CENTER);// 设置对齐方式
            iv.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return iv;
        }
    }
}
