package adapter.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import javabean.RecData;
import wlf.mvpdagger.R;

/**
 * Created by win10 on 2017/8/3.
 */

public class MainRecAdapter extends RecyclerView.Adapter<MainRecAdapter.MainRecViewHolder> {
    private Context context;
    private List<RecData> dataList;
    OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public MainRecAdapter(Context context, List<RecData> dataList) {
        this.dataList = dataList;
        this.context = context;
    }

    public void setDataList(List<RecData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MainRecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainRecViewHolder(LayoutInflater.from(context).inflate(R.layout.main_rec_item, null));
    }

    @Override
    public void onBindViewHolder(MainRecAdapter.MainRecViewHolder holder, final int position) {
        if (holder == null) {
            View item = LayoutInflater.from(context).inflate(R.layout.main_rec_item, null);
            holder = new MainRecViewHolder(item);
        }
        holder.mainRecItemIcon.setImageResource(dataList.get(position).getImgSrc());
        holder.mainRecItemName.setText(dataList.get(position).getItemName());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(v, position);
                }
            }
        });
    }

    static class MainRecViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.main_rec_item_icon)
        ImageView mainRecItemIcon;
        @BindView(R.id.main_rec_item_name)
        TextView mainRecItemName;
        View item;

        MainRecViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            item = view;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
