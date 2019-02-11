package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.callback.ItemEventListener;
import com.example.hiennv.loigiaihay.callback.SubItemClickListener;
import com.example.hiennv.loigiaihay.network.pojo.category.Event;
import com.example.hiennv.loigiaihay.network.pojo.category.SubItem;

import java.util.List;

import butterknife.ButterKnife;

public class ChapAdapter extends BaseExpandableListAdapter {
    //Group -> Event
    //Child -> SubItem
    private Context context;
    private List<Event> listEvent;
    private ItemEventListener itemEventListener;
    private SubItemClickListener subItemClickListener;

    public void setItemEventListener(ItemEventListener itemEventListener) {
        this.itemEventListener = itemEventListener;
    }

    public void setSubItemClickListener(SubItemClickListener subItemClickListener) {
        this.subItemClickListener = subItemClickListener;
    }

    public ChapAdapter(Context context, List<Event> listEvent) {
        this.context = context;
        this.listEvent = listEvent;
    }

    @Override
    public int getGroupCount() {
        return (listEvent == null) ? 0 : listEvent.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return (listEvent.get(groupPosition) == null) ? 0 : listEvent.get(groupPosition).getSubItems().size();
    }

    @Override
    public Event getGroup(int groupPosition) {
        return listEvent.get(groupPosition);
    }

    @Override
    public SubItem getChild(int groupPosition, int childPosition) {
        return listEvent.get(groupPosition).getSubItems().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
        TextView tvHeaderSubject = view.findViewById(R.id.tv_header_subject);
        Event event = getGroup(groupPosition);
        tvHeaderSubject.setText(event.getTitle());
        view.setOnClickListener(v -> {
            if (itemEventListener != null) {
                itemEventListener.doEventClick(event);
            }
        });
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.content_subject_detail, parent, false);
        TextView tvChapTitle = view.findViewById(R.id.tv_subject_title);
        SubItem subItem = getChild(groupPosition, childPosition);
        tvChapTitle.setText(subItem.getTitle());
        view.setOnClickListener(v -> {
            if (subItemClickListener != null) {
                subItemClickListener.doSubItemClick(subItem);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
