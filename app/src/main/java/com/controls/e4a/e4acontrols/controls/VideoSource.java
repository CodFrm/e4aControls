package com.controls.e4a.e4acontrols.controls;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.controls.e4a.e4acontrols.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoSource {
    private final Context mContext;
    private GridView sourceList;
    private ImageView selectIcon;
    private ImageView showIcon;
    private TextView selectText;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> sourceArrayList;
    private AdapterView.OnItemClickListener itemClickListener;
    private RelativeLayout selectLayout;
    private boolean isShow = false;
    private ImageView collectionBtn;
    private ImageView shareBtn;
    private ImageView downloadBtn;
    private boolean isCollection;
    private OnActionListener actionListener;
    private View contView;

    public VideoSource(Context context) {
        mContext = context;
    }

    public View create() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        contView = inflater.inflate(R.layout.video_source_controls, null);

        RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(400, 100);
        rllp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        rllp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//        rllp.leftMargin = 0;
//        rllp.topMargin = 0;
        ((Activity) mContext).addContentView(contView, rllp);
        sourceList = (GridView) contView.findViewById(R.id.source_list);
        selectIcon = (ImageView) contView.findViewById(R.id.select_icon);
        showIcon = (ImageView) contView.findViewById(R.id.show_icon);
        collectionBtn = (ImageView) contView.findViewById(R.id.collection);
        shareBtn = (ImageView) contView.findViewById(R.id.share);
        downloadBtn = (ImageView) contView.findViewById(R.id.download);
        selectText = (TextView) contView.findViewById(R.id.select_text);
        selectLayout = (RelativeLayout) contView.findViewById(R.id.source_list_show);
        selectLayout.setVisibility(View.GONE);
        sourceArrayList = new ArrayList<Map<String, Object>>();
        simpleAdapter = new SimpleAdapter(mContext, sourceArrayList,
                R.layout.video_source_list, new String[]{"image", "name"},
                new int[]{R.id.imageView1, R.id.textView1});
        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object bitmapData, String s) {
                if (view instanceof ImageView && bitmapData instanceof Bitmap) {
                    ImageView i = (ImageView) view;
                    i.setImageBitmap((Bitmap) bitmapData);
                    return true;
                }
                return false;
            }
        });
        ((LinearLayout) contView.findViewById(R.id.show)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isShow) {
                    hiddenList();
                } else {
                    showList();
                }
                actionListener.onAction(4);
            }
        });
        sourceList.setAdapter(simpleAdapter);
        sourceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemClickListener.onItemClick(adapterView, view, i, l);
                setSelection(i);
            }
        });
        collectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCollection(!isCollection);
                actionListener.onAction(1);
            }
        });
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionListener.onAction(2);
            }
        });
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionListener.onAction(3);
            }
        });
        return contView;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public void setOnActionListener(OnActionListener listener) {
        actionListener = listener;
    }

    public interface OnActionListener {
        void onAction(int action);
    }

    public void setCollection(boolean b) {
        if (b) {
            collectionBtn.setImageResource(R.drawable.collection_y);
        } else {
            collectionBtn.setImageResource(R.drawable.collection);
        }
        isCollection = b;
    }

    public void showList() {
        showIcon.setImageResource(R.drawable.up);
        selectLayout.setVisibility(View.VISIBLE);
        isShow = true;
    }

    public void hiddenList() {
        showIcon.setImageResource(R.drawable.down);
        selectLayout.setVisibility(View.GONE);
        isShow = false;
    }

    public void setSelection(int i) {
        Map<String, Object> item = (Map<String, Object>) sourceList.getItemAtPosition(i);
        selectIcon.setImageBitmap((Bitmap) item.get("image"));
        selectText.setText((String) item.get("name"));
        sourceList.setSelection(i);

        selectText.requestLayout();
        selectIcon.requestLayout();
        sourceList.requestLayout();
    }

    public int addItem(String name, String url, Bitmap bitmap) {
        Map<String, Object> item = new HashMap<String, Object>();
        item.put("image", bitmap);
        item.put("name", name);
        item.put("url", url);
        sourceArrayList.add(item);
        sourceList.requestLayout();
        return (sourceArrayList.size() - 1);
    }

    public String getName(int i) {
        Map<String, Object> item = (Map<String, Object>) sourceList.getItemAtPosition(i);
        return (String) item.get("name");
    }

    public String getUrl(int i) {
        Map<String, Object> item = (Map<String, Object>) sourceList.getItemAtPosition(i);
        return (String) item.get("url");
    }

    public void remove(int i) {
        sourceArrayList.remove(i);
    }

    public void removeAll() {
        sourceArrayList.removeAll(sourceArrayList);
        hiddenList();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        itemClickListener = listener;
    }


}
