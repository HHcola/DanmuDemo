package com.wpy.danmudemo.listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.wpy.danmudemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hewei05 on 17/4/28.
 */

public class ListViewAdapter extends BaseAdapter {

    private static final String TAG = "ListViewAdapter";
    private List<Integer> mImageData;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private Bitmap bitmap1;
    private Bitmap bitmap2;

    public ListViewAdapter(Context context) {
        mContext = context;
        mImageData = new ArrayList<>();
        layoutInflater = LayoutInflater.from(mContext);
        bitmap1 = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.wat);
        bitmap2 = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.girl);
    }


    public void setImageData(int imageResID) {
        if (mImageData != null) {
            mImageData.add(imageResID);
        }
    }


    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_image_view, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.list_image_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Log.d(TAG, "getView: position = " + position);
        viewHolder.imageView.setImageBitmap((position & 1) == 1 ? bitmap1 : bitmap2);
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
    }
}
