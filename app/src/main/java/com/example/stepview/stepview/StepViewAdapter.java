package com.example.stepview.stepview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.stepview.stepview.R.id.rlTimeline;

/**
 * Created by ly on 2017/12/2.
 */

public class StepViewAdapter extends BaseAdapter {
    private Context context;
    private List<StepViewBean> traceList = new ArrayList<>();
    private static final int TYPE_FINISH = 101;
    private static final int TYPE_UNFINISH = 102;
    private static final int TYPE_ERROR = 103;

    public StepViewAdapter(Context context, List<StepViewBean> traceList) {
        this.context = context;
        this.traceList = traceList;
    }

    @Override
    public int getCount() {
        return traceList.size();
    }

    @Override
    public StepViewBean getItem(int position) {
        return traceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final StepViewBean trace = getItem(position);
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.stepview_adapter, parent, false);
            holder.tvTopLine = (TextView) convertView.findViewById(R.id.tvTopLine);
            holder.tvDot = (TextView) convertView.findViewById(R.id.tvDot);
            holder.tvLine = (TextView) convertView.findViewById(R.id.tvLine);
            holder.tvAcceptStation = (TextView) convertView.findViewById(R.id.step_tv_des);
            holder.tvAcceptTime = (TextView) convertView.findViewById(R.id.step_tv_time);
            holder.tvAcceptStationBelow = (TextView) convertView.findViewById(R.id.step_tv_des_below);
            holder.rlTimeline = (RelativeLayout) convertView.findViewById(rlTimeline);

            convertView.setTag(holder);
        }
        if (position == 0) {
            holder.tvTopLine.setVisibility(View.INVISIBLE);
        }
        if (position == traceList.size() - 1) {
            holder.tvLine.setVisibility(View.GONE);
        } else {
            holder.tvLine.setVisibility(View.VISIBLE);
        }
        switch (getItemViewType(position)) {
            case TYPE_FINISH:
                holder.tvAcceptStation.setTextColor(context.getResources().getColor(R.color.crt_completed));
                holder.tvDot.setBackgroundResource(R.drawable.state_get_huankuan);
                holder.tvLine.setBackgroundColor(context.getResources().getColor(R.color.crt_completed));
                holder.tvTopLine.setBackgroundColor(context.getResources().getColor(R.color.crt_completed));
                break;
            case TYPE_UNFINISH:
                holder.tvAcceptStation.setTextColor(context.getResources().getColor(R.color.crt_uncompleted_text));
                holder.tvDot.setBackgroundResource(R.drawable.state_normal_huankuan);
                holder.tvLine.setBackgroundColor(context.getResources().getColor(R.color.crt_text_hint_color));
                break;
            case TYPE_ERROR:
                holder.tvTopLine.setVisibility(View.VISIBLE);
                holder.tvAcceptStation.setTextColor(context.getResources().getColor(R.color.crt_error_text));
                holder.tvDot.setBackgroundResource(R.drawable.state_lose_huankuan);
                break;
        }

        holder.tvAcceptTime.setText(trace.getAcceptTime());
        holder.tvAcceptStation.setText(trace.getAcceptStation());
        if (!TextUtils.isEmpty(trace.getAcceptStation())) {
            holder.tvAcceptStationBelow.setText(trace.getAcceptStationBelow());
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int id) {
          if(id==(traceList.size()-2)){
              return TYPE_ERROR;
          }
          if(id==(traceList.size()-1)){
              return TYPE_UNFINISH;
          }
          return TYPE_FINISH;
    }


    static class ViewHolder {
        public TextView tvAcceptTime, tvAcceptStation, tvLine, tvAcceptStationBelow;
        public TextView tvTopLine, tvDot;
        public RelativeLayout rlTimeline;

    }
}
